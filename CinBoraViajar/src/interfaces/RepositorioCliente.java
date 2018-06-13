package interfaces;

import classesBasicas.Cliente;
import erros.clienteNaoEncontradoException;

public interface RepositorioCliente {

	public void inserir(Cliente cliente) throws clienteNaoEncontradoException;

	public void atualizar(Cliente cliente) throws clienteNaoEncontradoException;

	public void remover(Cliente cliente) throws clienteNaoEncontradoException;

	public Cliente procurar(Cliente cliente) throws clienteNaoEncontradoException;

}