package negocio.controller;

import java.util.Collection;

import dados.FornecedorrefRepository;
import negocio.entities.Caixa;
import negocio.entities.Fornecedorref;

public class ControladorFornecedorref {

	private FornecedorrefRepository rep;

	public ControladorFornecedorref(FornecedorrefRepository rep) {
		this.rep = rep;
	}

	public Fornecedorref buscarFornecedor(int id) throws Exception{
		if(id>0 /*and conexao tipo caixa*/){
			return rep.getOne(id);
		}
		return null;
	}

	public Collection<Fornecedorref> listarFornecedor() throws Exception{
		return rep.getAll();
	}

	public void salvarFornecedor(Fornecedorref fornecedor) throws Exception{
		if(fornecedor.equals(null))
			throw new IllegalArgumentException();
		else
			rep.save(fornecedor);
	}

	public void deletarFornecedor(Fornecedorref fornecedor) throws Exception{
		if(fornecedor.equals(null)){
			throw new IllegalArgumentException();
		}
		else if(rep.getOne(fornecedor.getId()).equals(null))
			throw new Exception("Fornecedor não existe");
		else
			rep.delete(fornecedor);
	}

}
