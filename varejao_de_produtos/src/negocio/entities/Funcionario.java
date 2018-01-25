package negocio.entities;

import dados.MeuId;

public class Funcionario {
	@MeuId
	private Integer id;
	private String cpf;
	private Sexo sexo;
	private Estado_Civil estado_civil;
	private String rg;
	private String primeiro_nome;
	private String segundo_nome;
	private String terceiro_nome;
	private Situacao situacao;
	private String rua;
	private String bairro;
	private String estado;
	private String cep;
	private String login;
	private String senha;
	private String cpf_gerente;
	private Tipo_Funcionario tipo_funcionario;
	private String cnpj_matriz;
	private Integer seq_filial;
	
	
	public Funcionario() {
		//Implementar construtor default em todos
	}
	public Funcionario(Integer id, String cpf, Sexo sexo, Estado_Civil estadoC, String rg, String primeiro_nome,
			String segundo_nome, String terceiro_nome, Situacao situacao, String rua, String bairro, String estado,
			String cep, String login, String senha, String cpf_gerente, Tipo_Funcionario tipo, String cnpj_matriz,
			Integer seq_filial) {
		this.id = id;
		this.cpf = cpf;
		this.sexo = sexo;
		this.estado_civil = estadoC;
		this.rg = rg;
		this.primeiro_nome = primeiro_nome;
		this.segundo_nome = segundo_nome;
		this.terceiro_nome = terceiro_nome;
		this.situacao = situacao;
		this.rua = rua;
		this.bairro = bairro;
		this.estado = estado;
		this.cep = cep;
		this.login = login;
		this.senha = senha;
		this.cpf_gerente = cpf_gerente;
		this.tipo_funcionario = tipo;
		this.cnpj_matriz = cnpj_matriz;
		this.seq_filial = seq_filial;
	}
	
	public int getId() {
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
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public Estado_Civil getEstadoC() {
		return estado_civil;
	}
	public void setEstadoC(Estado_Civil estadoC) {
		this.estado_civil = estadoC;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getPrimeiro_nome() {
		return primeiro_nome;
	}
	public void setPrimeiro_nome(String primeiro_nome) {
		this.primeiro_nome = primeiro_nome;
	}
	public String getSegundo_nome() {
		return segundo_nome;
	}
	public void setSegundo_nome(String segundo_nome) {
		this.segundo_nome = segundo_nome;
	}
	public String getTerceiro_nome() {
		return terceiro_nome;
	}
	public void setTerceiro_nome(String terceiro_nome) {
		this.terceiro_nome = terceiro_nome;
	}
	public Situacao getSituacao() {
		return situacao;
	}
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCpf_gerente() {
		return cpf_gerente;
	}
	public void setCpf_gerente(String cpf_gerente) {
		this.cpf_gerente = cpf_gerente;
	}
	public Tipo_Funcionario getTipo() {
		return tipo_funcionario;
	}
	public void setTipo(Tipo_Funcionario tipo) {
		this.tipo_funcionario = tipo;
	}
	public String getCnpj_matriz() {
		return cnpj_matriz;
	}
	public void setCnpj_matriz(String cnpj_matriz) {
		this.cnpj_matriz = cnpj_matriz;
	}
	public Integer getSeq_filial() {
		return seq_filial;
	}
	public void setSeq_filial(Integer seq_filial) {
		this.seq_filial = seq_filial;
	}
	
	
	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", cpf=" + cpf + ", sexo=" + sexo + ", estadoC=" + estado_civil + ", rg=" + rg
				+ ", primeiro_nome=" + primeiro_nome + ", segundo_nome=" + segundo_nome + ", terceiro_nome="
				+ terceiro_nome + ", situacao=" + situacao + ", rua=" + rua + ", bairro=" + bairro + ", estado="
				+ estado + ", cep=" + cep + ", login=" + login + ", senha=" + senha + ", cpf_gerente=" + cpf_gerente
				+ ", tipo=" + tipo_funcionario + ", cnpj_matriz=" + cnpj_matriz + ", seq_filial=" + seq_filial + "]";
	}
	
	
	
	
}
