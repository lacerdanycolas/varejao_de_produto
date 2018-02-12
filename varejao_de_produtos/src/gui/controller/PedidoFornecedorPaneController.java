package gui.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import negocio.controller.FachadaVarejao;
import negocio.entities.Item_Pedido;
import negocio.entities.Pedido_Fornecedor;
import negocio.entities.Produtoref;
import negocio.entities.Situacao;
import negocio.entities.Situacao_Caixa;

public class PedidoFornecedorPaneController {
	private FachadaVarejao varejao;
	@FXML
	Label lblMensagem;

	@FXML
	private TableView<Pedido_Fornecedor> tabelaPedidos;

	@FXML
	private TableView<Produtoref> tabelaProdutos;

	@FXML
	private TableView<Item_Pedido> tabelaItem_Pedido;

	@FXML
	TableColumn<Pedido_Fornecedor, Integer> tbPedidosColumnID;

	@FXML
	TableColumn<Pedido_Fornecedor, String> tbPedidosColumnTotalDesconto;

	@FXML
	TableColumn<Pedido_Fornecedor, String> tbPedidosColumnIValorTotal;

	@FXML
	TableColumn<Pedido_Fornecedor, String> tbPedidosColumnIPI;

	@FXML
	TableColumn<Pedido_Fornecedor, String> tbPedidosColumnCFOP;

	@FXML
	TableColumn<Pedido_Fornecedor, String> tbPedidosColumnIValorFrete;

	@FXML
	TableColumn<Pedido_Fornecedor, String> tbPedidosColumnDataPedido;

	@FXML
	TableColumn<Pedido_Fornecedor, String> tbPedidosColumnSituacao;

	@FXML
	TableColumn<Pedido_Fornecedor, String> tbPedidosColumnCpfCoord;

	@FXML
	TableColumn<Item_Pedido, String> tbItensColumnID1;

	@FXML
	TableColumn<Item_Pedido, String> tbItensColumnIDFornecedor;

	@FXML
	TableColumn<Item_Pedido, String> tbItensColumnIDProduto;

	@FXML
	TableColumn<Item_Pedido, String> tbItensColumnQuantidade;

	@FXML
	TableColumn<Item_Pedido, String> tbItensColumnPreco;


	@FXML
	TableColumn<Produtoref, Integer> tbColumnID;

	@FXML
	TableColumn<Produtoref, String> tbColumnNome;

	@FXML
	TableColumn<Produtoref, String> tbColumnCodigoDeBarras;

	@FXML
	TableColumn<Produtoref, String> tbColumnPrecoTabela;

	@FXML
	TableColumn<Produtoref, String> tbColumnCST;

	@FXML
	TableColumn<Produtoref, String> tbColumnICMS;

	@FXML
	TableColumn<Produtoref, String> tbColumnDescricao;

	@FXML
	TableColumn<Produtoref, String> tbColumnPrecoUltimaCompra;

	@FXML
	TableColumn<Produtoref, String> tbColumnIDFornecedor;

	@FXML
	TableColumn<Produtoref, String> tbColumnIDCategoria;

	@FXML
	TableColumn<Produtoref, String> tbColumnIDSubcategoria;

	@FXML
	TableColumn<Produtoref, String> tbColumnIDUnidade;

	@FXML
	TableColumn<Produtoref, String> tbColumnIDMarca;

	@FXML
	TableColumn<Produtoref, String> tbColumnIDNCM;

	@FXML
	Button butCadastrar;

	@FXML
	Button butRemover;

	@FXML
	Button butLimpar;

	@FXML
	Button butBuscar;

	@FXML
	Button butAlterar;

	@FXML
	Button butGerarProduto;

	@FXML
	TextField textFieldTotalDesconto;

	@FXML
	TextField textFieldValorTotal;

	@FXML
	TextField textFieldIPI;

	@FXML
	TextField textFieldCFOP;

	@FXML
	ComboBox<String> comboboxSituacao;

	@FXML
	TextField textFieldValorFrete;

	@FXML
	TextField textFieldCPFcoordenador;

	@FXML
	TextField textFieldNomeProduto;

	@FXML
	TextField textFieldPrecoProduto;

	@FXML
	TextField textFieldQuantidadeProduto;

	@FXML
	DatePicker datePedido;

	private ObservableList<String> situacao = FXCollections.observableArrayList(Situacao_Caixa.ATIVO.toString(),Situacao.INATIVO.toString());

	int idProduto;
	int idPedido;

	private Collection<Pedido_Fornecedor> listaPedido = new ArrayList<>();
	private ObservableList<Pedido_Fornecedor> obListaPedido;

