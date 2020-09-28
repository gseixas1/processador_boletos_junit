package ProcessadorBoletos;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Pagamento {
	
	private ArrayList<Boleto> boletos;
	
	private BigDecimal valorTotal;
	
	public Pagamento() {
		this.valorTotal = BigDecimal.ZERO;
		this.boletos = new ArrayList<>();
	}
	
	public void addBoleto(Boleto b) {
		this.boletos.add(b);
		this.valorTotal = valorTotal.add(b.getValor());
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public ArrayList<Boleto> getBoletos() {
		return boletos;
	}
}
