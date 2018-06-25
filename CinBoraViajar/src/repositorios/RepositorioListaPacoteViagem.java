package repositorios;

import classesBasicas.PacoteViagem;
import erros.PacoteNaoEncontradoException;
import erros.PacoteViagemJaCadastradoException;
import interfaces.RepositorioPacoteViagem;

public class RepositorioListaPacoteViagem implements RepositorioPacoteViagem {
	private PacoteViagem pacoteViagem;
	private RepositorioListaPacoteViagem proximo;
	
	// construtor básico
	public RepositorioListaPacoteViagem() {
		this.pacoteViagem = null;
		this.proximo = null;
	}
	
	// insere o elemento na posição da lista e referencia próximo para uma nova lista
	public void inserir(PacoteViagem pacoteViagem) {
		if (this.pacoteViagem == null) {
			this.pacoteViagem = pacoteViagem;
			this.proximo = new RepositorioListaPacoteViagem();
		} else {
			this.proximo.inserir(pacoteViagem);
		}
	}

	// remove o elemento da lista (usa o garbage collector)
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
	
	// procura por um objeto com o determinado identificador, o remove, e insere o novo no lugar
	public void atualizar(PacoteViagem pacoteViagem) throws PacoteNaoEncontradoException {
		PacoteViagem pacoteViagemAnterior;
		pacoteViagemAnterior = procurar(pacoteViagem.getId());
		this.remover(pacoteViagemAnterior.getId());
		this.inserir(pacoteViagem);
	}
	
	// retorna o funcionário dado o seu cpf
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
	
	// método interno para checar se há um objeto com determinado identificador
	public boolean existe(String id) {
		if (this.pacoteViagem != null) {
			if (this.pacoteViagem.getId().equals(id)) {
				return true;
			} else {
				return this.proximo.existe(id);
			}
		} else {
			return false;
		}
	}
}