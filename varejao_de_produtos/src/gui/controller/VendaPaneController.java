package gui.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import gui.MainTeste;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import negocio.entities.Item_Venda;
import negocio.entities.Venda;
import negocio.controller.FachadaVarejao;
import negocio.entities.Caixa;
import negocio.entities.Preferencial_Caixa;
import negocio.entities.Situacao;
import negocio.entities.Situacao_Caixa;

public class VendaPaneController  implements Initializable{

	@FXML
	private javafx.scene.control.TextField textFieldValor_unitario;
	@FXML
	private javafx.scene.control.TextField textFieldId_produto;
	@FXML
	private javafx.scene.control.TextField textFieldQuantidade;
	@FXML
	private javafx.scene.control.TextField textFieldValor_Desconto_item;
	@FXML
	private javafx.scene.control.TextField textField_CpfComprador;

	//private javafx.scene.control.TextField textField_DataVenda;
	@FXML
	private javafx.scene.control.TextField textField_IdCaixa;


	@FXML
	javafx.scene.control.Button buttonCadastarVenda;

	@FXML
	javafx.scene.control.Button buttonAddItem;

	@FXML
	javafx.scene.control.Button buttonRemoverItem;
	
	@FXML
	private TableView<Venda> tabelaVendas;
	
	@FXML
	TableColumn<Venda, Integer> colunaId;
	
	@FXML
	TableColumn<Venda, Integer> colunaValorTotal;
	
	@FXML
	TableColumn<Venda, Integer> colunaIdCaixa;

	@FXML
	TableColumn<Venda, Integer> colunaValorDesconto;
	
	private ObservableList<Venda> obListaVenda;
	
	private ObservableList<BigDecimal>valor_desconto;
	private ObservableList<BigDecimal> valor_unitario;
	private ObservableList<Integer> quantidade;
	private ObservableList<Integer> id_produto;
	@FXML
	private ComboBox<Integer> comboBoxId;
	@FXML
	private ComboBox<Integer> comboBoxQuant;
	@FXML
	private ComboBox<BigDecimal> comboBoxVUnitario;
	@FXML
	private ComboBox<BigDecimal> comboBoxDesconto;


	private MainTeste main;
	private FachadaVarejao fachada = FachadaVarejao.getInstance();
	ArrayList<Item_Venda> items= new ArrayList<Item_Venda>();
	Item_Venda item_venda;
	Venda vendas;
    int codigoP;



	public Item_Venda AddItemLista(int id_venda, int id_produtoref, int quantidade,  BigDecimal valor_unitario,
			 BigDecimal valor_desconto_item) {
		Item_Venda item= new Item_Venda(id_venda, id_produtoref, quantidade, valor_unitario, valor_desconto_item);
		items.add(item);
		return item;
	}



	public void LimparLista(ArrayList<Item_Venda> items) {
		items.clear();
	}

	public void RemoverItem(int idProduto) {
		for(int i=0;i<items.size();i++) {
			if(items.get(i).getId_produtoref()== idProduto) {
				items.remove(items.get(i));
			}
		}
	}


