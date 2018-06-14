// deixar o inserir dinamico
package repositorios;

import classesBasicas.Cliente;
import erros.ClienteNaoEncontradoException;
import erros.LimiteAtingidoException;
import interfaces.RepositorioCliente;

public class RepositorioArrayCliente implements RepositorioCliente {
	private Cliente[] arrayCliente = new Cliente[1000];
	private int contador = 0;

	public void inserir(Cliente cliente) throws LimiteAtingidoException {
		if (this.contador < this.arrayCliente.length) {
			this.arrayCliente[contador] = cliente;
			this.contador++;
		} else {
			LimiteAtingidoException e;
			e = new LimiteAtingidoException();
			throw e;
		}
	}
	
	//Criar variável auxiliar
	public void remover(String cpf) throws ClienteNaoEncontradoException {
		int indice = this.getIndice(cpf);
		for (int i = 0; i < (arrayCliente.length - indice); i++) {
			arrayCliente[indice + 1] = arrayCliente [indice];
			indice++;
		}
	}

	public Cliente procurar(String cpf) throws ClienteNaoEncontradoException {
		Cliente resposta = null;
		boolean jaAchou = false;
		for (int i = 0; i <= this.contador && !jaAchou; i++) {
			if (this.arrayCliente[i].getCpf().equals(cpf)) {
				resposta = this.arrayCliente[i];
				jaAchou = true;
			}
		}

		if (jaAchou) {
			return resposta;
		} else {
			ClienteNaoEncontradoException e;
			e = new ClienteNaoEncontradoException();
			throw e;
		}
	}

	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException {
		int indice = this.getIndice(cliente.getCpf());
		arrayCliente[indice] = cliente;
	}

	public int getIndice(String cpf) throws ClienteNaoEncontradoException {
		int resposta = 0;
		boolean jaAchou = false;
		for (int i = 0; i <= this.contador && !jaAchou; i++) {
			if (this.arrayCliente[i].getCpf().equals(cpf)) {
				resposta = i;
				jaAchou = true;
			}
		}
		if (jaAchou) {
			return resposta;
		} else {
			ClienteNaoEncontradoException e;
			e = new ClienteNaoEncontradoException();
			throw e;
		}
	}
}