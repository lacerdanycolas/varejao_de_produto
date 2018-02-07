package negocio.controller;

import java.util.Collection;

import dados.FornecedorrefRepository;
import exceptions.FormatacaoInvalidaException;
import negocio.entities.Caixa;
import negocio.entities.Fornecedorref;

public class ControladorFornecedorref {

	private FornecedorrefRepository repositorio;
	private static ControladorFornecedorref instance;
	
	public static ControladorFornecedorref getInstance(){
		if(instance == null){
			instance = new ControladorFornecedorref();
		}
		return instance;
	}
	public ControladorFornecedorref() {
		this.repositorio = FornecedorrefRepository.getInstance();
	}

	public Fornecedorref buscarFornecedor(int id) throws Exception{
		if(id>0 /*and conexao tipo caixa*/){
			return repositorio.getOne(id);
		}
		return null;
	}

	public Collection<Fornecedorref> listarFornecedor() throws Exception{
		return repositorio.getAll();
	}

	public void salvarFornecedor(Fornecedorref fornecedor) throws Exception{
		if(fornecedor.equals(null))
			throw new IllegalArgumentException();
		else
			repositorio.save(fornecedor);
	}

	public void deletarFornecedor(Fornecedorref fornecedor) throws Exception{
		if(fornecedor.equals(null)){
			throw new IllegalArgumentException();
		}
		else if(repositorio.getOne(fornecedor.getId()).equals(null))
			throw new Exception("Fornecedor n�o existe");
		else
			repositorio.delete(fornecedor);
	}
	
	public void alterarFornecedor (Fornecedorref novoForn) throws Exception {
		if (novoForn == null) {
			throw new FormatacaoInvalidaException();
		} else {
			this.repositorio.update(novoForn);
		}
	}

}
