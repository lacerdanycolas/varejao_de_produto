package dados;

import java.math.BigDecimal;
import java.util.Collection;

import negocio.entities.Caixa;
import negocio.entities.Dia;
import negocio.entities.Estado_Civil;
import negocio.entities.Fornecedorref;
import negocio.entities.Funcionario;
import negocio.entities.Preferencial_Caixa;
import negocio.entities.Produtoref;
import negocio.entities.Sexo;
import negocio.entities.Situacao;
import negocio.entities.Situacao_Caixa;
import negocio.entities.Tipo_Funcionario;

public class Main {


	public static void main(String[] args) {
		 Situacao situacao = Situacao.ATIVO;
		 Estado_Civil estado_civil = Estado_Civil.SOLTEIRO;
		 Tipo_Funcionario tipo_func = Tipo_Funcionario.SUPERVISOR_DE_CAIXA;
		 Sexo sexo = Sexo.M;
		 Preferencial_Caixa e_preferencial = Preferencial_Caixa.N;
		// TODO Auto-generated method stub
		DiaRepository repository = DiaRepository.getInstance();
		FornecedorrefRepository fornecedorRepository = dados.FornecedorrefRepository.getInstance();
		FuncionarioRepository  funcionarioRepository = dados.FuncionarioRepository.getInstance();
		CaixaRepository caixaRepository = dados.CaixaRepository.getInstance();
		ProdutorefRepository produtoRepository = dados.ProdutorefRepository.getInstance();
		try {

			//Fornecedorref f = new Fornecedorref(21, "Jimmys ltda", "1291829182", "Rua Albacora", "54400-400", "PE", "Piedade", situacao);
		//	Funcionario func = new Funcionario(21, "03236541123",sexo, estado_civil, "8842161", "Rafael", "Camara", "Figueredo", situacao, "Rua Espardate", "Brasilia teimosa", "PE", "45555555", "admin", "admin", "10303577495",  tipo_func, "2352733254", 14);

			//Fornecedorref f = new Fornecedorref(21, "Jimmys ltda", "1291829182", "Rua Albacora", "54400-400", "PE", "Piedade", situacao);
			//Funcionario func = new Funcionario("03236541123",sexo, estado_civil, "8842161", "Rafael", "Camara", "Figueredo", situacao, "Rua Espardate", "Brasilia teimosa", "PE", "45555555", "admin", "admin", "10303577495",  tipo_func, "2352733254", 14);
// refs/remotes/origin/master
			//Caixa caixa = new Caixa(null, situacao, e_preferencial, null, 1, 26);
			Dia d = new Dia(27, "Olha o Dia novo");
			Produtoref produto = new Produtoref("28162152", 460, null, null, new BigDecimal("27.32"), "10", new BigDecimal("0.00"), "Faca de madeira", null, null, null, 3, 4, 4, 2, 9, 17);
			//Caixa caixa3 = new Caixa("teste",situacao,e_preferencial,null,1,24);
			//produtoRepository.save(produto);

			//caixaRepository.save(caixa3);


//			Collection<Produtoref> listaProdutos = produtoRepository.getAll();
//			for(Produtoref prod : listaProdutos){
//				System.out.println(prod.toString());
//			}


			//caixaRepository.save(caixa);
			/*Collection<Caixa> listaCaixa = caixaRepository.getAll();
			for(Caixa c : listaCaixa){
				System.out.println(c.toString());
			}*/
			//System.out.println(caixaRepository.getOne(21));

			//repository.save(d);
			/*FornecedorRepository.save(f);*/
			//funcionarioRepository.save(func);
			//System.out.println(funcionarioRepository.getOne(21));
			//fornecedorRepository.delete(f);
			//Collection<Fornecedorref> lista = fornecedorRepository.getAll();
			/*for(Fornecedorref fd : lista){
				System.out.println(fd.toString());
			}
			*/
			//System.out.println(fornecedorRepository.getOne(5));
			//repository.getAll();
			//repository.delete(d);
			//caixa.save(new Caixa());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
