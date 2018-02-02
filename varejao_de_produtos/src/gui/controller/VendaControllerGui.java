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

public class VendaControllerGui  implements Initializable{
	
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
	
	@FXML
	private javafx.scene.control.TextField textField_IdCaixa;
	
	
	@FXML
	javafx.scene.control.Button buttonCadastarVenda;
	
	@FXML
	javafx.scene.control.Button buttonAddItem;
	
	@FXML
	javafx.scene.control.Button buttonRemoverItem;

	private ObservableList<BigDecimal>valor_desconto;
	private ObservableList<BigDecimal> valor_unitario;
	private ObservableList<Integer> quantidade;
	private ObservableList<Integer> id_produto;
	
	@FXML
	private TableView<Item_Venda> tbViewItem;
	
	@FXML
	private TableColumn<Item_Venda, Integer> tbCollumIdProduto;
	
	@FXML
	private TableColumn<Item_Venda, BigDecimal> tbCollumPreco;
	
	@FXML
	private TableColumn<Item_Venda, Integer> tbCollumQuantidade;
	
	@FXML
	private TableColumn<Item_Venda, BigDecimal> tbCollumDesconto;
	
	

	
	private ObservableList<Item_Venda> listaItens;
	
	private MainTeste main;
	private FachadaVarejao fachada = FachadaVarejao.getInstance();
	private ArrayList<Item_Venda> items= new ArrayList<Item_Venda>();
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
	
	public Venda CadastrarVenda ( String cpf_comprador, Date data_venda,int id_caixa, Item_Venda item) throws Exception {
		BigDecimal valorTotal= item.Valor_total(items);
		BigDecimal valorTotalDesconto= item.Valor_Total_Desconto(items);
		
		Venda venda=new Venda(cpf_comprador,valorTotal,data_venda,valorTotalDesconto,id_caixa);
		fachada.CadastraVenda(venda);
		
		return venda;
	}
	
	public void CadastroItems(ArrayList<Item_Venda> items,Venda venda) throws Exception {
		int id_caixa=venda.getId();
		for(int i=0;i<items.size();i++) {
			items.get(i).setId(id_caixa);
			fachada.CadastrarItem_Venda(items.get(i));
		}
		
	}
	

	@FXML
	public void  AtualizaTabela () throws Exception{
		listaItens = FXCollections.observableArrayList();
		listaItens.addAll(items);
		tbViewItem.setItems(listaItens);
		
	}
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		this.main = MainTeste.getInstance();
		
		tbCollumIdProduto.setCellValueFactory(new PropertyValueFactory<Item_Venda,Integer>("Id"));
		tbCollumPreco.setCellValueFactory(new PropertyValueFactory<Item_Venda,BigDecimal>("Preço(R$"));
		tbCollumQuantidade.setCellValueFactory(new PropertyValueFactory<Item_Venda,Integer>("Quantidade"));
		tbCollumDesconto.setCellValueFactory(new PropertyValueFactory<Item_Venda,BigDecimal>("Desconto(R$"));
		
		
		listaItens = FXCollections.observableArrayList();
		listaItens.addAll(items);
		tbViewItem.setItems(listaItens);

		
	

		
		buttonCadastarVenda.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Stage stage = null;
				Parent root = null;
				
				if (event.getSource() == buttonCadastarVenda) {
					
					if(textField_CpfComprador.getText().equals(null)|| textField_IdCaixa.getText().equals(null)) {
						
						Alert dialogoInfo = new Alert(Alert.AlertType.WARNING);
				            dialogoInfo.setTitle("ATENÇÃO");
				            dialogoInfo.setHeaderText("Cadastro Venda");
				            dialogoInfo.setContentText("Os campos Id do Caixa e CPF do comprador são obrigatorios!");
				            dialogoInfo.showAndWait();
						
					}else {
						
					Date data= new Date();
					
					String cpf_comprador= new String (textField_CpfComprador.getText());
					Integer id_caixa= new Integer(textField_IdCaixa.getText());
					try {
						vendas= CadastrarVenda(cpf_comprador,data, id_caixa, item_venda);
						CadastroItems(items, vendas);
						AtualizaTabela();
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
			            dialogoInfo.setTitle("ATENÇÃO");
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
					try {
						AtualizaTabela();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
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
		            dialogoInfo.setTitle("ATENÇÃO");
		            dialogoInfo.setHeaderText("Remover Item da Venda");
		            dialogoInfo.setContentText("Digite um Id Válido");
		            dialogoInfo.showAndWait();
		            try {
						AtualizaTabela();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            	
	            }else {
	            	  codigoP= new Integer ( dialogo.getEditor().getText());
	            	  RemoverItem(codigoP);
	            }
	          
	            
	        

	        });
		}
		
	
	public void setApp(MainTeste main) {
		this.main = main;
	}
	
	
	@FXML
	public void txtCpfMask(){
		TextFieldFormatter tf = new TextFieldFormatter();
		tf.setMask("###.###.###-##");
		tf.setCaracteresValidos("0123456789");
		tf.setTf(textField_CpfComprador);
		tf.formatter();
	}

}
