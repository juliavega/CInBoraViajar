package repositorios;
import interfaces.RepositorioDestino;
import classesBasicas.Destino;
import erros.ClienteJaCadastradoException;
import erros.DestinoNaoEncontradoException;

public class RepositorioListaDestino implements RepositorioDestino {
	private Destino destino;
	private RepositorioListaDestino proximo;

	public RepositorioListaDestino() {
		this.destino = null;
		this.proximo = null;
	}

	public void inserir(Destino destino) throws DestinoJaCadastradoException {
		if (this.destino == null) {
			this.destino = destino;
			this.proximo = new RepositorioListaDestino();
		} else {
			if (this.destino.equals(destino)) {
				DestinoJaCadastradoException e;
				e = new DestinoJaCadastradoException();
				throw e;
			} else {					
				this.proximo.inserir(destino);
			}
		}
	}

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

	public void atualizar(Destino destino) throws DestinoNaoEncontradoException {
		Destino destinoAnterior;
		destinoAnterior = procurar(destino.getCidade());
		remover(destinoAnterior.getCidade());
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