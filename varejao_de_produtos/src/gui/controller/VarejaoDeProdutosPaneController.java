package gui.controller;

import java.io.IOException;

import gui.VarejaoDeProdutosApp;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
	Button	buttonLogin;

//	@FXML
//	Button buttonTelaFornecedor;


	private VarejaoDeProdutosApp main;

	@FXML
	public void initialize() throws Exception {

		this.setVarejaoDeProdutosApp(main.getInstance());
	 /*buttonLogin.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Stage stage = null;
				Parent root = null;
				try {
					if (event.getSource() == buttonLogin) {
						// get reference to the button's stage
						stage = (Stage) buttonLogin.getScene().getWindow();
						// load up OTHER FXML document
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
		});*/

	 /*buttonTelaFornecedor.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Stage stage = null;
				Parent root = null;
				try {
					if (event.getSource() == buttonTelaFornecedor) {
						// get reference to the button's stage
						stage = (Stage) buttonTelaFornecedor.getScene().getWindow();
						// load up OTHER FXML document
						root = FXMLLoader.load(getClass().getResource("/gui/view/TelaCadastroFornecedor.fxml"));
					}
					// create a new scene with root and set the stage
					Scene scene = new Scene(root);
					stage.setScene(scene);
					main.changeStage(stage);

				} catch (IOException e) {
					e.printStackTrace();
				}catch(NullPointerException e){

				}


			}
		});*/

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