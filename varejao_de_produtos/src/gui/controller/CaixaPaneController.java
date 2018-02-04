package gui.controller;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.ResourceBundle;
import negocio.controller.FachadaVarejao;
import gui.MainTeste;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import negocio.entities.Caixa;
import negocio.entities.Preferencial_Caixa;
import negocio.entities.Situacao;
import negocio.entities.Situacao_Caixa;


public class CaixaPaneController implements Initializable{
	private FachadaVarejao varejao;
	@FXML
	private TableView<Caixa> tbViewCaixa;
	@FXML
	private TableColumn<Caixa, String> tbCollumIdCaixa;
	@FXML
	private TableColumn<Caixa,String> tbCollumSituacaoCaixa;
	@FXML
	private TableColumn<Caixa, String> tbCollumPreferencialCaixa;
	@FXML
	private TableColumn<Caixa, String> tbCollumSeqFilialCaixa;


	@FXML
	private javafx.scene.control.TextField textFieldDescricaoCaixa;

	@FXML
	private javafx.scene.control.TextField textFieldObservacaoCaixa;

	@FXML
	private javafx.scene.control.TextField textFieldIdMatrizCaixa;


	@FXML
	private ComboBox<String> comboBoxSituacao;

	@FXML
	private ComboBox<String> comboBoxPreferencial;

	@FXML
	private ComboBox<Integer> comboBoxSeqFilial;

	@FXML
	javafx.scene.control.Button buttonSalvarCaixa;

	@FXML
	javafx.scene.control.Button buttonRemoverCaixa;

	@FXML
	javafx.scene.control.Button buttonLimparCaixa;
	
	@FXML
	Label lblMensagem;

	private Collection<Caixa> listaCaixa = new ArrayList<Caixa>();
	private Collection<Caixa> listcaixa2 = new ArrayList<Caixa>();
	private ObservableList<Caixa> oblistaCaixa;

	private MainTeste main;


	private ObservableList<String> situacao = FXCollections.observableArrayList(Situacao_Caixa.ATIVO.toString(),Situacao.INATIVO.toString());
	private ObservableList<String> preferencial = FXCollections.observableArrayList(Preferencial_Caixa.S.toString(),Preferencial_Caixa.N.toString());
	private ObservableList<Integer> seqFilialList;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.varejao = varejao.getInstance();
		this.main = MainTeste.getInstance();
		

		carregandoValoresTela();
		carregarTableViewCaixa();


