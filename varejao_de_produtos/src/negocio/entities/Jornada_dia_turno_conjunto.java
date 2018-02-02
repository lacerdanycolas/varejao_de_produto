package negocio.entities;

import dados.MeuId;

public class Jornada_dia_turno_conjunto {

	@MeuId
	private Integer id;
	private Integer id_jornada;
	private Integer sequencial_dia;
	private Integer codigo_turno;

	public Jornada_dia_turno_conjunto(Integer id_jornada, Integer sequencial_dia, Integer codigo_turno) {

		this.id_jornada = id_jornada;
		this.sequencial_dia = sequencial_dia;
		this.codigo_turno = codigo_turno;
	}
	public Jornada_dia_turno_conjunto(){

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_jornada() {
		return id_jornada;
	}

	public void setId_jornada(Integer id_jornada) {
		this.id_jornada = id_jornada;
	}

	public Integer getSequencial_dia() {
		return sequencial_dia;
	}

	public void setSequencial_dia(Integer sequencial_dia) {
		this.sequencial_dia = sequencial_dia;
	}

	public Integer getCodigo_turno() {
		return codigo_turno;
	}

	public void setCodigo_turno(Integer codigo_turno) {
		this.codigo_turno = codigo_turno;
	}

	@Override
	public String toString() {
		return "Jornada_dia_turno_conjunto [id=" + id + ", id_jornada=" + id_jornada + ", sequencial_dia="
				+ sequencial_dia + ", codigo_turno=" + codigo_turno + "]";
	}




}
