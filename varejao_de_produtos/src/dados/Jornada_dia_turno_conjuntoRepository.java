package dados;


import negocio.entities.Jornada_dia_turno_conjunto;

public class Jornada_dia_turno_conjuntoRepository extends Repository<Jornada_dia_turno_conjunto, Integer> {

	public static Jornada_dia_turno_conjuntoRepository instance;

	public static Jornada_dia_turno_conjuntoRepository getInstance(){
		if(instance==null){
			instance = new Jornada_dia_turno_conjuntoRepository();
		}
		return instance;
	}

	private Jornada_dia_turno_conjuntoRepository(){

	}

}
