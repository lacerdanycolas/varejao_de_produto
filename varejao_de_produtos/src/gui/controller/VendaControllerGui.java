package gui.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.ResourceBundle;

import dados.FuncoesRepository;
import gui.MainTeste;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import negocio.entities.Item_Venda;
import negocio.entities.Venda;
import negocio.controller.FachadaVarejao;
import negocio.entities.Caixa;
import negocio.entities.Fornecedorref;
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
	javafx.scene.control.ComboBox<Integer> comboBoxIdCaixa;
	
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
	private ObservableList<Integer> id_caixa;
	
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
	
	@FXML
	Label lblMensagem;

	
	private ObservableList<Item_Venda> listaItens;
	private Collection<Item_Venda> IVlist = new ArrayList<Item_Venda>();
	
	private MainTeste main;
	private FachadaVarejao fachada = FachadaVarejao.getInstance();
	private ArrayList<Item_Venda> items= new ArrayList<Item_Venda>();
	Item_Venda item_venda;
    int codigoP;
    
    private FuncoesRepository funcoes;
  
    public BigDecimal Valor_total(ArrayList<Item_Venda> lista) {
		BigDecimal decimal = new BigDecimal(0);
		BigDecimal dec=null;

		for(int i=0; i<lista.size();i++) {
			dec=new BigDecimal(lista.get(i).getQuantidade());
			decimal=decimal.add(lista.get(i).getValor_unitario().multiply(dec));
			
		}
		return decimal;
	}
	
	public BigDecimal Valor_Total_Desconto(ArrayList<Item_Venda> lista) {
		BigDecimal decimal = new BigDecimal(0);
		
		for(int i=0; i<lista.size();i++) {
			decimal=decimal.add(lista.get(i).getValor_desconto_item());
		}
		return decimal;
	}
	
	
	
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
	
	public Venda CadastrarVenda ( String cpf_comprador, Date data_venda,int id_caixa) throws Exception {
		BigDecimal valorTotal= Valor_total(items);
		BigDecimal valorTotalDesconto= Valor_Total_Desconto(items);
		
		Venda venda=new Venda(cpf_comprador,valorTotal,data_venda,valorTotalDesconto,id_caixa);
		fachada.CadastraVenda(venda);
		
		return venda;
	}
	
	public void CadastroItems(ArrayList<Item_Venda> items) throws Exception {
		int id_venda=fachada.ListarVenda().size();
//		int id_venda=46;
		for(int i=0;i<items.size();i++) {
			items.get(i).setId_venda(id_venda);
			fachada.CadastrarItem_Venda(items.get(i));
			funcoes.AtualizaQtdEstoque(items.get(i).getId_produtoref(), items.get(i).getQuantidade());
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
		CarregarComBox();
		
		tbCollumIdProduto.setCellValueFactory(new PropertyValueFactory<Item_Venda,Integer>("id_produtoref"));
		tbCollumPreco.setCellValueFactory(new PropertyValueFactory<Item_Venda,BigDecimal>("valor_unitario"));
		tbCollumQuantidade.setCellValueFactory(new PropertyValueFactory<Item_Venda,Integer>("Quantidade"));
		tbCollumDesconto.setCellValueFactory(new PropertyValueFactory<Item_Venda,BigDecimal>("valor_desconto_item"));
		
		
		
		

		listaItens = FXCollections.observableArrayList();
		listaItens.addAll(items);
		tbViewItem.setItems(listaItens);

		
	

		
		buttonCadastarVenda.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Stage stage = null;
				Parent root = null;
				
				if (event.getSource() == buttonCadastarVenda) {
					
					if(items.isEmpty()) {
						 Alert dialogoInfo = new Alert(Alert.AlertType.WARNING);
						  dialogoInfo.setTitle("Atenção");
				            dialogoInfo.setHeaderText("Cadastro da Venda");
				            dialogoInfo.setContentText("Adicione um item");
				            dialogoInfo.showAndWait();
						
					}else {
						
					try {
						
					Date data= new Date();
					
					String cpf_comprador= new String (textField_CpfComprador.getText());
					Integer id_caixa= new Integer(comboBoxIdCaixa.getValue());
					System.out.println(""+ id_caixa);
					try {
						CadastrarVenda(cpf_comprador,data, id_caixa);
						CadastroItems(items);
						AtualizaTabela();
						LimparLista(items);
						textField_CpfComprador.clear();
						
						AtualizaTabela();
						  Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
						  dialogoInfo.setTitle("Informação");
				            dialogoInfo.setHeaderText("Cadastro da Venda");
				            dialogoInfo.setContentText("Venda cadastrada com sucesso");
				            dialogoInfo.showAndWait();
						  
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						
						
					
						
						
					}catch(Exception e) {
						Alert dialogoInfo = new Alert(Alert.AlertType.WARNING);
			            dialogoInfo.setTitle("ATENÇÃO");
			            dialogoInfo.setHeaderText("Cadastro Venda");
			            dialogoInfo.setContentText("Os campos Id do Caixa e CPF do comprador são obrigatorios!");
			            dialogoInfo.showAndWait();
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
//					Scene scene = new Scene(root);
//					stage.setScene(scene);
//					stage.show();
//					main.changeStage(stage);
				
				}
		
			
		});
		
		
		buttonAddItem.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Stage stage = null;
				Parent root = null;
				
				if (event.getSource() == buttonAddItem) {
					
	
					try {
					
					int id_venda=0;
					Integer id_produtoref= new Integer(textFieldId_produto.getText());
					Integer quantidade= new Integer(textFieldQuantidade.getText());
					BigDecimal valor_unitario= new BigDecimal(textFieldValor_unitario.getText());
					BigDecimal valor_desconto_item= new BigDecimal(textFieldValor_Desconto_item.getText());
					
					int resultado=funcoes.QtdEstoque(id_produtoref, quantidade);
					if(resultado==1) {

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
					}else {
						Alert dialogoInfo = new Alert(Alert.AlertType.WARNING);
			            dialogoInfo.setTitle("ATENÇÃO");
			            dialogoInfo.setHeaderText("Venda de Itens");
			            dialogoInfo.setContentText("O produto não possui quantidade suficiente no estoque");
			            dialogoInfo.showAndWait();
					}
					
					
				}catch(Exception e) {
					Alert dialogoInfo = new Alert(Alert.AlertType.WARNING);
		            dialogoInfo.setTitle("ATENÇÃO");
		            dialogoInfo.setHeaderText("Cadastro de Itens");
		            dialogoInfo.setContentText("Preencha todos os campos!");
		            dialogoInfo.showAndWait();
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
//					Scene scene = new Scene(root);
//					stage.setScene(scene);
//					stage.show();
//					main.changeStage(stage);
				
				}
			
		});
		
			buttonRemoverItem.setOnAction(e -> {
				
	          try {
	        	  Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
	        	 
	        	  Item_Venda item= tbViewItem.getSelectionModel().getSelectedItem();
	        	  
	            if(item!= null && item instanceof Item_Venda) {
	            	items.remove(item);
	            	tbViewItem.getItems().remove(tbViewItem.getSelectionModel().getSelectedIndex());
					AtualizaTabela();
					 dialogoInfo.setTitle("Informação");
			            dialogoInfo.setHeaderText("Remoção Item da Venda");
			            dialogoInfo.setContentText("Item removido com sucesso");
			            dialogoInfo.showAndWait();
	            	
		            try {
						AtualizaTabela();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            	
	            
	            }else {
	            	 Alert dialogo = new Alert(Alert.AlertType.WARNING);
					  dialogo.setTitle("Atenção");
			            dialogo.setHeaderText("Remoção de item");
			            dialogo.setContentText("Selecione um item");
			            dialogo.showAndWait();
	            }
	            	  
	          } catch(Exception e2) {

	            	Alert dialogoInfo = new Alert(Alert.AlertType.WARNING);
		            dialogoInfo.setTitle("ATENÇÃO");
		            dialogoInfo.setHeaderText("Remover Item da Venda");
		            dialogoInfo.setContentText("Selecione um item para removê-lo");
		            dialogoInfo.showAndWait();
	            }
	          
	            
	        

	        });
		}
		
	
	public void setApp(MainTeste main) {
		this.main = main;
	}
	
	
	public void voltarMenuPrincipal(ActionEvent event) {
		((Node) event.getSource()).getScene().getWindow().hide();
		Parent parent;
		try {
			parent = FXMLLoader.load(getClass().getResource("/GUI/view/TelaPrincipalVarejao.fxml"));
			Stage stage3 = new Stage();
			Scene cena = new Scene(parent);
			stage3.setScene(cena);
			stage3.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sair(ActionEvent event) {
		((Node) event.getSource()).getScene().getWindow().hide();

	}
	
	public void CarregarComBox() {
		
		ArrayList<Integer> ListaidCaixa =new ArrayList<Integer>();
		int cont=0;
		try {
			for(int i=0; i <fachada.listarCaixa().size(); i++){
				cont++;
				ListaidCaixa.add(cont);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		id_caixa=FXCollections.observableArrayList(ListaidCaixa);
		comboBoxIdCaixa.setItems(id_caixa);
		
	}
	
	@FXML
	public void txtcpf() {
		TextFieldFormatter tf = new TextFieldFormatter();
		tf.setMask("###.####.###-##");
		tf.setCaracteresValidos("0123456789");
		tf.setTf(textField_CpfComprador);
		tf.formatter();
		
	}

}