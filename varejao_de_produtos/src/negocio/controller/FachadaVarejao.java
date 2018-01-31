package negocio.controller;

import java.util.Collection;

import dados.CaixaRepository;
import negocio.beans.Item_Venda;
import negocio.beans.Venda;
import negocio.entities.Caixa;

public class FachadaVarejao {

	private ControladorCaixa caixas;
	private ControladorVenda vendas;
	private Controlador_Item_Venda itens;

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
	
	
	//BUSCAR VENDA
	public Venda BuscarVenda(int id) throws Exception {
		return vendas.BuscarVenda(id);
	}
	
	//LISTAR VENDAS
	 public Collection<Venda> ListarVenda() throws Exception{
		 return vendas.ListarVenda();
	 }
	 
	 // CADASTRAR VENDA
	 public Venda CadastraVenda(Venda venda) throws Exception {
		 return vendas.CadastraVenda(venda);
	 }
	 
	 //DELETAR VENDA
	 public void DeletarVenda(Venda venda) throws Exception {
		  vendas.DeletarVenda(venda);
	 }
	 
	 //BUSCAR ITEM VENDA
	 
	 public Item_Venda Buscar_Itens_Venda(int id) throws Exception {
		 return itens.Buscar_Itens_Venda(id);
	 }
	 
	 //LISTAR ITENS VENDA
	 
	 public Collection<Item_Venda> Listar_Itens_Venda() throws Exception{
		 return itens.Listar_Itens_Venda();
	 }
	 
	 //CADASTRAR ITEM VENDA
	 
	 public void CadastrarItem_Venda(Item_Venda item) throws Exception {
		  itens.CadastrarItem_Venda(item);
	 }
	 
	 //DELETAR ITEM VENDA
	 
	 public void Deletar_Item_Venda (Item_Venda item) throws Exception {
		 itens.Deletar_Item_Venda(item);
	 }
	



}
