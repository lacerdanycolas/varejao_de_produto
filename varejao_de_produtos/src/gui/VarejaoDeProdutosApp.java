package gui;

import java.io.IOException;

import gui.controller.LoginPaneController;
import gui.controller.VarejaoDeProdutosPaneController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class VarejaoDeProdutosApp extends Application {

	private Stage primaryStage;
	private BorderPane rootScene;



	private static VarejaoDeProdutosApp instance;

	public static VarejaoDeProdutosApp getInstance(){
		if(instance == null){
			instance = new VarejaoDeProdutosApp();
		}
		return instance;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Varejao de Fraldas");
		this.primaryStage.sizeToScene();
		this.rootScene = new BorderPane();

		Scene scene = new Scene(rootScene, 660, 565);
		primaryStage.setScene(scene);
		primaryStage.show();



		carregarTelaLogin();

	}
	public static void main(String[] args) {
		launch(args);
	}

	public void carregarTelaLogin(){
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/GUI/view/TelaLoginVarejao.fxml"));
			BorderPane pane = (BorderPane) loader.load();

			this.rootScene.setCenter(pane);
			LoginPaneController loginPaneController= loader.getController();
			loginPaneController.setApp(this);
			}catch(IOException e){
				e.printStackTrace();
			}
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void changeStage(Stage stage){
		this.primaryStage = stage;
	}
}
