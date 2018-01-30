package negocio.controller;

import java.util.Collection;

import dados.CaixaRepository;
import negocio.entities.Caixa;

public class FachadaVarejao {

	private ControladorCaixa caixas;

	private static FachadaVarejao instance;

	private FachadaVarejao(){
		this.caixas = new ControladorCaixa(CaixaRepository.getInstance());
	}

	public static FachadaVarejao getInstance(){
		if(instance == null){
			instance = new FachadaVarejao();
		}
		return instance;
	}

	//BUSCAR
	public Caixa buscarCaixa(int id) throws Exception{
		return this.caixas.buscarCaixa(id);
	}

	//LISTAR
	public Collection<Caixa> listarCaixa() throws Exception{
		return this.caixas.listarCaixa();
	}

	//SALVAR
	public void salvarCaixa(Caixa caixa) throws Exception{
		this.caixas.salvarCaixa(caixa);
	}

	//DELETAR
	public void deletarCaixa(Caixa caixa) throws Exception{
		this.caixas.deletarCaixa(caixa);
	}



}
