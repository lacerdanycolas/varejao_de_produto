package negocio.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import dados.CaixaRepository;
import exceptions.FormatacaoInvalidaException;
import negocio.entities.Caixa;
import varejao_de_produtos.ConnectionMySQL;

public class ControladorCaixa {

	private CaixaRepository repositoroioCaixa;

	public ControladorCaixa(CaixaRepository rep) {
		if(rep !=null){
			this.repositoroioCaixa = rep;
		}else{
			IllegalArgumentException x = new IllegalArgumentException("Repositorio invalido.");
			throw x;
		}
	}

	public Caixa buscarCaixa(Integer id) throws Exception{
		if(id>0 /*and conexao tipo caixa*/){
			return repositoroioCaixa.getOne(id);
		}else{
			IllegalArgumentException x = new IllegalArgumentException("Repositorio invalido.");
			throw x;
		}
	}

	public Collection<Caixa> listarCaixa() throws Exception{
		return repositoroioCaixa.getAll();
	}



	public Caixa salvarCaixa(Caixa caixa) throws Exception{
		if(caixa == null)
			throw new FormatacaoInvalidaException();

		else
			return repositoroioCaixa.save(caixa);

	}

	public void deletarCaixa(Caixa caixa) throws Exception{
		if(caixa == null){
			throw new FormatacaoInvalidaException();
		}
		else if(repositoroioCaixa.getOne(caixa.getId()).equals(null))
			throw new Exception("Caixa no existe");
		else
			repositoroioCaixa.delete(caixa);
	}



}