		//Metodo Salvar
		buttonSalvarCaixa.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					if (event.getSource() == buttonSalvarCaixa) {
						// get reference to the button's stage
						String descricao = new String(textFieldDescricaoCaixa.getText());
						Situacao situ = null;
						String situacao = comboBoxSituacao.getValue();
						try{
							if(situacao.toString().equals("ATIVO")){
								situ = Situacao.ATIVO;
							}else{
								situ = Situacao.INATIVO;
							}
						}catch(Exception e){
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Erro ao cadastrar um caixa.");
							alert.setHeaderText("Preencha o campo Situacao.");
							alert.setContentText(e.getMessage());
							alert.showAndWait();
						}
						String preferencial = comboBoxPreferencial.getValue();
						Preferencial_Caixa pref = null;
						try{
							if(preferencial.toString().equals("S")){
								pref = Preferencial_Caixa.S;
							}else{
								pref = Preferencial_Caixa.N;
							}
						}catch(Exception e){
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Erro ao cadastrar um caixa.");
							alert.setHeaderText("Preencha o campo Preferencial.");
							alert.setContentText(e.getMessage());
							alert.showAndWait();
						}
						String observacao = new String(textFieldObservacaoCaixa.getText());

						String idMatriz = new String(textFieldIdMatrizCaixa.getText());
						int idm = Integer.parseInt(idMatriz);
						int seqf = 0;
						try{
						String seq_filial = new String(comboBoxSeqFilial.getValue().toString());
						seqf = Integer.parseInt(seq_filial);
						}catch(Exception e){
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Erro ao cadastrar um caixa.");
							alert.setHeaderText("Preencha o campo Sequencial Filial.");
							alert.setContentText(e.getMessage());
							alert.showAndWait();						
						}
						Caixa caixa = new Caixa(descricao, situ, pref, observacao, idm, seqf);
						try {
							varejao.salvarCaixa(caixa);
							refreshTable();
						} catch (Exception e) {
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Erro ao cadastrar um caixa.");
							alert.setHeaderText("Impossivel cadastrar caixa.");
							alert.setContentText(e.getMessage());
							alert.showAndWait();
						}
					} 

				}catch (Exception e) {
					e.printStackTrace();
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Erro ao cadastrar um caixa.");
					alert.setHeaderText("Impossivel efetuar cadastro.");
					alert.setContentText(e.getMessage());
					alert.showAndWait();
				}


			}
		});

		buttonLimparCaixa.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				Stage stage;
				Parent root;
				try{
					if(event.getSource()==buttonLimparCaixa){

							textFieldDescricaoCaixa.clear();
							textFieldObservacaoCaixa.clear();
							lblMensagem.setText("");

						//get reference to the button's stage
				        stage = (Stage) buttonLimparCaixa.getScene().getWindow();
				        //load up OTHER FXML document
				        root = FXMLLoader.load(getClass().getResource("/gui/view/TelaCadastroCaixa.fxml"));
				    } else {
						stage = (Stage) buttonLimparCaixa.getScene().getWindow();
						root = FXMLLoader.load(getClass().getResource("/gui/view/TelaCadastroCaixa.fxml"));
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

//Novo remover, deixa ASSIM!
	public void removerCaixa(){
		Caixa caixa = tbViewCaixa.getSelectionModel().getSelectedItem();
		try{
			if(caixa !=null && caixa instanceof Caixa){
				varejao.deletarCaixa(caixa);
				tbViewCaixa.getItems().remove(tbViewCaixa.getSelectionModel().getSelectedIndex());
				refreshTable();
				lblMensagem.setText("Caixa Removido");
			}else{
				lblMensagem.setText("Selecione um Caixa para ser removido");
			}
		}catch (Exception e){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro ao remover um caixa.");
			alert.setHeaderText("Impossivel efetuar remocao.");
			alert.setContentText(e.getMessage());
			alert.showAndWait();

		}
	}

	public void refreshTable() throws Exception{
		oblistaCaixa = FXCollections.observableArrayList();
		oblistaCaixa.addAll(varejao.listarCaixa());
		tbViewCaixa.setItems(oblistaCaixa);
	}
	
	
	public void carregarTableViewCaixa() {
		tbCollumIdCaixa.setCellValueFactory(new PropertyValueFactory<>("Id"));
        tbCollumSituacaoCaixa.setCellValueFactory(new PropertyValueFactory<>("Situacao"));
        tbCollumPreferencialCaixa.setCellValueFactory(new PropertyValueFactory<>("E_preferencial"));

        tbCollumSeqFilialCaixa.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSeq_filial().toString()));
        try {
			listaCaixa = varejao.listarCaixa();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        oblistaCaixa = FXCollections.observableArrayList(listaCaixa);
        tbViewCaixa.setItems(oblistaCaixa);
    }

public void carregandoValoresTela(){
	comboBoxSituacao.setItems(situacao);
	comboBoxPreferencial.setItems(preferencial);
	try {
		listcaixa2 = varejao.listarCaixa();
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	ArrayList<Integer> listseqfilial = new ArrayList<Integer>();
	for (Caixa caixa : listcaixa2) {
		listseqfilial.add(caixa.getSeq_filial());
	}
	Collections.sort(listseqfilial);
	seqFilialList = FXCollections.observableArrayList(listseqfilial);
	comboBoxSeqFilial.setItems(seqFilialList);
	textFieldIdMatrizCaixa.setText("1");
	textFieldIdMatrizCaixa.editableProperty().set(false);
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

