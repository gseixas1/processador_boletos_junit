package ProcessadorBoletos;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FaturaTest {
	
	@Test
	public void testCriaFatura() {

		BigDecimal valor = new BigDecimal("150.00");
		Boleto b = new Boleto(valor);
		Pagamento p = new Pagamento();
		p.addBoleto(b);
		
		Fatura f = new Fatura(new BigDecimal("150.00"));
		f.addPagamento(p);
		
		Assertions.assertAll("f",
				() -> assertEquals(1, f.getPagamentos().size()),
				() -> assertEquals(valor, f.getValorFatura()));
	}
	
	@Test
	public void testaIsPaga() {
		
		BigDecimal valor = new BigDecimal("150.00");
		
		//Testa fatura com mesmo valor do boleto
		Boleto b = new Boleto(valor);
		Pagamento p = new Pagamento();
		p.addBoleto(b);
		
		Fatura f = new Fatura(new BigDecimal("150.00"));
		f.addPagamento(p);
		
		//Testa boleto com valor superior ao da fatura
		Boleto b2 = new Boleto(valor);
		Pagamento p2 = new Pagamento();
		p2.addBoleto(b2);
		
		Fatura f2 = new Fatura(new BigDecimal("100.00"));
		f2.addPagamento(p2);
		
		//Testa boleto com valor inferior ao da fatura
		Boleto b3 = new Boleto(valor);
		Pagamento p3 = new Pagamento();
		p3.addBoleto(b3);
		
		Fatura f3 = new Fatura(new BigDecimal("200.00"));
		f3.addPagamento(p3);
		
		Assertions.assertAll("f",
				() -> assertTrue(f.isPaga()),
				() -> assertTrue(f2.isPaga()),
				() -> assertFalse(f3.isPaga()));
	}
	


}
