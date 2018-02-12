package gui.controller;

import java.awt.Button;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import gui.MainTeste;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import negocio.controller.FachadaVarejao;
import negocio.entities.Fornecedorref;
import negocio.entities.Produtoref;

public class GerenciarProdutosPaneController implements Initializable {

	private FachadaVarejao varejao;

	@FXML
	private ComboBox<Fornecedorref> comboBoxFornecedores;

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
	Label lblMensagem;

	private Collection<Fornecedorref> listaFornecedores = new ArrayList<>();
	private ObservableList<Fornecedorref> oblistaFornecedor;

	private MainTeste main;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.varejao = FachadaVarejao.getInstance();
		this.main = MainTeste.getInstance();

		try {
			listaFornecedores = this.varejao.listarFornecedores();
			oblistaFornecedor = FXCollections.observableArrayList(listaFornecedores);

			comboBoxFornecedores.setItems(oblistaFornecedor);
			comboBoxFornecedores.getSelectionModel().selectedItemProperty()
					.addListener((options, oldValue, newValue) -> {
						atualizarTabelaProdutos();
					});
		} catch (Exception e) {
			e.printStackTrace();
		}

		tbColumnID.setCellValueFactory(new PropertyValueFactory<>("Id"));
		tbColumnNome.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
		tbColumnCodigoDeBarras
				.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigo_de_barra()));
		tbColumnPrecoTabela.setCellValueFactory(new PropertyValueFactory<>("Preco_por_tabela"));
		tbColumnCST.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCst()));
		tbColumnICMS.setCellValueFactory(new PropertyValueFactory<>("icms"));
		tbColumnDescricao.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescricao()));
		tbColumnPrecoUltimaCompra.setCellValueFactory(new PropertyValueFactory<>("Preco_ultima_compra"));
		// tbColumnIDFornecedor.setCellValueFactory(new
		// PropertyValueFactory<>("Id_fornecedor"));
		tbColumnIDCategoria.setCellValueFactory(new PropertyValueFactory<>("Id_categoriaref"));
		tbColumnIDSubcategoria.setCellValueFactory(new PropertyValueFactory<>("Id_sub_categoriaref"));
		tbColumnIDUnidade.setCellValueFactory(new PropertyValueFactory<>("Id_unidaderef"));
		tbColumnIDMarca.setCellValueFactory(new PropertyValueFactory<>("Id_marcaref"));
		tbColumnIDNCM.setCellValueFactory(new PropertyValueFactory<>("id_ncm"));
	}

	public void removerProduto() {
		Produtoref produto = tabelaProdutos.getSelectionModel().getSelectedItem();
		try {
			if (produto != null && produto instanceof Produtoref) {
				varejao.deletarProduto(produto);

				refreshTable();
				lblMensagem.setText("Produto Removido");
			} else {
				lblMensagem.setText("Selecione um Produto para ser Removido");
			}
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro ao remover um produto.");
			alert.setHeaderText("Impossivel efetuar remocao.");
			alert.setContentText(e.getMessage());
			alert.showAndWait();

		}
	}

	public void refreshTable() throws Exception {
		listaFornecedores = this.varejao.listarFornecedores();
		oblistaFornecedor = FXCollections.observableArrayList(listaFornecedores);

		comboBoxFornecedores.setItems(oblistaFornecedor);
	}

	public void atualizarTabelaProdutos() {
		if (comboBoxFornecedores.getValue() != null) {
			int fornecedorId = comboBoxFornecedores.getValue().getId();

			try {
				ArrayList<Produtoref> produtos = this.varejao.buscarProdutosPorFornecedor(fornecedorId);
				ObservableList<Produtoref> obListaProduto = FXCollections.observableArrayList();
				obListaProduto.addAll(produtos);
				tabelaProdutos.setItems(obListaProduto);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@FXML
	public void abrirTelaProdutos(MouseEvent mouseEvent) {
		if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
			if (mouseEvent.getClickCount() == 2) {
				Produtoref produto = tabelaProdutos.getSelectionModel().getSelectedItem();
				// if(!tabelaProdutos.getSelectionModel().isEmpty()){
				//
				// }
				Parent root;
				Stage stage;
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/view/TelaCadastroProduto.fxml"));

					root = loader.load();

					ProdutoPaneController produtoController = loader.getController();
					// produtoController.setProduto(produto);
					ProdutoSingleton s = new ProdutoSingleton();
					s.produto = produto;
					Scene scene = new Scene(root);

					stage = (Stage) comboBoxFornecedores.getScene().getWindow();
					stage.setScene(scene);

					produtoController.setProduto(produto);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void setApp(MainTeste main) {
		this.main = main;
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
}
