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
		if (!this.destinos.existe(destino.getCidade())) {
			this.destinos.inserir(destino);
		} else {
			DestinoJaCadastradoException e;
			e = new DestinoJaCadastradoException();
			throw e;
		}
	}

	public void remover(String cidade) throws DestinoNaoEncontradoException {
		this.destinos.remover(cidade);
	}

	public void atualizar(Destino destino) throws DestinoNaoEncontradoException, DestinoJaCadastradoException {
		this.destinos.atualizar(destino);
	}

	public Destino procurar(String cidade) throws DestinoNaoEncontradoException {
		 return this.destinos.procurar(cidade);
	}
	
	public boolean existe(String cidade) {
		return this.destinos.existe(cidade);
	}
}