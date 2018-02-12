package negocio.controller;

import java.util.ArrayList;
import java.util.Collection;

import negocio.entities.Caixa;
import negocio.entities.Categoriaref;
import negocio.entities.Fornecedor_representante;
import negocio.entities.Fornecedorref;
import negocio.entities.Funcionario;
import negocio.entities.Item_Estoque;
import negocio.entities.Item_Pedido;
import negocio.entities.Item_Venda;
import negocio.entities.Marcaref;
import negocio.entities.Pedido_Fornecedor;
import negocio.entities.Produtoref;
import negocio.entities.Sub_categoriaref;
import negocio.entities.Unidaderef;
import negocio.entities.Venda;

public class FachadaVarejao {
	private ControladorCaixa caixas;
	private ControladorProduto produtos;
	private ControladorPedidoFornecedor pedidoFornecedor;
	private ControladorItemPedido itemPedido;
	private ControladorVenda vendas;
	private ControladorFornecedorref fornecedores;
	private Controlador_Item_Venda itens;
	private ControladorFuncionario funcionarios;
	private ControladorCategoria categoria;
	private ControladorSubcategoria subcategoria;
	private ControladorUnidade unidade;
	private ControladorMarca marca;
	private ControladorFornecedorRepresentante representante_forn;
	private ControladorItemEstoque itemEstoque;


	private ControladorRepresentante representantes;

	private static FachadaVarejao instance;

	private FachadaVarejao() {

		this.caixas = ControladorCaixa.getInstance();
		this.produtos = ControladorProduto.getInstance();
		this.pedidoFornecedor = ControladorPedidoFornecedor.getInstance();
		this.itemPedido = ControladorItemPedido.getInstance();
		this.vendas = ControladorVenda.getInstance();
		this.fornecedores = ControladorFornecedorref.getInstance();
		this.itens = Controlador_Item_Venda.getInstance();
		this.funcionarios = ControladorFuncionario.getInstance();
		this.categoria = ControladorCategoria.getInstance();
		this.subcategoria = ControladorSubcategoria.getInstance();
		this.unidade = ControladorUnidade.getInstance();
		this.marca = ControladorMarca.getInstance();
		this.representante_forn = ControladorFornecedorRepresentante.getInstance();
		this.itemEstoque = ControladorItemEstoque.getInstance();

	}

	public static FachadaVarejao getInstance() {
		if (instance == null) {
			instance = new FachadaVarejao();
		}
		return instance;
	}

	// BUSCAR CAIXA
	public Caixa buscarCaixa(Integer id) throws Exception {
		return this.caixas.buscarCaixa(id);
	}

	public Fornecedorref buscarFornecedor(int id) throws Exception {
		return this.fornecedores.buscarFornecedor(id);
	}

	// LISTAR

	// LISTAR CAIXA

	public Collection<Caixa> listarCaixa() throws Exception {
		return this.caixas.listarCaixa();
	}

	public Collection<Fornecedorref> listarFornecedores() throws Exception {
		return this.fornecedores.listarFornecedor();
	}

	// SALVAR CAIXA
	public void salvarCaixa(Caixa caixa) throws Exception {
		this.caixas.salvarCaixa(caixa);
	}

	public void alterarCaixa(Caixa caixa) throws Exception {
		this.caixas.alterarCaixa(caixa);
	}

	public void salvarFornecedor(Fornecedorref fornecedor) throws Exception {
		this.fornecedores.salvarFornecedor(fornecedor);
	}

	// DELETAR

	// DELETAR CAIXA

	public void deletarCaixa(Caixa caixa) throws Exception {
		this.caixas.deletarCaixa(caixa);
	}

	// PRODUTOS
	// BUSCAR
	public ArrayList<Produtoref> buscarProdutosPorFornecedor(int fornecedorId) throws Exception {
		Collection<Produtoref> produtos = this.produtos.listarProduto();

		ArrayList<Produtoref> produtosFiltrados = new ArrayList<>();

		for (Produtoref produtoref : produtos) {
			if (produtoref.getId_fornecedor() == fornecedorId) {
				produtosFiltrados.add(produtoref);
			}
		}

		return produtosFiltrados;
	}

