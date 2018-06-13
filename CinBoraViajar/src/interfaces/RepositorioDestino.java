package interfaces;

import classesBasicas.Destino;
import erros.DestinoNaoEncontradoException;

public interface RepositorioDestino {
	public void inserir(Destino destino) throws DestinoNaoEncontradoException;
	public void atualizar(Destino destinoAnterior, Destino destinoNovo) throws DestinoNaoEncontradoException;
	public void remover(Destino destino) throws DestinoNaoEncontradoException;
	public Destino procurar(String cidade) throws DestinoNaoEncontradoException;
}
