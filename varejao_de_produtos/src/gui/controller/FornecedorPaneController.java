package gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;
import gui.MainTeste;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import javafx.stage.Stage;
import negocio.controller.FachadaVarejao;
import negocio.entities.Estados;
import negocio.entities.Fornecedorref;
import negocio.entities.Situacao;
import negocio.entities.Situacao_Caixa;

public class FornecedorPaneController implements Initializable {
	private FachadaVarejao varejao;
	@FXML
	private TableView<Fornecedorref> tbViewFornecedor;
	@FXML
	private TableColumn<Fornecedorref, String> tbCollumIdFornecedor;
	@FXML
	private TableColumn<Fornecedorref, String> tbCollumNomeFornecedor;
	@FXML
	private TableColumn<Fornecedorref, String> tbCollumCnpjFornecedor;
	@FXML
	private TableColumn<Fornecedorref, String> tbCollumCepFornecedor;
	@FXML
	private TableColumn<Fornecedorref, String> tbCollumEstadoFornecedor;
	@FXML
	private TableColumn<Fornecedorref, String> tbCollumRuaFornecedor;
	@FXML
	private TableColumn<Fornecedorref, String> tbCollumBairroFornecedor;



	@FXML
	private TextField textFieldNomeFornecedor;
	@FXML
	private TextField textFieldCnpjFornecedor;
	@FXML
	private TextField textFieldRuaFornecedor;
	@FXML
	private TextField textFieldBairroFornecedor;
	@FXML
	private TextField textFieldCepFornecedor;

	@FXML
	private ComboBox<String> comboBoxSituacaoFornecedor;
	@FXML
	private ComboBox<String> comboBoxEstados;

	@FXML
	private Button buttonSalvarFornecedor;

	@FXML
	private Button buttonRemoverFornecedor;

	@FXML
	private Button buttonLimparFornecedor;

	@FXML
	private Button buttonListaRepresentantes;
	
	@FXML
	Label lblMensagem;

	private FachadaVarejao fachada = FachadaVarejao.getInstance();
	private MainTeste main;

	private Collection<Fornecedorref> fornecedorlist = new ArrayList<Fornecedorref>();
	private ObservableList<Fornecedorref> oblistaFornecedor;

	private ObservableList<String> situacaoFornecedor = FXCollections.observableArrayList(Situacao_Caixa.ATIVO.toString(),Situacao_Caixa.INATIVO.toString());
	private ObservableList<String> estados;
	private Estados[] arrayestados = Estados.values();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.main = MainTeste.getInstance();
		this.varejao = varejao.getInstance();

		carregarValoresTelaFornecedor();
		carregarTbViewFornecedor();

