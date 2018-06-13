package repositorios;

import classesBasicas.PacoteViagem;
import erros.PacoteNaoEncontradoException;
import erros.PacoteViagemJaCadastradoException;
import interfaces.RepositorioPacoteViagem;

public class RepositorioListaPacoteViagem implements RepositorioPacoteViagem {
	private PacoteViagem pacoteViagem;
	private RepositorioListaPacoteViagem proximo;

	public RepositorioListaPacoteViagem() {
		this.pacoteViagem = null;
		this.proximo = null;
	}

	public void inserir(PacoteViagem pacoteViagem) throws PacoteViagemJaCadastradoException {
		if (this.pacoteViagem == null) {
			this.pacoteViagem = pacoteViagem;
			this.proximo = new RepositorioListaPacoteViagem();
		} else {
			if (this.pacoteViagem.equals(pacoteViagem)) {
				PacoteViagemJaCadastradoException e;
				e = new PacoteViagemJaCadastradoException();
				throw e;
			} else {
				this.proximo.inserir(pacoteViagem);
			}
		}
	}

	public void remover(String id) throws PacoteNaoEncontradoException {
		PacoteViagem pacoteViagemAchado;
		pacoteViagemAchado = this.procurar(id);

		if (this.pacoteViagem != null) {
			if (this.pacoteViagem.equals(pacoteViagemAchado)) {
				this.pacoteViagem = this.proximo.pacoteViagem;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(id);
			}
		} else {
			PacoteNaoEncontradoException e;
			e = new PacoteNaoEncontradoException();
			throw e;
		}
	}

	public void atualizar(PacoteViagem pacoteViagem) throws PacoteNaoEncontradoException, PacoteViagemJaCadastradoException {
		PacoteViagem pacoteViagemAnterior;
		pacoteViagemAnterior = procurar(pacoteViagem.getId());
		this.remover(pacoteViagemAnterior.getId());
		this.inserir(pacoteViagem);
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