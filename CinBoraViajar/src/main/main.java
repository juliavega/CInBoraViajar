package main;

import java.util.Scanner;

import classesBasicas.Cliente;
import classesBasicas.Destino;
import classesBasicas.Funcionario;
import classesBasicas.PacoteViagem;
import erros.ClienteInvalidoException;
import erros.ClienteJaCadastradoException;
import erros.ClienteNaoEncontradoException;
import erros.CpfInvalidoException;
import erros.DataNascimentoInvalidaException;
import erros.DestinoInvalidoException;
import erros.DestinoJaCadastradoException;
import erros.DestinoNaoEncontradoException;
import erros.EmailInvalidoException;
import erros.FuncionarioJaCadastradoException;
import erros.LimiteAtingidoException;
import erros.NomeMuitoLongoException;
import erros.NumeroCartaoInvalidoException;
import erros.PacoteJaCadastradoException;
import erros.SalarioMuitoBaixoException;
import erros.ValorPacoteInvalidoException;
import fachada.CInBoraViajar;

public class main {
	public static void main (String [] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Olá, bem vindo a empresa CInBora viajar!");
		System.out.println("Você deseja utilizar nosso sistema em array ou lista? (Digite 0 para array e 1 para lista)");
		
		int escolha, valor, duracao;
		double salario;
		String nome, cpf, dataNascimento, email, numeroCartao, pais, cidade, hospedagem, id, cargo;
		CInBoraViajar cinbora = null;
		Cliente cliente = null;
		Destino destino = null;
		PacoteViagem pacote;
		Funcionario funcionario;
		// Escolha do tipo do repositorio
		escolha = in.nextInt();
		
		if (escolha == 0) {
			cinbora = new CInBoraViajar(false);
			System.out.println("---- Sistema criado em array ----");
		} else if (escolha == 1){
			cinbora = new CInBoraViajar(true);
			System.out.println("---- Sistema criado em lista ----");
		}
		
		while (escolha >= 0) {
			
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
				in.nextLine();
				
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
						cinbora.cadastrarCliente(cliente); 
					} catch (NomeMuitoLongoException e){
						System.out.println(e.getMessage());
					} catch (CpfInvalidoException e) {
						System.out.println(e.getMessage());
					} catch (DataNascimentoInvalidaException e) {
						System.out.println(e.getMessage());
					} catch (EmailInvalidoException e) {
						System.out.println(e.getMessage());
					} catch (NumeroCartaoInvalidoException e) {
						System.out.println(e.getMessage());
					} catch (ClienteJaCadastradoException e) {
						System.out.println(e.getMessage());
					} catch (LimiteAtingidoException e) {
						System.out.println(e.getMessage());
					}
					
					System.out.println("---- Cliente cadastrado com sucesso ----");
					
				} else if (escolha == 1){
					System.out.println("Digite o país:");
					pais = in.nextLine();
					System.out.println("Digite a cidade:");
					cidade = in.nextLine();
					System.out.println("Digite o tipo da hospedagem:");
					hospedagem = in.nextLine();
					
					try {					
						destino = new Destino(pais, cidade, hospedagem);
						cinbora.cadastrarDestino(destino);
					} catch (DestinoJaCadastradoException e) {
						System.out.println(e.getMessage());
					} catch (LimiteAtingidoException e) {
						System.out.println(e.getMessage());
					}
					
					System.out.println("---- Destino cadastrado com sucesso ----");
					
					//Deixar melhor experiencia de usuário
				} else if (escolha == 2) {
					System.out.println("Digite o cpf do cliente para quem o pacote será feito:");
					cpf = in.nextLine();
					try {
						cliente = cinbora.procurarCliente(cpf);
					} catch (ClienteNaoEncontradoException e){
						System.out.println(e.getMessage());
					} 
					System.out.println("Digite a cidade do pacote:");
					cidade = in.nextLine();
					try {
						destino = cinbora.procurarDestino(cidade);
					}catch (DestinoNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}
					System.out.println("Digite o valor do pacote:");
					valor = in.nextInt();
					in.nextLine();
					System.out.println("Digite o número de meses do pacote:");
					duracao = in.nextInt();
					in.nextLine();
					System.out.println("Digite o identificador do pacote:");
					id = in.nextLine();
					try {
						pacote = new PacoteViagem(cliente, destino, valor, duracao, id);
						cinbora.cadastrarPacote(pacote);
					} catch (ValorPacoteInvalidoException e) {
						System.out.println(e.getMessage());
					} catch (PacoteJaCadastradoException e) {
						System.out.println(e.getMessage());
					} catch (LimiteAtingidoException e) {
						System.out.println(e.getMessage());
					} catch (ClienteInvalidoException e) {
						System.out.println(e.getMessage());
					} catch (DestinoInvalidoException e) {
						System.out.println(e.getMessage());
					}
					
					System.out.println("---- Pacote cadastrado com sucesso ----");
					
				} else if (escolha == 3) {
					System.out.println("Digite o nome do funcionário:");
					nome = in.nextLine();
					System.out.println("Digite o cpf do funcionário:");
					cpf = in.nextLine();
					System.out.println("Digite a data de nascimento (no formato xx/xx/xxxx):");
					dataNascimento = in.nextLine();
					System.out.println("Digite o cargo do funcionário:");
					cargo = in.nextLine();
					System.out.println("Digite o salário do funcionário:");
					salario = in.nextDouble();
					in.nextLine();
					try {
						funcionario = new Funcionario(nome, cpf, dataNascimento, cargo, salario);
						cinbora.cadastrarFuncionario(funcionario);
					} catch (NomeMuitoLongoException e){
						System.out.println(e.getMessage());
					} catch (FuncionarioJaCadastradoException e) {
						System.out.println(e.getMessage());
					} catch (LimiteAtingidoException e) {
						System.out.println(e.getMessage());
					} catch (CpfInvalidoException e) {
						System.out.println(e.getMessage());
					} catch (SalarioMuitoBaixoException e) {
						System.out.println(e.getMessage());
					} catch (DataNascimentoInvalidaException e) {
						System.out.println(e.getMessage());
					}
					
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
}
