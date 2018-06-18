package main;

import java.util.Scanner;

import fachada.CInBoraViajar;

public class main {
	public static void main (String [] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Olá, bem vindo a empresa CInBora viajar!");
		System.out.println("Você deseja utilizar nosso sistema em array ou lista? (Digite 0 para array e 1 para lista)");
		
		int repositorio, metodo, cadastra, remove, atualiza, procura;
		String nome, cpf, dataNascimento;
		
		// Escolha do tipo do repositorio
		repositorio = in.nextInt();
		if (repositorio == 0) {
			CInBoraViajar CInBora = new CInBoraViajar(false);
			System.out.println("---- Sistema criado em array ----");
		} else if (repositorio == 1){
			CInBoraViajar CInbora = new CInBoraViajar(true);
			System.out.println("---- Sistema criado em lista ----");
		}
		
		System.out.println("O que você deseja fazer?");
		System.out.println("0 - Cadastrar");
		System.out.println("1 - Remover");
		System.out.println("2 - Atualizar");
		System.out.println("3 - Procurar");
		
		metodo = in.nextInt();
		if (metodo == 0) {
			System.out.println("O que voce deseja cadastrar?");
			System.out.println("0 - Cliente");
			System.out.println("1 - Destino");
			System.out.println("2 - Pacote de viagem");
			System.out.println("3 - Funcionário");
			
			cadastra = in.nextInt();
			
			if (cadastra == 0) {
				System.out.println("Digite o nome:");
				nome = in.nextLine();
				System.out.println("Digite o cpf:");
				cpf = in.nextLine();
				System.out.println("Digite a data de nascimento (no formato xx/xx/xxxx):");
				dataNascimento = in.nextLine();
				
				
			} else if (cadastra == 1){
				
			} else if (cadastra == 2) {
				
			} else if (cadastra == 3) {
				
			}
		} else if (metodo == 1) {
			System.out.println("O que voce deseja remover?");
			System.out.println("0 - Cliente");
			System.out.println("1 - Destino");
			System.out.println("2 - Pacote de viagem");
			System.out.println("3 - Funcionário");
			
			remove = in.nextInt();
		} else if (metodo == 2) {
			System.out.println("O que voce deseja atualizar?");
			System.out.println("0 - Cliente");
			System.out.println("1 - Destino");
			System.out.println("2 - Pacote de viagem");
			System.out.println("3 - Funcionário");
			
			atualiza = in.nextInt();
		} else if (metodo == 3){
			System.out.println("O que voce deseja procurar?");
			System.out.println("0 - Cliente");
			System.out.println("1 - Destino");
			System.out.println("2 - Pacote de viagem");
			System.out.println("3 - Funcionário");
			
			procura = in.nextInt();
		}
		
		/*System.out.println("O que você deseja fazer?");
		System.out.println("0 - Atualizar");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Procurar");
		System.out.println("3 - Remover");
		*/
		metodo = in.nextInt();
	}
}
