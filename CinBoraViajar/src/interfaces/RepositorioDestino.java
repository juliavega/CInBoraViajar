package interfaces;

import classesBasicas.Destino;
import erros.DestinoNaoEncontradoException;

public interface RepositorioDestino {
	public void inserir(Destino destino) throws DestinoNaoEncontradoException;
	public void atualizar(Destino destino) throws DestinoNaoEncontradoException;
	public void remover(String cidade) throws DestinoNaoEncontradoException;
	public Destino procurar(String cidade) throws DestinoNaoEncontradoException;
	public boolean existe(String cidade);
}