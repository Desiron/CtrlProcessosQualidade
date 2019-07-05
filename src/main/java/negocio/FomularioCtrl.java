package negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.sound.midi.VoiceStatus;

import beans.Formulario;
import beans.Pessoa;
import beans.Produto;
import beans.Rota;
import persistencia.FormularioDAO;
import persistencia.PessoaDAO;
import persistencia.ProdutoDAO;

@ManagedBean 
@SessionScoped
public class FomularioCtrl implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Pessoa pessoa = PessoaDAO.pessoaQueFazFormulario();
	private Formulario formulario = new Formulario();
	private Rota rota;
	private List<Formulario> listaFormularios = FormularioDAO.listagem(getPessoa(),3);
	private List<Produto> listaProdutos = new ArrayList<Produto>();
	private String produto ="";
	private Date dataTempUmidade;
	private List<VisuFormTemp> visuTemp;
	FacesMessage mensagem;
		
	
	public void iniform() {
		rota = new Rota();
		formulario = new Formulario();
		formulario.setPessoa(pessoa);
		formulario.setProduto(ProdutoDAO.consultaProd(produto));
		formulario.setDataFormulario(new Date());	
		rota.setHoraUmidade(new Date());
		formulario.setStatus(1);
	}
	
	public void salvarForm() {		
		if(formulario.getId()==0) {
			FormularioDAO.inserir(formulario);
			mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO,"Formulário "+formulario.getId()+" do produto: "+formulario.getProduto().getDescricao()+" salvo com sucesso!",null);
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
		}else {
			FormularioDAO.alterar(formulario);
		}		
	}
	
	public String novoForm() {
		salvarForm();
		return "novaRota.xhtml";
	}
	
	public int sizeRota(){
		return formulario.getRotas().size();
	}
	
	public String visuRota(Formulario form) {
		formulario = form;
		visuTemp = new ArrayList<VisuFormTemp>();
		VisuFormTemp temp = new VisuFormTemp();
		temp.setValores(new ArrayList<String>());
		temp.setLabel("ID: ");
		for(int i=0; i<formulario.getRotas().size(); i++) {
			System.out.println("ID: "+formulario.getRotas().get(i).getId());
			temp.getValores().add(Integer.toString((form.getRotas().get(i).getId())));
		}
		visuTemp.add(temp);
		return "visualizar.xhtml";
	}
	
	public String novaRota(Formulario form) {
		dataTempUmidade = null;
		formulario = form;
		rota = new Rota();
		return "novaRota.xhtml";
	}
	
	public String listarFormFechado(){
		listaFormularios = FormularioDAO.listagem(pessoa,0);
		return "principal.xhtml";
	}
	
	public String listarFormAberto(){
		listaFormularios = FormularioDAO.listagem(pessoa,1);
		return "principal.xhtml";
	}
	
	public String inicio() {
		listaFormularios = FormularioDAO.listagem(pessoa,3);
		return "principal.xhmtl";
	}
	
	public String salvarRota() {
		rota.setFormulario(formulario);
		rota.setHoraUmidade(dataTempUmidade);
		formulario.setRotas(new ArrayList<Rota>());
		formulario.getRotas().add(rota);
		salvarForm();
		listaFormularios = FormularioDAO.listagem(pessoa,3);
		mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO,"Rota salva com sucesso!",null);
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
		return "principal.xhtml";
	}
	
	public void fecharForm(Formulario form) {
		formulario = form;
		this.formulario.setStatus(0);
		salvarForm();
	}
	
	public void abrirForm() {
		this.formulario.setStatus(1);
	}
	
	public void setarForm(Formulario form) {
		formulario = form;
	}
	
	//Getters e Setters
	
	
	
	
	public Pessoa getPessoa() {
		return PessoaDAO.pessoaQueFazFormulario();
	}
	
	public List<VisuFormTemp> getVisuTemp() {
		return visuTemp;
	}

	public void setVisuTemp(List<VisuFormTemp> visuTemp) {
		this.visuTemp = visuTemp;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public List<Formulario> getListaFormularios() {
		return listaFormularios;
	}	

	public void setListaFormularios(List<Formulario> listaFormularios) {
		this.listaFormularios = listaFormularios;
	}
	
	public Date getDataTempUmidade() {
		return dataTempUmidade;
	}
	public void setDataTempUmidade(Date dataTempUmidade) {
		this.dataTempUmidade = dataTempUmidade;
	}
		
	public Formulario getFormulario() {
		return formulario;
	}
	
	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}

	public Rota getRota() {
		return rota;
	}

	public void setRota(Rota rota) {
		this.rota = rota;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public List<Produto> getListaProdutos() {
		listaProdutos = ProdutoDAO.listagem("");
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
}


/*x2.getValores().add(Float.toString(form.getRotas().get(i).getPesoAssMin()));
x3.getValores().add(Float.toString(form.getRotas().get(i).getPesoAssMax()));
x4.getValores().add(Float.toString(form.getRotas().get(i).getFormatoMin()));
x5.getValores().add(Float.toString(form.getRotas().get(i).getFormatoMax()));
x6.getValores().add(Float.toString(form.getRotas().get(i).getCompriMin()));
x7.getValores().add(Float.toString(form.getRotas().get(i).getCompriMax()));
x8.getValores().add(Float.toString(form.getRotas().get(i).getDiameMin()));
x9.getValores().add(Float.toString(form.getRotas().get(i).getDiamMax()));
x10.getValores().add(Float.toString(form.getRotas().get(i).getEspessuraMin()));
x11.getValores().add(Float.toString(form.getRotas().get(i).getEspessuraMax()));
x12.getValores().add(form.getRotas().get(i).getAspectoVisu());
x14.getValores().add(Float.toString(form.getRotas().get(i).getPorcUmidade()));
x15.getValores().add(Float.toString(form.getRotas().get(i).getPesoPacote()));
x16.getValores().add(Float.toString(form.getRotas().get(i).getPesoPacoteUni()));
x17.getValores().add(Float.toString(form.getRotas().get(i).getPesoUnidade()));
x18.getValores().add(Float.toString(form.getRotas().get(i).getQtdBisco()));
x19.getValores().add(form.getRotas().get(i).getEmbalagem());
x20.getValores().add(form.getRotas().get(i).getSoldaVert());
x21.getValores().add(form.getRotas().get(i).getSoldaSuperior());
x22.getValores().add(form.getRotas().get(i).getSoldaInferior());
x23.getValores().add(form.getRotas().get(i).getLoteValPrima());
x24.getValores().add(form.getRotas().get(i).getLoteValSecun());
x25.getValores().add(form.getRotas().get(i).getEtiquetaSecun());
x26.getValores().add(form.getRotas().get(i).getLastro());*/

/*visuTemp.getLastro().add((form.getRotas().get(i).getLastro()));
visuTemp.getTeto().add((form.getRotas().get(i).getTeto()));
visuTemp.getPesoAssMin().add((form.getRotas().get(i).getPesoAssMin()));
visuTemp.getPesoAssMax().add((form.getRotas().get(i).getPesoAssMax()));
visuTemp.getFormatoMin().add((form.getRotas().get(i).getFormatoMin()));
visuTemp.getFormatoMax().add((form.getRotas().get(i).getFormatoMax()));
visuTemp.getCompriMin().add((form.getRotas().get(i).getCompriMin()));
visuTemp.getCompriMax().add((form.getRotas().get(i).getCompriMax()));
visuTemp.getDiameMin().add((form.getRotas().get(i).getDiameMin()));
visuTemp.getDiamMax().add((form.getRotas().get(i).getDiamMax()));
visuTemp.getEspessuraMin().add((form.getRotas().get(i).getEspessuraMin()));
visuTemp.getEspessuraMax().add((form.getRotas().get(i).getEspessuraMax()));
visuTemp.getAspectoVisu().add((form.getRotas().get(i).getAspectoVisu()));
visuTemp.getHoraUmidade().add((form.getRotas().get(i).getHoraUmidade()));
visuTemp.getPorcUmidade().add((form.getRotas().get(i).getPorcUmidade()));
visuTemp.getPesoPacote().add((form.getRotas().get(i).getPesoPacote()));
visuTemp.getPesoPacoteUni().add((form.getRotas().get(i).getPesoPacoteUni()));
visuTemp.getPesoUnidade().add((form.getRotas().get(i).getPesoUnidade()));
visuTemp.getQtdBisco().add((form.getRotas().get(i).getQtdBisco()));
visuTemp.getEmbalagem().add((form.getRotas().get(i).getEmbalagem()));
visuTemp.getSoldaVert().add((form.getRotas().get(i).getSoldaVert()));
visuTemp.getSoldaSuperior().add((form.getRotas().get(i).getSoldaSuperior()));
visuTemp.getSoldaInferior().add((form.getRotas().get(i).getSoldaInferior()));
visuTemp.getLoteValPrima().add((form.getRotas().get(i).getLoteValPrima()));
visuTemp.getLoteValSecun().add((form.getRotas().get(i).getLoteValSecun()));
visuTemp.getEtiquetaSecun().add((form.getRotas().get(i).getEtiquetaSecun()));
visuTemp.getId().add((form.getRotas().get(i).getId()));*/