		buttonSalvarFornecedor.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					if (event.getSource() == buttonSalvarFornecedor) {
						// get reference to the button's stage
						String nome = new String(textFieldNomeFornecedor.getText());
						Situacao situ = null;
						String situacao = comboBoxSituacaoFornecedor.getValue();
						try{
							if(situacao.toString().equals("ATIVO")){
								situ = Situacao.ATIVO;
							}else
								situ = Situacao.INATIVO;
						}catch(Exception e){
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Erro ao cadastrar um Fornecedor.");
							alert.setHeaderText("Preencha o campo Situacao.");
							alert.setContentText(e.getMessage());
							alert.showAndWait();
						}
						String cnpj = textFieldCnpjFornecedor.getText();
						String rua = textFieldRuaFornecedor.getText();
						String cep = textFieldCepFornecedor.getText();

						String estadoletra = comboBoxEstados.getValue();
						Estados estadosigla = null;
						String UF;

						for(int i=0;i<arrayestados.length;i++){
							if(arrayestados[i].toString().equals(estadoletra)){
								estadosigla = arrayestados[i];
							}
						}

						String bairro = textFieldBairroFornecedor.getText();

						Fornecedorref fornecedor = new Fornecedorref(nome, cnpj, rua, cep, estadoletra, bairro, situ);
						try {
							varejao.salvarFornecedor(fornecedor);
							lblMensagem.setText("Fornecedor Cadastrado");
							refreshTable();
						} catch (Exception e) {
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Erro ao cadastrar um Fornecedor.");
							alert.setHeaderText("Impssivel efetuar cadastro");
							alert.setContentText(e.getMessage());
							alert.showAndWait();
						}
					}

				} catch (Exception e) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Erro ao cadastrar um fornecedor.");
					alert.setHeaderText("Impossivel efetuar cadastro.");
					alert.setContentText(e.getMessage());
					alert.showAndWait();
				}


			}
		});

		buttonLimparFornecedor.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				Stage stage;
				Parent root;
				try{
					if(event.getSource()==buttonLimparFornecedor){

							textFieldBairroFornecedor.clear();
							textFieldCepFornecedor.clear();
							textFieldCnpjFornecedor.clear();
							textFieldNomeFornecedor.clear();
							textFieldRuaFornecedor.clear();
							lblMensagem.setText("");

						//get reference to the button's stage
				        stage = (Stage) buttonLimparFornecedor.getScene().getWindow();
				        //load up OTHER FXML document
				        root = FXMLLoader.load(getClass().getResource("/gui/view/TelaCadastroFornecedor.fxml"));
				    } else {
						stage = (Stage) buttonLimparFornecedor.getScene().getWindow();
						root = FXMLLoader.load(getClass().getResource("/gui/view/TelaCadastroFornecedor.fxml"));
					}
					//create a new scene with root and set the stage
					Scene scene = new Scene(root);
				    stage.setScene(scene);
				    main.changeStage(stage);

			}catch(IOException e){
				e.printStackTrace();
			}


		}
		});
	}
	
	public void removerFornecedor(){
		Fornecedorref fornecedor = tbViewFornecedor.getSelectionModel().getSelectedItem();
		try{
			if(fornecedor !=null && fornecedor instanceof Fornecedorref){
				varejao.deletarFornecedor(fornecedor);
				tbViewFornecedor.getItems().remove(tbViewFornecedor.getSelectionModel().getSelectedIndex());
				refreshTable();
				lblMensagem.setText("Fornecedor Removido");
			}else{
				lblMensagem.setText("Selecione um Fornecedor para ser removido");
			}
		}catch (Exception e){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro ao remover um fornecedor.");
			alert.setHeaderText("Impossivel efetuar remocao.");
			alert.setContentText(e.getMessage());
			alert.showAndWait();

		}
	}

	@FXML
	private void txtcnpjKey(){
		TextFieldFormatter tf = new TextFieldFormatter();
		tf.setMask("##.###.###/####-##");
		tf.setCaracteresValidos("0123456789");
		tf.setTf(textFieldCnpjFornecedor);
		tf.formatter();
	}

	@FXML
	private void txtCepKey(){
		TextFieldFormatter tf = new TextFieldFormatter();
		tf.setMask("##.###-###");
		tf.setCaracteresValidos("0123456789");
		tf.setTf(textFieldCepFornecedor);
		tf.formatter();
	}

	private void carregarTbViewFornecedor(){
		//tbCollumIdCaixa.setCellValueFactory(new PropertyValueFactory<>("Id"));
		tbCollumIdFornecedor.setCellValueFactory(new PropertyValueFactory<>("Id"));
		tbCollumNomeFornecedor.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		tbCollumCnpjFornecedor.setCellValueFactory(new PropertyValueFactory<>("Cnpj"));
		tbCollumCepFornecedor.setCellValueFactory(new PropertyValueFactory<>("Cep"));
		tbCollumEstadoFornecedor.setCellValueFactory(new PropertyValueFactory<>("Estado"));
		tbCollumRuaFornecedor.setCellValueFactory(new PropertyValueFactory<>("Rua"));
		tbCollumBairroFornecedor.setCellValueFactory(new PropertyValueFactory<>("Bairro"));

		try {
			fornecedorlist = fachada.listarFornecedores();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		oblistaFornecedor = FXCollections.observableArrayList(fornecedorlist);
		tbViewFornecedor.setItems(oblistaFornecedor);
	}

	private void carregarValoresTelaFornecedor(){
		comboBoxSituacaoFornecedor.setItems(situacaoFornecedor);

		ArrayList<String> stringestados = new ArrayList<String>();
		for(int i=0; i < arrayestados.length; i++){
			stringestados.add(arrayestados[i].toString());
		}
		estados = FXCollections.observableArrayList(stringestados);
		comboBoxEstados.setItems(estados);
	}

	public void sair(ActionEvent event) {
		((Node) event.getSource()).getScene().getWindow().hide();

	}
	
	public void refreshTable() throws Exception{
		oblistaFornecedor = FXCollections.observableArrayList();
		oblistaFornecedor.addAll(varejao.listarFornecedores());
		tbViewFornecedor.setItems(oblistaFornecedor);
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
