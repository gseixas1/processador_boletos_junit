package calculadora;


import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois números")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exceção não lançada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}
	
	@Test
	public void testMultiplicacaoDoisNumeros() {
		int multiplicacao = calc.multiplicacao(2, 4);
		assertEquals(8, multiplicacao);

	}
	
	@DisplayName("Testa a subtração de dois números")
	@Test
	public void testSubtracaoDoisNumeros() {
		int subtracao = calc.subtracao(6, 3);
		assertTrue(subtracao == 3);
	}
	
	@Test
	public void testSomatoria() {
		int somatoria = calc.somatoria(3);
		assertEquals(6, somatoria);
	}
	
	@Test
	public void ehPositivo() {
		Assertions.assertAll(
				() -> assertTrue(calc.ehPositivo(1)),
				() -> assertTrue(calc.ehPositivo(0)),
				() -> assertFalse(calc.ehPositivo(-1))
		);
	}
	
	@Test
	public void comparaDoisNumeros() {
		int a = 2;
		int b = 3;
		int c = 2;
		Assertions.assertAll(
				() -> assertEquals(0, calc.compara(a, c)),
				() -> assertEquals(1, calc.compara(b, a)),
				() -> assertEquals(-1, calc.compara(a, b))
		);
	}
	
	
		

}
