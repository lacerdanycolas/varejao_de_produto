package negocio.controller;

import java.util.Collection;

import dados.CategoriaRepository;
import dados.Sub_categoriaRepository;
import dados.UnidadeRepository;
import exceptions.FormatacaoInvalidaException;
import negocio.entities.Categoriaref;
import negocio.entities.Sub_categoriaref;
import negocio.entities.Unidaderef;

public class ControladorUnidade {
		private static ControladorUnidade instance;
		private UnidadeRepository repositorio;

		public static ControladorUnidade getInstance(){
			if(instance == null){
				instance = new ControladorUnidade();
			}
			return instance;
		}

		public ControladorUnidade() {
			this.repositorio = UnidadeRepository.getInstance();
		}

		public Unidaderef buscarUnidade(int id) throws Exception{
			if(id > 0) {
				return repositorio.getOne(id);
			}
			return null;
		}

		public Collection<Unidaderef> listarUnidade() throws Exception {
			return repositorio.getAll();
		}

		public Unidaderef salvarUnidade(Unidaderef unidade) throws Exception {
			if (unidade.equals(null)) {
				throw new IllegalArgumentException();
			} else {
				return repositorio.save(unidade);
			}
		}

		public void deletarUnidade(Unidaderef unidade) throws Exception {
			if(unidade.equals(null)) {
				throw new IllegalArgumentException();
			} else if (repositorio.getOne(unidade.getId()).equals(null)) {
				throw new Exception("Unidade nao existe");
			} else {
				repositorio.delete(unidade);
			}
		}

		public void alterarUnidade(Unidaderef unidade) throws Exception {
			if(unidade == null){
				throw new FormatacaoInvalidaException();
			}else{
				this.repositorio.update(unidade);
			}
		}
}