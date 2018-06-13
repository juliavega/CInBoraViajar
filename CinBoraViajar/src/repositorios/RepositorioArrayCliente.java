package repositorios;

import classesBasicas.Cliente;
import erros.ClienteNaoEncontradoException;
import interfaces.RepositorioCliente;

public class RepositorioArrayCliente implements RepositorioCliente{
	Cliente[] arrayCliente = new Cliente[1000];
	
	public void inserir(Cliente clente) {
		
	}

	@Override
	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Cliente cliente) throws ClienteNaoEncontradoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente procurar(String cpf) throws ClienteNaoEncontradoException {
		// TODO Auto-generated method stub
		return null;
	}
}
