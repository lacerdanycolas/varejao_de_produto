package dados;

import negocio.entities.Caixa;
import negocio.entities.Dia;
import negocio.entities.Fornecedorref;
import negocio.entities.Situacao;

public class Main {

	private static Situacao situacao = Situacao.ATIVO;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DiaRepository repository = DiaRepository.getInstance();
		FornecedorrefRepository FornecedorRepository = dados.FornecedorrefRepository.getInstance();
				
		Repository<Caixa, Integer> caixa = new Repository();
		try {
			Fornecedorref f = new Fornecedorref(21, "Jimmys ltda", "1291829182", "Rua Albacora", "54400-400", "PE", "Piedade", situacao);
			Dia d = new Dia(27, "Olha o Dia novo");
			//repository.save(d);
			FornecedorRepository.save(f);
			//repository.getAll(); 
			//repository.delete(d);
			//caixa.save(new Caixa());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
