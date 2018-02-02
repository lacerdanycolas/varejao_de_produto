package negocio.controller;


import java.util.Collection;
import dados.CaixaRepository;
import exceptions.FormatacaoInvalidaException;
import negocio.entities.Caixa;

public class ControladorCaixa {

	private CaixaRepository repositoroio;
	private static ControladorCaixa instance;
	public static ControladorCaixa getInstance(){
		if(instance==null){
			instance = new ControladorCaixa();
		}
		return instance;
	}

	public ControladorCaixa() {
		this.repositoroio = CaixaRepository.getInstance();
	}

	public Caixa buscarCaixa(Integer id) throws Exception{
		if(id>0 /*and conexao tipo caixa*/){
			return repositoroio.getOne(id);
		}else{
			IllegalArgumentException x = new IllegalArgumentException("Repositorio invalido.");
			throw x;
		}
	}

	public Collection<Caixa> listarCaixa() throws Exception{
		return repositoroio.getAll();
	}



	public Caixa salvarCaixa(Caixa caixa) throws Exception{
		if(caixa == null)
			throw new FormatacaoInvalidaException();

		else
			return repositoroio.save(caixa);

	}

	public void deletarCaixa(Caixa caixa) throws Exception{
		if(caixa == null){
			throw new FormatacaoInvalidaException();
		}
		else if(repositoroio.getOne(caixa.getId()).equals(null))
			throw new Exception("Caixa no existe");
		else
			repositoroio.delete(caixa);
	}



}
