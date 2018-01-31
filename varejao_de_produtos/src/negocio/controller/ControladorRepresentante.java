package negocio.controller;

import java.util.Collection;

import dados.CaixaRepository;
import dados.RepresentanteRepository;
import exceptions.FormatacaoInvalidaException;
import negocio.entities.Caixa;
import negocio.entities.Representante;

public class ControladorRepresentante {

	private RepresentanteRepository repositorioRepresentante;

	public ControladorRepresentante(RepresentanteRepository rep) {
		if(rep !=null){
			this.repositorioRepresentante = rep;
		}else{
			IllegalArgumentException x = new IllegalArgumentException("Repositorio invalido.");
			throw x;
		}
	}

	public Representante buscarRepresentante(Integer id) throws Exception{
		if(id>0 /*and conexao tipo caixa*/){
			return repositorioRepresentante.getOne(id);
		}else{
			IllegalArgumentException x = new IllegalArgumentException("Repositorio invalido.");
			throw x;
		}
	}

	public Collection<Representante> listarRepresentante() throws Exception{
		return repositorioRepresentante.getAll();
	}



	public Representante salvarRepresentante(Representante representante) throws Exception{
		if(representante == null)
			throw new FormatacaoInvalidaException();

		else
			return repositorioRepresentante.save(representante);

	}

	public void deletarRepresentante(Representante representante) throws Exception{
		if(representante == null){
			throw new FormatacaoInvalidaException();
		}
		else if(repositorioRepresentante.getOne(representante.getId()).equals(null))
			throw new Exception("Representante no existe");
		else
			repositorioRepresentante.delete(representante);
	}
}
