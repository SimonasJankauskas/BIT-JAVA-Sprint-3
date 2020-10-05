package lt.simonasjankauskas.app;


import java.io.*;
import java.util.*;


public class App {
    static ArrayList<Product> inputProducts = new ArrayList<>();
    static File newFile = new File("./data/newFile.csv");

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int select = 4;


        if (inputProducts.size() != 0) reader(newFile);
        while(select != 0) {
        // MENU
        System.out.println("\t~~~~~ WELCOME TO APPLE SHOP ~~~~~\n");
        System.out.println("Select one of the options: ");
        System.out.println("~ 1\tAdd new Apple product ~");
        System.out.println("~ 2\tShow products in console ~");
        System.out.println("~ 3\tDelete product by name ~");
        System.out.println("~ 0\tExit ~");
        select = Integer.parseInt(scan.nextLine());


        switch (select) {
            case 0 :
                System.out.println("[ E X I T I N G ...... ]");
                break;
            case 1 :
                addProduct(newFile);
                reWrite(newFile);

                break;
            case 2 :
                showInConsole(newFile);
                break;
            case 3 :
                System.out.println("Enter product index: ");
                int index = scan.nextInt();
                scan.nextLine();
                inputProducts.remove(index);
                reWrite(newFile);
            }
        }
    }
    // Add and write to file
    static void addProduct(File newFile) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("\tPlease enter product ID, name and price");
        System.out.println("Product ID --");
        int ID = Integer.parseInt(inputScanner.nextLine());
        System.out.println("Product name --");
        String name = inputScanner.nextLine();
        System.out.println("Product price --");
        double price = Double.parseDouble(inputScanner.nextLine());
        Product products = new Product(ID, name, price);
        inputProducts.add(products);

    }
    // Read file
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
    static  void reWrite(File newFile) {
        FileWriter fw;
        try {
            fw = new FileWriter(newFile, false);
            for (Product p: inputProducts
                 ) {
                fw.write(String.valueOf(p));
            }
            fw.close();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    static void reader(File newFile) {
        try {
            FileReader fileReader = new FileReader(newFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String fileLine = bufferedReader.readLine();
            while (fileLine != null) {
                String[] readFile = fileLine.split(":");
                Product products = new Product(Integer.parseInt(readFile[1]), readFile[3], Double.parseDouble(readFile[5]));
                inputProducts.add(products);
                fileLine = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }






