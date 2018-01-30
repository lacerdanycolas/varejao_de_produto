package negocio.entities;

import java.util.Comparator;

import dados.MeuId;

public class Caixa {
	@MeuId
	private Integer id;
	private String descricao;
	private Situacao situacao;
	private Preferencial_Caixa e_preferencial;
	private String observacao;
	private Integer id_matriz;
	private Integer sequencial_filial;

	public Caixa(){

	}

	public Caixa(String descricao, Situacao situacao, Preferencial_Caixa e_preferencial,
			String observacao, int id_matriz, int seq_filial) {
		super();
		this.descricao = descricao;
		this.situacao = situacao;
		this.e_preferencial = e_preferencial;
		this.observacao = observacao;
		this.id_matriz = id_matriz;
		this.sequencial_filial = seq_filial;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Situacao getSituacao() {
		return situacao;
	}
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	public Preferencial_Caixa getE_preferencial() {
		return e_preferencial;
	}
	public void setE_preferencial(Preferencial_Caixa e_preferencial) {
		this.e_preferencial = e_preferencial;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Integer getId_matriz() {
		return id_matriz;
	}
	public void setId_matriz(Integer id_matriz) {
		this.id_matriz = id_matriz;
	}
	public Integer getSeq_filial() {
		return sequencial_filial;
	}
	public void setSeq_filial(Integer seq_filial) {
		this.sequencial_filial = seq_filial;
	}
	@Override
	public String toString() {
		return "Caixa [id=" + id + ", descricao=" + descricao + ", situacao=" + situacao + ", e_preferencial="
				+ e_preferencial + ", observacao=" + observacao + ", id_matriz=" + id_matriz + ", seq_filial="
				+ sequencial_filial + "]";
	}
	
	




}
