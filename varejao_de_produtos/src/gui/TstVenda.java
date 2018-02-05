package gui;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import gui.controller.VendaControllerGui;
import negocio.controller.FachadaVarejao;
import negocio.entities.Item_Venda;
import negocio.entities.Venda;

public class TstVenda {
	
	
	
	public static void main (String []args) {
		
		 FachadaVarejao fachada = FachadaVarejao.getInstance();
		 
		 int id_produto=1;
			int quantidade=1;
			BigDecimal preco= new BigDecimal(10);
			BigDecimal desconto= new BigDecimal(0);
			Date data= new Date();
			
			Item_Venda item_venda = new Item_Venda(45, 2, 1, preco, desconto);
		//	Venda venda =new Venda ("12312312333",preco,data,desconto,1);
			
		 try {
			//fachada.CadastrarItem_Venda(item_venda);
		//System.out.println(fachada.Listar_Itens_Venda());
		//	venda=fachada.CadastraVenda(venda);
		System.out.println(fachada.ListarVenda().size());
		
		
		} catch (Exception e2) {
			e2.getMessage();
		}
		
//		Venda vendas = null;
//
//		ArrayList<Item_Venda> items= new ArrayList<Item_Venda>();
//		
//		int id_caixa=1;
//		String cpf_com="123456789";
//		
//		
//		VendaControllerGui venda= new VendaControllerGui();
//		
//		item_venda=venda.AddItemLista(0, id_produto, quantidade, preco, desconto);
//		Date data= new Date();
//		try {
//			vendas= venda.CadastrarVenda(cpf_com,data, id_caixa, item_venda);
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		try {
//			venda.CadastroItems(items, vendas);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		
	}

}
