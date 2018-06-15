package cadastro;

import classesBasicas.Cliente;
import erros.ClienteJaCadastradoException;
import erros.ClienteNaoEncontradoException;
import erros.LimiteAtingidoException;
import interfaces.RepositorioCliente;
import repositorios.RepositorioArrayCliente;
import repositorios.RepositorioListaCliente;

public class CadastroCliente {
	private RepositorioCliente clientes;

	public CadastroCliente(boolean tipo) {
		if (tipo) {
			this.clientes = new RepositorioListaCliente();
		} else {			
			this.clientes = new RepositorioArrayCliente();
		}
	}

	public void cadastrar(Cliente cliente) throws LimiteAtingidoException, ClienteJaCadastradoException {
		this.clientes.inserir(cliente);
	}

	public void remover(String cpf) throws ClienteNaoEncontradoException {
		this.clientes.remover(cpf);
	}

	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException, ClienteJaCadastradoException {
		this.clientes.atualizar(cliente);
	}
	
	public Cliente procurar (String cpf) throws ClienteNaoEncontradoException {
		return this.clientes.procurar(cpf);
	}
}
