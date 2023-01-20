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
	}
}
