package gui.controller;

import java.awt.Button;
import java.awt.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import negocio.controller.ControladorCaixa;
import negocio.controller.FachadaVarejao;
import dados.CaixaRepository;
import dados.RepositorioCaixa;
import gui.MainTeste;
import gui.VarejaoDeProdutosApp;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import negocio.entities.Caixa;
import negocio.entities.Preferencial_Caixa;
import negocio.entities.Situacao;
import negocio.entities.Situacao_Caixa;


public class CaixaControllerGui implements Initializable{

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

	private Collection<Caixa> listaCaixa = new ArrayList<Caixa>();
	private Collection<Caixa> listcaixa2 = new ArrayList<Caixa>();
	private ObservableList<Caixa> oblistaCaixa;

	private MainTeste main;
	private FachadaVarejao fachada = FachadaVarejao.getInstance();


	private ObservableList<String> situacao = FXCollections.observableArrayList(Situacao_Caixa.ATIVO.toString(),Situacao.INATIVO.toString());
	private ObservableList<String> preferencial = FXCollections.observableArrayList(Preferencial_Caixa.S.toString(),Preferencial_Caixa.N.toString());
	private ObservableList<Integer> seqFilialList;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.main = MainTeste.getInstance();

		//setando os valores do combobox
//		comboBoxSituacao.setItems(situacao);
//		comboBoxPreferencial.setItems(preferencial);
//		try {
//			listcaixa2 = fachada.listarCaixa();
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		ArrayList<Integer> listseqfilial = new ArrayList<Integer>();
//		for (Caixa caixa : listcaixa2) {
//			listseqfilial.add(caixa.getSeq_filial());
//		}
//		Collections.sort(listseqfilial);
//		seqFilialList = FXCollections.observableArrayList(listseqfilial);
//		comboBoxSeqFilial.setItems(seqFilialList);
//		textFieldIdMatrizCaixa.setText("1");
//		textFieldIdMatrizCaixa.editableProperty().set(false);

		//carregandoTableView
		carregandoValoresTela();
		carregarTableViewCaixa();


		//Metodo Salvar
		buttonSalvarCaixa.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Stage stage = null;
				Parent root = null;
				try {
					if (event.getSource() == buttonSalvarCaixa) {
						// get reference to the button's stage
						String descricao = new String(textFieldDescricaoCaixa.getText());
						Situacao situ;
						String situacao = comboBoxSituacao.getValue();
						if(situacao.toString().equals("ATIVO")){
							situ = Situacao.ATIVO;
						}else
							situ = Situacao.INATIVO;

						String preferencial = comboBoxPreferencial.getValue();
						Preferencial_Caixa pref;
						if(preferencial.toString().equals("S")){
							pref = Preferencial_Caixa.S;
						}else
							pref = Preferencial_Caixa.N;

						String observacao = new String(textFieldObservacaoCaixa.getText());

						String idMatriz = new String(textFieldIdMatrizCaixa.getText());
						int idm = Integer.parseInt(idMatriz);

						String seq_filial = new String(comboBoxSeqFilial.getValue().toString());
						int seqf = Integer.parseInt(seq_filial);

						Caixa caixa = new Caixa(descricao, situ, pref, observacao, idm, seqf);

						try {
							fachada.getInstance().salvarCaixa(caixa);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						stage = (Stage) buttonSalvarCaixa.getScene().getWindow();
				        //load up OTHER FXML document
				        root = FXMLLoader.load(getClass().getResource("/gui/view/TelaCadastroCaixa.fxml"));

					} else {
						stage = (Stage) buttonSalvarCaixa.getScene().getWindow();
						root = FXMLLoader.load(getClass().getResource("/gui/view/TelaCadastroCaixa.fxml"));
					}
					// create a new scene with root and set the stage
					Scene scene = new Scene(root);
					stage.setScene(scene);
					main.changeStage(stage);

				} catch (IOException e) {
					e.printStackTrace();
				}


			}
		});

		//Metodo Remover
		buttonRemoverCaixa.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				Stage stage;
				Parent root;
				try{

					Caixa caixaremove = tbViewCaixa.getSelectionModel().getSelectedItem();
					if(caixaremove!= null && caixaremove instanceof Caixa){

						try {
							fachada.deletarCaixa(caixaremove);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
					if(event.getSource()==buttonRemoverCaixa){
				        //get reference to the button's stage
				        stage = (Stage) buttonRemoverCaixa.getScene().getWindow();
				        //load up OTHER FXML document
				        root = FXMLLoader.load(getClass().getResource("/gui/view/TelaCadastroCaixa.fxml"));
				    } else {
						stage = (Stage) buttonRemoverCaixa.getScene().getWindow();
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

		buttonLimparCaixa.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				Stage stage;
				Parent root;
				try{
					if(event.getSource()==buttonLimparCaixa){

							textFieldDescricaoCaixa.clear();
							textFieldObservacaoCaixa.clear();

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

//	public void carregarTableViewCaixa() {
//		try {
//			listaCaixa = CaixaRepository.getInstance().getAll();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        oblistaCaixa = FXCollections.observableArrayList(listaCaixa);
//        //obslistaUsuarios.addAll(this.listaUsuarios);
//        tbViewCaixa.setItems(oblistaCaixa);
//        tbCollumIdCaixa.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId().toString()));
//        tbCollumSituacaoCaixa.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSituacao().toString()));
//	}

//
	public void carregarTableViewCaixa() {
		tbCollumIdCaixa.setCellValueFactory(new PropertyValueFactory<>("Id"));
        tbCollumSituacaoCaixa.setCellValueFactory(new PropertyValueFactory<>("Situacao"));
        tbCollumPreferencialCaixa.setCellValueFactory(new PropertyValueFactory<>("E_preferencial"));
        //tbCollumSeqFilialCaixa.setCellValueFactory(new PropertyValueFactory<>("sequencial_filial"));
        tbCollumSeqFilialCaixa.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSeq_filial().toString()));
        try {
			listaCaixa = fachada.listarCaixa();
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
		listcaixa2 = fachada.listarCaixa();
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
}