	private Collection<Produtoref> listaProduto = new ArrayList<Produtoref>();
	private ObservableList<Produtoref> obListaProduto;

	private Collection<Item_Pedido> listaItensPedido = new ArrayList<Item_Pedido>();
	private ObservableList<Item_Pedido> obListaItensPedido;

	@FXML
	private void initialize() throws Exception {

		varejao = varejao.getInstance();

		tbPedidosColumnID.setCellValueFactory(new PropertyValueFactory<>("Id"));
		tbPedidosColumnTotalDesconto.setCellValueFactory(
				cellData -> new SimpleStringProperty(cellData.getValue().getTotal_desconto().toString()));
		tbPedidosColumnIValorTotal.setCellValueFactory(
				cellData -> new SimpleStringProperty(cellData.getValue().getValor_total().toString()));

		tbColumnID.setCellValueFactory(new PropertyValueFactory<>("Id"));
		tbColumnNome.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
		tbColumnCodigoDeBarras.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigo_de_barra()));
		tbColumnPrecoTabela.setCellValueFactory(new PropertyValueFactory<>("Preco_por_tabela"));
		tbColumnCST.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCst()));
		tbColumnICMS.setCellValueFactory(new PropertyValueFactory<>("icms"));
		tbColumnDescricao.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescricao()));
		tbColumnPrecoUltimaCompra.setCellValueFactory(new PropertyValueFactory<>("Preco_ultima_compra"));
		//tbColumnIDFornecedor.setCellValueFactory(new PropertyValueFactory<>("Id_fornecedor"));
		tbColumnIDCategoria.setCellValueFactory(new PropertyValueFactory<>("Id_categoriaref"));
		tbColumnIDSubcategoria.setCellValueFactory(new PropertyValueFactory<>("Id_sub_categoriaref"));
		tbColumnIDUnidade.setCellValueFactory(new PropertyValueFactory<>("Id_unidaderef"));
		tbColumnIDMarca.setCellValueFactory(new PropertyValueFactory<>("Id_marcaref"));
		tbColumnIDNCM.setCellValueFactory(new PropertyValueFactory<>("id_ncm"));


		tbPedidosColumnIPI.setCellValueFactory(new PropertyValueFactory<>("IPI"));
		tbPedidosColumnCFOP.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCfop()));
		tbPedidosColumnIValorFrete.setCellValueFactory(new PropertyValueFactory<>("Valor_frete"));
		tbPedidosColumnCpfCoord.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCpf_coordenador()));
		tbPedidosColumnSituacao.setCellValueFactory(new PropertyValueFactory<>("Situacao"));

		tbItensColumnID1.setCellValueFactory(new PropertyValueFactory<>("Id"));
		tbItensColumnIDFornecedor.setCellValueFactory(new PropertyValueFactory<>("Id_fornecedor"));
		tbItensColumnIDProduto.setCellValueFactory(new PropertyValueFactory<>("Id_produto"));
		tbItensColumnQuantidade.setCellValueFactory(new PropertyValueFactory<>("Quantidade"));
		tbItensColumnPreco.setCellValueFactory(new PropertyValueFactory<>("Preco"));


		// tbColumnPrecoTabela.setCellValueFactory(new
		// PropertyValueFactory<>("Preco_por_tabela"));
		// tbColumnCST.setCellValueFactory(cellData -> new
		// SimpleStringProperty(cellData.getValue().getCst()));
		// tbColumnICMS.setCellValueFactory(new PropertyValueFactory<>("icms"));
		// tbColumnDescricao.setCellValueFactory(cellData -> new
		// SimpleStringProperty(cellData.getValue().getDescricao()));
		// tbColumnPrecoUltimaCompra.setCellValueFactory(new
		// PropertyValueFactory<>("Preco_ultima_compra"));
		// tbColumnIDFornecedor.setCellValueFactory(new
		// PropertyValueFactory<>("Id_fornecedor"));
		// tbColumnIDCategoria.setCellValueFactory(new
		// PropertyValueFactory<>("Id_categoriaref"));
		// tbColumnIDSubcategoria.setCellValueFactory(new
		// PropertyValueFactory<>("Id_sub_categoriaref"));
		// tbColumnIDUnidade.setCellValueFactory(new
		// PropertyValueFactory<>("Id_unidaderef"));
		// tbColumnIDMarca.setCellValueFactory(new
		// PropertyValueFactory<>("Id_marcaref"));
		// tbColumnIDNCM.setCellValueFactory(new
		// PropertyValueFactory<>("id_ncm"));

		tbColumnID.setCellValueFactory(new PropertyValueFactory<>("Id"));

		obListaPedido = FXCollections.observableArrayList();
		obListaPedido.addAll(varejao.listarPedidoFornecedor());
		tabelaPedidos.setItems(obListaPedido);

		obListaProduto = FXCollections.observableArrayList();
		obListaProduto.addAll(varejao.listarProduto());
		tabelaProdutos.setItems(obListaProduto);

		obListaItensPedido = FXCollections.observableArrayList();
		Collection<Item_Pedido> pe = varejao.listarItemPedido();
		obListaItensPedido.addAll(pe);
		tabelaItem_Pedido.setItems(obListaItensPedido);

		comboboxSituacao.setItems(situacao);
	}

	@FXML
	public void refreshTable() throws Exception {
		obListaPedido = FXCollections.observableArrayList();
		obListaPedido.addAll(varejao.listarPedidoFornecedor());
		tabelaPedidos.setItems(obListaPedido);

		obListaProduto = FXCollections.observableArrayList();
		obListaProduto.addAll(varejao.listarProduto());
		tabelaProdutos.setItems(obListaProduto);

		obListaItensPedido = FXCollections.observableArrayList();
		Collection<Item_Pedido> pe = varejao.listarItemPedido();
		obListaItensPedido.addAll(pe);
		tabelaItem_Pedido.setItems(obListaItensPedido);

	}

	@FXML
	public void selecionarProduto(MouseEvent arg0) {
		Produtoref produto = tabelaProdutos.getSelectionModel().getSelectedItem();
		if (!tabelaProdutos.getSelectionModel().isEmpty()) {
			idProduto = produto.getId();
			textFieldNomeProduto.setText(produto.getNome());
			textFieldPrecoProduto.setText(produto.getPreco_por_tabela().toString());
		}
	}

	@FXML
	public void selecionarPedido(MouseEvent arg0) {
		Pedido_Fornecedor pedido = tabelaPedidos.getSelectionModel().getSelectedItem();
		if (!tabelaPedidos.getSelectionModel().isEmpty()) {
			idPedido = pedido.getId();
			textFieldTotalDesconto.setText(pedido.getTotal_desconto().toString());
			textFieldValorTotal.setText(pedido.getValor_total().toString());
			textFieldIPI.setText(pedido.getIpi().toString());
			textFieldCFOP.setText(pedido.getCfop());
			textFieldValorFrete.setText(pedido.getValor_frete().toString());
			textFieldCPFcoordenador.setText(pedido.getCpf_coordenador());

		}
	}

	public void sair(ActionEvent event) {
		((Node) event.getSource()).getScene().getWindow().hide();

	}

	public void voltarMenuPrincipal(ActionEvent event) {
		((Node) event.getSource()).getScene().getWindow().hide();
		Parent parent;
		try {
			parent = FXMLLoader.load(getClass().getResource("/GUI/view/TelaPrincipalVarejao.fxml"));
			Stage stage3 = new Stage();
			Scene cena = new Scene(parent);
			stage3.setScene(cena);
			stage3.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void limparForm() {
		textFieldTotalDesconto.clear();
		textFieldIPI.clear();
		textFieldCFOP.clear();
		textFieldValorFrete.clear();
		textFieldCPFcoordenador.clear();
		textFieldValorTotal.clear();
		comboboxSituacao.valueProperty().set(null);


		lblMensagem.setText("");

	}

	public void cadastrarPedidoFornecedor() {
		try {
			BigDecimal totalDesconto = new BigDecimal(textFieldTotalDesconto.getText());
			BigDecimal valorTotal = new BigDecimal(textFieldValorTotal.getText());
			BigDecimal ipi = new BigDecimal(textFieldIPI.getText());
			String cfop = textFieldCFOP.getText();
			String situacao = comboboxSituacao.getValue();

			LocalDate ld = datePedido.getValue();
			Calendar c =  Calendar.getInstance();
			c.set(ld.getYear(), ld.getMonthValue(), ld.getDayOfMonth());
			java.util.Date data = c.getTime();
			java.sql.Date sqlDate = new java.sql.Date(data.getTime());

			Situacao situ = Situacao.INATIVO;
			if (situacao.toString().equals("ATIVO")) {
				situ = Situacao.ATIVO;
			}
			BigDecimal valorFrete = new BigDecimal(textFieldValorFrete.getText());
			String cpfCoordenador = textFieldCPFcoordenador.getText();

			// (int id, BigDecimal total_desconto, BigDecimal valor_total,
			// BigDecimal ipi, String cfop,
			// Date data_pedido, Situacao situacao, BigDecimal valor_frete,
			// String cpf_coordenador) {

			Pedido_Fornecedor pedidoFornecedor = new Pedido_Fornecedor(totalDesconto, valorTotal, ipi, cfop, sqlDate,
					situ, valorFrete, cpfCoordenador);

			varejao.salvarPedidoFornecedor(pedidoFornecedor);

			refreshTable();
			limparForm();
			lblMensagem.setText("Produto Cadastrado");
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro ao cadastrar um produto.");
			alert.setHeaderText("Impossivel efetuar cadastro.");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	public void removerPedidoFornecedor() {
		Pedido_Fornecedor pedido = tabelaPedidos.getSelectionModel().getSelectedItem();
		try {
			if (pedido != null && pedido instanceof Pedido_Fornecedor) {
				varejao.deletarPedidoFornecedor(pedido);
				tabelaPedidos.getItems().remove(tabelaPedidos.getSelectionModel().getSelectedIndex());
				limparForm();
				refreshTable();
				lblMensagem.setText("Pedido Removido");
			} else {
				lblMensagem.setText("Selecione um pedido para ser Removido");
			}
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro ao remover um pedido.");
			alert.setHeaderText("Impossivel efetuar remocao.");
			alert.setContentText(e.getMessage());
			alert.showAndWait();

		}
	}

	public void alterarPedidoFornecedor() {
		Pedido_Fornecedor aux = tabelaPedidos.getSelectionModel().getSelectedItem();
		try {
			String cfop, cpf_coordenador;

			Situacao situ = null;
			String situacao = comboboxSituacao.getValue();
			try{
				if(situacao.toString().equals("ATIVO")){
					situ = Situacao.ATIVO;
				}else{
					situ = Situacao.INATIVO;
				}
			}catch(Exception e){
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erro ao alterar um caixa.");
				alert.setHeaderText("Preencha o campo Situacao.");
				alert.setContentText(e.getMessage());
				alert.showAndWait();
			}


			cfop = textFieldCFOP.getText();
			BigDecimal ipi = new BigDecimal(textFieldIPI.getText());
			BigDecimal valor_frete = new BigDecimal(textFieldValorFrete.getText());
			BigDecimal valor_total = new BigDecimal(textFieldValorTotal.getText());
			BigDecimal total_desconto = new BigDecimal(textFieldValorTotal.getText());
			LocalDate ld = datePedido.getValue();
			Calendar c =  Calendar.getInstance();
			c.set(ld.getYear(), ld.getMonthValue(), ld.getDayOfMonth());
			java.util.Date data = c.getTime();
			java.sql.Date sqlDate = new java.sql.Date(data.getTime());
			String cpfCoordenador = textFieldCPFcoordenador.getText();

			aux.setTotal_desconto(total_desconto);
			aux.setValor_total(valor_total);
			aux.setIpi(ipi);
			aux.setCfop(cfop);
			aux.setData_pedido(sqlDate);
			aux.setSituacao(situ);
			aux.setValor_frete(valor_frete);
			aux.setCpf_coordenador(cpfCoordenador);

			try {
				varejao.alterarPedidoFornecedor(aux);
				lblMensagem.setText("Pedido alterado");
				refreshTable();
			} catch (Exception e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erro ao alterar um Pedido.");
				alert.setHeaderText("Impossivel efetuar alteracao.");
				alert.setContentText(e.getMessage());
				alert.showAndWait();
			}
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro ao alterar um Pedido.");
			alert.setHeaderText("Impossivel efetuar alteracao.");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	public void gerarItemProduto() {
		try {
			String nomeProduto = textFieldNomeProduto.getText();
			int quantidade = Integer.parseInt(textFieldQuantidadeProduto.getText());
			BigDecimal precoProduto = new BigDecimal(textFieldPrecoProduto.getText());

			// int id, int id_pedido_fornecedor, int id_produto_ref, int
			// quantidade, double preco_unitario
			Item_Pedido pedido = new Item_Pedido(idPedido, idProduto, quantidade, precoProduto);
			varejao.salvarItemPedido(pedido);

			refreshTable();
			limparForm();
			lblMensagem.setText("Produto Cadastrado");
		} catch (Exception e) {
			e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro ao cadastrar um produto.");
			alert.setHeaderText("Impossivel efetuar cadastro.");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	@FXML
	public void txtCodigoDeBarrapMask() {
		TextFieldFormatter tf = new TextFieldFormatter();
		tf.setMask("#########");
		tf.setCaracteresValidos("0123456789");
		tf.setTf(textFieldIPI);
		tf.formatter();
	}
}