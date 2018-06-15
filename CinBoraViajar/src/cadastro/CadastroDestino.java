package cadastro;

import classesBasicas.Destino;
import erros.DestinoJaCadastradoException;
import erros.DestinoNaoEncontradoException;
import interfaces.RepositorioDestino;
import repositorios.RepositorioArrayDestino;
import repositorios.RepositorioListaDestino;

public class CadastroDestino {
	private RepositorioDestino destinos;

	public CadastroDestino(boolean tipo) {
		if (tipo) {
			this.destinos = new RepositorioListaDestino();
		} else {
			this.destinos = new RepositorioArrayDestino();
		}
	}

	public void cadastrar(Destino destino) throws DestinoNaoEncontradoException, DestinoJaCadastradoException {
		this.destinos.inserir(destino);
	}

	public void remover(String cidade) throws DestinoNaoEncontradoException {
		this.destinos.remover(cidade);
	}

	public void atualizar(Destino destino) throws DestinoNaoEncontradoException, DestinoJaCadastradoException {
		this.destinos.atualizar(destino);
	}

	public void procurar(String cidade) throws DestinoNaoEncontradoException {
		this.destinos.procurar(cidade);
	}
}