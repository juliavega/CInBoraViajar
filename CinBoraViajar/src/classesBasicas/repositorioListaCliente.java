package classesBasicas;

import erros.clienteNaoEncontradoException;

public class repositorioListaCliente {
	private Cliente cliente;
	private repositorioListaCliente proximo;

	public repositorioListaCliente() {
		this.cliente = null;
		this.proximo = null;
	}

	public void inserir(Cliente cliente) {
		if (this.cliente == null) {
			this.cliente = cliente;
			this.proximo = new repositorioListaCliente();
		} else {
			this.proximo.inserir(cliente);
		}
	}

	public void remover(Cliente cliente) throws clienteNaoEncontradoException {
		if (this.cliente != null) {
			if (this.cliente.equals(cliente)) {
				this.cliente = this.proximo.cliente;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(cliente);
			}
		} else {
			clienteNaoEncontradoException e;
			e = new clienteNaoEncontradoException();
			throw e;
		}
	}
	
	public void atualizar() {
		
	}
	
	public Cliente procurar(Cliente cliente) throws clienteNaoEncontradoException{
		Cliente resposta;
		resposta = null;
		if (this.cliente != null) {			
			if (this.cliente.equals(cliente)) {
				resposta = this.cliente;
			} else {
				this.proximo.procurar(cliente);
			}
		} else {
			clienteNaoEncontradoException e;
			e = new clienteNaoEncontradoException();
			throw e;
		}
		return resposta;
	}

}
