package br.com.alura.loja.modelo;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "actor")
public class Ator {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "actor_id")
	private Long id;
	@Column(name = "first_name")
	private String primeiroNome;
	@Column(name = "last_name")
	private String sobrenome;
	@Column(name = "last_update")
	private LocalDate ultimaAtualizacao;
	
	/*
	 * public Ator() {}
	 * 
	 * public Ator(String primeiroNome, String sobrenome, LocalDate
	 * ultimaAtualizacao) { this.primeiroNome = primeiroNome; this.sobrenome =
	 * sobrenome; this.ultimaAtualizacao = ultimaAtualizacao; }
	 */
	
	public String getPrimeiroNome() {
		return primeiroNome;
	}
	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public LocalDate getUltimaAtualizacao() {
		return ultimaAtualizacao;
	}
	public void setUltimaAtualizacao(LocalDate ultimaAtualizacao) {
		this.ultimaAtualizacao = ultimaAtualizacao;
	}
}
