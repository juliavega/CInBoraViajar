package interfaces;

import classesBasicas.Destino;
import erros.DestinoJaCadastradoException;
import erros.DestinoNaoEncontradoException;
import erros.LimiteAtingidoException;

public interface RepositorioDestino {
	public void inserir(Destino destino) throws LimiteAtingidoException;
	public void atualizar(Destino destino) throws DestinoNaoEncontradoException;
	public void remover(String cidade) throws DestinoNaoEncontradoException;
	public Destino procurar(String cidade) throws DestinoNaoEncontradoException;
	public boolean existe(String cidade);
}