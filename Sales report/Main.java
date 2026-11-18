import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] products = {"Cozy nights Monarch mattress", "Restonic Barbados mattress", "Sealy phuket mattress"};
        int[][] sales = new int[products.length][3];

        for (int i = 0; i < products.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter number of sales for month " + (j + 1) + " for " + products[i] + ": ");
                sales[i][j] = scanner.nextInt();
            }
        }
        Product productLogic = new Product(products, sales);
        PrintProduct printer = new PrintProduct();

        System.out.println();
        printer.printReport(products, sales, productLogic);

    }
}