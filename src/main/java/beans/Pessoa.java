package beans;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="bel_pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pes_id")
	private int id;
	
	@Column(name="pes_nome")
	private String nome;
	
	@Column(name="pes_usuario", nullable = true)
	private String usuario;
	
	@Column(name="pes_senha", nullable = true, length = 32)
	private String senha;
	
	@Column(name="pes_tipo", nullable = true)
	private String tipo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
		this.senha = hash.toString(16);
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL )
	private List<Formulario> formularios;

	public List<Formulario> getFormularios() {
		return formularios;
	}

	public void setFormularios(List<Formulario> formularios) {
		this.formularios = formularios;
	}
}
