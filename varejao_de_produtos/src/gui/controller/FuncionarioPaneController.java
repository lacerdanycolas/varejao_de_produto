package gui.controller;

import java.io.IOException;
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
import javafx.stage.Stage;
import negocio.controller.FachadaVarejao;
import negocio.entities.Caixa;
import negocio.entities.Estado_Civil;
import negocio.entities.Funcionario;
import negocio.entities.Sexo;
import negocio.entities.Situacao;
import negocio.entities.Situacao_Caixa;
import negocio.entities.Tipo_Funcionario;
public class FuncionarioPaneController {
	private FachadaVarejao varejao;
	@FXML
	Label lblMensagem;
	
	@FXML
	private TableView<Funcionario> tabelaFuncionarios;
	
	@FXML
	TableColumn<Funcionario, Integer> colunaId;
	
	@FXML
	TableColumn<Funcionario, String> colunaCPF;
	
	@FXML
	TableColumn<Funcionario, String> colunaLogin;
	
	@FXML
	TableColumn<Funcionario, String> colunaSexo;
	
	@FXML
	TableColumn<Funcionario, String> colunaEstadoCivil;
	
	@FXML
	TableColumn<Funcionario, String> colunaRG;
	
	@FXML
	TableColumn<Funcionario, String> colunaPrimeiroNome;
	
	@FXML
	TableColumn<Funcionario, String> colunaSegundoNome;
	
	@FXML
	TableColumn<Funcionario, String> colunaTerceiroNome;
	
	@FXML
	TableColumn<Funcionario, String> colunaSituacao;
	
	@FXML
	TableColumn<Funcionario, String> colunaRua;
	
	@FXML
	TableColumn<Funcionario, String> colunaTipo;
	
	@FXML
	Button butCadastrar;
	
	@FXML
	Button butRemover;
	
	@FXML
	Button butLimpar;
	
	@FXML
	Button butBuscar;
	
	@FXML
	TextField txtCPF;
	
	@FXML
	TextField txtRG;
	
	@FXML
	TextField txtPrimeiroNome;
	
	@FXML
	TextField txtSegundoNome;
	
	@FXML
	TextField txtTerceiroNome;
	
	@FXML
	TextField txtRua;
	
	@FXML
	TextField txtBairro;
	
	@FXML
	TextField txtEstado;
	
	@FXML
	TextField txtCep;
	
	@FXML
	TextField txtLogin;
	
	@FXML
	TextField txtSenha;
	
	@FXML
	TextField txtCpf_gerente;
	
	@FXML
	TextField txtCnpj_matriz;
	
	@FXML
	private ComboBox<String> comboBoxSituacao;

	@FXML
	private ComboBox<String> comboBoxSexo;

	@FXML
	private ComboBox<Integer> comboBoxSeqFilial;
	
	@FXML
	private ComboBox<String> comboBoxEstadoCivil;
	
	@FXML
	private ComboBox<String> comboBoxTipoFuncionario;
	
	private Collection<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
	private ObservableList<Funcionario> obListaFuncionario;
	
	private ObservableList<String> situacao = FXCollections.observableArrayList(Situacao_Caixa.ATIVO.toString(),Situacao.INATIVO.toString());
	private ObservableList<String> sexo = FXCollections.observableArrayList(Sexo.M.toString(), Sexo.F.toString());
	private ObservableList<String> estadoCivil = FXCollections.observableArrayList(Estado_Civil.SOLTEIRO.toString(),Estado_Civil.CASADO.toString(),Estado_Civil.DIVORCIADO.toString());
	private ObservableList<String> tipoFuncionario = FXCollections.observableArrayList(Tipo_Funcionario.OPERADOR_DE_CAIXA.toString(), Tipo_Funcionario.SUPERVISOR_DE_CAIXA.toString(), Tipo_Funcionario.COORDENADOR.toString(), Tipo_Funcionario.CARREGADOR.toString(), Tipo_Funcionario.SUPERVISOR_DE_ESTOQUE.toString());
	private ObservableList<Integer> seqFilialList;
	
