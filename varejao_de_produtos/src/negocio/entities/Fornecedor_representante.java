package negocio.entities;

import java.util.Date;

import dados.MeuId;

public class Fornecedor_representante {

	@MeuId
	private Integer id;

	private Integer id_fornecedor;
	private Integer id_representante;
	private Date data_inicio;
	private Date data_fim;

	public Fornecedor_representante(Integer id_fornecedor, Integer id_representante, Date data_inicio, Date data_fim) {
		super();
		this.id_fornecedor = id_fornecedor;
		this.id_representante = id_representante;
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;
	}
	public Fornecedor_representante(){
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_fornecedor() {
		return id_fornecedor;
	}
	public void setId_fornecedor(Integer id_fornecedor) {
		this.id_fornecedor = id_fornecedor;
	}
	public Integer getId_representante() {
		return id_representante;
	}
	public void setId_representante(Integer id_representante) {
		this.id_representante = id_representante;
	}
	public Date getData_Inicio() {
		return data_inicio;
	}
	public void setData_Inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}
	public Date getData_fim() {
		return data_fim;
	}
	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
	}



}
