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
import erros.FuncionarioNaoEncontradoException;
import erros.LimiteAtingidoException;
import erros.NomeMuitoLongoException;
import erros.NumeroCartaoInvalidoException;
import erros.PacoteJaCadastradoException;
import erros.PacoteNaoEncontradoException;
import erros.SalarioMuitoBaixoException;
import erros.ValorPacoteInvalidoException;
import fachada.CInBoraViajar;

public class main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Olá, bem vindo a empresa CInBora viajar!");
		System.out
				.println("Você deseja utilizar nosso sistema em array ou lista? (Digite 0 para array e 1 para lista)");

		int escolha, valor, duracao;
		double salario;
		String nome = null, cpf, dataNascimento, email, numeroCartao, pais, cidade, hospedagem, id, cargo;
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
		} else if (escolha == 1) {
			cinbora = new CInBoraViajar(true);
			System.out.println("---- Sistema criado em lista ----");
		}

		while (escolha >= 0) {

			System.out.println("O que você deseja fazer?");
			System.out.println("0 - Cadastrar");
			System.out.println("1 - Remover");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Procurar");
			System.out.println("(Para encerrar o sistema digite -1)");

			escolha = in.nextInt();
			if (escolha == 0) {
				System.out.println("O que voce deseja cadastrar?");
				System.out.println("0 - Cliente");
				System.out.println("1 - Destino");
				System.out.println("2 - Pacote de viagem");
				System.out.println("3 - Funcionário");
				System.out.println("4 - Voltar para o início");
				
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
						System.out.println("---- Cliente cadastrado com sucesso ----");
					} catch (NomeMuitoLongoException e) {
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

				} else if (escolha == 1) {
					System.out.println("Digite o país:");
					pais = in.nextLine();
					System.out.println("Digite a cidade:");
					cidade = in.nextLine();
					System.out.println("Digite o tipo da hospedagem:");
					hospedagem = in.nextLine();

					try {
						destino = new Destino(pais, cidade, hospedagem);
						cinbora.cadastrarDestino(destino);
						System.out.println("---- Destino cadastrado com sucesso ----");
					} catch (DestinoJaCadastradoException e) {
						System.out.println(e.getMessage());
					} catch (LimiteAtingidoException e) {
						System.out.println(e.getMessage());
					}

				} else if (escolha == 2) {
					System.out.println("Digite o cpf do cliente para quem o pacote será feito:");
					
					cpf = in.nextLine();
					try {
						cliente = cinbora.procurarCliente(cpf);
					} catch (ClienteNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}
					
					System.out.println("Digite a cidade do pacote:");
					cidade = in.nextLine();
					try {
						destino = cinbora.procurarDestino(cidade);
					} catch (DestinoNaoEncontradoException e) {
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
						System.out.println("---- Pacote cadastrado com sucesso ----");
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
						System.out.println("---- Funcionário cadastrado com sucesso ----");
					} catch (NomeMuitoLongoException e) {
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
				System.out.println("4 - Voltar para o início");

				escolha = in.nextInt();
				in.nextLine();

				if (escolha == 0) {
					System.out.println("Digite o cpf do cliente que vai ser removido:");
					cpf = in.nextLine();
					try {
						nome = cinbora.procurarCliente(cpf).getNome();
						cinbora.removerCliente(cpf);
						System.out.println("---- Cliente " + nome + " removido com sucesso ----");
					} catch (ClienteNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}
				} else if (escolha == 1) {
					System.out.println("Digite a cidade que vai ser removida:");
					cidade = in.nextLine();
					try {
						cinbora.removerDestino(cidade);
						System.out.println("---- Destino " + cidade + " removido com sucesso ----");
					} catch (DestinoNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}

				} else if (escolha == 2) {
					System.out.println("Digite o identificador do pacote que vai ser removido:");
					id = in.nextLine();
					try {
						cinbora.removerPacote(id);
						System.out.println("---- Pacote " + id + " removido com sucesso ----");
					} catch (PacoteNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}

				} else if (escolha == 3) {
					System.out.println("Digite o cpf do funcionário que vai ser removido:");
					cpf = in.nextLine();
					try {
						nome = cinbora.procurarFuncionario(cpf).getNome();
						cinbora.removerFuncionario(cpf);
						System.out.println("---- Funcionario " + nome + " removido com sucesso ----");
					} catch (FuncionarioNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}

				}

			} else if (escolha == 2) {
				System.out.println("O que voce deseja atualizar?");
				System.out.println("0 - Cliente");
				System.out.println("1 - Destino");
				System.out.println("2 - Pacote de viagem");
				System.out.println("3 - Funcionário");
				System.out.println("4 - Voltar para o início");
				
				escolha = in.nextInt();
				in.nextLine();

				if (escolha == 0) {
					System.out.println("Digite o nome do cliente:");
					nome = in.nextLine();
					System.out.println("Digite o cpf do cliente:");
					cpf = in.nextLine();
					System.out.println("Digite a data de nascimento do cliente (no formato xx/xx/xxxx):");
					dataNascimento = in.nextLine();
					System.out.println("Digite o email:");
					email = in.nextLine();
					System.out.println("Digite o numero do cartão com 16 dígitos:");
					numeroCartao = in.nextLine();
					try {
						cliente = new Cliente(nome, cpf, dataNascimento, email, numeroCartao);
						cinbora.atualizarCliente(cliente);
						System.out.println("---- Cliente " + nome + " atualizado com sucesso ----");
					} catch (NomeMuitoLongoException e) {
						System.out.println(e.getMessage());
					} catch (CpfInvalidoException e) {
						System.out.println(e.getMessage());
					} catch (DataNascimentoInvalidaException e) {
						System.out.println(e.getMessage());
					} catch (EmailInvalidoException e) {
						System.out.println(e.getMessage());
					} catch (NumeroCartaoInvalidoException e) {
						System.out.println(e.getMessage());
					} catch (ClienteNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}
				} else if (escolha == 1) {
					System.out.println("Digite o país:");
					pais = in.nextLine();
					System.out.println("Digite a cidade:");
					cidade = in.nextLine();
					System.out.println("Digite o tipo da hospedagem:");
					hospedagem = in.nextLine();

					try {
						destino = new Destino(pais, cidade, hospedagem);
						cinbora.atualizarDestino(destino);
						System.out.println("---- Destino " + cidade + " atualizado com sucesso ----");
					} catch (DestinoJaCadastradoException e) {
						System.out.println(e.getMessage());
					} catch (DestinoNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}
				} else if (escolha == 2) {
					
					System.out.println("Digite o cpf do cliente que possui o pacote a ser atualizado:");
					cpf = in.nextLine();
					try {
						cliente = cinbora.procurarCliente(cpf);
					} catch (ClienteNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}
					System.out.println("Digite a cidade do pacote:");
					cidade = in.nextLine();
					try {
						destino = cinbora.procurarDestino(cidade);
					} catch (DestinoNaoEncontradoException e) {
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
						cinbora.atualizarPacote(pacote);
						System.out.println("---- Pacote "+ id + " atualizado com sucesso ----");
					} catch (ValorPacoteInvalidoException e) {
						System.out.println(e.getMessage());
					} catch (PacoteNaoEncontradoException e) {
						System.out.println(e.getMessage());
					} catch (ClienteInvalidoException e) {
						System.out.println(e.getMessage());
					} catch (DestinoInvalidoException e) {
						System.out.println(e.getMessage());
					}
					
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
						cinbora.atualizarFuncionario(funcionario);
						System.out.println("---- Funcionário "+ nome+ "atualizado com sucesso ----");
					} catch (NomeMuitoLongoException e) {
						System.out.println(e.getMessage());
					} catch (FuncionarioJaCadastradoException e) {
						System.out.println(e.getMessage());
					}  catch (CpfInvalidoException e) {
						System.out.println(e.getMessage());
					} catch (SalarioMuitoBaixoException e) {
						System.out.println(e.getMessage());
					} catch (DataNascimentoInvalidaException e) {
						System.out.println(e.getMessage());
					} catch (FuncionarioNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}
				}
				
			} else if (escolha == 3) {
				System.out.println("O que voce deseja procurar?");
				System.out.println("0 - Cliente");
				System.out.println("1 - Destino");
				System.out.println("2 - Pacote de viagem");
				System.out.println("3 - Funcionário");
				System.out.println("4 - Voltar para o início");

				escolha = in.nextInt();
				in.nextLine();
				if (escolha == 0) {
					System.out.println("Digite o cpf do cliente que você deseja procurar:");
					cpf = in.nextLine();
					try {
						System.out.println("O nome do cliente é: " + cinbora.procurarCliente(cpf).getNome());
						System.out.println("A data de nascimento é: " + cinbora.procurarCliente(cpf).getDataNascimento());
						System.out.println("O email é: " + cinbora.procurarCliente(cpf).getEmail());
						System.out.println("O número do cartão é: " + cinbora.procurarCliente(cpf).getNumeroCartao());
					} catch (ClienteNaoEncontradoException e){
						System.out.println(e.getMessage());
					}
				} else if (escolha == 1) {
					System.out.println("Digite a cidade do destino que você quer encontrar:");
					cidade = in.nextLine();
					try {
						System.out.println("O país do destino é: " + cinbora.procurarDestino(cidade).getPais());
						System.out.println("A cidade do destino é: " + cinbora.procurarDestino(cidade).getCidade());
						System.out.println("O tipo de hospedagem do destino é: " + cinbora.procurarDestino(cidade).getHospedagem());
					} catch (DestinoNaoEncontradoException e){
						System.out.println(e.getMessage());
					}
				} else if (escolha == 2) {
					System.out.println("Digite o identificador do pacote que você quer procurar:");
					id = in.nextLine();
					try {
						System.out.println("O cliente que possui o pacote é: " + cinbora.procurarCliente(cinbora.procurarPacote(id).getCliente().getCpf()).getNome());	
						System.out.println("O destino do pacote é: " + cinbora.procurarDestino(cinbora.procurarPacote(id).getDestino().getCidade()).getCidade());
						System.out.println("O valor do pacote é: " + cinbora.procurarPacote(id).getValor() + " reais");
						System.out.println("A duração do pacote é: " + cinbora.procurarPacote(id).getDuracao() + " meses");
					} catch (PacoteNaoEncontradoException e){
						System.out.println(e.getMessage());
					} catch (ClienteNaoEncontradoException e) {
						System.out.println(e.getMessage());
					} catch (DestinoNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}
				} else if (escolha == 3) {
					System.out.println("Digite o cpf do funcionário que você deseja procurar:");
					cpf = in.nextLine();
					try {
						System.out.println("O nome do funcionário é: " + cinbora.procurarFuncionario(cpf).getNome());
						System.out.println("A data de nascimento é: " + cinbora.procurarFuncionario(cpf).getDataNascimento());
						System.out.println("O cargo é: " + cinbora.procurarFuncionario(cpf).getCargo());
						System.out.println("O salário é: " + cinbora.procurarFuncionario(cpf).getSalario() + " reais");
					} catch (FuncionarioNaoEncontradoException e){
						System.out.println(e.getMessage());
					}
				}
			}
		}
		System.out.println("---- Sistema encerrado ----");
	}
}
