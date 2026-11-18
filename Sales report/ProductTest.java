import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        String[] products = {"Test Mattress"};
        int[][] sales = {{25, 18, 20}};

        Product product = new Product(products, sales);
        assertEquals(63, product.GetTotalProductsSold());
    }

    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        String[] products = {"Test Mattress"};
        int[][] sales = {{20, 20, 20}};

        Product product = new Product(products, sales);
        assertEquals(20.0, product.GetAverageProductSold(), 0.001);
    }
}