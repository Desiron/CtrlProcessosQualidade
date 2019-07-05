package persistencia;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

import beans.Produto;
public class ProdutoDAO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public static List<Produto> listagem(String filtro) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta;
		if (filtro.trim().length() == 0) {
			consulta = sessao.createQuery("from Produto order by prod_descricao");
		} else {
			consulta = sessao.createQuery("from Produto where prod_descricao like :parametro order by prod_decricao");
			consulta.setString("parametro", "%" + filtro + "%");		
		}
		List<Produto> lista = consulta.list();
		sessao.close();
		return lista;
	}
	
	public static Produto consultaProd(String id) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta;
			consulta = sessao.createQuery("from Produto where prod_id="+id);		
		List<Produto> lista = consulta.list();
		sessao.close();
		return lista.get(0);
	}
}
