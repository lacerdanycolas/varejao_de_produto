package gui;

import java.io.IOException;
import java.util.Spliterator;

import gui.controller.CaixaPaneController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainTeste extends Application{

	private Stage primaryStage;
	private BorderPane rootScene;

	private static MainTeste instance;

	public static MainTeste getInstance(){
		if(instance == null){
			instance = new MainTeste();
		}
		return instance;
	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Caixa");
		this.primaryStage.sizeToScene();
		this.rootScene = new BorderPane();

		Scene scene = new Scene(rootScene, 660, 565);
		primaryStage.setScene(scene);
		primaryStage.show();
		carregarTelaCaixa();
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

	public void carregarTelaCaixa(){
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/gui/view/TelaCadastroCaixa.fxml"));
		AnchorPane ap = null;
		try {
			ap = (AnchorPane) loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.rootScene.setCenter(ap);
		CaixaPaneController caixacontrol2 = new CaixaPaneController();
		loader.setController(caixacontrol2);
		caixacontrol2.setApp(this);
	}

}
