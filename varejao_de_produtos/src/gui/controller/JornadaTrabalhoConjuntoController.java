package gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import dados.DiaRepository;
import dados.Jornada_TrabalhoRepository;
import dados.Jornada_dia_turno_conjuntoRepository;
import dados.TurnoRepository;
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
import negocio.entities.Dia;
import negocio.entities.Funcionario;
import negocio.entities.Jornada_Trabalho;
import negocio.entities.Jornada_dia_turno_conjunto;
import negocio.entities.Trabalha_Sabado;
import negocio.entities.Turno;

public class JornadaTrabalhoConjuntoController implements Initializable {


	@FXML
	private TableView<Funcionario> tbViewFuncionario;
	@FXML
	private TableColumn<Funcionario, String> tbCollumIdFunc;
	@FXML
	private TableColumn<Funcionario, String> tbCollumPNomeFunc;
	@FXML
	private TableColumn<Funcionario, String> tbCollumSNomeFunc;
	@FXML
	private TableView<Jornada_Trabalho> tbViewJornada;
	@FXML
	private TableColumn<Jornada_Trabalho, String> tbCollumJornadaIdFunc;
	@FXML
	private TableColumn<Jornada_Trabalho, String> tbCollumJornadaTrabSabado;


	@FXML
	private ComboBox<String> comboBoxTrabalhaSabado;
	@FXML
	private ComboBox<String> comboBoxDiaJornada;
	@FXML
	private ComboBox<String> comboBoxTurnoJornada;
	@FXML
	private TextField txtDescricaoJornada;
    @FXML
    private Button buttonSalvarJornada;
    @FXML
    private Button btSalvarPeriodo;
    @FXML
    private Button btDeletarJornada;
    @FXML
    private Button btnVoltar;
    @FXML
    private Label lblMessage;
    @FXML
    private Label lblPeriodo;
    @FXML
    private Label lblDeleteJornada;

    private MainTeste main;
	private Collection<Funcionario> listafunc = new ArrayList();
	private Collection<Jornada_Trabalho> listajornada = new ArrayList();
	private Collection<Dia> listadia = new ArrayList();
	private Collection<Turno> listaturno = new ArrayList();
	private ObservableList<String> obslistadia;
	private ObservableList<String> obslistaturno;
	private ObservableList<Funcionario> obslistafunc;
	private ObservableList<Jornada_Trabalho> obslistajornada;
	private FachadaVarejao fachada;
	private ObservableList<String> trabalhaSabado = FXCollections.observableArrayList(Trabalha_Sabado.N.toString(),Trabalha_Sabado.S.toString());

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		fachada = FachadaVarejao.getInstance();
		main = MainTeste.getInstance();

		carregarTbViewFuncionario();
		comboBoxTrabalhaSabado.setItems(trabalhaSabado);
		carregartTbViewJornada();


