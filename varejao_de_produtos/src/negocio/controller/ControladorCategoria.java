package negocio.controller;

import java.util.Collection;

import dados.CategoriaRepository;
import exceptions.FormatacaoInvalidaException;
import negocio.entities.Categoriaref;

public class ControladorCategoria {
		private static ControladorCategoria instance;
		private CategoriaRepository repositorio;

		public static ControladorCategoria getInstance(){
			if(instance == null){
				instance = new ControladorCategoria();
			}
			return instance;
		}

		public ControladorCategoria() {
			this.repositorio = CategoriaRepository.getInstance();
		}

		public Categoriaref buscarCategoria(int id) throws Exception{
			if(id > 0) {
				return repositorio.getOne(id);
			}
			return null;
		}

		public Collection<Categoriaref> listarCategoria() throws Exception {
			return repositorio.getAll();
		}

		public Categoriaref salvarCategoria(Categoriaref categoria) throws Exception {
			if (categoria.equals(null)) {
				throw new IllegalArgumentException();
			} else {
				return repositorio.save(categoria);
			}
		}

		public void deletarCategoria(Categoriaref categoria) throws Exception {
			if(categoria.equals(null)) {
				throw new IllegalArgumentException();
			} else if (repositorio.getOne(categoria.getId()).equals(null)) {
				throw new Exception("Categoria nao existe");
			} else {
				repositorio.delete(categoria);
			}
		}

		public void alterarCategoria(Categoriaref categoria) throws Exception {
			if(categoria == null){
				throw new FormatacaoInvalidaException();
			}else{
				this.repositorio.update(categoria);
			}
		}
}