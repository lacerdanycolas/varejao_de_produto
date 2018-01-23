package negocio.entities;

import negocio.preferencial_caixa;
import negocio.situacao_caixa;

public class Caixa {

	private int id;
	private String descricao;
	private situacao_caixa situacao;
	private preferencial_caixa e_preferencial;
	private String observacao;
	private int id_matriz;
	private int seq_filial;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public situacao_caixa getSituacao() {
		return situacao;
	}
	public void setSituacao(situacao_caixa situacao) {
		this.situacao = situacao;
	}
	public preferencial_caixa getE_preferencial() {
		return e_preferencial;
	}
	public void setE_preferencial(preferencial_caixa e_preferencial) {
		this.e_preferencial = e_preferencial;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public int getId_matriz() {
		return id_matriz;
	}
	public void setId_matriz(int id_matriz) {
		this.id_matriz = id_matriz;
	}
	public int getSeq_filial() {
		return seq_filial;
	}
	public void setSeq_filial(int seq_filial) {
		this.seq_filial = seq_filial;
	}
	@Override
	public String toString() {
		return "Caixa [id=" + id + ", descricao=" + descricao + ", situacao=" + situacao + ", e_preferencial="
				+ e_preferencial + ", observacao=" + observacao + ", id_matriz=" + id_matriz + ", seq_filial="
				+ seq_filial + "]";
	}




}
