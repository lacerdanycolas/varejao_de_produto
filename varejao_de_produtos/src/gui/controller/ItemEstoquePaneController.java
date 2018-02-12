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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import negocio.controller.FachadaVarejao;
import negocio.entities.Item_Estoque;
import negocio.entities.Produtoref;


public class ItemEstoquePaneController {
	private FachadaVarejao varejao;
	@FXML
	Label lblMensagem;

	@FXML
	private TableView<Item_Estoque> tabelaItemEstoque;

	@FXML
	private TableView<Produtoref> tabelaProdutos;


	@FXML
	TableColumn<Item_Estoque, Integer> tbItemEstoqueColumnID;

	@FXML
	TableColumn<Item_Estoque, String> tbItemEstoqueColumnValor;

	@FXML
	TableColumn<Item_Estoque, String> tbItemEstoqueColumnQuantidade;

	@FXML
	TableColumn<Item_Estoque, String> tbItemEstoqueColumnDataValidade;

	@FXML
	TableColumn<Item_Estoque, String> tbItemEstoqueColumnDataEntrada;

	@FXML
	TableColumn<Item_Estoque, String> tbItemEstoqueColumnIdAvaria;

	@FXML
	TableColumn<Item_Estoque, String> tbItemEstoqueColumnIdPrateleira;

	@FXML
	TableColumn<Item_Estoque, String> tbItemEstoqueColumnIdProduto;

	@FXML
	TableColumn<Item_Estoque, String> tbItemEstoqueColumnIdLote;

	@FXML
	TableColumn<Item_Estoque, String> tbItemEstoqueColumnIdEstoque;


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
	TextField textFieldValorCompra;

	@FXML
	TextField textFieldQuantidade;

	@FXML
	DatePicker datePickerDataValidade;

	@FXML
	DatePicker datePickerDataEntrada;

	@FXML
	TextField textFieldIdAvaria;

	@FXML
	TextField textFieldIdPrateleira;

	@FXML
	TextField textFieldIdProduto;

	@FXML
	TextField textFieldIdLote;

	@FXML
	TextField textFieldIdEstoque;


	int idItemEstoque;

	private Collection<Item_Estoque> listaItemEstoque = new ArrayList<>();
	private ObservableList<Item_Estoque> obListaItemEstoque;

	@FXML
	private void initialize() throws Exception {

		varejao = varejao.getInstance();

		tbItemEstoqueColumnID.setCellValueFactory(new PropertyValueFactory<>("Id"));
		tbItemEstoqueColumnValor.setCellValueFactory(
				cellData -> new SimpleStringProperty(cellData.getValue().getValor_compra().toString()));
		tbItemEstoqueColumnQuantidade.setCellValueFactory(new PropertyValueFactory<>("Quantidade"));
		tbItemEstoqueColumnDataValidade.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getData_validade().toString()));
		tbItemEstoqueColumnDataEntrada.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getData_entrada().toString()));
		tbItemEstoqueColumnIdAvaria.setCellValueFactory(new PropertyValueFactory<>("Id_avaria"));
		tbItemEstoqueColumnIdPrateleira.setCellValueFactory(new PropertyValueFactory<>("Id_prateleira"));
		tbItemEstoqueColumnIdProduto.setCellValueFactory(new PropertyValueFactory<>("Id_produto"));
		tbItemEstoqueColumnIdLote.setCellValueFactory(new PropertyValueFactory<>("Id_lote"));
		tbItemEstoqueColumnIdEstoque.setCellValueFactory(new PropertyValueFactory<>("Id_estoque"));

