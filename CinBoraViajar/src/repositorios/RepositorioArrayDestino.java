package repositorios;

import classesBasicas.Destino;
import erros.DestinoNaoEncontradoException;
import interfaces.RepositorioDestino;

public class RepositorioArrayDestino implements RepositorioDestino{

	@Override
	public void inserir(Destino destino) throws DestinoNaoEncontradoException {
		// TODO Auto-generated method stub
		
	}
	public void remover(Destino destino) throws DestinoNaoEncontradoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Destino procurar(String cidade) throws DestinoNaoEncontradoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizar(Destino destinoAnterior, Destino destinoNovo) throws DestinoNaoEncontradoException {
		// TODO Auto-generated method stub
		
	}

}
