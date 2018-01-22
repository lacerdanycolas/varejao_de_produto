package negocio.beans;

import java.sql.Time;

import com.mysql.jdbc.TimeUtil;

public class Turno {

	private int codigo;
	private String descricao;
	private Time hora_inicio;
	private Time hora_fim;
	public Turno(int codigo, String descricao, Time hora_inicio, Time hora_fim) {
		
		this.codigo = codigo;
		this.descricao = descricao;
		this.hora_inicio = hora_inicio;
		this.hora_fim = hora_fim;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Time getHora_inicio() {
		return hora_inicio;
	}
	public void setHora_inicio(Time hora_inicio) {
		this.hora_inicio = hora_inicio;
	}
	public Time getHora_fim() {
		return hora_fim;
	}
	public void setHora_fim(Time hora_fim) {
		this.hora_fim = hora_fim;
	}
	

	public String toString() {
		return "Turno [codigo=" + codigo + ", descricao=" + descricao + ", hora_inicio=" + hora_inicio + ", hora_fim="
				+ hora_fim + "]";
	}
	
	
	
}
