package classesBasicas;

import erros.pacoteNaoEncontradoException;

public class repositorioListaPacoteViagem {
	private PacoteViagem pacoteViagem;
	private repositorioListaPacoteViagem proximo;
	
	public repositorioListaPacoteViagem() {
		this.pacoteViagem = null;
		this.proximo = null;
	}
	
	public void inserir(PacoteViagem pacoteViagem) {
		if (this.pacoteViagem == null) {
			this.pacoteViagem = pacoteViagem;
			this.proximo = new repositorioListaPacoteViagem();
		} else {
			this.proximo.inserir(pacoteViagem);
		}
	}
	
	public void remover(PacoteViagem pacoteViagem) throws pacoteNaoEncontradoException {
		if (this.pacoteViagem != null) {
			if (this.pacoteViagem.equals(pacoteViagem)) {
				this.pacoteViagem = this.proximo.pacoteViagem;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(pacoteViagem);
			}
		} else {
			pacoteNaoEncontradoException e;
			e = new pacoteNaoEncontradoException();
			throw e;
		}
	}
	
	public void atualizar() {
		
	}
	
	public PacoteViagem procurar(PacoteViagem pacoteViagem) throws pacoteNaoEncontradoException {
		PacoteViagem resposta;
		resposta = null;
		if (this.pacoteViagem != null) {
			if (this.pacoteViagem.equals(pacoteViagem)) {
				resposta = this.pacoteViagem;
			} else {
				this.proximo.procurar(pacoteViagem);
			}
		} else {
			pacoteNaoEncontradoException e;
			e = new pacoteNaoEncontradoException();
			throw e;
		}
		return resposta;
	} 
}