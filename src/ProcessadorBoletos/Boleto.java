package ProcessadorBoletos;

import java.math.BigDecimal;

public class Boleto {
	
	private BigDecimal valor;

	public Boleto(BigDecimal valor) {
		this.valor = valor;
	}
	
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
