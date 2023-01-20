package br.com.alura.loja.dao;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.vo.RelatorioDeVendasVo;

public class PedidoDao {

	private EntityManager em;

	public PedidoDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Pedido pedido) {
		this.em.persist(pedido);
	}

	public BigDecimal valorTotalVendido() {
		String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
		return em.createQuery(jpql, BigDecimal.class).getSingleResult();
	}
	
	public List<RelatorioDeVendasVo> relatorioDeVendas() {
		String jpql = "SELECT new br.com.alura.loja.vo.RelatorioDeVendasVo(pr.nome, SUM(i.quantidade), MAX(pe.data)) FROM Pedido pe JOIN pe.itens i JOIN i.produto pr GROUP BY pr.nome ORDER BY i.quantidade DESC";
		return em.createQuery(jpql, RelatorioDeVendasVo.class).getResultList();
	}
}