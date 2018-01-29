package gui.controller;

import java.awt.Button;
import java.awt.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

import controllers.ControladorCaixa;
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
	private javafx.scene.control.TextField textFieldDescricaoCaixa;

	@FXML
	private javafx.scene.control.TextField textFieldObservacaoCaixa;

	@FXML
	private javafx.scene.control.TextField textFieldIdMatrizCaixa;

	@FXML
	private javafx.scene.control.TextField textFieldSequencialFilialCaixa;

	@FXML
	private ComboBox<String> comboBoxSituacao;

	@FXML
	private ComboBox<String> comboBoxPreferencial;

	@FXML
	javafx.scene.control.Button buttonSalvarCaixa;

	@FXML
	javafx.scene.control.Button buttonRemoverCaixa;
	

	private Collection<Caixa> listaCaixa = new ArrayList<Caixa>();
	private ObservableList<Caixa> oblistaCaixa;

	private MainTeste main;

	private ObservableList<String> situacao = FXCollections.observableArrayList(Situacao_Caixa.ATIVO.toString(),Situacao.INATIVO.toString());
	private ObservableList<String> preferencial = FXCollections.observableArrayList(Preferencial_Caixa.S.toString(),Preferencial_Caixa.N.toString());

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.main = MainTeste.getInstance();
		comboBoxSituacao.setItems(situacao);
		comboBoxPreferencial.setItems(preferencial);

		carregarTableViewCaixa();

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

						String seq_filial = new String(textFieldSequencialFilialCaixa.getText());
						int seqf = Integer.parseInt(seq_filial);

						Caixa caixa = new Caixa(descricao, situ, pref, observacao, idm, seqf);

						try {
							CaixaRepository.getInstance().save(caixa);
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

		buttonRemoverCaixa.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				Stage stage;
				Parent root;
				try{

					Caixa caixaremove = tbViewCaixa.getSelectionModel().getSelectedItem();
					if(caixaremove!= null && caixaremove instanceof Caixa){

						try {
							CaixaRepository.getInstance().delete(caixaremove);
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
        try {
			listaCaixa = CaixaRepository.getInstance().getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        oblistaCaixa = FXCollections.observableArrayList(listaCaixa);
        tbViewCaixa.setItems(oblistaCaixa);
    }




	public void setApp(MainTeste main) {
		this.main = main;
	}
}
