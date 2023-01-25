package br.com.alura.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.alura.loja.modelo.Ator;

public class AtorDao {

	private EntityManager em;
	
	public AtorDao(EntityManager em) {
		this.em = em;
	}
	
	public List<Ator> listaAtores() {
		String jpql = "SELECT a FROM Ator a";
		return em.createQuery(jpql, Ator.class).getResultList();
	}
	
	public List<Ator> buscarPorParametros(String primeiroNome, String sobrenome) {
		String jpql = "SELECT a FROM Ator a WHERE 1=1";
		if (primeiroNome != null && !primeiroNome.trim().isEmpty()) {
			jpql += " AND a.primeiroNome = :nome";
		}
		if (sobrenome != null && !sobrenome.trim().isEmpty()) {
			jpql += " AND a.sobrenome = :sobrenome";
		}

		TypedQuery<Ator> query = em.createQuery(jpql, Ator.class);

		if (primeiroNome != null && !primeiroNome.trim().isEmpty()) {
			query.setParameter("nome", primeiroNome);
		}
		if (sobrenome != null && !sobrenome.trim().isEmpty()) {
			query.setParameter("sobrenome", sobrenome);
		}
		
		return query.getResultList();
	}
	
	public List<Ator> buscaPorParametrosComCriteria(String primeiroNome, String sobrenome) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Ator> query = builder.createQuery(Ator.class);
		Root<Ator> from = query.from(Ator.class);
		
		Predicate filtros = builder.and();
		if (primeiroNome != null && !primeiroNome.trim().isEmpty()) {
			filtros = builder.and(filtros, builder.equal(from.get("primeiroNome"), primeiroNome));
		}
		if (sobrenome != null && !sobrenome.trim().isEmpty()) {
			filtros = builder.and(filtros, builder.equal(from.get("sobrenome"), sobrenome));
		}
		query.where(filtros);
		
		return em.createQuery(query).getResultList();
	}
}
