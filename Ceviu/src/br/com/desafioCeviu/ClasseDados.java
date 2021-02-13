package br.com.desafioCeviu;

import java.util.ArrayList;
import java.util.Scanner;

public class ClasseDados {

	private int inicioCasa;
	private int fimCasa;
	private int pontoArvoreA;
	private int pontoArvoreB;
	private int calculoA;
	private int calculoB;
	private int quantidadeMacaNaCasa = 0;
	private int quantidadeLaranjaNaCasa = 0;

	ClasseDados() {
		super();
	}

	Scanner enter = new Scanner(System.in);

	ArrayList<Integer> distanciasM = new ArrayList<>();
	ArrayList<Integer> distanciasN = new ArrayList<>();

	public void validarDadosInicioCasa() {
		boolean validar = false;
		do {
			System.out.println("Digite o valor do início da casa:");
			inicioCasa = enter.nextInt();
			if (inicioCasa < 1 || inicioCasa > 100000) {
				validar = true;
				System.out.println("valor digitado INVÁLIDO! Digite um número entre 1 e 100.000");
			} else {
				validar = false;
			}
		} while (validar != false);
	}

	public void validarDadosFimCasa() {
		boolean validar = false;
		do {
			System.out.println("Digite o valor do fim da casa:");
			fimCasa = enter.nextInt();
			if (fimCasa < 1 || fimCasa > 100000 || fimCasa < inicioCasa) {
				validar = true;
				System.out.println("valor digitado INVÁLIDO!"
						+ "\nDigite um número entre 1 e 100.000 e maior que valor de inicio da casa");
			} else {
				validar = false;
			}
		} while (validar != false);
	}

	public void validarDadosPontoArvoreA() {
		boolean validar = false;
		do {
			System.out.println("Digite o ponto da árvore A:");
			pontoArvoreA = enter.nextInt();
			if (pontoArvoreA < 1 || pontoArvoreA > 100000 || pontoArvoreA > inicioCasa || pontoArvoreA > fimCasa) {
				validar = true;
				System.out.println("valor digitado INVÁLIDO!"
						+ "\nDigite Digite um número entre 1 e 100.000 e menor que os valores de inicio e fim da Casa");
			} else {
				validar = false;
			}
		} while (validar != false);
	}

	public void validarDadosPontoArvoreB() {
		boolean validar = false;
		do {
			System.out.println("Digite o ponto da árvore B:");
			pontoArvoreB = enter.nextInt();
			if (pontoArvoreB < 1 || pontoArvoreB > 100000 || pontoArvoreB < pontoArvoreA || pontoArvoreB < inicioCasa
					|| pontoArvoreB < fimCasa) {
				validar = true;
				System.out.println("valor digitado INVÁLIDO!"
						+ "\nDigite Digite um número entre 1 e 100.000 e maior que os valores de inicio e fim da Casa e ponto árvore A");
			} else {
				validar = false;
			}
		} while (validar != false);

	}

	public void validarDadosDistanciasM() {
		boolean validar = false;
		do {
			System.out.println("Digite o(s) valor(es) para a distância(s):");
			int valor = enter.nextInt();
			if (valor < -100000 || valor > 100000) {
				validar = true;
				System.out.println("O valor Para distância deve ser maior que -100000 e menor que 100000");
			} else {
				distanciasM.add(valor);
				validar = false;
			}
		} while (validar != false);

	}
	
	public void validarDadosDistanciasN() {
		boolean validar = false;
		do {
			System.out.println("Digite o(s) valor(es) para a distância(s):");
			int valor = enter.nextInt();
			if (valor < -100000 || valor > 100000) {
				validar = true;
				System.out.println("O valor Para distância deve ser maior que -100000 e menor que 100000");
			} else {
				distanciasN.add(valor);
				validar = false;
			}
		} while (validar != false);

	}

	public void receberDistanciasDe_M() {
		boolean validaInicial = false;
		boolean valida = false;
		String menu = "";
		do {
			System.out.println("Digite [s] para inserir valor de distância das Maças ou [n] para sair da operação");
			do {
				menu = enter.next();
				if (!menu.equalsIgnoreCase("s") && !menu.equalsIgnoreCase("n")) {
					validaInicial = true;
					System.out.println("valor digitado INVÁLIDO! ");
					System.out.println(
							"Digite [s] para inserir valor de distância das Maças ou [n] para sair da operação");
				} else {
					validaInicial = false;
				}
			} while (validaInicial != false);

			if (menu.equalsIgnoreCase("s")) {
				valida = true;
				validarDadosDistanciasM();
			} else {
				valida = false;
				System.out.println("Distâncias de M" + distanciasM);
			}

		} while (valida != false);

	}

	public void receberDistanciasDe_N() {
		boolean validaInicial = false;
		boolean validar;
		String menu = "";
		do {
			System.out.println("Digite [s] para inserir valor de distância das Laranjas ou [n] para sair da operação");
			do {
				menu = enter.next();
				if (!menu.equalsIgnoreCase("s") && !menu.equalsIgnoreCase("n")) {
					validaInicial = true;
					System.out.println("valor digitado INVÁLIDO! ");
					System.out.println(
							"Digite [s] para inserir valor de distância das Laranjas ou [n] para sair da operação");
				} else {
					validaInicial = false;
				}
			} while (validaInicial != false);

			if (menu.equalsIgnoreCase("s")) {
				validar = true;
				
				validarDadosDistanciasN();

			} else {
				validar = false;
				System.out.println("Distâncias de N:" + distanciasN);
			}

		} while (validar != false);

	}

	public void calcularQuantidadeNaCasa() {
		for (int valorM : distanciasM) {
			calculoA = pontoArvoreA + valorM;
			if (calculoA >= inicioCasa && calculoA <= fimCasa) {
				quantidadeMacaNaCasa += 1;

			}

		}

		for (int valorN : distanciasN) {
			calculoB = pontoArvoreB + valorN;
			if (calculoB >= inicioCasa && calculoB <= fimCasa) {
				quantidadeLaranjaNaCasa += 1;

			}
		}

		System.out.println("Quantidade de Maça que caíram na Casa:" + quantidadeMacaNaCasa);
		System.out.println("Quantidade de Laranja que caíram na Casa:" + quantidadeLaranjaNaCasa);
	}

	public int getInicioCasa() {
		return inicioCasa;
	}

	public void setInicioCasa(int incicioCasa) {
		this.inicioCasa = incicioCasa;
	}

	public int getFimCasa() {
		return fimCasa;
	}

	public void setFimCasa(int fimCasa) {
		this.fimCasa = fimCasa;
	}

	public int getPontoArvore_A() {
		return pontoArvoreA;
	}

	public void setPontoArvore_A(int pontoArvore_A) {
		this.pontoArvoreA = pontoArvore_A;
	}

	public int getPontoArvore_B() {
		return pontoArvoreB;
	}

	public void setPontoArvore_B(int pontoArvore_B) {
		this.pontoArvoreB = pontoArvore_B;
	}

}
