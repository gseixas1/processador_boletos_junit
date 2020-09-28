package ProcessadorBoletos;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Fatura {
	
	private ArrayList<Pagamento> pagamentos;
	private boolean isPaga;
	private BigDecimal valorFatura;
	private BigDecimal valorTotal;
	

	public Fatura(BigDecimal valorFatura) {
		
		this.pagamentos = new ArrayList<>();
		this.valorFatura = valorFatura;
		this.valorTotal = BigDecimal.ZERO;

	}
	
	public void addPagamento (Pagamento p) {
		
		this.pagamentos.add(p);
		
		this.valorTotal = valorTotal.add(p.getValorTotal());
		
		if ( valorTotal.compareTo(valorFatura) != -1)
			this.isPaga = true;
	}

	public boolean isPaga() {
		return isPaga;
	}
	
	public BigDecimal getValorFatura() {
		return valorFatura;
	}

	public ArrayList<Pagamento> getPagamentos() {
		return pagamentos;
	}
	
}
