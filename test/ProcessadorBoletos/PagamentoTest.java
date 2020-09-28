package ProcessadorBoletos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PagamentoTest {
	
	@Test
	public void testCriaPagamento() {

		BigDecimal valor = new BigDecimal("150.00");
		Boleto b = new Boleto(valor);
		Pagamento p = new Pagamento();
		p.addBoleto(b);
		
		Assertions.assertAll("p",
				() -> assertEquals(1, p.getBoletos().size()),
				() -> assertEquals(valor, p.getValorTotal()));
		
	}
	
	@Test
	public void testValorTotalVariosBoletos() {

		BigDecimal valorb1 = new BigDecimal("150.00");
		Boleto b1 = new Boleto(valorb1);
		
		BigDecimal valorb2 = new BigDecimal("300.50");
		Boleto b2 = new Boleto(valorb2);
		
		BigDecimal valorTotal = valorb1.add(valorb2);
		
		Pagamento p = new Pagamento();
		p.addBoleto(b1);
		p.addBoleto(b2);
		
		Assertions.assertAll("p",
				() -> assertEquals(2, p.getBoletos().size()),
				() -> assertEquals(valorTotal, p.getValorTotal()));
	}

}
