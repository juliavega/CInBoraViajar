package repositorios;

import classesBasicas.PacoteViagem;
import erros.PacoteNaoEncontradoException;

public class RepositorioListaPacoteViagem {
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
	
	public void atualizar() {
		
	}
	
	public PacoteViagem procurar(PacoteViagem pacoteViagem) throws PacoteNaoEncontradoException {
		PacoteViagem resposta;
		resposta = null;
		if (this.pacoteViagem != null) {
			if (this.pacoteViagem.equals(pacoteViagem)) {
				resposta = this.pacoteViagem;
			} else {
				this.proximo.procurar(pacoteViagem);
			}
		} else {
			PacoteNaoEncontradoException e;
			e = new PacoteNaoEncontradoException();
			throw e;
		}
		return resposta;
	} 
}