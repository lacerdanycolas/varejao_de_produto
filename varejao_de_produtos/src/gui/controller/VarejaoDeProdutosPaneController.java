package gui.controller;

import java.io.IOException;

import gui.VarejaoDeProdutosApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class VarejaoDeProdutosPaneController {
	private VarejaoDeProdutosApp varejaoDeProdutosApp;
	@FXML
	Button butX;
	@FXML
	Button butCaixa;
	@FXML
	Button butFuncionario;
	@FXML
	Button butFornecedor;
	@FXML
	Button butProduto;
	@FXML
	Button butVenda;
	
	@FXML
	public void initialize() throws Exception {
		this.setVarejaoDeProdutosApp(VarejaoDeProdutosApp.getInstance());
	}
	
	@FXML
	public void telaCaixa(ActionEvent event){
		Parent root;
		Stage stage;
		try{
			if(event.getSource() == butCaixa){
				stage = (Stage) butCaixa.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/GUI/view/TelaCadastroCaixa.fxml"));
			}else {
				stage = (Stage) butCaixa.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/GUI/view/TelaPrincipalVarejao.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);
			varejaoDeProdutosApp.changeStage(stage);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	@FXML
	public void telaFuncionario(ActionEvent event){
		Parent root;
		Stage stage;
		try{
			if(event.getSource() == butFuncionario){
				stage = (Stage) butFuncionario.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/GUI/view/TelaCadastroFuncionario.fxml"));
			}else {
				stage = (Stage) butFuncionario.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/GUI/view/TelaPrincipalVarejao.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);
			varejaoDeProdutosApp.changeStage(stage);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void sair(ActionEvent event) {
		((Node) event.getSource()).getScene().getWindow().hide();

	}

	public void setApp(VarejaoDeProdutosApp varejaoDeProdutosApp) {
		this.setVarejaoDeProdutosApp(varejaoDeProdutosApp);
	}

	public VarejaoDeProdutosApp getVarejaoDeProdutosApp() {
		return varejaoDeProdutosApp;
	}

	public void setVarejaoDeProdutosApp (VarejaoDeProdutosApp varejaoDeProdutosApp) {
		this.varejaoDeProdutosApp = varejaoDeProdutosApp;
	}
	
	public void voltarTelaLogin(ActionEvent event) {
		((Node) event.getSource()).getScene().getWindow().hide();
		Parent parent;
		try {
			parent = FXMLLoader.load(getClass().getResource("/GUI/view/TelaLoginVarejao.fxml"));
			Stage stage3 = new Stage();
			Scene cena = new Scene(parent);
			stage3.setScene(cena);
			stage3.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
