package repositorios;

import classesBasicas.Cliente;
import classesBasicas.PacoteViagem;
import erros.ClienteNaoEncontradoException;
import erros.LimiteAtingidoException;
import erros.PacoteNaoEncontradoException;
import interfaces.RepositorioPacoteViagem;

public class RepositorioArrayPacoteViagem implements RepositorioPacoteViagem{
	private PacoteViagem[] arrayPacoteViagem = new PacoteViagem[1000];
	private int contador = 0;
	
	public void inserir(PacoteViagem pacoteViagem) throws PacoteNaoEncontradoException {
		if (this.contador < this.arrayPacoteViagem.length) {
			this.arrayPacoteViagem[contador] = pacoteViagem;
			this.contador++;
		} else {
			PacoteNaoEncontradoException e;
			e = new PacoteNaoEncontradoException();
			throw e;
		}
	}

	public void remover(String id) throws PacoteNaoEncontradoException {
		int indice = this.getIndice(id);
		int indiceAux = indice;
		for (int i = 1; i < (arrayPacoteViagem.length - indice); i++) {
			arrayPacoteViagem[indiceAux] = arrayPacoteViagem [indiceAux + 1];
			indiceAux++;
		}
		arrayPacoteViagem[arrayPacoteViagem.length - 1] = null;
	}

	public PacoteViagem procurar(String id) throws PacoteNaoEncontradoException {
		PacoteViagem resposta = null;
		boolean jaAchou = false;
		for (int i = 0; i < this.contador && !jaAchou; i++) {
			if (this.arrayPacoteViagem[i].getId().equals(id)) {
				resposta = this.arrayPacoteViagem[i];
				jaAchou = true;
			}
		}

		if (jaAchou) {
			return resposta;
		} else {
			PacoteNaoEncontradoException e;
			e = new PacoteNaoEncontradoException();
			throw e;
		}
	}

	public void atualizar(PacoteViagem pacoteViagem) throws PacoteNaoEncontradoException {
		int indice = this.getIndice(pacoteViagem.getId());
		arrayPacoteViagem[indice] = pacoteViagem;
	}
	
	public int getIndice(String id) throws PacoteNaoEncontradoException {
		int resposta = 0;
		boolean jaAchou = false;
		for (int i = 0; i < this.contador && !jaAchou; i++) {
			if (this.arrayPacoteViagem[i].getId().equals(id)) {
				resposta = i;
				jaAchou = true;
			}
		}
		if (jaAchou) {
			return resposta;
		} else {
			PacoteNaoEncontradoException e;
			e = new PacoteNaoEncontradoException();
			throw e;
		}
	}
	
	public boolean existe(String id) {
		boolean resposta = false;
		for (int i = 0; i < this.contador && !resposta; i++) {
			if (this.arrayPacoteViagem[i].getId().equals(id)) {
				resposta = true;
			}
		}
		return resposta;
	}
}
