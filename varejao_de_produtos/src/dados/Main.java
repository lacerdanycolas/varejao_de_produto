package dados;

import negocio.entities.Caixa;
import negocio.entities.Dia;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DiaSemanaRepository repository = DiaSemanaRepository.getInstance();
		Repository<Caixa, Integer> caixa = new Repository();
		try {
			Dia d = new Dia(27, "Olha o Dia novo");
			//repository.save(d);
			repository.getAll(); 
			repository.delete(d);
			//caixa.save(new Caixa());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