	@FXML 
	private void initialize() throws Exception{
		
		varejao = varejao.getInstance();
		
		colunaId.setCellValueFactory(new PropertyValueFactory<>("Id"));
		colunaCPF.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCpf()));
		colunaLogin.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLogin()));
		colunaSexo.setCellValueFactory(new PropertyValueFactory<>("Sexo"));
		colunaEstadoCivil.setCellValueFactory(new PropertyValueFactory<>("Estado_civil"));
		colunaRG.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRg()));
		colunaPrimeiroNome.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrimeiro_nome()));
		colunaSegundoNome.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSegundo_nome()));
		colunaTerceiroNome.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTerceiro_nome()));
		colunaSituacao.setCellValueFactory(new PropertyValueFactory<>("Situacao"));
		colunaRua.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRua()));
		colunaTipo.setCellValueFactory(new PropertyValueFactory<>("Tipo"));
		
		carregarComboBoxs();
		obListaFuncionario = FXCollections.observableArrayList();
		obListaFuncionario.addAll(varejao.listarFuncionario());
		tabelaFuncionarios.setItems(obListaFuncionario);
	}
	
	@FXML
	public void refreshTable() throws Exception{
		obListaFuncionario = FXCollections.observableArrayList();
		obListaFuncionario.addAll(varejao.listarFuncionario());
		tabelaFuncionarios.setItems(obListaFuncionario);
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
		txtCPF.clear();
		txtRG.clear();
		txtPrimeiroNome.clear();
		txtSegundoNome.clear();
		txtTerceiroNome.clear();
		txtRua.clear();
		txtBairro.clear();
		txtEstado.clear();
		txtCep.clear();
		txtLogin.clear();
		txtSenha.clear();
		txtCpf_gerente.clear();
		txtCnpj_matriz.clear();

	}
	
	public void cadastrarFuncionario(){
		try{
			String cpf, rg, primeiro_nome, segundo_nome, terceiro_nome, rua, bairro, estado, cep, login, senha, cpf_gerente, cnpj_Matriz;
			Sexo sexo;
			String sexoString = comboBoxSexo.getValue();
			if(sexoString.toString().equals("M")){
				sexo = Sexo.M;
			}else {
				sexo = Sexo.F;
			}
			Estado_Civil estadoCivil;
			String estadoCivilString = comboBoxEstadoCivil.getValue();
			if(estadoCivilString.toString().equals("SOLTEIRO")){
				estadoCivil = Estado_Civil.SOLTEIRO;
			}else if(estadoCivilString.toString().equals("CASADO")){
				estadoCivil = Estado_Civil.CASADO;
			}else{
				estadoCivil = Estado_Civil.DIVORCIADO;
			}
			Situacao situacao;
			String situacaoString = comboBoxSituacao.getValue();
			if(situacaoString.toString().equals("ATIVO")){
				situacao = Situacao.ATIVO;
			}else
				situacao = Situacao.INATIVO;
			Tipo_Funcionario tipoFuncionario;
			String tipoFuncionarioString = comboBoxTipoFuncionario.getValue();
			if(tipoFuncionarioString.toString().equals("OPERADOR_DE_CAIXA")){
				tipoFuncionario = Tipo_Funcionario.OPERADOR_DE_CAIXA;
			}else if(tipoFuncionarioString.toString().equals("SUPERVISOR_DE_CAIXA")){
				tipoFuncionario = Tipo_Funcionario.SUPERVISOR_DE_CAIXA;
			}else if(tipoFuncionarioString.toString().equals("COORDENADOR")){
				tipoFuncionario = Tipo_Funcionario.COORDENADOR;
			}else if(tipoFuncionarioString.toString().equals("CARREGADOR")){
				tipoFuncionario = Tipo_Funcionario.CARREGADOR;
			}else{
				tipoFuncionario = Tipo_Funcionario.SUPERVISOR_DE_ESTOQUE;
			}
			cpf = txtCPF.getText();
			cpf = cpf.replace(".", "").replace("-", "");
			rg = txtRG.getText();
			rg = rg.replace(".", "");
			primeiro_nome = txtPrimeiroNome.getText();
			segundo_nome = txtSegundoNome.getText();
			terceiro_nome = txtTerceiroNome.getText();
			rua = txtRua.getText();
			bairro = txtBairro.getText();
			estado = txtEstado.getText();
			cep = txtCep.getText();
			login = txtLogin.getText();
			senha = txtSenha.getText();
			cpf_gerente = txtCpf_gerente.getText();
			cpf_gerente = cpf_gerente.replace(".", "").replace("-", "");
			cnpj_Matriz = txtCnpj_matriz.getText();
			cnpj_Matriz = cnpj_Matriz.replace("-", "");
			String seq_filial = new String(comboBoxSeqFilial.getValue().toString());
			int seqf = Integer.parseInt(seq_filial);
			Funcionario aux = new Funcionario(cpf, sexo, estadoCivil, rg, primeiro_nome, segundo_nome, terceiro_nome, situacao, rua, bairro, estado, cep, login, senha, cpf_gerente, tipoFuncionario, cnpj_Matriz, seqf);
			varejao.salvarFuncionario(aux);
			refreshTable();
			limparForm();
			lblMensagem.setText("Funcionario Cadastrado");
		}catch(Exception e){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro ao cadastrar um funcionario.");
			alert.setHeaderText("Impossivel efetuar cadastro.");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}
	
	public void removerFuncionario(){
		Funcionario funcionario = tabelaFuncionarios.getSelectionModel().getSelectedItem();
		try{
			if(funcionario !=null && funcionario instanceof Funcionario){
				varejao.deletarFuncionario(funcionario);
				tabelaFuncionarios.getItems().remove(tabelaFuncionarios.getSelectionModel().getSelectedIndex());
				limparForm();
				refreshTable();
				lblMensagem.setText("Funcionario Removido");
			}
		}catch (Exception e){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro ao remover um funcionario.");
			alert.setHeaderText("Impossivel efetuar remocao.");
			alert.setContentText(e.getMessage());
			alert.showAndWait();

		}
	}
	
	public void carregarComboBoxs(){
		comboBoxSituacao.setItems(situacao);
		comboBoxSexo.setItems(sexo);
		comboBoxEstadoCivil.setItems(estadoCivil);
		comboBoxTipoFuncionario.setItems(tipoFuncionario);
		try {
			listaFuncionario = varejao.listarFuncionario();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ArrayList<Integer> listseqfilial = new ArrayList<Integer>();
		for (Funcionario funcionario : listaFuncionario) {
			listseqfilial.add(funcionario.getSeq_filial());
		}
		Collections.sort(listseqfilial);
		seqFilialList = FXCollections.observableArrayList(listseqfilial);
		comboBoxSeqFilial.setItems(seqFilialList);
		txtCnpj_matriz.setText("1376-19-273-43530");
		txtCnpj_matriz.editableProperty().set(false);
	}
	
}
