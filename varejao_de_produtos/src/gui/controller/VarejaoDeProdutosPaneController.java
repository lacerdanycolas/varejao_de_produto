package gui.controller;

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
	private VarejaoDeProdutosApp VarejaoDeProdutosApp;
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
	
	public void sair(ActionEvent event) {
		((Node) event.getSource()).getScene().getWindow().hide();

	}

	public void setApp(VarejaoDeProdutosApp VarejaoDeProdutosApp) {
		this.setVarejaoDeProdutosApp(VarejaoDeProdutosApp);
	}

	public VarejaoDeProdutosApp getPanelaFitApp() {
		return VarejaoDeProdutosApp;
	}

	public void setVarejaoDeProdutosApp (VarejaoDeProdutosApp VarejaoDeProdutosApp) {
		this.VarejaoDeProdutosApp = VarejaoDeProdutosApp;
	}
}