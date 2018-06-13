package interfaces;

import classesBasicas.PacoteViagem;
import erros.PacoteNaoEncontradoException;

public interface RepositorioPacoteViagem {
	public void inserir(PacoteViagem pacoteViagem) throws PacoteNaoEncontradoException;
	public void atualizar(PacoteViagem pacoteViagem) throws PacoteNaoEncontradoException;
	public void remover(PacoteViagem pacoteViagem) throws PacoteNaoEncontradoException;
	public PacoteViagem procurar(PacoteViagem pacoteViagem) throws PacoteNaoEncontradoException;
}
