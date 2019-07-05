package persistencia;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import beans.Formulario;
import beans.Rota;

public class RotaDAO implements Serializable {

private static final long serialVersionUID = 1L;
	
	public static List<Rota> listagem(Formulario form) {
		System.out.println(" |  |  |  =========== ROTA DAO ============== |  |  |  ");
		System.out.println("\\_/\\_/\\_/                                    \\_/\\_/\\_/");
		Query consulta;
		Session sessao = HibernateUtil.getSessionFactory().openSession();
			consulta = sessao.createQuery("from Rota where rota_form_id like :parametro order by rota_id");
			consulta.setString("parametro", "%" + form.getId() + "%");
			System.out.println("-----\n\n" + consulta.list().size() + "\n\n-----");
		List<Rota> lista = consulta.list();
		System.out.println(" ^  ^  ^  =========== ROTA DAO ============== ^  ^  ^  ");
		System.out.println(" |  |  |                                      |  |  |  ");
		sessao.close();		
		return lista;		
	}
}
