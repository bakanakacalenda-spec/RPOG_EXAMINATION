public class PrintProduct {
    public void printReport(String[] products, int[][] sales, IProduct productObj){
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println("*****************************************************************");
        System.out.println("TOTAL PRODUCT SALES: "+ productObj.GetTotalProductsSold());
        System.out.println("AVERAGE PRODUCT SALES: " + productObj.GetAverageProductSold());
        System.out.println("MOST POPULAR PRODUCT: " + productObj.GetMostPopularProduct());
    }
}