//		tbColumnID.setCellValueFactory(new PropertyValueFactory<>("Id"));
//		tbColumnNome.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
//		tbColumnCodigoDeBarras.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigo_de_barra()));
//		tbColumnPrecoTabela.setCellValueFactory(new PropertyValueFactory<>("Preco_por_tabela"));
//		tbColumnCST.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCst()));
//		tbColumnICMS.setCellValueFactory(new PropertyValueFactory<>("icms"));
//		tbColumnDescricao.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescricao()));
//		tbColumnPrecoUltimaCompra.setCellValueFactory(new PropertyValueFactory<>("Preco_ultima_compra"));
//		//tbColumnIDFornecedor.setCellValueFactory(new PropertyValueFactory<>("Id_fornecedor"));
//		tbColumnIDCategoria.setCellValueFactory(new PropertyValueFactory<>("Id_categoriaref"));
//		tbColumnIDSubcategoria.setCellValueFactory(new PropertyValueFactory<>("Id_sub_categoriaref"));
//		tbColumnIDUnidade.setCellValueFactory(new PropertyValueFactory<>("Id_unidaderef"));
//		tbColumnIDMarca.setCellValueFactory(new PropertyValueFactory<>("Id_marcaref"));
//		tbColumnIDNCM.setCellValueFactory(new PropertyValueFactory<>("id_ncm"));


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

		obListaItemEstoque = FXCollections.observableArrayList();
		obListaItemEstoque.addAll(varejao.listarItemEstoque());
		tabelaItemEstoque.setItems(obListaItemEstoque);

//		obListaProduto = FXCollections.observableArrayList();
//		obListaProduto.addAll(varejao.listarProduto());
//		tabelaProdutos.setItems(obListaProduto);

	}

	@FXML
	public void refreshTable() throws Exception {
		obListaItemEstoque = FXCollections.observableArrayList();
		obListaItemEstoque.addAll(varejao.listarItemEstoque());
		tabelaItemEstoque.setItems(obListaItemEstoque);

//		obListaProduto = FXCollections.observableArrayList();
//		obListaProduto.addAll(varejao.listarProduto());
//		tabelaProdutos.setItems(obListaProduto);

	}

