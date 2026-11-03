import cardapio.Lanche;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LancheTest {

    @Test
    void precoNegativoLancaExcecao() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Lanche("Teste", -1)
        );

    }
}