package persistencia;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.Formulario;
import beans.Pessoa;

public class FormularioDAO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	public static void inserir(Formulario formulario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = (Transaction) sessao.beginTransaction();
		sessao.save(formulario);
		t.commit();
		sessao.close();
	}
	
	public static void inserirVarios(List<Formulario> ListaFormularios) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = (Transaction) sessao.beginTransaction();
		sessao.save(ListaFormularios);
		t.commit();
		sessao.close();
	}
	
	public static void alterar(Formulario formulario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = (Transaction) sessao.beginTransaction();
		sessao.update(formulario);
		t.commit();
		sessao.close();
	}

	public static void excluir(Formulario formulario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = (Transaction) sessao.beginTransaction();
		sessao.delete(formulario);
		t.commit();
		sessao.close();		
	}
	
	public static List<Formulario> listagem(Pessoa pes, int form) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta;
		String consul;
		if (form != 0 && form !=1) {
			if(pes.getTipo().equals("ROLE_ADMINISTRADOR")) {
				consul ="from Formulario order by form_dataform desc";
			}else {
				consul = "from Formulario where form_pes_id = "+pes.getId()+" order by form_dataform desc";
			}
		} else {	
			if(pes.getTipo().equals("ROLE_ADMINISTRADOR")) {
				consul = "from Formulario where form_status="+form+" order by form_dataform desc";
			}else {
				consul = "from Formulario where form_status="+form+" and form_pes_id="+pes.getId()+" order by form_dataform desc";
			}
		}
		consulta = sessao.createQuery(consul);
		List<Formulario> lista = consulta.list();
		sessao.close();
		return lista;
	}
}
