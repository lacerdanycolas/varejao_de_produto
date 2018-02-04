package gui.controller;
import negocio.controller.FachadaVarejao;
import gui.VarejaoDeProdutosApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginPaneController{
	private VarejaoDeProdutosApp varejaoDeProdutosApp;
	private FachadaVarejao varejao;
	@FXML
	TextField txtLogin;
	@FXML
	TextField txtSenha;
	@FXML
	Button butLogin;
	@FXML
	Button butX;
	@FXML
	public void efetuarLogin(ActionEvent event){
		Parent root;
		Stage stage;
		varejao = FachadaVarejao.getInstance();
		try{
			if(varejao.efetuarLoginFuncionario(txtLogin.getText(), txtSenha.getText())){
				if(event.getSource() == butLogin){
					stage = (Stage) butLogin.getScene().getWindow();
					root = FXMLLoader.load(getClass().getResource("/GUI/view/TelaPrincipalVarejao.fxml"));
					Scene scene = new Scene(root);
					stage.setScene(scene);
					varejaoDeProdutosApp.changeStage(stage);
				}
			}else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erro ao executar o login.");
				alert.setHeaderText("Impossivel efetuar login.");
				alert.showAndWait();
			}
		} catch(Exception e){
			e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro ao executar o login.");
			alert.setHeaderText("Impossivel efetuar login.");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}
	
	public void sair(ActionEvent event) {
		((Node) event.getSource()).getScene().getWindow().hide();

	}
	
	public void setVarejaoDeProdutosApp (VarejaoDeProdutosApp varejaoDeProdutosApp) {
		this.varejaoDeProdutosApp = varejaoDeProdutosApp;
	}
	
	public void setApp(VarejaoDeProdutosApp varejaoDeProdutosApp) {
		this.setVarejaoDeProdutosApp(varejaoDeProdutosApp);
	}
	
	/*@Override
	public void initialize(URL location, ResourceBundle resources) {
		try{
			
		}catch (Exception e){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro ao executar o login.");
			alert.setHeaderText("Impossivel efetuar login.");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
		
	}*/
	

	
}