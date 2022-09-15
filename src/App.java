import entities.Product;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Product> productList = new ArrayList<>();

        System.out.print("How many products do you want to register? ");
        int productsToRegister = sc.nextInt();

        for (int i = 0; i < productsToRegister; i++) {

            System.out.printf("\nProduct #%d data:\n", (i + 1));

            sc.nextLine();

            System.out.print("Product name: ");
            String productName = sc.nextLine();

            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();

            System.out.print("Product quantity: ");
            int productQuantity = sc.nextInt();

            Product product = new Product(productName, productPrice, productQuantity);
            productList.add(product);
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\temp\\out\\summary.csv", false))){

            for (Product product : productList) {
                bufferedWriter.write(product.getName() + ", " + String.format("%.2f", product.getPrice() * product.getQuantity()));
                bufferedWriter.newLine();
            }
        }

        catch (IOException exception) {
            System.out.println("Error: " + exception.getMessage());
        }

        finally {
            sc.close();
        }
    }
}