		buttonSalvarJornada.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				Stage stage;
				Parent root;
				try{
					if(event.getSource()==buttonSalvarJornada){
						Funcionario funcsalve = tbViewFuncionario.getSelectionModel().getSelectedItem();
						String trabalha_sabado = comboBoxTrabalhaSabado.getValue();
						Trabalha_Sabado trabSab = null;
						if(trabalha_sabado.equals("S"))
							trabSab = Trabalha_Sabado.S;
						else
							trabSab = Trabalha_Sabado.N;
						String descricao = txtDescricaoJornada.getText();
						Jornada_Trabalho jornadaTrab = new Jornada_Trabalho(funcsalve.getId(),trabSab,descricao);
						try {
							Jornada_TrabalhoRepository.getInstance().save(jornadaTrab);
							Alert alert = new Alert(Alert.AlertType.INFORMATION);
							alert.setTitle("Tela Cadastro Jornada e Periodo");
							alert.setHeaderText("Cadastramento Jornada");
							alert.setContentText("Jornada cadastrada com sucesso!");
							alert.show();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Erro ao cadastrar uma Jornada.");
							alert.setHeaderText("Impossivel efetuar cadastro.");
							alert.setContentText(e.getMessage());
							alert.showAndWait();
						}


						//get reference to the button's stage
				        stage = (Stage) buttonSalvarJornada.getScene().getWindow();
				        //load up OTHER FXML document
				        root = FXMLLoader.load(getClass().getResource("/gui/view/TelaCadastroJornadaConjunto.fxml"));
				    } else {
						stage = (Stage) buttonSalvarJornada.getScene().getWindow();
						root = FXMLLoader.load(getClass().getResource("/gui/view/TelaCadastroJornadaConjunto.fxml"));
					}
					//create a new scene with root and set the stage
					Scene scene = new Scene(root);
				    stage.setScene(scene);
				    main.changeStage(stage);

			}catch(Exception e){
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erro ao cadastrar uma Jornada.");
				alert.setHeaderText("Parametros inválidos ou nulos.");
				alert.setContentText(e.getMessage());
				alert.showAndWait();
			}


		}
		});

		btSalvarPeriodo.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				Stage stage;
				Parent root;
				try{
					if(event.getSource()==btSalvarPeriodo){

							Jornada_Trabalho jornada = tbViewJornada.getSelectionModel().getSelectedItem();
							String diadescr = comboBoxDiaJornada.getValue();
							Dia diacad = null;
							for (Dia dia : listadia) {
								if(dia.getDescricao().equals(diadescr)){
									diacad = dia;
								}
							}
							String turnodesc = comboBoxTurnoJornada.getValue();
							Turno turnocad = null;
							for (Turno turno : listaturno) {
								if(turno.getDescricao().equals(turnodesc))
								{
									turnocad = turno;
								}
							}

							Jornada_dia_turno_conjunto jdt = new Jornada_dia_turno_conjunto(jornada.getId(),diacad.getSequencial(),turnocad.getCodigo());

							try {
								Jornada_dia_turno_conjuntoRepository.getInstance().save(jdt);
								Alert alert = new Alert(Alert.AlertType.INFORMATION);
								alert.setTitle("Tela Cadastro Jornada e Periodo");
								alert.setHeaderText("Cadastramento Período");
								alert.setContentText("Período cadastrado com sucesso");
								alert.show();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								Alert alert = new Alert(AlertType.ERROR);
								alert.setTitle("Erro ao cadastrar um Período.");
								alert.setHeaderText("Impossivel efetuar cadastro.");
								alert.setContentText(e.getMessage());
								alert.showAndWait();
							}

						//get reference to the button's stage
				        stage = (Stage) btSalvarPeriodo.getScene().getWindow();
				        //load up OTHER FXML document
				        root = FXMLLoader.load(getClass().getResource("/gui/view/TelaCadastroJornadaConjunto.fxml"));
				    } else {
						stage = (Stage) btSalvarPeriodo.getScene().getWindow();
						root = FXMLLoader.load(getClass().getResource("/gui/view/TelaCadastroJornadaConjunto.fxml"));
					}
					//create a new scene with root and set the stage
					Scene scene = new Scene(root);
				    stage.setScene(scene);
				    main.changeStage(stage);

			}catch(Exception e){
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erro ao cadastrar um Período.");
				alert.setHeaderText("Parametros inválidos ou nulos, impossível realizar ação.");
				alert.setContentText(e.getMessage());
				alert.showAndWait();
			}


		}
		});

		btDeletarJornada.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				Stage stage;
				Parent root;
				try{
					if(event.getSource()==btDeletarJornada){

						Jornada_Trabalho jornadarem = tbViewJornada.getSelectionModel().getSelectedItem();
						try {
							Jornada_TrabalhoRepository.getInstance().delete(jornadarem);
							Alert alert = new Alert(Alert.AlertType.INFORMATION);
							alert.setTitle("Tela Cadastro Jornada e Periodo");
							alert.setHeaderText("Deletando Jornada");
							alert.setContentText("Jornada excluida com sucesso");
							alert.show();

						} catch (Exception e) {
							// TODO Auto-generated catch block
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Erro ao deletar uma jornada.");
							alert.setHeaderText("Parametros inválidos ou nulos. Selecione uma jornada para deletar");
							alert.setContentText(e.getMessage());
							alert.showAndWait();
						}


						//get reference to the button's stage
				        stage = (Stage) btDeletarJornada.getScene().getWindow();
				        //load up OTHER FXML document
				        root = FXMLLoader.load(getClass().getResource("/gui/view/TelaCadastroJornadaConjunto.fxml"));
				    } else {
						stage = (Stage) btDeletarJornada.getScene().getWindow();
						root = FXMLLoader.load(getClass().getResource("/gui/view/TelaCadastroJornadaConjunto.fxml"));
					}
					//create a new scene with root and set the stage
					Scene scene = new Scene(root);
				    stage.setScene(scene);
				    main.changeStage(stage);

			}catch(Exception e){
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erro ao deletar uma Jornada.");
				alert.setHeaderText("Parametros nulos. Selecione uma jornada para deletar");
				alert.setContentText(e.getMessage());
				alert.showAndWait();
			}


		}
		});

	}

	private void carregarTbViewFuncionario(){
		tbCollumIdFunc.setCellValueFactory(new PropertyValueFactory<>("Id"));
		tbCollumPNomeFunc.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getPrimeiro_nome()));
		tbCollumSNomeFunc.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getSegundo_nome()));

		try {
			listafunc = fachada.listarFuncionario();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		obslistafunc = FXCollections.observableArrayList(listafunc);
		tbViewFuncionario.setItems(obslistafunc);
	}
	private void carregartTbViewJornada(){
		tbCollumJornadaIdFunc.setCellValueFactory(new PropertyValueFactory<>("id_func"));
		tbCollumJornadaTrabSabado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTrabaS().toString()));

		try {
			listajornada = Jornada_TrabalhoRepository.getInstance().getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		obslistajornada = FXCollections.observableArrayList(listajornada);
		tbViewJornada.setItems(obslistajornada);

		try {
			listadia = DiaRepository.getInstance().getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<String> stringdias = new ArrayList<String>();
		for (Dia dia : listadia) {
			stringdias.add(dia.getDescricao());
		}
		obslistadia = FXCollections.observableArrayList(stringdias);
		comboBoxDiaJornada.setItems(obslistadia);

		try {
			listaturno = TurnoRepository.getInstance().getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> stringturno = new ArrayList<String>();
		for (Turno turno : listaturno) {
			stringturno.add(turno.getDescricao());
		}
		obslistaturno = FXCollections.observableArrayList(stringturno);
		comboBoxTurnoJornada.setItems(obslistaturno);


	}

	@FXML
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
	public void sair(ActionEvent event) {
		((Node) event.getSource()).getScene().getWindow().hide();

	}


}
