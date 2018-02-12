package negocio.controller;

import java.util.Collection;

import dados.CategoriaRepository;
import dados.Sub_categoriaRepository;
import exceptions.FormatacaoInvalidaException;
import negocio.entities.Categoriaref;
import negocio.entities.Sub_categoriaref;

public class ControladorSubcategoria {
		private static ControladorSubcategoria instance;
		private Sub_categoriaRepository repositorio;

		public static ControladorSubcategoria getInstance(){
			if(instance == null){
				instance = new ControladorSubcategoria();
			}
			return instance;
		}

		public ControladorSubcategoria() {
			this.repositorio = Sub_categoriaRepository.getInstance();
		}

		public Sub_categoriaref buscarSubcategoria(int id) throws Exception{
			if(id > 0) {
				return repositorio.getOne(id);
			}
			return null;
		}

		public Collection<Sub_categoriaref> listarSubcategoria() throws Exception {
			return repositorio.getAll();
		}

		public Sub_categoriaref salvarSubcategoria(Sub_categoriaref subcategoria) throws Exception {
			if (subcategoria.equals(null)) {
				throw new IllegalArgumentException();
			} else {
				return repositorio.save(subcategoria);
			}
		}

		public void deletarSubcategoria(Sub_categoriaref subcategoria) throws Exception {
			if(subcategoria.equals(null)) {
				throw new IllegalArgumentException();
			} else if (repositorio.getOne(subcategoria.getId()).equals(null)) {
				throw new Exception("Categoria nao existe");
			} else {
				repositorio.delete(subcategoria);
			}
		}

		public void alterarSubcategoria(Sub_categoriaref subcategoria) throws Exception {
			if(subcategoria == null){
				throw new FormatacaoInvalidaException();
			}else{
				this.repositorio.update(subcategoria);
			}
		}
}