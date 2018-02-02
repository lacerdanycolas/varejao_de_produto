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
import negocio.entities.Estado_Civil;
import negocio.entities.Estados;
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
	TextField txtCpfFuncionario;

	@FXML
	TextField txtRgFuncionario;

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
	TextField txtCepFuncionario;

	@FXML
	TextField txtLogin;

	@FXML
	TextField txtSenha;

	@FXML
	TextField txtCpf_gerente;

	@FXML
	TextField txtCnpjMatrizFuncionario;
	
	@FXML
	private ComboBox<String> comboBoxEstados;
	
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
	private ObservableList<String> estados;
	private Estados[] arrayestados = Estados.values();
	@FXML
	private void initialize() throws Exception{

		this.varejao = varejao.getInstance();

		colunaId.setCellValueFactory(new PropertyValueFactory<>("Id"));
		colunaCPF.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCpf()));
		colunaLogin.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLogin()));
		colunaSexo.setCellValueFactory(new PropertyValueFactory<>("Sexo"));
		//colunaEstadoCivil.setCellValueFactory(new PropertyValueFactory<>("estado_civil"));
		colunaEstadoCivil.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEstadoC().toString()) );
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
		txtCpfFuncionario.clear();
		txtRgFuncionario.clear();
		txtPrimeiroNome.clear();
		txtSegundoNome.clear();
		txtTerceiroNome.clear();
		txtRua.clear();
		txtBairro.clear();
		txtCepFuncionario.clear();
		txtLogin.clear();
		txtSenha.clear();
		txtCpf_gerente.clear();
		txtCnpjMatrizFuncionario.clear();

	}

	public void cadastrarFuncionario(){
		try{
			String cpf, rg, primeiro_nome, segundo_nome, terceiro_nome, rua, bairro, estado, cep, login, senha, cpf_gerente, cnpj_Matriz;
			Sexo sexo = null;
			String sexoString = comboBoxSexo.getValue();
			try{
				if(sexoString.toString().equals("M")){
					sexo = Sexo.M;
				}else {
					sexo = Sexo.F;
				}
			}catch(Exception e){
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erro ao cadastrar um Funcionario.");
				alert.setHeaderText("Preencha o campo Sexo.");
				alert.setContentText(e.getMessage());
				alert.showAndWait();
			}
			Estado_Civil estadoCivil = null;
			String estadoCivilString = comboBoxEstadoCivil.getValue();
			try{
				if(estadoCivilString.toString().equals("SOLTEIRO")){
					estadoCivil = Estado_Civil.SOLTEIRO;
				}else if(estadoCivilString.toString().equals("CASADO")){
					estadoCivil = Estado_Civil.CASADO;
				}else{
					estadoCivil = Estado_Civil.DIVORCIADO;
				}
			}catch(Exception e){
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erro ao cadastrar um Funcionario.");
				alert.setHeaderText("Preencha o campo Estado_Civil.");
				alert.setContentText(e.getMessage());
				alert.showAndWait();
			}
			Situacao situacao = null;
			String situacaoString = comboBoxSituacao.getValue();
			try{
				if(situacaoString.toString().equals("ATIVO")){
					situacao = Situacao.ATIVO;
				}else{
					situacao = Situacao.INATIVO;
				}
			}catch(Exception e){
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erro ao cadastrar um Funcionario.");
				alert.setHeaderText("Preencha o campo Situacao.");
				alert.setContentText(e.getMessage());
				alert.showAndWait();
			}
			Tipo_Funcionario tipoFuncionario = null;
			String tipoFuncionarioString = comboBoxTipoFuncionario.getValue();
			try{
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
			}catch(Exception e){
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erro ao cadastrar um Funcionario.");
				alert.setHeaderText("Preencha o campo Tipo.");
				alert.setContentText(e.getMessage());
				alert.showAndWait();
			}
			cpf = txtCpfFuncionario.getText();
			cpf = cpf.replace(".", "").replace("-", "");
			rg = txtRgFuncionario.getText();
			rg = rg.replace(".", "");
			primeiro_nome = txtPrimeiroNome.getText();
			segundo_nome = txtSegundoNome.getText();
			terceiro_nome = txtTerceiroNome.getText();
			rua = txtRua.getText();
			bairro = txtBairro.getText();
			String estadoletra = comboBoxEstados.getValue();
			Estados estadosigla = null;
			String UF;

			for(int i=0;i<arrayestados.length;i++){
				if(arrayestados[i].toString().equals(estadoletra)){
					estadosigla = arrayestados[i];
				}
			}
			cep = txtCepFuncionario.getText();
			login = txtLogin.getText();
			senha = txtSenha.getText();
			cpf_gerente = txtCpf_gerente.getText();
			cpf_gerente = cpf_gerente.replace(".", "").replace("-", "");
			cnpj_Matriz = txtCnpjMatrizFuncionario.getText();
			cnpj_Matriz = cnpj_Matriz.replace("-", "");
			int seqf = 0;
			try{
			String seq_filial = new String(comboBoxSeqFilial.getValue().toString());
			seqf = Integer.parseInt(seq_filial);
			}catch(Exception e){
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erro ao cadastrar um Funcionario.");
				alert.setHeaderText("Preencha o campo Sequencial Filial.");
				alert.setContentText(e.getMessage());
				alert.showAndWait();	
			}
			Funcionario aux = new Funcionario(cpf, sexo, estadoCivil, rg, primeiro_nome, segundo_nome, terceiro_nome, situacao, rua, bairro, estadoletra, cep, login, senha, cpf_gerente, tipoFuncionario, cnpj_Matriz, seqf);
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
			}else{
				lblMensagem.setText("Selecione um funcionario para ser removido");
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
		txtCnpjMatrizFuncionario.setText("1376-19-273-43530");
		txtCnpjMatrizFuncionario.editableProperty().set(false);
		ArrayList<String> stringestados = new ArrayList<String>();
		for(int i=0; i < arrayestados.length; i++){
			stringestados.add(arrayestados[i].toString());
		}
		estados = FXCollections.observableArrayList(stringestados);
		comboBoxEstados.setItems(estados);
	}

	@FXML
	public void txtCpfMask(){
		TextFieldFormatter tf = new TextFieldFormatter();
		tf.setMask("###.###.###-##");
		tf.setCaracteresValidos("0123456789");
		tf.setTf(txtCpfFuncionario);
		tf.formatter();
	}

	@FXML
	public void txtRgMask(){
		TextFieldFormatter tf = new TextFieldFormatter();
		tf.setMask("#.###.###");
		tf.setCaracteresValidos("0123456789");
		tf.setTf(txtRgFuncionario);
		tf.formatter();
	}

	@FXML
	public void txtCepMask(){
		TextFieldFormatter tf = new TextFieldFormatter();
		tf.setMask("##.###-###");
		tf.setCaracteresValidos("0123456789");
		tf.setTf(txtCepFuncionario);
		tf.formatter();
	}

	@FXML
	public void txtCpf_GerenteMask(){
		TextFieldFormatter tf = new TextFieldFormatter();
		tf.setMask("###.###.###-##");
		tf.setCaracteresValidos("0123456789");
		tf.setTf(txtCpf_gerente);
		tf.formatter();
	}

}
