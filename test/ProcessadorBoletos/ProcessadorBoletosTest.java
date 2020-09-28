package ProcessadorBoletos;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProcessadorBoletosTest {

	@Test
	public void testBoletoUnicoValorInferior() {

		ProcessadorBoletos pb = new ProcessadorBoletos();
		ArrayList<Boleto> boletos = new ArrayList<>();

		BigDecimal valor = new BigDecimal("150.00");
		Boleto b = new Boleto(valor);
		boletos.add(b);

		Fatura f = new Fatura(new BigDecimal("200.00"));
		pb.processar(boletos, f);

		Assertions.assertFalse(f.isPaga());

	}

	@Test
	public void testBoletoUnicoValorIgual() {

		ProcessadorBoletos pb = new ProcessadorBoletos();
		ArrayList<Boleto> boletos = new ArrayList<>();

		BigDecimal valor = new BigDecimal("150.00");
		Boleto b = new Boleto(valor);
		boletos.add(b);

		Fatura f = new Fatura(new BigDecimal("150.00"));
		pb.processar(boletos, f);

		Assertions.assertTrue(f.isPaga());

	}

	@Test
	public void testBoletoUnicoValorMaior() {

		ProcessadorBoletos pb = new ProcessadorBoletos();
		ArrayList<Boleto> boletos = new ArrayList<>();

		BigDecimal valor = new BigDecimal("150.00");
		Boleto b = new Boleto(valor);
		boletos.add(b);

		Fatura f = new Fatura(new BigDecimal("149.00"));
		pb.processar(boletos, f);

		Assertions.assertTrue(f.isPaga());

	}

	@Test
	public void testBoletosValorInferior() {

		ProcessadorBoletos pb = new ProcessadorBoletos();
		ArrayList<Boleto> boletos = new ArrayList<>();

		BigDecimal valor = new BigDecimal("150.00");
		Boleto b = new Boleto(valor);
		boletos.add(b);

		BigDecimal valor2 = new BigDecimal("150.00");
		Boleto b2 = new Boleto(valor2);
		boletos.add(b2);

		Fatura f = new Fatura(new BigDecimal("800.00"));
		pb.processar(boletos, f);

		Assertions.assertFalse(f.isPaga());

	}

	@Test
	public void testBoletosValorIgual() {

		ProcessadorBoletos pb = new ProcessadorBoletos();
		ArrayList<Boleto> boletos = new ArrayList<>();

		BigDecimal valor = new BigDecimal("400.00");
		Boleto b = new Boleto(valor);
		boletos.add(b);

		BigDecimal valor2 = new BigDecimal("400.00");
		Boleto b2 = new Boleto(valor2);
		boletos.add(b2);

		Fatura f = new Fatura(new BigDecimal("800.00"));
		pb.processar(boletos, f);

		Assertions.assertTrue(f.isPaga());

	}

	@Test
	public void testBoletosValorMaior() {

		ProcessadorBoletos pb = new ProcessadorBoletos();
		ArrayList<Boleto> boletos = new ArrayList<>();

		BigDecimal valor = new BigDecimal("700.00");
		Boleto b = new Boleto(valor);
		boletos.add(b);

		BigDecimal valor2 = new BigDecimal("600.00");
		Boleto b2 = new Boleto(valor2);
		boletos.add(b2);

		Fatura f = new Fatura(new BigDecimal("800.00"));
		pb.processar(boletos, f);

		Assertions.assertTrue(f.isPaga());

	}

}
