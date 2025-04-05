package br.com.acruz.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb_acessorios")
public class Acessorio {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carro_seq")
	@SequenceGenerator(name = "carro_seq", sequenceName = "sq_carro", initialValue = 1, allocationSize = 1)
	private Integer id;
	
	@Column(name = "codigo", length = 8, nullable = false)
	private String codigo;
	
	@Column(name = "nome", length = 20, nullable = false)
	private String nome;
	
	@Column(name = "descricao", length = 50)
	private String descricao;

	@ManyToOne
	List<Carro> Carro;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Carro> getCarro() {
		return Carro;
	}

	public void setCarro(List<Carro> carro) {
		Carro = carro;
	}
	
}
