package negocio.controller;

import java.util.Collection;

import dados.RepresentanteRepository;
import exceptions.FormatacaoInvalidaException;
import negocio.entities.Representante;

public class ControladorRepresentante {

	private RepresentanteRepository repositorio;
	private static ControladorRepresentante instance;
	
	public static ControladorRepresentante getInstance(){
		if(instance == null){
			instance = new ControladorRepresentante();
		}
		return instance;
	}
	
	public ControladorRepresentante() {
		this.repositorio = RepresentanteRepository.getInstance();
	}

	public Representante buscarRepresentante(Integer id) throws Exception{
		if(id>0 /*and conexao tipo caixa*/){
			return repositorio.getOne(id);
		}else{
			IllegalArgumentException x = new IllegalArgumentException("Repositorio invalido.");
			throw x;
		}
	}

	public Collection<Representante> listarRepresentante() throws Exception{
		return repositorio.getAll();
	}



	public Representante salvarRepresentante(Representante representante) throws Exception{
		if(representante == null)
			throw new FormatacaoInvalidaException();

		else
			return repositorio.save(representante);

	}

	public void deletarRepresentante(Representante representante) throws Exception{
		if(representante == null){
			throw new FormatacaoInvalidaException();
		}
		else if(repositorio.getOne(representante.getId()).equals(null))
			throw new Exception("Representante no existe");
		else
			repositorio.delete(representante);
	}
}
