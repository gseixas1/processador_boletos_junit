package carrinho;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("Classe para teste do Carrinho")
public class CarrinhoTest {

	Carrinho items;

	@BeforeEach
	public void inicializa() {
		items = new Carrinho();
	}


	@Test
	public void testaAdditem() {

		Produto livro = new Produto("Introdução ao Teste de Software", 100.00);
		items.addItem(livro);
		assertEquals(items.getQtdeItems(), 1);
		assertThat(items.getValorTotal(), equalTo(100.00));
	}

	@Test
	public void testaQtdItems() {

		Produto livro = new Produto("Introdução ao Teste de Software", 100.00);
		Produto caneta = new Produto("Bique", 3.00);
		Produto caderno = new Produto("Carderno capa dura", 15.00);

		items.addItem(livro);
		items.addItem(caneta);
		items.addItem(caderno);

		assertThat(items.getQtdeItems(), equalTo(3));
	}

	@Test
	public void testaRemoveItem() throws ProdutoNaoEncontradoException {

		Produto livro = new Produto("Introdução ao Teste de Software", 100.00);
		items.addItem(livro);
		items.removeItem(livro);

		assertThat(items.getQtdeItems(), equalTo(0));
		assertThat(items.getValorTotal(), equalTo(0.0));
	}

	@Test
	public void testaRemoveItemNaoExistente() {

		Produto livro = new Produto("Introdução ao Teste de Software", 100.00);
		Produto caneta = new Produto("Bique", 3.00);

		items.addItem(livro);

		try {
			items.removeItem(caneta);
		} catch (ProdutoNaoEncontradoException e) {
			System.out.printf("%s não foi encontrado", caneta.getNome());
		}

		assertThat(items.getQtdeItems(), equalTo(1));
		assertThat(items.getValorTotal(), equalTo(100.00));
	}

	@Test
	public void testaEsvazia() {

		Produto livro = new Produto("Introdução ao Teste de Software", 100.00);
		Produto caneta = new Produto("Bique", 3.00);
		Produto caderno = new Produto("Carderno capa dura", 15.00);

		items.addItem(livro);
		items.addItem(caneta);
		items.addItem(caderno);

		items.esvazia();

		assertThat(items.getQtdeItems(), equalTo(0));

	}

	@Test
	public void testaValorTotal() {

		Produto livro = new Produto("Introdução ao Teste de Software", 100.00);
		Produto caneta = new Produto("Bique", 3.00);
		Produto caderno = new Produto("Carderno capa dura", 15.00);

		items.addItem(livro);
		items.addItem(caneta);
		items.addItem(caderno);

		assertThat(items.getQtdeItems(), equalTo(3));
		assertThat(items.getValorTotal(), equalTo(118.00));

		try {
			items.removeItem(caneta);
		} catch (ProdutoNaoEncontradoException e) {
			System.out.printf("%s não foi encontrado", caneta.getNome());
		}

		assertThat(items.getQtdeItems(), equalTo(2));
		assertThat(items.getValorTotal(), equalTo(115.00));

	}





}
