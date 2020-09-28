package ProcessadorBoletos;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoletoTest {

	@Test
	public void testCriaBoleto() {

		BigDecimal valor = new BigDecimal("150.00");
		Boleto boleto = new Boleto(valor);

		Assertions.assertTrue(valor.equals(boleto.getValor()));
	}

}
