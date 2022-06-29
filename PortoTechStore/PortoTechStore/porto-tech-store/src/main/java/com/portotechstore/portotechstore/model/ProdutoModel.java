package com.portotechstore.portotechstore.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Entity // Indica que essa classe será uma entidade
@Table(name = "produtos") // Nome da tabela no banco de dados
public class ProdutoModel {
	
	//teste commit
	// Campos da Tabela: ID,NOME,PRECO_VENDA,PRECO_CUSTO,QTDE_ESTOQUE,DATA_CADASTRO

	// Id do Produto
	@Id // Chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Gerador automático de Ids (Ex: 1,2,3,4,5...)
	private long idProduto;

	// Nome Produtos
	@NotNull // Obrigatório // Qtde de caracteres no nome
	private String nomeProduto;

	// Preço de Venda
	@NotNull // ??????????? É apenas isso mesmo?
	@PositiveOrZero
	private double precoVendaProduto;

	//descricao
	@NotNull
	private String descricaoProduto;

	// Qtde Estoque
	@NotNull
	@PositiveOrZero
	private int qtdeEstoqueProduto;
	
	@NotNull
	private String urlFotoProduto;
	
	@NotNull
	private String categoriaProduto;
	
	@NotNull
	
	private String marcaProduto;
	// Data de Cadastro
	@Temporal(TemporalType.TIMESTAMP) //Informando que o tipo de dado é um tipo date timestamp
	private Date createdDateProduto = new java.sql.Date(System.currentTimeMillis());// Captura a data exata que o dado foi inserido

	public long getIdProduto() {
		return this.idProduto;
	}

	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return this.nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public double getPrecoVendaProduto() {
		return this.precoVendaProduto;
	}

	public void setPrecoVendaProduto(double precoVendaProduto) {
		this.precoVendaProduto = precoVendaProduto;
	}

	public int getQtdeEstoqueProduto() {
		return this.qtdeEstoqueProduto;
	}

	public void setQtdeEstoqueProduto(int qtdeEstoqueProduto) {
		this.qtdeEstoqueProduto = qtdeEstoqueProduto;
	}

	public Date getCreatedDateProduto() {
		return this.createdDateProduto;
	}

	public void setCreatedDateProduto(Date createdDateProduto) {
		this.createdDateProduto = createdDateProduto;
	}

	public String getUrlFotoProduto() {
		return urlFotoProduto;
	}

	public void setUrlFotoProduto(String urlFotoProduto) {
		this.urlFotoProduto = urlFotoProduto;
	}

	public String getCategoriaProduto() {
		return categoriaProduto;
	}

	public void setCategoriaProduto(String categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}

	public String getMarcaProduto() {
		return marcaProduto;
	}

	public void setMarcaProduto(String marcaProduto) {
		this.marcaProduto = marcaProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	
}