package negocio.entities;

public class Coordenador extends Funcionario{

	public Coordenador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Coordenador(String cpf, Sexo sexo, Estado_Civil estadoC, String rg, String primeiro_nome,
			String segundo_nome, String terceiro_nome, Situacao situacao, String rua, String bairro, String estado,
			String cep, String login, String senha, String cpf_gerente, Tipo_Funcionario tipo, String cnpj_matriz,
			Integer seq_filial) {
		super(cpf, sexo, estadoC, rg, primeiro_nome, segundo_nome, terceiro_nome, situacao, rua, bairro, estado, cep, login,
				senha, cpf_gerente, tipo, cnpj_matriz, seq_filial);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Coordenador [getId()=" + getId() + ", getCpf()=" + getCpf() + ", getSexo()=" + getSexo()
				+ ", getEstadoC()=" + getEstadoC() + ", getRg()=" + getRg() + ", getPrimeiro_nome()="
				+ getPrimeiro_nome() + ", getSegundo_nome()=" + getSegundo_nome() + ", getTerceiro_nome()="
				+ getTerceiro_nome() + ", getSituacao()=" + getSituacao() + ", getRua()=" + getRua() + ", getBairro()="
				+ getBairro() + ", getEstado()=" + getEstado() + ", getCep()=" + getCep() + ", getLogin()=" + getLogin()
				+ ", getSenha()=" + getSenha() + ", getCpf_gerente()=" + getCpf_gerente() + ", getTipo()=" + getTipo()
				+ ", getCnpj_matriz()=" + getCnpj_matriz() + ", getSeq_filial()=" + getSeq_filial() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	

}
