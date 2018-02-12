package negocio.controller;

import java.util.Collection;

import dados.MarcaRepository;
import exceptions.FormatacaoInvalidaException;
import negocio.entities.Marcaref;
import negocio.entities.Unidaderef;

public class ControladorMarca {
		private static ControladorMarca instance;
		private MarcaRepository repositorio;

		public static ControladorMarca getInstance(){
			if(instance == null){
				instance = new ControladorMarca();
			}
			return instance;
		}

		public ControladorMarca() {
			this.repositorio = MarcaRepository.getInstance();
		}

		public Marcaref buscarMarca(int id) throws Exception{
			if(id > 0) {
				return repositorio.getOne(id);
			}
			return null;
		}

		public Collection<Marcaref> listarMarca() throws Exception {
			return repositorio.getAll();
		}

		public Marcaref salvarMarca(Marcaref marca) throws Exception {
			if (marca.equals(null)) {
				throw new IllegalArgumentException();
			} else {
				return repositorio.save(marca);
			}
		}

		public void deletarMarca(Marcaref marca) throws Exception {
			if(marca.equals(null)) {
				throw new IllegalArgumentException();
			} else if (repositorio.getOne(marca.getId()).equals(null)) {
				throw new Exception("Marca nao existe");
			} else {
				repositorio.delete(marca);
			}
		}

		public void alterarMarca(Marcaref marca) throws Exception {
			if(marca == null){
				throw new FormatacaoInvalidaException();
			}else{
				this.repositorio.update(marca);
			}
		}
}