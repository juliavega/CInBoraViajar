package interfaces;

import classesBasicas.Cliente;
import erros.ClienteNaoEncontradoException;
import erros.LimiteAtingidoException;

public interface RepositorioCliente {
	public void inserir(Cliente cliente) throws LimiteAtingidoException;
	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException;
	public void remover(Cliente cliente) throws ClienteNaoEncontradoException;
	public Cliente procurar(String cpf) throws ClienteNaoEncontradoException;
}