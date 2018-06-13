package repositorios;
import interfaces.RepositorioDestino;
import classesBasicas.Destino;
import erros.DestinoNaoEncontradoException;

public class RepositorioListaDestino implements RepositorioDestino {
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

	public void atualizar(Destino destino) throws DestinoNaoEncontradoException {
		Destino destinoAnterior;
		destinoAnterior = procurar(destino.getCidade());
		remover(destinoAnterior);
		inserir(destino);
	}

	public Destino procurar(String cidade) throws DestinoNaoEncontradoException {
		Destino resposta;
		resposta = null;
		if (this.destino != null) {
			if (this.destino.getCidade().equals(destino)) {
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
}