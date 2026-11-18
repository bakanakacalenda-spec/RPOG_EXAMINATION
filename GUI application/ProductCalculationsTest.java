import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductCalculationsTest {

    @Nested
    class ProductCalculationTest {

        @Test
        public void GetVat_WithValidData_ReturnsCorrectValue() {
            double price = 3500.0;
            ProductCalculations calc = new ProductCalculations(price);

            assertEquals(525.0, calc.GetVat(), 0.001);
        }
    }
}
