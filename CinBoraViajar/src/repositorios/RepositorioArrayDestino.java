package repositorios;

import classesBasicas.Cliente;
import classesBasicas.Destino;
import erros.ClienteNaoEncontradoException;
import erros.DestinoNaoEncontradoException;
import erros.LimiteAtingidoException;
import interfaces.RepositorioDestino;

public class RepositorioArrayDestino implements RepositorioDestino{
	private Destino[] arrayDestino = new Destino[1000];
	private int contador = 0;

	public void inserir(Destino destino) throws DestinoNaoEncontradoException {
		if (this.contador < this.arrayDestino.length) {
			this.arrayDestino[contador] = destino;
			this.contador++;
		} else {
			DestinoNaoEncontradoException e;
			e = new DestinoNaoEncontradoException();
			throw e;
		}		
	}
	public void remover(String cidade) throws DestinoNaoEncontradoException {
		int indice = this.getIndice(cidade);
		int indiceaux = indice;
		for (int i = 1; i < (arrayDestino.length - indice); i++) {
			arrayDestino[indiceaux] = arrayDestino [indiceaux + 1];
			indiceaux++;
		}
		arrayDestino[arrayDestino.length - 1] = null;
	}

	public Destino procurar(String cidade) throws DestinoNaoEncontradoException {
		Destino resposta = null;
		boolean jaAchou = false;
		for (int i = 0; i <= this.contador && !jaAchou; i++) {
			if (this.arrayDestino[i].getCidade().equals(cidade)) {
				resposta = this.arrayDestino[i];
				jaAchou = true;
			}
		}
		if (jaAchou) {
			return resposta;
		} else {
			DestinoNaoEncontradoException e;
			e = new DestinoNaoEncontradoException();
			throw e;
		}
	}

	public void atualizar(Destino destino) throws DestinoNaoEncontradoException {
		int indice = this.getIndice(destino.getCidade());
		arrayDestino[indice] = destino;	
	}
	public int getIndice(String cidade) throws DestinoNaoEncontradoException {
		int resposta = 0;
		boolean jaAchou = false;
		for (int i = 0; i <= this.contador && !jaAchou; i++) {
			if (this.arrayDestino[i].getCidade().equals(cidade)) {
				resposta = i;
				jaAchou = true;
			}
		}
		if (jaAchou) {
			return resposta;
		} else {
			DestinoNaoEncontradoException e;
			e = new DestinoNaoEncontradoException();
			throw e;
		}
	}
}
