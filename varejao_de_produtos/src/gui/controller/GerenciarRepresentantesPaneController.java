package gui.controller;

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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import negocio.controller.FachadaVarejao;
import negocio.entities.Fornecedor_representante;
import negocio.entities.Fornecedorref;
import negocio.entities.Produtoref;
import negocio.entities.Representante;

public class GerenciarRepresentantesPaneController implements Initializable {

	private FachadaVarejao varejao;

	@FXML
	private TableView<Fornecedor_representante> tabelaRepresentantes;

	@FXML
	private ComboBox<Fornecedorref> comboBoxFornecedores;

	@FXML
	TableColumn<Fornecedor_representante, Integer> tbColumnID;

	@FXML
	TableColumn<Fornecedor_representante, String> tbColumnIDfornecedor;

	@FXML
	TableColumn<Fornecedor_representante, String> tbColumnIDrepresentante;

	@FXML
	TableColumn<Fornecedor_representante, String> tbColumnDataInicio;

	@FXML
	TableColumn<Fornecedor_representante, String> tbColumnDataFim;

	@FXML
	TextField textFieldIDfornecedor;

	@FXML
	TextField textFieldIDrepresentante;

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
						atualizarTabelaRepresentantes();
					});
		} catch (Exception e) {
			e.printStackTrace();
		}

		tbColumnID.setCellValueFactory(new PropertyValueFactory<>("Id"));
		tbColumnIDfornecedor.setCellValueFactory(new PropertyValueFactory<>("ID_fornecedor"));
		tbColumnIDrepresentante.setCellValueFactory(new PropertyValueFactory<>("ID_representante"));
		tbColumnDataInicio.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getData_Inicio().toString()));
		tbColumnDataFim.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getData_fim().toString()));

	}

	public void removerFornecedor_representante() {
		Fornecedor_representante representante_forn = tabelaRepresentantes.getSelectionModel().getSelectedItem();
		try {
			if (representante_forn != null && representante_forn instanceof Fornecedor_representante) {
				varejao.deletarFornecedor_representante(representante_forn);

				refreshTable();
				lblMensagem.setText("Representante Removido");
			} else {
				lblMensagem.setText("Selecione um Representante para ser Removido");
			}
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro ao remover um representante.");
			alert.setHeaderText("Impossivel efetuar remocao.");
			alert.setContentText(e.getMessage());
			alert.showAndWait();

		}
	}

	public void atualizarTabelaRepresentantes() {
		if (comboBoxFornecedores.getValue() != null) {
			int fornecedorId = comboBoxFornecedores.getValue().getId();

			try {
				ArrayList<Fornecedor_representante> rep = this.varejao.buscarRepresentatesPorFornecedor(fornecedorId);
				ObservableList<Fornecedor_representante> obListaFornecedor_representante = FXCollections.observableArrayList();
				obListaFornecedor_representante.addAll(rep);
				tabelaRepresentantes.setItems(obListaFornecedor_representante);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void refreshTable() throws Exception {
		listaFornecedores = this.varejao.listarFornecedores();
		oblistaFornecedor = FXCollections.observableArrayList(listaFornecedores);

		comboBoxFornecedores.setItems(oblistaFornecedor);
	}

	public void atualizarTabelaFornecedor_representante() {
		if (comboBoxFornecedores.getValue() != null) {
			int fornecedorId = comboBoxFornecedores.getValue().getId();

			try {
				ArrayList<Fornecedor_representante> rep = this.varejao.buscarRepresentatesPorFornecedor(fornecedorId);
				ObservableList<Fornecedor_representante> obListaFornecedor_representante = FXCollections.observableArrayList();
				obListaFornecedor_representante.addAll(rep);
				tabelaRepresentantes.setItems(obListaFornecedor_representante);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@FXML
	public void abrirTelaRepresentantes(MouseEvent mouseEvent) {
		if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
			if (mouseEvent.getClickCount() == 2) {
				Fornecedor_representante forn_representante = tabelaRepresentantes.getSelectionModel().getSelectedItem();
				// if(!tabelaProdutos.getSelectionModel().isEmpty()){
				//
				// }
				Parent root;
				Stage stage;
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/view/TelaCadastroFornecedor_representante.fxml"));

					root = loader.load();

					Fornecedor_representantePaneController fornecedor_representanteController = loader.getController();
					// produtoController.setProduto(produto);
					Fornecedor_representanteSingleton s = new Fornecedor_representanteSingleton();
					s.forn_representante = forn_representante;
					Scene scene = new Scene(root);

					stage = (Stage) comboBoxFornecedores.getScene().getWindow();
					stage.setScene(scene);

					fornecedor_representanteController.setFornecedor_representante(forn_representante);
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
