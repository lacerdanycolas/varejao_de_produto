package negocio.controller;

import java.util.Collection;

import dados.CaixaRepository;
import dados.ProdutorefRepository;
import dados.VendaRepository;
import negocio.entities.Caixa;
import negocio.entities.Produtoref;
import negocio.entities.Venda;
import dados.FornecedorrefRepository;

import dados.FuncionarioRepository;
import dados.Item_Venda_Repository;
import negocio.entities.Caixa;

import negocio.entities.Fornecedorref;

import negocio.entities.Funcionario;
import negocio.entities.Item_Venda;


public class FachadaVarejao {

	private ControladorCaixa caixas;
	private ControladorProduto produtos;
	private ControladorVenda vendas;
	private ControladorFornecedorref fornecedores;
	private Controlador_Item_Venda itens;
	private ControladorFuncionario funcionarios;


	private static FachadaVarejao instance;

	private FachadaVarejao(){
		this.caixas = new ControladorCaixa(CaixaRepository.getInstance());
		this.produtos = new ControladorProduto(ProdutorefRepository.getInstance());
		this.vendas = new ControladorVenda(VendaRepository.getInstance());
		this.fornecedores = new ControladorFornecedorref(FornecedorrefRepository.getInstance());
		this.itens = new Controlador_Item_Venda(Item_Venda_Repository.getInstance());
		this.funcionarios = new ControladorFuncionario(FuncionarioRepository.getInstance());

	}

	public static FachadaVarejao getInstance(){
		if(instance == null){
			instance = new FachadaVarejao();
		}
		return instance;
	}

	//BUSCAR CAIXA
	public Caixa buscarCaixa(Integer id) throws Exception{
		return this.caixas.buscarCaixa(id);
	}

	public Fornecedorref buscarFornecedor(int id) throws Exception{
		return this.fornecedores.buscarFornecedor(id);
	}


	//LISTAR

	//LISTAR CAIXA

	public Collection<Caixa> listarCaixa() throws Exception{
		return this.caixas.listarCaixa();
	}

	public Collection<Fornecedorref> listarFornecedores() throws Exception{
		return this.fornecedores.listarFornecedor();
	}

	//SALVAR CAIXA
	public void salvarCaixa(Caixa caixa) throws Exception{
		this.caixas.salvarCaixa(caixa);
	}


	public void salvarFornecedor(Fornecedorref fornecedor) throws Exception{
		this.fornecedores.salvarFornecedor(fornecedor);
	}

	//DELETAR

	//DELETAR CAIXA

	public void deletarCaixa(Caixa caixa) throws Exception{
		this.caixas.deletarCaixa(caixa);
	}

//PRODUTOS
	//BUSCAR
	public Produtoref buscarProduto(int id) throws Exception{
		return this.produtos.buscarProduto(id);
	}

	//LISTAR
	public Collection<Produtoref> listarProduto() throws Exception{
		return this.produtos.listarProduto();
	}

	//SALVAR
	public void salvarProduto(Produtoref produto) throws Exception{
		this.produtos.salvarProduto(produto);
	}

	//DELETAR
	public void deletarProduto(Produtoref produto) throws Exception{
		this.produtos.deletarProduto(produto);
	}

		//BUSCAR FUNCIONARIO
	public Funcionario buscarFuncionario (Integer id) throws Exception{
		return this.funcionarios.buscarFuncionario(id);
	}

	//LISTAR FUNCIONARIO
	public Collection<Funcionario> listarFuncionario() throws Exception{
		return this.funcionarios.listarFuncionario();
	}

	//SALVAR FUNCIONARIO
	public void salvarFuncionario(Funcionario funcionario) throws Exception{
		this.funcionarios.salvarFuncionario(funcionario);
	}

	//DELETAR FUNCIONARIO
	public void deletarFuncionario(Funcionario funcionario) throws Exception{
		this.funcionarios.deletarFuncionario(funcionario);
	}

	//LOGIN FUNCIONARIO
	public boolean efetuarLoginFuncionario(String login, String senha) throws Exception{
		if(this.funcionarios.efetuarLogin(login, senha) == true){
			return true;
		}else{
			return false;
		}
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

	public void deletarFornecedor(Fornecedorref fornecedor) throws Exception{
		this.fornecedores.deletarFornecedor(fornecedor);
	}


}

