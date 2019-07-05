package beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bel_rotaform")
public class Rota {
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			@Column(name="rota_id")
			private int id;
	
			//Saída do forno
			@Column(name="rota_lastro", length = 2, nullable = true)
			private String lastro;
			
			@Column(name="rota_teto", length = 2, nullable = true)
			private String teto;
			
			@Column(name="rota_pesoassmin", nullable = true)
			private float pesoAssMin;
			
			@Column(name="rota_pesoassmax", nullable = true)
			private float pesoAssMax;
			
			@Column(name="rota_formamin")
			private float formatoMin;
			
			@Column(name="rota_formamax")
			private float formatoMax;
			
			@Column(name="rota_compmin")
			private float compriMin;
			
			@Column(name="rota_compmax")
			private float compriMax;
			
			@Column(name="rota_diammin")
			private float diameMin;
			
			@Column(name="rota_diammax")
			private float diamMax;
			
			@Column(name="rota_espemin", nullable = true)
			private float espessuraMin;
			
			@Column(name="rota_espemax", nullable = true)
			private float espessuraMax;
			
			@Column(name="rota_aspvisual", length = 2, nullable = true)
			private String aspectoVisu;
			
						
			//Umidade
			@Column(name="rota_horaumidade", nullable = true)
			private Date horaUmidade;
			
			@Column(name="rota_porcumidade", nullable = true)
			private float porcUmidade;
		
			
			//Pacotes
			@Column(name="rota_pesopacote", nullable = true)
			private float pesoPacote;
			
			@Column(name="rota_pesopacoteuni")
			private float pesoPacoteUni;
			
			@Column(name="rota_pesouni", nullable = true )
			private float pesoUnidade;
			
			@Column(name="rota_qtdbisc")
			private float qtdBisco;
			
			@Column(name="rota_embalagem", length = 2, nullable = true)
			private String embalagem;
			
			@Column(name="rota_soldavert", length = 2, nullable = true)
			private String soldaVert;
			
			@Column(name="rota_soldasup", length = 2, nullable = true)
			private String soldaSuperior;
			
			@Column(name="rota_soldainf", length = 2, nullable = true)
			private String soldaInferior;		
			
						
			//Codificação
			@Column(name="rota_lotevalprima", length = 2, nullable = true)
			private String loteValPrima;
			
			@Column(name="rota_lotevalsecun", length = 2)
			private String loteValSecun;
			
			@Column(name="rota_etiquetasecun", length = 2, nullable = true)
			private String etiquetaSecun;
			
			//Dependências
			@ManyToOne
			@JoinColumn(name="rota_form_id")
			private Formulario formulario;

			public Formulario getFormulario() {
				return formulario;
			}

			public void setFormulario(Formulario formulario) {
				this.formulario = formulario;
			}

			//Getters e Setters
			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public String getLastro() {
				return lastro;
			}

			public void setLastro(String lastro) {
				this.lastro = lastro;
			}

			public String getTeto() {
				return teto;
			}

			public void setTeto(String teto) {
				this.teto = teto;
			}

			public float getPesoAssMin() {
				return pesoAssMin;
			}

			public void setPesoAssMin(float pesoAssMin) {
				this.pesoAssMin = pesoAssMin;
			}

			public float getPesoAssMax() {
				return pesoAssMax;
			}

			public void setPesoAssMax(float pesoAssMax) {
				this.pesoAssMax = pesoAssMax;
			}

			public float getFormatoMin() {
				return formatoMin;
			}

			public void setFormatoMin(float formatoMin) {
				this.formatoMin = formatoMin;
			}

			public float getFormatoMax() {
				return formatoMax;
			}

			public void setFormatoMax(float formatoMax) {
				this.formatoMax = formatoMax;
			}

			public float getCompriMin() {
				return compriMin;
			}

			public void setCompriMin(float compriMin) {
				this.compriMin = compriMin;
			}

			public float getCompriMax() {
				return compriMax;
			}

			public void setCompriMax(float compriMax) {
				this.compriMax = compriMax;
			}

			public float getDiameMin() {
				return diameMin;
			}

			public void setDiameMin(float diameMin) {
				this.diameMin = diameMin;
			}

			public float getDiamMax() {
				return diamMax;
			}

			public void setDiamMax(float diamMax) {
				this.diamMax = diamMax;
			}

			public float getEspessuraMin() {
				return espessuraMin;
			}

			public void setEspessuraMin(float espessuraMin) {
				this.espessuraMin = espessuraMin;
			}

			public float getEspessuraMax() {
				return espessuraMax;
			}

			public void setEspessuraMax(float espessuraMax) {
				this.espessuraMax = espessuraMax;
			}

			public String getAspectoVisu() {
				return aspectoVisu;
			}

			public void setAspectoVisu(String aspectoVisu) {
				this.aspectoVisu = aspectoVisu;
			}

			public Date getHoraUmidade() {
				return horaUmidade;
			}

			public void setHoraUmidade(Date horaUmidade) {
				Date dataTemp = new Date();
				horaUmidade.setDate(dataTemp.getDate());
				horaUmidade.setMonth(dataTemp.getMonth());
				horaUmidade.setYear(dataTemp.getYear());
				this.horaUmidade = horaUmidade;
			}

			public float getPorcUmidade() {
				return porcUmidade;
			}

			public void setPorcUmidade(float porcUmidade) {
				this.porcUmidade = porcUmidade;
			}

			public float getPesoPacote() {
				return pesoPacote;
			}

			public void setPesoPacote(float pesoPacote) {
				this.pesoPacote = pesoPacote;
			}

			public float getPesoPacoteUni() {
				return pesoPacoteUni;
			}

			public void setPesoPacoteUni(float pesoPacoteUni) {
				this.pesoPacoteUni = pesoPacoteUni;
			}

			public float getPesoUnidade() {
				return pesoUnidade;
			}

			public void setPesoUnidade(float pesoUnidade) {
				this.pesoUnidade = pesoUnidade;
			}

			public float getQtdBisco() {
				return qtdBisco;
			}

			public void setQtdBisco(float qtdBisco) {
				this.qtdBisco = qtdBisco;
			}

			public String getEmbalagem() {
				return embalagem;
			}

			public void setEmbalagem(String embalagem) {
				this.embalagem = embalagem;
			}

			public String getSoldaVert() {
				return soldaVert;
			}

			public void setSoldaVert(String soldaVert) {
				this.soldaVert = soldaVert;
			}

			public String getSoldaSuperior() {
				return soldaSuperior;
			}

			public void setSoldaSuperior(String soldaSuperior) {
				this.soldaSuperior = soldaSuperior;
			}

			public String getSoldaInferior() {
				return soldaInferior;
			}

			public void setSoldaInferior(String soldaInferior) {
				this.soldaInferior = soldaInferior;
			}

			public String getLoteValPrima() {
				return loteValPrima;
			}

			public void setLoteValPrima(String loteValPrima) {
				this.loteValPrima = loteValPrima;
			}

			public String getLoteValSecun() {
				return loteValSecun;
			}

			public void setLoteValSecun(String loteValSecun) {
				this.loteValSecun = loteValSecun;
			}

			public String getEtiquetaSecun() {
				return etiquetaSecun;
			}

			public void setEtiquetaSecun(String etiquetaSecun) {
				this.etiquetaSecun = etiquetaSecun;
			}			
	
}
