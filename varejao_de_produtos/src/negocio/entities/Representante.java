package negocio.entities;

import dados.MeuId;

public class Representante {

	@MeuId
	private Integer id;
	private String cpf;
	private String nome;
	private String email;
	private String telefone;
	public Representante(String cpf, String nome, String email, String telefone) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Representante [id=" + id + ", cpf=" + cpf + ", nome=" + nome + ", email=" + email + ", telefone="
				+ telefone + "]";
	}




}
