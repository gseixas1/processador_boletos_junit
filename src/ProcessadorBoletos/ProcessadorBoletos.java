package ProcessadorBoletos;

import java.util.ArrayList;

public class ProcessadorBoletos {
	
	public void processar(ArrayList<Boleto> boletos, Fatura fatura) {
		
		for (Boleto b : boletos) {
			
			Pagamento p = new Pagamento();
			p.addBoleto(b);
			fatura.addPagamento(p);

		}
  	}

}
