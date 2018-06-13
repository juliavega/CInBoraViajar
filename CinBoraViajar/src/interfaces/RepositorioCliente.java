package interfaces;

import classesBasicas.Cliente;
import erros.ClienteNaoEncontradoException;

public interface RepositorioCliente {
	public void inserir(Cliente cliente) throws ClienteNaoEncontradoException;
	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException;
	public void remover(Cliente cliente) throws ClienteNaoEncontradoException;
	public Cliente procurar(String cpf) throws ClienteNaoEncontradoException;
}