	public ArrayList<Fornecedor_representante> buscarRepresentatesPorFornecedor(int fornecedorId) throws Exception {
		Collection<Fornecedor_representante> representante_forn = this.representante_forn.listarFornecedor_representante();

		ArrayList<Fornecedor_representante> repsFiltrados = new ArrayList<>();

		for (Fornecedor_representante representante_forn1 : representante_forn) {
			if (representante_forn1.getId_fornecedor() == fornecedorId) {
				repsFiltrados.add(representante_forn1);
			}
		}

		return repsFiltrados;
	}

	public Produtoref buscarProduto(int id) throws Exception {
		return this.produtos.buscarProduto(id);
	}

	// LISTAR
	public Collection<Produtoref> listarProduto() throws Exception {
		return this.produtos.listarProduto();
	}

	// SALVAR
	public void salvarProduto(Produtoref produto) throws Exception {
		this.produtos.salvarProduto(produto);
	}

	// DELETAR
	public void deletarProduto(Produtoref produto) throws Exception {
		this.produtos.deletarProduto(produto);
	}

	// PEDIDOFORNECEDOR
	// BUSCAR
	public Pedido_Fornecedor buscarPedidoFornecedor(int id) throws Exception {
		return this.pedidoFornecedor.buscarPedidoFornecedor(id);
	}

	// LISTAR
	public Collection<Pedido_Fornecedor> listarPedidoFornecedor() throws Exception {
		return this.pedidoFornecedor.listarPedidoFornecedor();
	}

	// SALVAR
	public void salvarPedidoFornecedor(Pedido_Fornecedor pedido) throws Exception {
		this.pedidoFornecedor.salvarPedidoFornecedor(pedido);
	}

	// DELETAR
	public void deletarPedidoFornecedor(Pedido_Fornecedor pedido) throws Exception {

		Collection<Item_Pedido> itens = this.listarItemPedido();

		for (Item_Pedido item : itens) {
			if (item.getId_pedido_fornecedor() == pedido.getId()) {
				this.itemPedido.deletarItemPedido(item);
			}
		}

		this.pedidoFornecedor.deletarPedidoFornecedor(pedido);
	}

	// ITEMPEDIDO
	// BUSCAR
	public Item_Pedido buscarItemPedido(int id) throws Exception {
		return this.itemPedido.buscarItemPedido(id);
	}

	// LISTAR
	public Collection<Item_Pedido> listarItemPedido() throws Exception {
		return this.itemPedido.listarItemPedido();
	}

	// SALVAR
	public void salvarItemPedido(Item_Pedido item) throws Exception {
		this.itemPedido.salvarItemPedido(item);
	}

	// DELETAR
	public void deletarItemPedido(Item_Pedido item) throws Exception {
		this.itemPedido.deletarItemPedido(item);
	}

	// BUSCAR FUNCIONARIO
	public Funcionario buscarFuncionario(Integer id) throws Exception {
		return this.funcionarios.buscarFuncionario(id);
	}

	// LISTAR FUNCIONARIO
	public Collection<Funcionario> listarFuncionario() throws Exception {
		return this.funcionarios.listarFuncionarios();
	}

	// SALVAR FUNCIONARIO
	public void salvarFuncionario(Funcionario funcionario) throws Exception {
		this.funcionarios.cadastrarFuncionario(funcionario);
	}

	// DELETAR FUNCIONARIO
	public void deletarFuncionario(Funcionario funcionario) throws Exception {
		this.funcionarios.deletarFuncionario(funcionario);
	}

	// LOGIN FUNCIONARIO
	public boolean efetuarLoginFuncionario(String login, String senha) throws Exception {
		return this.funcionarios.efetuarLogin(login, senha);
	}

	// BUSCAR VENDA
	public Venda BuscarVenda(int id) throws Exception {
		return vendas.BuscarVenda(id);
	}

	// LISTAR VENDAS
	public Collection<Venda> ListarVenda() throws Exception {
		return vendas.ListarVenda();
	}

	// CADASTRAR VENDA
	public Venda CadastraVenda(Venda venda) throws Exception {
		return vendas.CadastraVenda(venda);
	}

	// DELETAR VENDA
	public void DeletarVenda(Venda venda) throws Exception {
		vendas.DeletarVenda(venda);
	}

	// BUSCAR ITEM VENDA

