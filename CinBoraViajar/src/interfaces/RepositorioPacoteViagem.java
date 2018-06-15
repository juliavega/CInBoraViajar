package interfaces;

import classesBasicas.PacoteViagem;
import erros.PacoteNaoEncontradoException;
import erros.PacoteViagemJaCadastradoException;

public interface RepositorioPacoteViagem {
	public void inserir(PacoteViagem pacoteViagem) throws PacoteNaoEncontradoException;
	public void atualizar(PacoteViagem pacoteViagem) throws PacoteNaoEncontradoException;
	public void remover(String id) throws PacoteNaoEncontradoException;
	public PacoteViagem procurar(String id) throws PacoteNaoEncontradoException;
	public boolean existe (String id);
}
