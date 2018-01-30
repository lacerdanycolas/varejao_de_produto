package negocio.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import dados.CaixaRepository;
import negocio.entities.Caixa;
import varejao_de_produtos.ConnectionMySQL;

public class ControladorCaixa {


	private CaixaRepository rep;

	public ControladorCaixa(CaixaRepository rep) {
		this.rep = rep;
	}

	public Caixa buscarCaixa(int id) throws Exception{
		if(id>0 /*and conexao tipo caixa*/){
			return rep.getOne(id);
		}
		return null;
	}

	public Collection<Caixa> listarCaixa() throws Exception{
		return rep.getAll();
	}

	public Caixa salvarCaixa(Caixa caixa) throws Exception{
		if(caixa.equals(null))
			throw new IllegalArgumentException();
		else
			return rep.save(caixa);
	}

	public void deletarCaixa(Caixa caixa) throws Exception{
		if(caixa.equals(null)){
			throw new IllegalArgumentException();
		}
		else if(rep.getOne(caixa.getId()).equals(null))
			throw new Exception("Caixa não existe");
		else
			rep.delete(caixa);
	}



}
