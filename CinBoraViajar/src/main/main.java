package main;

import java.util.Scanner;

import classesBasicas.Cliente;
import classesBasicas.Destino;
import erros.ClienteJaCadastradoException;
import erros.ClienteNaoEncontradoException;
import erros.CpfInvalidoException;
import erros.DataNascimentoInvalidaException;
import erros.EmailInvalidoException;
import erros.LimiteAtingidoException;
import erros.NomeMuitoLongoException;
import erros.NumeroCartaoInvalidoException;
import fachada.CInBoraViajar;

public class main {
	public static void main (String [] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Olá, bem vindo a empresa CInBora viajar!");
		System.out.println("Você deseja utilizar nosso sistema em array ou lista? (Digite 0 para array e 1 para lista)");
		
		int escolha;
		String nome, cpf, dataNascimento, email, numeroCartao, pais, cidade, hospedagem;
		CInBoraViajar cinbora = null;
		Cliente cliente;
		// Escolha do tipo do repositorio
		escolha = in.nextInt();
		
		if (escolha == 0) {
			cinbora = new CInBoraViajar(false);
			System.out.println("---- Sistema criado em array ----");
		} else if (escolha == 1){
			cinbora = new CInBoraViajar(true);
			System.out.println("---- Sistema criado em lista ----");
		}
		escolha = 0;
		System.out.println("O que você deseja fazer?");
		System.out.println("0 - Cadastrar");
		System.out.println("1 - Remover");
		System.out.println("2 - Atualizar");
		System.out.println("3 - Procurar");
		
		escolha = in.nextInt();
		if (escolha == 0) {
			System.out.println("O que voce deseja cadastrar?");
			System.out.println("0 - Cliente");
			System.out.println("1 - Destino");
			System.out.println("2 - Pacote de viagem");
			System.out.println("3 - Funcionário");
			
			escolha = in.nextInt();
			
			if (escolha == 0) {
				System.out.println("Digite o nome:");
				nome = in.nextLine();
				System.out.println("Digite o cpf:");
				cpf = in.nextLine();
				System.out.println("Digite a data de nascimento (no formato xx/xx/xxxx):");
				dataNascimento = in.nextLine();
				System.out.println("Digite o email:");
				email = in.nextLine();
				System.out.println("Digite o numero do cartão com 16 dígitos:");
				numeroCartao = in.nextLine();
				try {					
					cliente = new Cliente(nome, cpf, dataNascimento, email, numeroCartao);
				} catch (NomeMuitoLongoException e){
					System.out.println(e.getMessage());
				} catch (CpfInvalidoException e) {
					System.out.println(e.getMessage());
				} catch (DataNascimentoInvalidaException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("---- Cliente cadastrado com sucesso----");
				escolha = 0;
			} else if (escolha == 1){
				System.out.println("Digite o país:");
				pais = in.nextLine();
				System.out.println("Digite a cidade:");
				cidade = in.nextLine();
				System.out.println("Digite o tipo da hospedagem:");
				hospedagem = in.nextLine();
				
				Destino destino = new Destino(pais, cidade, hospedagem);
				System.out.println("---- Destino cadastrado com sucesso----");
				
				//Deixar melhor experiencia de usuário
			} else if (escolha == 2) {
				System.out.println("Digite o cpf do cliente:");
				cpf = in.nextLine();
				try {
					cliente = cinbora.procurarCliente(cpf);
				} catch (ClienteNaoEncontradoException e){
					System.out.println(e.getMessage());
				} 
				System.out.println("Digite");
				System.out.println("");
				
			} else if (escolha == 3) {
				
			}
		} else if (escolha == 1) {
			System.out.println("O que voce deseja remover?");
			System.out.println("0 - Cliente");
			System.out.println("1 - Destino");
			System.out.println("2 - Pacote de viagem");
			System.out.println("3 - Funcionário");
			
			escolha = in.nextInt();
		} else if (escolha == 2) {
			System.out.println("O que voce deseja atualizar?");
			System.out.println("0 - Cliente");
			System.out.println("1 - Destino");
			System.out.println("2 - Pacote de viagem");
			System.out.println("3 - Funcionário");
			
			escolha = in.nextInt();
		} else if (escolha == 3){
			System.out.println("O que voce deseja procurar?");
			System.out.println("0 - Cliente");
			System.out.println("1 - Destino");
			System.out.println("2 - Pacote de viagem");
			System.out.println("3 - Funcionário");
			
			escolha = in.nextInt();
		}
		
	}
}
