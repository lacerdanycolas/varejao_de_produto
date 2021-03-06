package gui.controller;

import java.io.IOException;

import gui.VarejaoDeProdutosApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
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
	Button butGerenciarProdutos;
	@FXML
	Button butFornecedorRepresentante;
	@FXML
	Button butJornadaTrabalho;
	@FXML
	Button butPedidoFornecedor;
	@FXML
	Button buttonLogin;
	@FXML
	Button butGerenciarRepresentantes;
	@FXML
	Button butItemEstoque;

	@FXML
	Button buttonTelaFornecedor;

	private VarejaoDeProdutosApp main;

	@FXML
	public void initialize() throws Exception {
		this.setVarejaoDeProdutosApp(main.getInstance());
		this.setVarejaoDeProdutosApp(VarejaoDeProdutosApp.getInstance());
	}

	@FXML
	public void telaCaixa(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == butCaixa) {
				stage = (Stage) butCaixa.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/GUI/view/TelaCadastroCaixa.fxml"));
			} else {
				stage = (Stage) butCaixa.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/GUI/view/TelaPrincipalVarejao.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);
			varejaoDeProdutosApp.changeStage(stage);
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro ao carregar tela de Caixa.");
			alert.setHeaderText("Impssivel Carregar tela");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	@FXML
	public void telaFuncionario(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == butFuncionario) {
				stage = (Stage) butFuncionario.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/GUI/view/TelaCadastroFuncionario.fxml"));
			} else {
				stage = (Stage) butFuncionario.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/GUI/view/TelaPrincipalVarejao.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);
			varejaoDeProdutosApp.changeStage(stage);
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro ao carregar tela de Funcionario.");
			alert.setHeaderText("Impssivel Carregar tela");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	@FXML
	public void telaFornecedor(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == butFornecedor) {
				stage = (Stage) butFornecedor.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/GUI/view/TelaCadastroFornecedor.fxml"));
			} else {
				stage = (Stage) butFornecedor.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/GUI/view/TelaPrincipalVarejao.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);
			varejaoDeProdutosApp.changeStage(stage);
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro ao carregar tela de Fornecedor.");
			alert.setHeaderText("Impssivel Carregar tela");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	@FXML
	public void telaProduto(ActionEvent event) throws IOException {
		Parent root;
		Stage stage;
			if (event.getSource() == butProduto) {
				stage = (Stage) butProduto.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/GUI/view/TelaCadastroProduto.fxml"));
			} else {
				stage = (Stage) butProduto.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/GUI/view/TelaPrincipalVarejao.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);
			varejaoDeProdutosApp.changeStage(stage);

	}

	@FXML
	public void telaVenda(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == butVenda) {
				stage = (Stage) butVenda.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/GUI/view/TelaCadastroVenda.fxml"));
			} else {
				stage = (Stage) butVenda.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/GUI/view/TelaPrincipalVarejao.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);
			varejaoDeProdutosApp.changeStage(stage);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@FXML
	public void telaJornadaTrabalho(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == butJornadaTrabalho) {
				stage = (Stage) butJornadaTrabalho.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/gui/view/TelaCadastroJornadaConjunto.fxml"));
			} else {
				stage = (Stage) butJornadaTrabalho.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/GUI/view/TelaPrincipalVarejao.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);
			varejaoDeProdutosApp.changeStage(stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void telaPedidoFornecedor(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == butPedidoFornecedor) {
				stage = (Stage) butPedidoFornecedor.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/gui/view/TelaCadastroPedidoFornecedor.fxml"));
			} else {
				stage = (Stage) butPedidoFornecedor.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/GUI/view/TelaPrincipalVarejao.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);
			varejaoDeProdutosApp.changeStage(stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void telaCadastroFornecedor_representante(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == butFornecedorRepresentante) {
				stage = (Stage) butFornecedorRepresentante.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/gui/view/TelaCadastroFornecedor_representante.fxml"));
			} else {
				stage = (Stage) butFornecedorRepresentante.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/GUI/view/TelaPrincipalVarejao.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);
			varejaoDeProdutosApp.changeStage(stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void telaCadastroItemEstoque(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == butItemEstoque) {
				stage = (Stage) butItemEstoque.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/gui/view/TelaCadastroItemEstoque.fxml"));
			} else {
				stage = (Stage) butItemEstoque.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/GUI/view/TelaPrincipalVarejao.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);
			varejaoDeProdutosApp.changeStage(stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void telaGerenciarProdutos(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == butGerenciarProdutos) {
				stage = (Stage) butGerenciarProdutos.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/gui/view/TelaGerenciarProdutos.fxml"));
			} else {
				stage = (Stage) butGerenciarProdutos.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/GUI/view/TelaPrincipalVarejao.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);
			varejaoDeProdutosApp.changeStage(stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void telaGerenciarRepresentantes(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (event.getSource() == butGerenciarRepresentantes) {
				stage = (Stage) butGerenciarRepresentantes.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/gui/view/TelaGerenciarRepresentantes.fxml"));
			} else {
				stage = (Stage) butGerenciarRepresentantes.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/GUI/view/TelaPrincipalVarejao.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);
			varejaoDeProdutosApp.changeStage(stage);
		} catch (Exception e) {
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

	public void setVarejaoDeProdutosApp(VarejaoDeProdutosApp varejaoDeProdutosApp) {
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
