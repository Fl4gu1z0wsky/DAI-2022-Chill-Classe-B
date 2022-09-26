package ch.heigvd.dai.chill.domain.wasadigi;

import ch.heigvd.dai.chill.domain.Bartender;
import ch.heigvd.dai.chill.protocol.OrderRequest;
import ch.heigvd.dai.chill.protocol.OrderResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuinnessTest {

    @Test
    void thePriceAndNameForGuinessShouldBeCorrect() {
        Guinness g = new Guinness();
        assertEquals(g.getName(), Guinness.NAME);
        assertEquals(g.getPrice(), Guinness.PRICE);
    }

    @Test
    void aBartenderShouldAcceptAnOrderForGuiness() {
        Bartender David = new Bartender();
        String productName = "ch.heigvd.dai.chill.domain.wasadigi.Guinness";
        OrderRequest request = new OrderRequest(3, productName);
        OrderResponse response = David.order(request);
        BigDecimal expectedTotalPrice = Guinness.PRICE.multiply(new BigDecimal(3));
        assertEquals(expectedTotalPrice, response.getTotalPrice());
    }
}
