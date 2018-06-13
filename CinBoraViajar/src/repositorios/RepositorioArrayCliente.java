// deixar o inserir dinamico
package repositorios;

import classesBasicas.Cliente;
import erros.ClienteNaoEncontradoException;
import erros.LimiteAtingidoException;
import interfaces.RepositorioCliente;

public class RepositorioArrayCliente implements RepositorioCliente{
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
	
	// MUDAR O PROCURAR E O REMOVER PARA O CPF
	public void remover(String cpf) throws ClienteNaoEncontradoException {
		
		
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
		// TODO Auto-generated method stub
		
	}
}
