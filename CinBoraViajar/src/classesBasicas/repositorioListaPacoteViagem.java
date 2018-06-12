package classesBasicas;

import erros.pacoteNaoEncontradoException;

public class repositorioListaPacoteViagem {
	private PacoteViagem pacoteviagem;
	private repositorioListaPacoteViagem proximo;
	
	public repositorioListaPacoteViagem() {
		this.pacoteviagem = null;
		this.proximo = null;
	}
	
	public void inserir(PacoteViagem pacoteviagem) {
		if (this.pacoteviagem == null) {
			this.pacoteviagem = pacoteviagem;
			this.proximo = new repositorioListaPacoteViagem();
		} else {
			this.proximo.inserir(pacoteviagem);
		}
	}
	
	public void remover(PacoteViagem pacoteviagem) throws pacoteNaoEncontradoException {
		if (this.pacoteviagem != null) {
			if (this.pacoteviagem.equals(pacoteviagem)) {
				this.pacoteviagem = this.proximo.pacoteviagem;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(pacoteviagem);
			}
		} else {
			pacoteNaoEncontradoException e;
			e = new pacoteNaoEncontradoException();
			throw e;
		}
	}
	
	public void atualizar() {
		
	}
	
	public PacoteViagem procurar(PacoteViagem pacoteviagem) throws pacoteNaoEncontradoException {
		PacoteViagem resposta;
		resposta = null;
		if (this.pacoteviagem != null) {
			if (this.pacoteviagem.equals(pacoteviagem)) {
				resposta = this.pacoteviagem;
			} else {
				this.proximo.procurar(pacoteviagem);
			}
		} else {
			pacoteNaoEncontradoException e;
			e = new pacoteNaoEncontradoException();
			throw e;
		}
		return resposta;
	} 
}