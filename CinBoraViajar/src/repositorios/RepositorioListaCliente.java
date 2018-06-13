package repositorios;
import interfaces.RepositorioCliente;
import classesBasicas.Cliente;
import erros.ClienteJaCadastradoException;
import erros.ClienteNaoEncontradoException;

public class RepositorioListaCliente implements RepositorioCliente {
	private Cliente cliente;
	private RepositorioListaCliente proximo;

	public RepositorioListaCliente() {
		this.cliente = null;
		this.proximo = null;
	}

	public void inserir(Cliente cliente) throws ClienteJaCadastradoException {
		
		if (this.cliente == null) {
			this.cliente = cliente;
			this.proximo = new RepositorioListaCliente();
		} else {
			this.proximo.inserir(cliente);
		}
	}

	public void remover(String cpf) throws ClienteNaoEncontradoException {
		Cliente clienteAchado;
		clienteAchado = this.procurar(cpf);
		
		if (this.cliente != null) {
			if (this.cliente.equals(clienteAchado)) {
				this.cliente = this.proximo.cliente;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(cpf);
			}
		} else {
			ClienteNaoEncontradoException e;
			e = new ClienteNaoEncontradoException();
			throw e;
		}
	}

	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException, ClienteJaCadastradoException{
		Cliente clienteAnterior;
		clienteAnterior = procurar(cliente.getCpf());
		remover(clienteAnterior.getCpf());
		inserir(cliente);
	}

	public Cliente procurar(String cpf) throws ClienteNaoEncontradoException {
		Cliente resposta;
		resposta = null;
		if (this.cliente != null) {
			if (this.cliente.getCpf().equals(cpf)) {
				resposta = this.cliente;
			} else {
				this.proximo.procurar(cpf);
			}
		} else {
			ClienteNaoEncontradoException e;
			e = new ClienteNaoEncontradoException();
			throw e;
		}
		return resposta;
	}

}