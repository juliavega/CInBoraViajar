package fachada;

import cadastro.CadastroCliente;
import cadastro.CadastroDestino;
import cadastro.CadastroFuncionario;
import cadastro.CadastroPacoteViagem;
import classesBasicas.Cliente;
import classesBasicas.Destino;
import classesBasicas.Funcionario;
import classesBasicas.PacoteViagem;
import erros.ClienteInvalidoException;
import erros.ClienteJaCadastradoException;
import erros.ClienteNaoEncontradoException;
import erros.DestinoInvalidoException;
import erros.DestinoJaCadastradoException;
import erros.DestinoNaoEncontradoException;
import erros.FuncionarioJaCadastradoException;
import erros.FuncionarioNaoEncontradoException;
import erros.LimiteAtingidoException;
import erros.PacoteJaCadastradoException;
import erros.PacoteNaoEncontradoException;

public class CInBoraViajar {
	private CadastroCliente clientes;
	private CadastroFuncionario funcionarios;
	private CadastroDestino destinos;
	private CadastroPacoteViagem pacotesViagem;
	
	public CInBoraViajar(boolean tipo) {
		clientes = new CadastroCliente(tipo);
		funcionarios = new CadastroFuncionario(tipo);
		destinos = new CadastroDestino(tipo);
		pacotesViagem = new CadastroPacoteViagem(tipo);		
	}
	
	// Cliente
	public void cadastrarCliente(Cliente cliente) throws LimiteAtingidoException, ClienteJaCadastradoException {
		clientes.cadastrar(cliente);
	}

	public void removerCliente(String cpf) throws ClienteNaoEncontradoException {
		clientes.remover(cpf);
	}

	public void atualizarCliente(Cliente cliente) throws ClienteNaoEncontradoException {
		clientes.atualizar(cliente);
	}

	public Cliente procurarCliente(String cpf) throws ClienteNaoEncontradoException {
		return clientes.procurar(cpf);
	}
	
	//Pacote
	public void cadastrarPacote(PacoteViagem pacote) throws PacoteJaCadastradoException, LimiteAtingidoException,
			DestinoInvalidoException, ClienteInvalidoException {
		Destino d = pacote.getDestino();
		Cliente c = pacote.getCliente();
		
		// Erro de Pacote já existente
		if (destinos.existe(d.getCidade()) && clientes.existe(c.getCpf())) {
			pacotesViagem.cadastrar(pacote);
		} else if (!destinos.existe(d.getCidade())) {
			DestinoInvalidoException e;
			e = new DestinoInvalidoException();
			throw e;
		} else {
			ClienteInvalidoException e;
			e = new ClienteInvalidoException();
			throw e;
		}
	}

	public void removerPacote(String id) throws PacoteNaoEncontradoException {
		pacotesViagem.remover(id);
	}

	public void atualizarPacote(PacoteViagem pacote) throws PacoteNaoEncontradoException, DestinoInvalidoException, ClienteInvalidoException {
		Destino d = pacote.getDestino();
		Cliente c = pacote.getCliente();
		
		// Verificação se o cliente e o pacote existem 
		if (destinos.existe(d.getCidade()) && clientes.existe(c.getCpf())) {
			pacotesViagem.atualizar(pacote);
		} else if (!destinos.existe(d.getCidade())) {
			DestinoInvalidoException e;
			e = new DestinoInvalidoException();
			throw e;
		} else {
			ClienteInvalidoException e;
			e = new ClienteInvalidoException();
			throw e;
		}
	}

	public PacoteViagem procurarPacote(String id) throws PacoteNaoEncontradoException {
		return pacotesViagem.procurar(id);
	}
	
	//Funcionário
	public void cadastrarFuncionario(Funcionario funcionario) throws LimiteAtingidoException, FuncionarioJaCadastradoException {
		funcionarios.cadastrar(funcionario);
	}

	public void removerFuncionario(String cpf) throws FuncionarioNaoEncontradoException {
		funcionarios.remover(cpf);
	}

	public void atualizarFuncionario(Funcionario funcionario)
			throws FuncionarioNaoEncontradoException, FuncionarioJaCadastradoException {
		funcionarios.atualizar(funcionario);
	}

	public Funcionario procurarFuncionario(String cpf) throws FuncionarioNaoEncontradoException {
		return funcionarios.procurar(cpf);
	}
	
	//Destino
	public void cadastrarDestino(Destino destino) throws DestinoJaCadastradoException, LimiteAtingidoException {
		destinos.cadastrar(destino);
	}

	public void removerDestino(String cidade) throws DestinoNaoEncontradoException {
		destinos.remover(cidade);
	}

	public void atualizarDestino(Destino destino) throws DestinoNaoEncontradoException, DestinoJaCadastradoException {
		destinos.atualizar(destino);
	}

	public Destino procurarDestino(String cidade) throws DestinoNaoEncontradoException {
		return destinos.procurar(cidade);
	}

}
