package negocio.controller;

import java.util.Collection;

import dados.VendaRepository;
import negocio.entities.Venda;

public class ControladorVenda {
	
	private VendaRepository repositorio;
	
	 public ControladorVenda(VendaRepository rep) {
		this.repositorio=rep;
	}
	 
	 public Venda BuscarVenda (int id) throws Exception {
		 Venda venda = null;
		if(id>0) {
			venda= repositorio.getOne(id);
		}else {
			throw new IllegalArgumentException("Id invalido");
		}
		
		return venda;
	 }
	 
	 public Venda CadastraVenda(Venda venda) throws Exception {
		 Venda retorno =null;
		 if(venda.equals(null)) {
			 throw new IllegalArgumentException("Preencha os dados");
		 }else {
			 
			 retorno = repositorio.save(venda);
			 
		 }
		 
		 return retorno;
	 }

	 
	 
	 public void DeletarVenda(Venda venda) throws Exception {
		 if(venda.equals(null)) {
			 throw new IllegalArgumentException("Não exite");
		 }else if(repositorio.getOne(venda.getId()).equals(null)) {
			 throw new IllegalArgumentException("Venda não existe");
		 }
		 else {
			 repositorio.delete(venda);
		 }
	 }
	
	 public Collection<Venda> ListarVenda() throws Exception{
		 return repositorio.getAll();
	 }
	 
}