//	@FXML
//	public void selecionarProduto(MouseEvent arg0) {
//		Produtoref produto = tabelaProdutos.getSelectionModel().getSelectedItem();
//		if (!tabelaProdutos.getSelectionModel().isEmpty()) {
//			idProduto = produto.getId();
//			textFieldNomeProduto.setText(produto.getNome());
//			textFieldPrecoProduto.setText(produto.getPreco_por_tabela().toString());
//		}
//	}

	@FXML
	public void selecionarItemEstoque(MouseEvent arg0) {
		Item_Estoque itemEstoque = tabelaItemEstoque.getSelectionModel().getSelectedItem();
		if (!tabelaItemEstoque.getSelectionModel().isEmpty()) {
			idItemEstoque = itemEstoque.getId();
			textFieldValorCompra.setText(itemEstoque.getValor_compra().toString());
			textFieldQuantidade.setText(itemEstoque.getQuantidade().toString());
			textFieldIdAvaria.setText(itemEstoque.getId_avaria().toString());
			textFieldIdPrateleira.setText(itemEstoque.getId_pratileira().toString());
			textFieldIdProduto.setText(itemEstoque.getId_produtoref().toString());
			textFieldIdLote.setText(itemEstoque.getId_lote().toString());
			textFieldIdEstoque.setText(itemEstoque.getId_estoque().toString());

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
		textFieldValorCompra.clear();
		textFieldQuantidade.clear();
		datePickerDataValidade.valueProperty().set(null);
		datePickerDataEntrada.valueProperty().set(null);
		textFieldIdAvaria.clear();
		textFieldIdPrateleira.clear();
		textFieldIdProduto.clear();
		textFieldIdLote.clear();
		textFieldIdEstoque.clear();

		lblMensagem.setText("");

	}

	public void cadastrarItemEstoque() {
		try {
			BigDecimal valor_compra = new BigDecimal(textFieldValorCompra.getText());
			int quantidade = Integer.parseInt(textFieldQuantidade.getText());

			LocalDate ld = datePickerDataValidade.getValue();
			Calendar c =  Calendar.getInstance();
			c.set(ld.getYear(), ld.getMonthValue(), ld.getDayOfMonth());
			java.util.Date data = c.getTime();
			java.sql.Date sqlDate = new java.sql.Date(data.getTime());

			LocalDate ld2 = datePickerDataEntrada.getValue();
			Calendar c2 =  Calendar.getInstance();
			c2.set(ld2.getYear(), ld2.getMonthValue(), ld2.getDayOfMonth());
			java.util.Date data2 = c2.getTime();
			java.sql.Date sqlDate2 = new java.sql.Date(data2.getTime());

			int id_avaria = Integer.parseInt(textFieldIdAvaria.getText());
			int id_pratileira = Integer.parseInt(textFieldIdPrateleira.getText());
			int id_produtoref = Integer.parseInt(textFieldIdProduto.getText());
			int id_lote = Integer.parseInt(textFieldIdLote.getText());
			int id_estoque = Integer.parseInt(textFieldIdEstoque.getText());

			Item_Estoque itemEstoque = new Item_Estoque(valor_compra, quantidade, sqlDate, sqlDate2, id_avaria, id_pratileira, id_produtoref, id_lote, id_estoque);

			varejao.salvarItemEstoque(itemEstoque);

			refreshTable();
			limparForm();
			lblMensagem.setText("Item Cadastrado");
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro ao cadastrar um Item.");
			alert.setHeaderText("Impossivel efetuar cadastro.");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	public void removerItemEstoque() {
		Item_Estoque itemEstoque = tabelaItemEstoque.getSelectionModel().getSelectedItem();
		try {
			if (itemEstoque != null && itemEstoque instanceof Item_Estoque) {
				varejao.deletarItemEstoque(itemEstoque);
				tabelaItemEstoque.getItems().remove(tabelaItemEstoque.getSelectionModel().getSelectedIndex());
				limparForm();
				refreshTable();
				lblMensagem.setText("Item Removido");
			} else {
				lblMensagem.setText("Selecione um item para ser Removido");
			}
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro ao remover um item.");
			alert.setHeaderText("Impossivel efetuar remocao.");
			alert.setContentText(e.getMessage());
			alert.showAndWait();

		}
	}

	public void alterarItemEstoque() {
		Item_Estoque aux = tabelaItemEstoque.getSelectionModel().getSelectedItem();
		try {
			BigDecimal valor_compra = new BigDecimal(textFieldValorCompra.getText());
			int quantidade = Integer.parseInt(textFieldQuantidade.getText());

			LocalDate ld = datePickerDataValidade.getValue();
			Calendar c =  Calendar.getInstance();
			c.set(ld.getYear(), ld.getMonthValue(), ld.getDayOfMonth());
			java.util.Date data = c.getTime();
			java.sql.Date sqlDate = new java.sql.Date(data.getTime());

			LocalDate ld2 = datePickerDataEntrada.getValue();
			Calendar c2 =  Calendar.getInstance();
			c2.set(ld2.getYear(), ld2.getMonthValue(), ld2.getDayOfMonth());
			java.util.Date data2 = c2.getTime();
			java.sql.Date sqlDate2 = new java.sql.Date(data2.getTime());

			int id_avaria = Integer.parseInt(textFieldIdAvaria.getText());
			int id_pratileira = Integer.parseInt(textFieldIdPrateleira.getText());
			int id_produtoref = Integer.parseInt(textFieldIdProduto.getText());
			int id_lote = Integer.parseInt(textFieldIdLote.getText());
			int id_estoque = Integer.parseInt(textFieldIdEstoque.getText());

			aux.setValor_compra(valor_compra);
			aux.setQuantidade(quantidade);
			aux.setData_validade(sqlDate);
			aux.setData_entrada(sqlDate2);
			aux.setId_avaria(id_avaria);
			aux.setId_pratileira(id_pratileira);
			aux.setId_produtoref(id_produtoref);
			aux.setId_lote(id_lote);
			aux.setId_estoque(id_estoque);

			try {
				varejao.alterarItemEstoque(aux);
				lblMensagem.setText("Item alterado");
				refreshTable();
			} catch (Exception e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erro ao alterar um Item.");
				alert.setHeaderText("Impossivel efetuar alteracao.");
				alert.setContentText(e.getMessage());
				alert.showAndWait();
			}
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro ao alterar um Item.");
			alert.setHeaderText("Impossivel efetuar alteracao.");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

}