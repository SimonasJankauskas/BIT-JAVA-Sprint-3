package lt.simonasjankauskas.app;


import java.io.*;
import java.util.*;


public class App {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int select = 4;
        int id;


        while(select != 0) {

        File newFile = new File("./data/newFile.csv");

        // MENU
        System.out.println("\t~~~~~ WELCOME TO APPLE SHOP ~~~~~\n");
        System.out.println("Select one of the options: ");
        System.out.println("~ 1\tAdd new Apple product ~");
        System.out.println("~ 2\tShow products in console ~");
        System.out.println("~ 3\tDelete product by name ~");
        System.out.println("~ 0\tExit ~");
        select = Integer.parseInt(scan.nextLine());
        ArrayList<Product> inputProducts = new ArrayList<>();

        switch (select) {
            case 0 :
                System.out.println("[ E X I T I N G ...... ]");
                break;
            case 1 :
                addProduct(newFile, inputProducts);
                break;
            case 2 :
                showInConsole(newFile);
                break;
            case 3 :
                Scanner deleteScanner = new Scanner(System.in);
                newFile = new File("./data/newFile.csv");
                try {
                    File temp = File.createTempFile("newFile", ".csv", newFile.getParentFile());
                    System.out.println("Enter product name to remove it --");
                    String delete = deleteScanner.nextLine();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(newFile)));
                    PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(temp)));
                    for (String line; (line = reader.readLine()) != null;) {
                        line = line.replaceAll(delete, "");
                        writer.println(line);
                    }

                    reader.close();
                    writer.close();
                    newFile.delete();
                    temp.renameTo(newFile);

                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }
    }
    static void addProduct(File newFile, ArrayList arrProducts) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("\tPlease enter product name and price");
        System.out.println("Product ID --");
        int ID = Integer.parseInt(inputScanner.nextLine());
        System.out.println("Product name --");
        String name = inputScanner.nextLine();
        System.out.println("Product price --");
        double price = Double.parseDouble(inputScanner.nextLine());
        Product products = new Product(ID, name, price);
        arrProducts.add(products);
        FileWriter fw;
        try {
            fw = new FileWriter(newFile, true);
            fw.write("\n");
            fw.write("-------------------------");
            fw.write("\n");
            fw.write(String.valueOf(arrProducts));
            fw.close();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    static void showInConsole(File newFile) {
        try {
            FileReader fileReader = new FileReader(newFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String fileLine = bufferedReader.readLine();
            while (fileLine != null) {
                System.out.println(fileLine);
                fileLine = bufferedReader.readLine();
            }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }






