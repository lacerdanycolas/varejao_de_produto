package gui.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import negocio.controller.FachadaVarejao;
import negocio.entities.Produtoref;

public class ProdutoPaneController {
	private FachadaVarejao varejao;
	@FXML
	Label lblMensagem;

	@FXML
	private TableView<Produtoref> tabelaProdutos;

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
	TextField textFieldNome;

	@FXML
	TextField textFieldID;

	@FXML
	TextField textFieldCodigoDeBarras;

	@FXML
	TextField textFieldPrecoTabela;

	@FXML
	TextField textFieldDescricao;

	@FXML
	TextField textFieldFrequenciaPedido;

	@FXML
	TextField textFieldCST;

	@FXML
	TextField textFieldICMS;

	@FXML
	TextField textFieldPrecoUltimaCompra;

	@FXML
	TextField textFieldQuantidadeEstoque;

	@FXML
	TextField textFieldQuantidadeMinima;

	@FXML
	TextField textFieldIdFornecedor;

	@FXML
	TextField textFieldIdCategoria;

	@FXML
	TextField textFieldIdSubcategoria;

	@FXML
	TextField textFieldIdUnidade;

	@FXML
	TextField textFieldIdMarca;

	@FXML
	TextField textFieldIdNCM;

	private Collection<Produtoref> listaProduto = new ArrayList<Produtoref>();
	private ObservableList<Produtoref> obListaProduto;

	@FXML
	private void initialize() throws Exception{

		varejao = varejao.getInstance();

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
		obListaProduto = FXCollections.observableArrayList();
		obListaProduto.addAll(varejao.listarProduto());
		tabelaProdutos.setItems(obListaProduto);
	}

	@FXML
	public void refreshTable() throws Exception{
		obListaProduto = FXCollections.observableArrayList();
		obListaProduto.addAll(varejao.listarProduto());
		tabelaProdutos.setItems(obListaProduto);
	}
	
	@FXML
	public void selecionarProduto(MouseEvent arg0){
		Produtoref produto = tabelaProdutos.getSelectionModel().getSelectedItem();
		if(!tabelaProdutos.getSelectionModel().isEmpty()){
			textFieldNome.setText(produto.getNome());
			textFieldCodigoDeBarras.setText(produto.getCodigo_de_barra());
			textFieldPrecoTabela.setText(produto.getPreco_por_tabela().toString());
			textFieldDescricao.setText(produto.getDescricao());
			if(produto.getFrequencia_pedido()==null){
				textFieldFrequenciaPedido.setText("");
			}else{
				textFieldFrequenciaPedido.setText(produto.getFrequencia_pedido().toString());
			}
			textFieldCST.setText(produto.getCst());
			textFieldICMS.setText(produto.getIcms().toString());
			if(produto.getPreco_ultima_compra()==null){
				textFieldPrecoUltimaCompra.setText("");
			}else{
			textFieldPrecoUltimaCompra.setText(produto.getPreco_ultima_compra().toString());
			}
			if(produto.getQuantidade_minima()==null){
				textFieldQuantidadeMinima.setText("");
			}else{
			textFieldQuantidadeMinima.setText(produto.getQuantidade_estoque().toString());
			}
			if(produto.getQuantidade_estoque()==null){
				textFieldQuantidadeEstoque.setText("");
			}else{
			textFieldQuantidadeEstoque.setText(produto.getQuantidade_estoque().toString());
			}
			textFieldIdFornecedor.setText(produto.getId_fornecedor().toString());
			textFieldIdCategoria.setText(produto.getId_categoriaref().toString());
			textFieldIdSubcategoria.setText(produto.getId_sub_categoriaref().toString());
			textFieldIdUnidade.setText(produto.getId_unidaderef().toString());
			textFieldIdMarca.setText(produto.getId_marcaref().toString());
			textFieldIdNCM.setText(produto.getId_ncm().toString());
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
		textFieldNome.clear();
		textFieldCodigoDeBarras.clear();
		textFieldPrecoTabela.clear();
		textFieldDescricao.clear();
		textFieldFrequenciaPedido.clear();
		textFieldCST.clear();
		textFieldICMS.clear();
		textFieldPrecoUltimaCompra.clear();
		textFieldQuantidadeEstoque.clear();
		textFieldQuantidadeMinima.clear();
		textFieldIdFornecedor.clear();
		textFieldIdCategoria.clear();
		textFieldIdSubcategoria.clear();
		textFieldIdUnidade.clear();
		textFieldIdMarca.clear();
		textFieldIdNCM.clear();
		lblMensagem.setText("");

	}

	public void cadastrarProduto(){
		try{
			String nome, descricao, cst, codigo_de_barra;

			nome = textFieldNome.getText();
			codigo_de_barra = textFieldCodigoDeBarras.getText();
			BigDecimal preco_por_tabela = new BigDecimal (textFieldPrecoTabela.getText());
			descricao = textFieldDescricao.getText();
			BigDecimal frequencia_pedido = new BigDecimal(textFieldFrequenciaPedido.getText());
			cst = textFieldCST.getText();
			BigDecimal icms = new BigDecimal(textFieldICMS.getText());
			BigDecimal preco_ultima_compra = new BigDecimal(textFieldPrecoUltimaCompra.getText());
			int quantidade_estoque = Integer.parseInt(textFieldQuantidadeEstoque.getText());
			int quantidade_minima = Integer.parseInt(textFieldQuantidadeMinima.getText());
			int id_fornecedor = Integer.parseInt(textFieldIdFornecedor.getText());
			int id_categoriaref = Integer.parseInt(textFieldIdCategoria.getText());
			int id_subcategoriaref = Integer.parseInt(textFieldIdSubcategoria.getText());
			int id_unidaderef = Integer.parseInt(textFieldIdUnidade.getText());
			int id_marcaref = Integer.parseInt(textFieldIdMarca.getText());
			int id_ncm = Integer.parseInt(textFieldIdNCM.getText());

			Produtoref aux = new Produtoref(codigo_de_barra, descricao, frequencia_pedido, preco_por_tabela, cst, icms, nome, preco_ultima_compra, quantidade_estoque, quantidade_minima, id_fornecedor, id_categoriaref, id_subcategoriaref, id_unidaderef,id_marcaref, id_ncm);
			varejao.salvarProduto(aux);
			refreshTable();
			limparForm();
			lblMensagem.setText("Produto Cadastrado");
		}catch(Exception e){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro ao cadastrar um produto.");
			alert.setHeaderText("Impossivel efetuar cadastro.");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	public void removerProduto(){
		Produtoref produto = tabelaProdutos.getSelectionModel().getSelectedItem();
		try{
			if(produto !=null && produto instanceof Produtoref){
				varejao.deletarProduto(produto);
				tabelaProdutos.getItems().remove(tabelaProdutos.getSelectionModel().getSelectedIndex());
				limparForm();
				refreshTable();
				lblMensagem.setText("Produto Removido");
			}else{
				lblMensagem.setText("Selecione um Produto para ser Removido");
			}
		}catch (Exception e){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro ao remover um produto.");
			alert.setHeaderText("Impossivel efetuar remocao.");
			alert.setContentText(e.getMessage());
			alert.showAndWait();

		}
	}
	
	public void alterarProduto(){
		Produtoref aux = tabelaProdutos.getSelectionModel().getSelectedItem();
		try{
			String nome, descricao, cst, codigo_de_barra;

			nome = textFieldNome.getText();
			codigo_de_barra = textFieldCodigoDeBarras.getText();
			BigDecimal preco_por_tabela = new BigDecimal (textFieldPrecoTabela.getText());
			descricao = textFieldDescricao.getText();
			BigDecimal frequencia_pedido = new BigDecimal(textFieldFrequenciaPedido.getText());
			cst = textFieldCST.getText();
			BigDecimal icms = new BigDecimal(textFieldICMS.getText());
			BigDecimal preco_ultima_compra = new BigDecimal(textFieldPrecoUltimaCompra.getText());
			int quantidade_estoque = Integer.parseInt(textFieldQuantidadeEstoque.getText());
			int quantidade_minima = Integer.parseInt(textFieldQuantidadeMinima.getText());
			int id_fornecedor = Integer.parseInt(textFieldIdFornecedor.getText());
			int id_categoriaref = Integer.parseInt(textFieldIdCategoria.getText());
			int id_subcategoriaref = Integer.parseInt(textFieldIdSubcategoria.getText());
			int id_unidaderef = Integer.parseInt(textFieldIdUnidade.getText());
			int id_marcaref = Integer.parseInt(textFieldIdMarca.getText());
			int id_ncm = Integer.parseInt(textFieldIdNCM.getText());
			aux.setNome(nome);
			aux.setCodigo_de_barra(codigo_de_barra);
			aux.setPreco_por_tabela(preco_por_tabela);
			aux.setDescricao(descricao);
			aux.setFrequencia_pedido(frequencia_pedido);
			aux.setCst(cst);
			aux.setIcms(icms);
			aux.setPreco_ultima_compra(preco_ultima_compra);
			aux.setQuantidade_estoque(quantidade_estoque);
			aux.setQuantidade_minima(quantidade_minima);
			aux.setId_fornecedor(id_fornecedor);
			aux.setId_categoriaref(id_categoriaref);
			aux.setId_sub_categoriaref(id_subcategoriaref);
			aux.setId_unidaderef(id_unidaderef);
			aux.setId_marcaref(id_marcaref);
			aux.setId_ncm(id_ncm);
			try{
				varejao.alterarProduto(aux);
				lblMensagem.setText("Produto alterado");
				refreshTable();
			}catch(Exception e){
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erro ao alterar um Produto.");
				alert.setHeaderText("Impossivel efetuar alteracao.");
				alert.setContentText(e.getMessage());
				alert.showAndWait();
			}
			}catch(Exception e){
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erro ao alterar um Produto.");
				alert.setHeaderText("Impossivel efetuar alteracao.");
				alert.setContentText(e.getMessage());
				alert.showAndWait();
		}
	}
	
	@FXML
	public void txtCodigoDeBarrapMask(){
		TextFieldFormatter tf = new TextFieldFormatter();
		tf.setMask("#########");
		tf.setCaracteresValidos("0123456789");
		tf.setTf(textFieldCodigoDeBarras);
		tf.formatter();
	}
}