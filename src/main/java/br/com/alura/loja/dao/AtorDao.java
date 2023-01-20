package br.com.alura.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;

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
}
