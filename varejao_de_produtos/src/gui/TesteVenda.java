package gui;

import java.io.IOException;

import gui.controller.CaixaPaneController;
import gui.controller.VendaControllerGui;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TesteVenda  extends Application{

	private Stage primaryStage;
	private BorderPane rootScene;

	private static TesteVenda instance;

	public static TesteVenda getInstance(){
		if(instance == null){
			instance = new TesteVenda();
		}
		return instance;
	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Venda");
		this.primaryStage.sizeToScene();
		this.rootScene = new BorderPane();

		Scene scene = new Scene(rootScene, 660, 565);
		primaryStage.setScene(scene);
		primaryStage.show();
		carregarTelaVenda();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void changeStage(Stage stage){
		this.primaryStage = stage;
	}

	public void carregarTelaVenda(){
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/gui/view/TelaCadastroVenda.fxml"));
		AnchorPane ap = null;
		try {
			ap = (AnchorPane) loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.rootScene.setCenter(ap);
		VendaControllerGui vendacontroller = new VendaControllerGui();
		loader.setController(vendacontroller);
		vendacontroller.setApp(this);
	}
	

}