	public Item_Venda Buscar_Itens_Venda(int id) throws Exception {
		return itens.Buscar_Itens_Venda(id);
	}

	// LISTAR ITENS VENDA

	public Collection<Item_Venda> Listar_Itens_Venda() throws Exception {
		return itens.Listar_Itens_Venda();
	}

	// CADASTRAR ITEM VENDA

	public void CadastrarItem_Venda(Item_Venda item) throws Exception {
		itens.CadastrarItem_Venda(item);
	}

	// DELETAR ITEM VENDA

	public void Deletar_Item_Venda(Item_Venda item) throws Exception {
		itens.Deletar_Item_Venda(item);
	}

	public void deletarFornecedor(Fornecedorref fornecedor) throws Exception {
		this.fornecedores.deletarFornecedor(fornecedor);
	}

	public void alterarFornecedor(Fornecedorref fornecedor) throws Exception {
		this.fornecedores.alterarFornecedor(fornecedor);
	}

	public void alterarProduto(Produtoref produto) throws Exception {
		this.produtos.alterarProduto(produto);
	}

	public void alterarFuncionario(Funcionario funcionario) throws Exception {
		this.funcionarios.alterarFuncionario(funcionario);
	}

	public void alterarPedidoFornecedor(Pedido_Fornecedor pedidoFornecedor) throws Exception {
		this.pedidoFornecedor.alterarPedidoFornecedor(pedidoFornecedor);
	}

	public void alterarItemPedido(Item_Pedido itemPedido) throws Exception {
		this.itemPedido.alterarItemPedido(itemPedido);

	}

	public Categoriaref buscarCategoria(Integer id) throws Exception {
		return this.categoria.buscarCategoria(id);
	}

	public Collection<Categoriaref> listarCategorias() throws Exception {
		return categoria.listarCategoria();
	}

	public Sub_categoriaref buscarSubategoria(Integer id) throws Exception {
		return this.subcategoria.buscarSubcategoria(id);
	}

	public Collection<Sub_categoriaref> listarSubcategorias() throws Exception {
		return subcategoria.listarSubcategoria();
	}

	public Unidaderef buscarUnidade(Integer id) throws Exception {
		return this.unidade.buscarUnidade(id);
	}

	public Collection<Unidaderef> listarUnidades() throws Exception {
		return unidade.listarUnidade();
	}

	public Marcaref buscarMarca(Integer id) throws Exception {
		return this.marca.buscarMarca(id);
	}

	public Collection<Marcaref> listarMarcas() throws Exception {
		return marca.listarMarca();
	}

	// BUSCAR REPRESENTANTE
		public Fornecedor_representante buscarFornecedor_representante(Integer id) throws Exception {
			return this.representante_forn.buscarFornecedor_representante(id);
		}

		// LISTAR FUNCIONARIO
		public Collection<Fornecedor_representante> listarFornecedor_representantes() throws Exception {
			return this.representante_forn.listarFornecedor_representante();
		}

		// SALVAR FUNCIONARIO
		public void salvarFornecedor_representante(Fornecedor_representante representante_forn) throws Exception {
			this.representante_forn.salvarFornecedor_representante(representante_forn);
		}

		// DELETAR FUNCIONARIO
		public void deletarFornecedor_representante(Fornecedor_representante representante_forn) throws Exception {
			this.representante_forn.deletarFornecedor_representante(representante_forn);
		}

		public void alterarFornecedor_representante(Fornecedor_representante representante_forn) throws Exception {
			this.representante_forn.alterarFornecedor_representante(representante_forn);
		}

		public Item_Estoque buscarItemEstoque(int id) throws Exception {
			return this.itemEstoque.buscarItemEstoque(id);
		}

		// LISTAR
		public Collection<Item_Estoque> listarItemEstoque() throws Exception {
			return this.itemEstoque.listarItemEstoque();
		}

		// SALVAR
		public void salvarItemEstoque(Item_Estoque item) throws Exception {
			this.itemEstoque.salvarItemEstoque(item);
		}

		// DELETAR
		public void deletarItemEstoque(Item_Estoque item) throws Exception {
			this.itemEstoque.deletarItemEstoque(item);
		}

		public void alterarItemEstoque(Item_Estoque itemEstoque) throws Exception {
			this.itemEstoque.alterarItemEstoque(itemEstoque);
		}
}
