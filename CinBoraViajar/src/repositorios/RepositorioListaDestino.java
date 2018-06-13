package repositorios;

import classesBasicas.Destino;
import erros.DestinoNaoEncontradoException;

public class RepositorioListaDestino {
	private Destino destino;
	private RepositorioListaDestino proximo;

	public RepositorioListaDestino() {
		this.destino = null;
		this.proximo = null;
	}

	public void inserir(Destino destino) {
		if (this.destino == null) {
			this.destino = destino;
			this.proximo = new RepositorioListaDestino();
		} else {
			this.proximo.inserir(destino);
		}
	}

	public void remover(Destino destino) throws DestinoNaoEncontradoException {
		if (this.destino != null) {
			if (this.destino.equals(destino)) {
				this.destino = this.proximo.destino;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(destino);
			}
		} else {
			DestinoNaoEncontradoException e;
			e = new DestinoNaoEncontradoException();
			throw e;
		}
	}

	public void atualizar() {

	}

	public Destino procurar(Destino destino) throws DestinoNaoEncontradoException {
		Destino resposta;
		resposta = null;
		if (this.destino != null) {
			if (this.destino.equals(destino)) {
				resposta = this.destino;
			} else {
				this.proximo.procurar(destino);
			}
		} else {
			DestinoNaoEncontradoException e;
			e = new DestinoNaoEncontradoException();
			throw e;
		}
		return resposta;
	}
}