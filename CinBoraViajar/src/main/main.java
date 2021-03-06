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

		System.out.println("Ol�, bem vindo a empresa CInBora viajar!");
		System.out
				.println("Voc� deseja utilizar nosso sistema em array ou lista? (Digite 0 para array e 1 para lista)");

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
		
		
		//Loop do programa
		while (escolha >= 0) {

			System.out.println("O que voc� deseja fazer?");
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
				System.out.println("3 - Funcion�rio");
				System.out.println("4 - Voltar para o in�cio");
				
				escolha = in.nextInt();
				in.nextLine();

				if (escolha == 0) {
					System.out.println("Digite o nome:");
					nome = in.nextLine();
					System.out.println("Digite o cpf (somente os d�gitos):");
					cpf = in.nextLine();
					System.out.println("Digite a data de nascimento (no formato xx/xx/xxxx):");
					dataNascimento = in.nextLine();
					System.out.println("Digite o email:");
					email = in.nextLine();
					System.out.println("Digite o numero do cart�o com 16 d�gitos:");
					numeroCartao = in.nextLine();
					
					// Tenta cadastrar conferindo se todos os parametros est�o certos
					try {
						cliente = new Cliente(nome, cpf, dataNascimento, email, numeroCartao);
						cinbora.cadastrarCliente(cliente);
						System.out.println("---- Cliente cadastrado com sucesso ----");
						
					// Caso n�o estejam, estes erros poder�o ser lan�ados
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
					System.out.println("Digite o pa�s:");
					pais = in.nextLine();
					System.out.println("Digite a cidade:");
					cidade = in.nextLine();
					System.out.println("Digite o tipo da hospedagem:");
					hospedagem = in.nextLine();

					// Tenta cadastrar conferindo se todos os parametros est�o certos
					try {
						destino = new Destino(pais, cidade, hospedagem);
						cinbora.cadastrarDestino(destino);
						System.out.println("---- Destino cadastrado com sucesso ----");
						
					// Caso n�o estejam, estes erros poder�o ser lan�ados
					} catch (DestinoJaCadastradoException e) {
						System.out.println(e.getMessage());
					} catch (LimiteAtingidoException e) {
						System.out.println(e.getMessage());
					}

				} else if (escolha == 2) {
					System.out.println("Digite o cpf do cliente para quem o pacote ser� feito:");
					
					cpf = in.nextLine();
					boolean clienteOk = false;
					boolean destinoOk = false;
					
					// Confere se o cliente est� cadastrado
					try {
						cliente = cinbora.procurarCliente(cpf);
						clienteOk = true;
					} catch (ClienteNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}
					
					System.out.println("Digite a cidade do pacote:");
					cidade = in.nextLine();
					
					// Confere se o destino est� cadastrado
					try {
						destino = cinbora.procurarDestino(cidade);
						destinoOk = true;
					} catch (DestinoNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}
					
					System.out.println("Digite o valor do pacote:");
					valor = in.nextInt();
					in.nextLine();
					
					System.out.println("Digite o n�mero de meses do pacote:");
					duracao = in.nextInt();
					in.nextLine();
					
					System.out.println("Digite o identificador do pacote:");
					id = in.nextLine();
					
					// S� continua se o cliente e o destino estiverem corretos (j� cadastrados)
					if (clienteOk && destinoOk) {
						// Tenta cadastrar conferindo se todos os parametros est�o certos
						try {
							pacote = new PacoteViagem(cliente, destino, valor, duracao, id);
							cinbora.cadastrarPacote(pacote);
							System.out.println("---- Pacote cadastrado com sucesso ----");
						
						// Caso n�o estejam, estes erros poder�o ser lan�ados
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
					} else if (!clienteOk) {
						System.out.println("Cliente nao encontrado");
					} else if (!destinoOk) {
						System.out.println("Destino nao encontrado");
					}

				} else if (escolha == 3) {
					System.out.println("Digite o nome do funcion�rio:");
					nome = in.nextLine();
					System.out.println("Digite o cpf do funcion�rio (somente os d�gitos):");
					cpf = in.nextLine();
					System.out.println("Digite a data de nascimento (no formato xx/xx/xxxx):");
					dataNascimento = in.nextLine();
					System.out.println("Digite o cargo do funcion�rio:");
					cargo = in.nextLine();
					System.out.println("Digite o sal�rio do funcion�rio:");
					salario = in.nextDouble();
					in.nextLine();

					// Tenta cadastrar conferindo se todos os parametros est�o certos
					try {
						funcionario = new Funcionario(nome, cpf, dataNascimento, cargo, salario);
						cinbora.cadastrarFuncionario(funcionario);
						System.out.println("---- Funcion�rio cadastrado com sucesso ----");
						
					// Caso n�o estejam, estes erros poder�o ser lan�ados
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
				System.out.println("3 - Funcion�rio");
				System.out.println("4 - Voltar para o in�cio");

				escolha = in.nextInt();
				in.nextLine();

				if (escolha == 0) {
					System.out.println("Digite o cpf do cliente que vai ser removido:");
					cpf = in.nextLine();
					
					// Confere se existe para remover e procura o nome para dizer quem removeu 
					try {
						nome = cinbora.procurarCliente(cpf).getNome();
						cinbora.removerCliente(cpf);
						System.out.println("---- Cliente " + nome + " removido com sucesso ----");
						
					// Caso n�o exista, manda este erro
					} catch (ClienteNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}
				} else if (escolha == 1) {
					System.out.println("Digite a cidade que vai ser removida:");
					cidade = in.nextLine();
					
					// Confere se o destino existe para remover
					try {
						cinbora.removerDestino(cidade);
						System.out.println("---- Destino " + cidade + " removido com sucesso ----");
						
					// Caso n�o, manda este erro
					} catch (DestinoNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}

				} else if (escolha == 2) {
					System.out.println("Digite o identificador do pacote que vai ser removido:");
					id = in.nextLine();
					
					// Confere se o pacote existe para remover
					try {
						cinbora.removerPacote(id);
						System.out.println("---- Pacote " + id + " removido com sucesso ----");
					// Caso n�o exista, manda esse erro
					} catch (PacoteNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}

				} else if (escolha == 3) {
					System.out.println("Digite o cpf do funcion�rio que vai ser removido:");
					cpf = in.nextLine();
					
					// Confere se existe para remover e procura o nome para dizer quem removeu
					try {
						nome = cinbora.procurarFuncionario(cpf).getNome();
						cinbora.removerFuncionario(cpf);
						System.out.println("---- Funcionario " + nome + " removido com sucesso ----");
					
					// Caso n�o exista, manda este erro
					} catch (FuncionarioNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}

				}

			} else if (escolha == 2) {
				System.out.println("O que voce deseja atualizar?");
				System.out.println("0 - Cliente");
				System.out.println("1 - Destino");
				System.out.println("2 - Pacote de viagem");
				System.out.println("3 - Funcion�rio");
				System.out.println("4 - Voltar para o in�cio");
				
				escolha = in.nextInt();
				in.nextLine();

				if (escolha == 0) {
					System.out.println("Digite o nome do cliente:");
					nome = in.nextLine();
					System.out.println("Digite o cpf do cliente (somente os d�gitos):");
					cpf = in.nextLine();
					System.out.println("Digite a data de nascimento do cliente (no formato xx/xx/xxxx):");
					dataNascimento = in.nextLine();
					System.out.println("Digite o email:");
					email = in.nextLine();
					System.out.println("Digite o numero do cart�o com 16 d�gitos:");
					numeroCartao = in.nextLine();
					
					// Confere se os dados est�o corretos e se o cliente existe
					try {
						cliente = new Cliente(nome, cpf, dataNascimento, email, numeroCartao);
						cinbora.atualizarCliente(cliente);
						System.out.println("---- Cliente " + nome + " atualizado com sucesso ----");
						
					// Caso n�o, pode mandar estes erros
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
					System.out.println("Digite o pa�s:");
					pais = in.nextLine();
					System.out.println("Digite a cidade:");
					cidade = in.nextLine();
					System.out.println("Digite o tipo da hospedagem:");
					hospedagem = in.nextLine();

					// Confere se os dados est�o corretos e se o destino existe
					try {
						destino = new Destino(pais, cidade, hospedagem);
						cinbora.atualizarDestino(destino);
						System.out.println("---- Destino " + cidade + " atualizado com sucesso ----");
						
					// Caso n�o, pode mandar estes erros
					} catch (DestinoJaCadastradoException e) {
						System.out.println(e.getMessage());
					} catch (DestinoNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}
				} else if (escolha == 2) {
					System.out.println("Digite o cpf do cliente que possui o pacote a ser atualizado:");
					
					cpf = in.nextLine();
					boolean clienteOk = false;
					boolean destinoOk = false;	
					
					// Confere se o cliente est� cadastrado
					try {
						cliente = cinbora.procurarCliente(cpf);
						clienteOk = true;
					} catch (ClienteNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}
					System.out.println("Digite a cidade do pacote:");
					cidade = in.nextLine();
					
					// Confere se o destino est� cadastrado
					try {
						destino = cinbora.procurarDestino(cidade);
						destinoOk = true;
					} catch (DestinoNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}
					System.out.println("Digite o valor do pacote:");
					valor = in.nextInt();
					in.nextLine();
					System.out.println("Digite o n�mero de meses do pacote:");
					duracao = in.nextInt();
					in.nextLine();
					System.out.println("Digite o identificador do pacote:");
					id = in.nextLine();
					if (clienteOk && destinoOk) {
						
						// Confere se os dados est�o corretos e se o pacote realmente existe
						try {
							pacote = new PacoteViagem(cliente, destino, valor, duracao, id);
							cinbora.atualizarPacote(pacote);
							System.out.println("---- Pacote "+ id + " atualizado com sucesso ----");
							
						// Caso n�o, pode mandar estes erros
						} catch (ValorPacoteInvalidoException e) {
							System.out.println(e.getMessage());
						} catch (PacoteNaoEncontradoException e) {
							System.out.println(e.getMessage());
						} catch (ClienteInvalidoException e) {
							System.out.println(e.getMessage());
						} catch (DestinoInvalidoException e) {
							System.out.println(e.getMessage());
						}
					} else if (!clienteOk) {
						System.out.println("Cliente nao encontrado");
					} else if (!destinoOk) {
						System.out.println("Destino nao encontrado");
					}
					
				} else if (escolha == 3) {
					System.out.println("Digite o nome do funcion�rio:");
					nome = in.nextLine();
					System.out.println("Digite o cpf do funcion�rio (somente os d�gitos):");
					cpf = in.nextLine();
					System.out.println("Digite a data de nascimento (no formato xx/xx/xxxx):");
					dataNascimento = in.nextLine();
					System.out.println("Digite o cargo do funcion�rio:");
					cargo = in.nextLine();
					System.out.println("Digite o sal�rio do funcion�rio:");
					salario = in.nextDouble();
					in.nextLine();
					
					// Confere se os dados est�o corretos e se existe o funcionario
					try {
						funcionario = new Funcionario(nome, cpf, dataNascimento, cargo, salario);
						cinbora.atualizarFuncionario(funcionario);
						System.out.println("---- Funcion�rio "+ nome+ " atualizado com sucesso ----");
					
					// Caso n�o, pode mandar estes erros
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
				System.out.println("3 - Funcion�rio");
				System.out.println("4 - Voltar para o in�cio");

				escolha = in.nextInt();
				in.nextLine();
				if (escolha == 0) {
					System.out.println("Digite o cpf do cliente que voc� deseja procurar:");
					cpf = in.nextLine();
					
					// Procura se existe e informa todos as vari�veis de cliente
					try {
						System.out.println("O nome do cliente �: " + cinbora.procurarCliente(cpf).getNome());
						System.out.println("A data de nascimento �: " + cinbora.procurarCliente(cpf).getDataNascimento());
						System.out.println("O email �: " + cinbora.procurarCliente(cpf).getEmail());
						System.out.println("O n�mero do cart�o �: " + cinbora.procurarCliente(cpf).getNumeroCartao());
						
					// Caso n�o exista, manda este erro
					} catch (ClienteNaoEncontradoException e){
						System.out.println(e.getMessage());
					}
				} else if (escolha == 1) {
					System.out.println("Digite a cidade do destino que voc� quer encontrar:");
					cidade = in.nextLine();
					
					// Procura se existe e informa todos as vari�veis de destino
					try {
						System.out.println("O pa�s do destino �: " + cinbora.procurarDestino(cidade).getPais());
						System.out.println("A cidade do destino �: " + cinbora.procurarDestino(cidade).getCidade());
						System.out.println("O tipo de hospedagem do destino �: " + cinbora.procurarDestino(cidade).getHospedagem());
						
					// Caso n�o exista, manda este erro
					} catch (DestinoNaoEncontradoException e){
						System.out.println(e.getMessage());
					}
				} else if (escolha == 2) {
					System.out.println("Digite o identificador do pacote que voc� quer procurar:");
					id = in.nextLine();
					
					// Procura se existe e informa todos as vari�veis de cliente
					try {
						System.out.println("O cliente que possui o pacote �: " + cinbora.procurarCliente(cinbora.procurarPacote(id).getCliente().getCpf()).getNome());	
						System.out.println("O destino do pacote �: " + cinbora.procurarDestino(cinbora.procurarPacote(id).getDestino().getCidade()).getCidade());
						System.out.println("O valor do pacote �: " + cinbora.procurarPacote(id).getValor() + " reais");
						System.out.println("A dura��o do pacote �: " + cinbora.procurarPacote(id).getDuracao() + " meses");
					
					// Caso algum dos parametros n�o exista, poder� mandar estes erros
					} catch (PacoteNaoEncontradoException e){
						System.out.println(e.getMessage());
					} catch (ClienteNaoEncontradoException e) {
						System.out.println(e.getMessage());
					} catch (DestinoNaoEncontradoException e) {
						System.out.println(e.getMessage());
					}
				} else if (escolha == 3) {
					System.out.println("Digite o cpf do funcion�rio que voc� deseja procurar:");
					cpf = in.nextLine();
					
					// Procura se existe e informa todos as vari�veis de cliente
					try {
						System.out.println("O nome do funcion�rio �: " + cinbora.procurarFuncionario(cpf).getNome());
						System.out.println("A data de nascimento �: " + cinbora.procurarFuncionario(cpf).getDataNascimento());
						System.out.println("O cargo �: " + cinbora.procurarFuncionario(cpf).getCargo());
						System.out.println("O sal�rio �: " + cinbora.procurarFuncionario(cpf).getSalario() + " reais");
						
					// Caso n�o exista, manda esse erro
					} catch (FuncionarioNaoEncontradoException e){
						System.out.println(e.getMessage());
					}
				}
			}
		}
		System.out.println("---- Sistema encerrado ----");
	}
}
