package gui.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

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
import negocio.entities.Fornecedor_representante;
import negocio.entities.Item_Pedido;
import negocio.entities.Pedido_Fornecedor;
import negocio.entities.Produtoref;
import negocio.entities.Situacao;
import negocio.entities.Situacao_Caixa;

public class Fornecedor_representantePaneController {
	private FachadaVarejao varejao;
	@FXML
	Label lblMensagem;

	@FXML
	private TableView<Fornecedor_representante> tabelaRepresentantes;

	@FXML
	TableColumn<Fornecedor_representante, Integer> tbCollumID;

	@FXML
	TableColumn<Fornecedor_representante, String> tbColumnIDfornecedor;

	@FXML
	TableColumn<Fornecedor_representante, String> tbColumnIDrepresentante;

	@FXML
	TableColumn<Fornecedor_representante, String> tbColumnDataInicio;

	@FXML
	TableColumn<Fornecedor_representante, String> tbColumnDataFim;

	@FXML
	Button buttonCadastrar;

	@FXML
	Button buttonRemover;

	@FXML
	Button buttonLimpar;

	@FXML
	Button buttonBuscar;

	@FXML
	Button buttonAlterar;

	@FXML
	TextField textFieldIDfornecedor;

	@FXML
	TextField textFieldIDrepresentante;

	@FXML
	DatePicker datePickerDataInicio;

	@FXML
	DatePicker datePickerDataFim;

	private Collection<Fornecedor_representante> listaFornecedor_representante = new ArrayList<>();
	private ObservableList<Fornecedor_representante> obListaFornecedor_representante;

	int idFornecedor_representante;

	@FXML
	private void initialize() throws Exception {

		varejao = varejao.getInstance();

		tbCollumID.setCellValueFactory(new PropertyValueFactory<>("Id"));
		tbColumnIDfornecedor.setCellValueFactory(new PropertyValueFactory<>("Id_fornecedor"));
		tbColumnIDrepresentante.setCellValueFactory(new PropertyValueFactory<>("Id_representante"));
		tbColumnDataInicio.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getData_Inicio().toString()));
		tbColumnDataFim.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getData_fim().toString()));

		obListaFornecedor_representante = FXCollections.observableArrayList();
		obListaFornecedor_representante.addAll(varejao.listarFornecedor_representantes());
		tabelaRepresentantes.setItems(obListaFornecedor_representante);

	}

	@FXML
	public void refreshTable() throws Exception {
		obListaFornecedor_representante = FXCollections.observableArrayList();
		obListaFornecedor_representante.addAll(varejao.listarFornecedor_representantes());
		tabelaRepresentantes.setItems(obListaFornecedor_representante);

	}

	@FXML
	public void selecionarFornecedor_representante(MouseEvent arg0) {
		Fornecedor_representante rep = tabelaRepresentantes.getSelectionModel().getSelectedItem();
		if (!tabelaRepresentantes.getSelectionModel().isEmpty()) {
			idFornecedor_representante = rep.getId();
			textFieldIDfornecedor.setText(rep.getId_fornecedor().toString());
			textFieldIDrepresentante.setText(rep.getId_representante().toString());
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
		textFieldIDfornecedor.clear();
		textFieldIDrepresentante.clear();
		datePickerDataInicio.valueProperty().set(null);
		datePickerDataFim.valueProperty().set(null);

		lblMensagem.setText("");

	}

	public void cadastrarFornecedor_representante() {
		try {
			int id_fornecedor = Integer.parseInt(textFieldIDfornecedor.getText());
			int id_representante = Integer.parseInt(textFieldIDrepresentante.getText());


			LocalDate ld = datePickerDataInicio.getValue();
			Calendar c =  Calendar.getInstance();
			c.set(ld.getYear(), ld.getMonthValue(), ld.getDayOfMonth());
			java.util.Date data = c.getTime();
			java.sql.Date sqlDate = new java.sql.Date(data.getTime());

			LocalDate ld2 = datePickerDataFim.getValue();
			Calendar c2 =  Calendar.getInstance();
			c2.set(ld.getYear(), ld2.getMonthValue(), ld2.getDayOfMonth());
			java.util.Date data2 = c2.getTime();
			java.sql.Date sqlDate2 = new java.sql.Date(data2.getTime());

			Fornecedor_representante forn_representante = new Fornecedor_representante(id_fornecedor, id_representante, sqlDate, sqlDate2);

			varejao.salvarFornecedor_representante(forn_representante);

			refreshTable();
			limparForm();
			lblMensagem.setText("Representante Cadastrado");
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro ao cadastrar um Representante.");
			alert.setHeaderText("Impossivel efetuar cadastro.");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	public void removerFornecedor_representante() {
		Fornecedor_representante forn_representante = tabelaRepresentantes.getSelectionModel().getSelectedItem();
		try {
			if (forn_representante != null && forn_representante instanceof Fornecedor_representante) {
				varejao.deletarFornecedor_representante(forn_representante);
				tabelaRepresentantes.getItems().remove(tabelaRepresentantes.getSelectionModel().getSelectedIndex());
				limparForm();
				refreshTable();
				lblMensagem.setText("Representante Removido");
			} else {
				lblMensagem.setText("Selecione um Representante para ser Removido");
			}
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro ao remover um Representante.");
			alert.setHeaderText("Impossivel efetuar remocao.");
			alert.setContentText(e.getMessage());
			alert.showAndWait();

		}
	}

	public void setFornecedor_representante(Fornecedor_representante forn_representante) {

		tabelaRepresentantes.getSelectionModel().select(forn_representante);

		textFieldIDfornecedor.setText(forn_representante.getId_fornecedor().toString());
		textFieldIDrepresentante.setText(forn_representante.getId_representante().toString());
	}

	public void alterarFornecedor_representante() {
		Fornecedor_representante aux = tabelaRepresentantes.getSelectionModel().getSelectedItem();
		try {

			int id_fornecedor = Integer.parseInt(textFieldIDfornecedor.getText());
			int id_representante = Integer.parseInt(textFieldIDrepresentante.getText());

			LocalDate ld = datePickerDataInicio.getValue();
			Calendar c =  Calendar.getInstance();
			c.set(ld.getYear(), ld.getMonthValue(), ld.getDayOfMonth());
			java.util.Date data = c.getTime();
			java.sql.Date sqlDate = new java.sql.Date(data.getTime());

			LocalDate ld2 = datePickerDataFim.getValue();
			Calendar c2 =  Calendar.getInstance();
			c2.set(ld2.getYear(), ld2.getMonthValue(), ld2.getDayOfMonth());
			java.util.Date data2 = c2.getTime();
			java.sql.Date sqlDate2 = new java.sql.Date(data2.getTime());

			aux.setId_fornecedor(id_fornecedor);
			aux.setId_representante(id_representante);

			try {
				varejao.alterarFornecedor_representante(aux);
				lblMensagem.setText("Representante alterado");
				refreshTable();
			} catch (Exception e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erro ao alterar um Representante.");
				alert.setHeaderText("Impossivel efetuar alteracao.");
				alert.setContentText(e.getMessage());
				alert.showAndWait();
			}
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro ao alterar um Representante.");
			alert.setHeaderText("Impossivel efetuar alteracao.");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

}