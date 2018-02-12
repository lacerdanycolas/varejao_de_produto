package negocio.controller;

import java.util.Collection;

import dados.Fornecedor_representanteRepository;
import exceptions.FormatacaoInvalidaException;
import negocio.entities.Fornecedor_representante;
import negocio.entities.Produtoref;
import negocio.entities.Representante;

public class ControladorFornecedorRepresentante {

	private Fornecedor_representanteRepository repositorio;
	private static ControladorFornecedorRepresentante instance;

	public static ControladorFornecedorRepresentante getInstance(){
		if(instance == null){
			instance = new ControladorFornecedorRepresentante();
		}
		return instance;
	}

	public ControladorFornecedorRepresentante() {
		this.repositorio = Fornecedor_representanteRepository.getInstance();
	}

	public Fornecedor_representante buscarFornecedor_representante(Integer id) throws Exception{
		if(id>0 /*and conexao tipo caixa*/){
			return repositorio.getOne(id);
		}else{
			IllegalArgumentException x = new IllegalArgumentException("Repositorio invalido.");
			throw x;
		}
	}

	public Collection<Fornecedor_representante> listarFornecedor_representante() throws Exception{
		return repositorio.getAll();
	}



	public Fornecedor_representante salvarFornecedor_representante(Fornecedor_representante representante_forn) throws Exception{
		if(representante_forn == null)
			throw new FormatacaoInvalidaException();

		else
			return repositorio.save(representante_forn);

	}

	public void deletarFornecedor_representante(Fornecedor_representante representante_forn) throws Exception{
		if(representante_forn == null){
			throw new FormatacaoInvalidaException();
		}
		else if(repositorio.getOne(representante_forn.getId()).equals(null))
			throw new Exception("Representante no existe");
		else
			repositorio.delete(representante_forn);
	}

	public void alterarFornecedor_representante(Fornecedor_representante novoFornecedor_representante) throws Exception {
		if(novoFornecedor_representante == null){
			throw new FormatacaoInvalidaException();
		}else{
			this.repositorio.update(novoFornecedor_representante);
		}
	}
}