	public void CadastroItems(ArrayList<Item_Venda> items,Venda venda) throws Exception {
		int id_caixa=venda.getId();
		for(int i=0;i<items.size();i++) {
			items.get(i).setId(id_caixa);
			fachada.CadastrarItem_Venda(items.get(i));
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		this.main = MainTeste.getInstance();

		try {
			carregandoValoresTela();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		buttonCadastarVenda.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Stage stage = null;
				Parent root = null;

				if (event.getSource() == buttonCadastarVenda) {

					if(textField_CpfComprador.getText().equals(null)|| textField_IdCaixa.getText().equals(null)) {

						Alert dialogoInfo = new Alert(Alert.AlertType.WARNING);
				            dialogoInfo.setTitle("ATEN��O");
				            dialogoInfo.setHeaderText("Cadastro Venda");
				            dialogoInfo.setContentText("Os campos Id do Caixa e CPF do comprador s�o obrigatorios!");
				            dialogoInfo.showAndWait();

					}else {

					Date data= new Date();

					String cpf_comprador= new String (textField_CpfComprador.getText());
					Integer id_caixa= new Integer(textField_IdCaixa.getText());
					try {
	
						CadastroItems(items, vendas);
						LimparLista(items);
						textField_CpfComprador.clear();
						textField_IdCaixa.clear();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}





					}

				}else {
						stage = (Stage) buttonCadastarVenda.getScene().getWindow();
						try {
							root = FXMLLoader.load(getClass().getResource("/gui/view/TelaCadastroVenda.fxml"));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					// create a new scene with root and set the stage
					Scene scene = new Scene(root);
					stage.setScene(scene);
					stage.show();
					main.changeStage(stage);

				}


		});


		buttonAddItem.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Stage stage = null;
				Parent root = null;

				if (event.getSource() == buttonAddItem) {

					if(textFieldId_produto.getText().equals(null) || textFieldQuantidade.getText().equals(null)|| textFieldValor_Desconto_item.getText().equals(null)||textFieldValor_unitario.getText().equals(null)) {

						Alert dialogoInfo = new Alert(Alert.AlertType.WARNING);
			            dialogoInfo.setTitle("ATEN��O");
			            dialogoInfo.setHeaderText("Cadastro Venda");
			            dialogoInfo.setContentText("Preencha todos os campos!");
			            dialogoInfo.showAndWait();

					}else {

					int id_venda=0;
					Integer id_produtoref= new Integer(textFieldId_produto.getText());
					Integer quantidade= new Integer(textFieldQuantidade.getText());
					BigDecimal valor_unitario= new BigDecimal(textFieldValor_unitario.getText());
					BigDecimal valor_desconto_item= new BigDecimal(textFieldValor_Desconto_item.getText());
					item_venda= AddItemLista(id_venda, id_produtoref, quantidade, valor_unitario, valor_desconto_item);


					textFieldId_produto.clear();
					textFieldQuantidade.clear();
					textFieldValor_unitario.clear();
					textFieldValor_Desconto_item.clear();

				}
				}else {
						stage = (Stage) buttonAddItem.getScene().getWindow();
						try {
							root = FXMLLoader.load(getClass().getResource("/gui/view/TelaCadastroVenda.fxml"));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					Scene scene = new Scene(root);
					stage.setScene(scene);
					stage.show();
					main.changeStage(stage);

				}

		});

			buttonRemoverItem.setOnAction(e -> {

	            TextInputDialog dialogo = new TextInputDialog();
	            dialogo.setTitle("Remover Item");
	            dialogo.setHeaderText("Informe: ");
	            dialogo.setContentText("Id do produto: ");
	            if(dialogo.getEditor().getText().equals(null)) {

	            	Alert dialogoInfo = new Alert(Alert.AlertType.WARNING);
		            dialogoInfo.setTitle("ATEN��O");
		            dialogoInfo.setHeaderText("Remover Item da Venda");
		            dialogoInfo.setContentText("Digite um Id V�lido");
		            dialogoInfo.showAndWait();


	            }else {
	            	  codigoP= new Integer ( dialogo.getEditor().getText());
	            	  RemoverItem(codigoP);
	            }




	        });
		}

public void refreshTable() throws Exception{
	obListaVenda = FXCollections.observableArrayList();
	obListaVenda.addAll(fachada.ListarVenda());
	tabelaVendas.setItems(obListaVenda);
}

	public void carregandoValoresTela() throws Exception{
		colunaId.setCellValueFactory(new PropertyValueFactory<>("Id"));
		colunaValorTotal.setCellValueFactory(new PropertyValueFactory<>("Valor_total"));
		colunaIdCaixa.setCellValueFactory(new PropertyValueFactory<>("Id_caixa"));
		colunaValorDesconto.setCellValueFactory(new PropertyValueFactory<>("Valor_total_desconto"));
		
		obListaVenda = FXCollections.observableArrayList();
		obListaVenda.addAll(fachada.ListarVenda());
		tabelaVendas.setItems(obListaVenda);
/*		ArrayList<Integer> listId = new ArrayList<Integer>();
		ArrayList<Integer> listQtd = new ArrayList<Integer>();
		ArrayList<BigDecimal> listVUnita = new ArrayList<BigDecimal>();
		ArrayList<BigDecimal> listVDesc = new ArrayList<BigDecimal>();

		for (int i=0;i<items.size();i++) {
			listId.add(items.get(i).getId());
			listQtd.add((items.get(i).getQuantidade()));
			listVUnita.add(items.get(i).getValor_unitario());
			listVDesc.add(items.get(i).getValor_desconto_item());
		}
		Collections.sort(listId);
		Collections.sort(listQtd);
		Collections.sort(listVUnita);
		Collections.sort(listVDesc);
		id_produto = FXCollections.observableArrayList(listId);
		quantidade = FXCollections.observableArrayList(listQtd);
		valor_unitario=FXCollections.observableArrayList(listVUnita);
		valor_desconto= FXCollections.observableArrayList(listVDesc);
		comboBoxId.setItems(id_produto);
		comboBoxQuant.setItems(quantidade);
		comboBoxVUnitario.setItems(valor_unitario);
		comboBoxDesconto.setItems(valor_desconto);*/
	}

	public void setApp(MainTeste main) {
		this.main = main;
	}



}
