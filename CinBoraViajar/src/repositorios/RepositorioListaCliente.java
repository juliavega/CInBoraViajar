package repositorios;
import interfaces.RepositorioCliente;
import classesBasicas.Cliente;
import erros.ClienteNaoEncontradoException;

public class RepositorioListaCliente implements RepositorioCliente {
	private Cliente cliente;
	private RepositorioListaCliente proximo;

	public RepositorioListaCliente() {
		this.cliente = null;
		this.proximo = null;
	}

	public void inserir(Cliente cliente) {
		if (this.cliente == null) {
			this.cliente = cliente;
			this.proximo = new RepositorioListaCliente();
		} else {
			this.proximo.inserir(cliente);
		}
	}

	public void remover(Cliente cliente) throws ClienteNaoEncontradoException {
		if (this.cliente != null) {
			if (this.cliente.equals(cliente)) {
				this.cliente = this.proximo.cliente;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(cliente);
			}
		} else {
			ClienteNaoEncontradoException e;
			e = new ClienteNaoEncontradoException();
			throw e;
		}
	}

	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException{
		Cliente clienteAnterior;
		clienteAnterior = procurar(cliente.getCpf());
		remover(clienteAnterior);
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