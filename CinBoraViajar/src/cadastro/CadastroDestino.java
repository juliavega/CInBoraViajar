package cadastro;

import classesBasicas.Destino;
import erros.DestinoJaCadastradoException;
import erros.DestinoNaoEncontradoException;
import erros.LimiteAtingidoException;
import interfaces.RepositorioDestino;
import repositorios.RepositorioArrayDestino;
import repositorios.RepositorioListaDestino;

public class CadastroDestino {
	private RepositorioDestino destinos;

	// se o construtor receber um parâmtro true, inicializa uma lista, senão, um array
	public CadastroDestino(boolean tipo) {
		if (tipo) {
			this.destinos = new RepositorioListaDestino();
		} else {
			this.destinos = new RepositorioArrayDestino();
		}
	}

	// checa se o destino já está cadastrado. Se não estiver, o cadastra
	public void cadastrar(Destino destino) throws DestinoJaCadastradoException, LimiteAtingidoException {
		if (!this.destinos.existe(destino.getCidade())) {
			this.destinos.inserir(destino);
		} else {
			DestinoJaCadastradoException e;
			e = new DestinoJaCadastradoException();
			throw e;
		}
	}

	// chama o remover da interface
	public void remover(String cidade) throws DestinoNaoEncontradoException {
		this.destinos.remover(cidade);
	}

	// chama o atualizar da interface
	public void atualizar(Destino destino) throws DestinoNaoEncontradoException, DestinoJaCadastradoException {
		this.destinos.atualizar(destino);
	}
	
	// chama o procurar da interface
	public Destino procurar(String cidade) throws DestinoNaoEncontradoException {
		 return this.destinos.procurar(cidade);
	}
	
	// chama o existe da interface	
	public boolean existe(String cidade) {
		return this.destinos.existe(cidade);
	}
}