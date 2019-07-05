package beans;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="bel_formulario")
public class Formulario {
	
		//Cabeçalho formulário
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="form_id")
		private int id;
		
		@Column(name="form_dataform", nullable = true)
		private Date dataFormulario;
		
		@Column(name="form_datalinha", nullable = true)
		private Date dataLinha;
		
		@Column(name="form_status", nullable = true)		
		private int status;
		
		//Saída do forno		
		@Column(name="form_obssaidaforno", length = 500)
		private String obsSaidaForno;
		
		//Umidade	
		@Column(name="form_obsumidade", length = 500)
		private String obsUmidade;
		
		//Pacotes		
		@Column(name="form_obspacote", length = 500)
		private String obsPacote;
		
		//Codificação			
		@Column(name="form_obscodi", length = 500)
		private String obsCodificacao;
		
		
		//Dependências
		@ManyToOne
		@JoinColumn(name="form_pes_id")
		private Pessoa pessoa;
		
		public Pessoa getPessoa() {
			return pessoa;
		}
		public void setPessoa(Pessoa pessoa) {
			this.pessoa = pessoa;
		}
		
		@ManyToOne
		@JoinColumn(name="form_prod_id")
		private Produto produto;

		public Produto getProduto() {
			return produto;
		}
		public void setProduto(Produto produto) {
			this.produto = produto;
		}
		
		/*POPULAR CLASSES FILHAS JUNTO COM SELECT DO PAI*/
		/*@OneToMany(mappedBy = "formulario", cascade = CascadeType.ALL)*/
		
		@OneToMany(mappedBy = "formulario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	    @Fetch(FetchMode.SUBSELECT)
		private List<Rota> rotas;
		
		public List<Rota> getRotas() {
			return rotas;
		}
		public void setRotas(List<Rota> rotas) {
			this.rotas = rotas;
		}
		
		
		//Getters e Setters
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Date getDataFormulario() {
			return dataFormulario;
		}
		public void setDataFormulario(Date dataFormulario) {
			this.dataFormulario = dataFormulario;
		}
		public Date getDataLinha() {
			return dataLinha;
		}
		public void setDataLinha(Date dataLinha) {
			this.dataLinha = dataLinha;
		}
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
		public String getObsSaidaForno() {
			return obsSaidaForno;
		}
		public void setObsSaidaForno(String obsSaidaForno) {
			this.obsSaidaForno = obsSaidaForno;
		}
		public String getObsUmidade() {
			return obsUmidade;
		}
		public void setObsUmidade(String obsUmidade) {
			this.obsUmidade = obsUmidade;
		}
		public String getObsPacote() {
			return obsPacote;
		}
		public void setObsPacote(String obsPacote) {
			this.obsPacote = obsPacote;
		}
		public String getObsCodificacao() {
			return obsCodificacao;
		}
		public void setObsCodificacao(String obsCodificacao) {
			this.obsCodificacao = obsCodificacao;
		}		
}
