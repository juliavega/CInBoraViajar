package interfaces;

import classesBasicas.PacoteViagem;
import erros.PacoteNaoEncontradoException;

public interface RepositorioPacoteViagem {
	public void inserir(PacoteViagem pacoteViagem) throws PacoteNaoEncontradoException;
	public void atualizar(PacoteViagem pacoteViagemAnterior, PacoteViagem pacoteViagemNovo) throws PacoteNaoEncontradoException;
	public void remover(PacoteViagem pacoteViagem) throws PacoteNaoEncontradoException;
	public PacoteViagem procurar(String id) throws PacoteNaoEncontradoException;
}
