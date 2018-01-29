package controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import dados.CaixaRepository;
import negocio.entities.Caixa;
import varejao_de_produtos.ConnectionMySQL;

public class ControladorCaixa {

	CaixaRepository rep = CaixaRepository.getInstance();

	public Caixa getOne(int id) throws Exception{
		if(id>0 /*and conexao tipo caixa*/){
			return rep.getOne(id);
		}
		return null;
	}

	public Collection<Caixa> getAll() throws Exception{
		return rep.getAll();
	}

	public Caixa save(Caixa caixa) throws Exception{
		if(caixa.equals(null))
			throw new IllegalArgumentException();
		else
			return rep.save(caixa);
	}

	public void delete(Caixa caixa) throws Exception{
		if(caixa.equals(null)){
			throw new IllegalArgumentException();
		}
		else if(rep.getOne(caixa.getId()).equals(null))
			throw new Exception("Caixa não existe");
		else
			rep.delete(caixa);
	}



}
