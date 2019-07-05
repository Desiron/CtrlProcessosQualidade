package negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import beans.Produto;
import persistencia.ProdutoDAO;

@ManagedBean(name="produtoCtrl" , eager = true)
@SessionScoped
public class ProdutoCtrl implements Serializable {

	private static final long serialVersionUID = 1L;
	private Produto produto = new Produto();
	private List<Produto> produtos = new ArrayList<Produto>();
	
	
	public List<Produto> getProdutos() {
		produtos =  ProdutoDAO.listagem("");
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public Produto getProduto() {
		System.out.println("PRODUTO SETADO!!!!! 001 -> "+produto.getDescricao());
		return produto;
	}
	public void setProduto(Produto produto) {
		System.out.println("PRODUTO SETADO!!!!! 002 -> "+produto.getDescricao());
		this.produto = produto;
	}
	
	
}
