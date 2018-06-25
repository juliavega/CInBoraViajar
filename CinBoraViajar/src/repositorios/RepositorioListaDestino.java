package repositorios;

import interfaces.RepositorioDestino;
import classesBasicas.Destino;
import erros.DestinoNaoEncontradoException;

public class RepositorioListaDestino implements RepositorioDestino {
	private Destino destino;
	private RepositorioListaDestino proximo;
	
	// construtor básico
	public RepositorioListaDestino() {
		this.destino = null;
		this.proximo = null;
	}
	
	// insere o elemento na posição da lista e referencia próximo para uma nova lista
	public void inserir(Destino destino) {
		if (this.destino == null) {
			this.destino = destino;
			this.proximo = new RepositorioListaDestino();
		} else {
			this.proximo.inserir(destino);
		}
	}
	
	// remove o elemento da lista (usa o garbage collector)
	public void remover(String cidade) throws DestinoNaoEncontradoException {
		Destino destinoAchado;
		destinoAchado = this.procurar(cidade);

		if (this.destino != null) {
			if (this.destino.equals(destinoAchado)) {
				this.destino = this.proximo.destino;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(cidade);
			}
		} else {
			DestinoNaoEncontradoException e;
			e = new DestinoNaoEncontradoException();
			throw e;
		}
	}
	
	// procura por um objeto com o determinado identificador, o remove, e insere o novo no lugar
	public void atualizar(Destino destino) throws DestinoNaoEncontradoException {
		Destino destinoAnterior;
		destinoAnterior = procurar(destino.getCidade());
		this.remover(destinoAnterior.getCidade());
		this.inserir(destino);
	}
	
	// retorna o destino cliente dada a sua cidade
	public Destino procurar(String cidade) throws DestinoNaoEncontradoException {
		Destino resposta;
		resposta = null;
		if (this.destino != null) {
			if (this.destino.getCidade().equals(cidade)) {
				resposta = this.destino;
			} else {
				this.proximo.procurar(cidade);
			}
		} else {
			DestinoNaoEncontradoException e;
			e = new DestinoNaoEncontradoException();
			throw e;
		}
		return resposta;
	}
	
	// método interno para checar se há um objeto com determinado identificador
	public boolean existe(String cidade) {
		if (this.destino != null) {
			if (this.destino.getCidade().equals(cidade)) {
				return true;
			} else {
				return this.proximo.existe(cidade);
			}
		} else {
			return false;
		}
	}
}