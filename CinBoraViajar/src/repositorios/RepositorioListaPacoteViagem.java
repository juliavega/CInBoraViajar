package repositorios;

import classesBasicas.PacoteViagem;
import erros.PacoteNaoEncontradoException;
import interfaces.RepositorioPacoteViagem;
public class RepositorioListaPacoteViagem implements RepositorioPacoteViagem{
	private PacoteViagem pacoteViagem;
	private RepositorioListaPacoteViagem proximo;
	
	public RepositorioListaPacoteViagem() {
		this.pacoteViagem = null;
		this.proximo = null;
	}
	
	public void inserir(PacoteViagem pacoteViagem) {
		if (this.pacoteViagem == null) {
			this.pacoteViagem = pacoteViagem;
			this.proximo = new RepositorioListaPacoteViagem();
		} else {
			this.proximo.inserir(pacoteViagem);
		}
	}
	
	public void remover(PacoteViagem pacoteViagem) throws PacoteNaoEncontradoException {
		if (this.pacoteViagem != null) {
			if (this.pacoteViagem.equals(pacoteViagem)) {
				this.pacoteViagem = this.proximo.pacoteViagem;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(pacoteViagem);
			}
		} else {
			PacoteNaoEncontradoException e;
			e = new PacoteNaoEncontradoException();
			throw e;
		}
	}
	
	public void atualizar(PacoteViagem pacoteViagemAnterior, PacoteViagem pacoteViagemNovo) {
		
	}
	
	public PacoteViagem procurar(String id) throws PacoteNaoEncontradoException {
		PacoteViagem resposta;
		resposta = null;
		if (this.pacoteViagem != null) {
			if (this.pacoteViagem.getId().equals(id)) {
				resposta = this.pacoteViagem;
			} else {
				this.proximo.procurar(id);
			}
		} else {
			PacoteNaoEncontradoException e;
			e = new PacoteNaoEncontradoException();
			throw e;
		}
		return resposta;
	} 
}