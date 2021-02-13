package br.com.desafioCeviu;

public class ClasseMain {

	public static void main(String[] args) {

		ClasseDados dados = new ClasseDados();

		System.out.println("========== DESAFIO CEVIU ==========" + " \n");
		System.out.println(" ENTRANDA DOS DADOS INICIAIS:");
		System.out.println("------------------------------");
		dados.validarDadosInicioCasa();
		dados.validarDadosFimCasa();
		dados.validarDadosPontoArvoreA();
		dados.validarDadosPontoArvoreB();
		System.out.println("\n ENTRANDA DOS DADOS PARA AS DISTÂNCIAS DAS MAÇA:");
		System.out.println("-------------------------------------------------------");
		dados.receberDistanciasDe_M();
		System.out.println("\n ENTRANDA DOS DADOS PARA AS DISTÂNCIAS DAS LARANJAS:");
		System.out.println("-------------------------------------------------------");
		dados.receberDistanciasDe_N();
		System.out.println(" \n RESULTADO:");
		System.out.println("-----------");
		dados.calcularQuantidadeNaCasa();

	}

}
