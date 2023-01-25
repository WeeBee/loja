package br.com.alura.loja;
import java.util.List;
import javax.persistence.EntityManager;
import br.com.alura.loja.dao.AtorDao;
import br.com.alura.loja.modelo.Ator;
import br.com.alura.loja.util.JPAUtil;

public class Atores {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getMyEntityManager();
		AtorDao atorDao = new AtorDao(em);
		List<Ator> listaAtores = atorDao.listaAtores();
		listaAtores.forEach(a -> System.out.println(a.getPrimeiroNome() + " " + a.getSobrenome()));
		System.out.println("quantidade de registros: " + listaAtores.size());

		System.out.println("\npesquisando somente os Williams, temos:\n");
		List<Ator> listaWilliams = atorDao.buscarPorParametros(null, "Williams");
		listaWilliams.forEach(w -> System.out.println(w.getPrimeiroNome() + " " + w.getSobrenome()));

		System.out.println("\npesquisando os Kenneth com Criteria:\n");
		List<Ator> listaKennethComCriteria = atorDao.buscaPorParametrosComCriteria("Kenneth", null);
		listaKennethComCriteria.forEach(w2 -> System.out.println(w2.getPrimeiroNome() + " " + w2.getSobrenome()));
	}
}
