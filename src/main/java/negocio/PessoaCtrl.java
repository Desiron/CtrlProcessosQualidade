package negocio;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import beans.Pessoa;
import persistencia.PessoaDAO;

@ManagedBean
@SessionScoped
public class PessoaCtrl implements Serializable {

	private static final long serialVersionUID = 1L;
	private Pessoa pessoa = new Pessoa();
	private List<Pessoa> list = new ArrayList<Pessoa>();
	private String filtro = "";
	private String senhaLogin;
	
	

	public String getSenhaLogin() {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		BigInteger hash = new BigInteger(1, md.digest(senhaLogin.getBytes()));
		return hash.toString(16);
	}

	public void setSenhaLogin(String senhaLogin) {
		this.senhaLogin = senhaLogin;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public List<Pessoa> getList() {
		return PessoaDAO.listagem(filtro);
	}

	public void setList(List<Pessoa> list) {
		this.list = list;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public String actionGravarCadastro() {
		if(pessoa.getId()==0) {
			PessoaDAO.inserir(pessoa);
		}else {
			PessoaDAO.alterar(pessoa);
		}
		return "listPessoas.xhtml";
	}
	
	public String actionAlterarUsuario(Pessoa pes) {
		pessoa = pes;		
		return "formPessoa.xhtml";
	}
	
	public String actionExcluir(Pessoa pes) {
		PessoaDAO.excluir(pes);
		return "form_pessoa";
	}
	
	public static String usuarioLogado() {
		String usuario="";
		UserDetails user = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		usuario = user.getUsername();
		return usuario;
	}
	
	public void limpar() {
		pessoa = new Pessoa();
	}
	
	public String cadUsuario() {
		pessoa = new Pessoa();
		return "formPessoa.xhtml";
	}
	
	
}
