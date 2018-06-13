package interfaces;

import classesBasicas.Destino;
import erros.DestinoNaoEncontradoException;

public interface RepositorioDestino {
	public void inserir(Destino destino) throws DestinoNaoEncontradoException;
	public void atualizar(Destino destino) throws DestinoNaoEncontradoException;
	public void remover(Destino destino) throws DestinoNaoEncontradoException;
	public Destino procurar(Destino destino) throws DestinoNaoEncontradoException;
}
