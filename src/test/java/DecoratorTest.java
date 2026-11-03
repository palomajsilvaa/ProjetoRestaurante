import cardapio.ComCheddar;
import cardapio.ItemCardapio;
import cardapio.LancheFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecoratorTest {

    @Test
    void xBaconComCheddarCusta26() {

        ItemCardapio lanche =
                new ComCheddar(
                        LancheFactory.xBacon()
                );

        assertEquals(
                26.0,
                lanche.getPreco(),
                0.001
        );

    }
}