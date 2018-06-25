package repositorios;

import classesBasicas.Destino;
import erros.DestinoJaCadastradoException;
import erros.DestinoNaoEncontradoException;
import erros.LimiteAtingidoException;
import interfaces.RepositorioDestino;

public class RepositorioArrayDestino implements RepositorioDestino{
	private Destino[] arrayDestino = new Destino[1000];
	private int contador = 0;
	
	// checa se há posição disponível no array e insere o destino
	public void inserir(Destino destino) throws LimiteAtingidoException {
		if (this.contador < this.arrayDestino.length) {
			this.arrayDestino[contador] = destino;
			this.contador++;
		} else {
			LimiteAtingidoException e;
			e = new LimiteAtingidoException();
			throw e;
		}		
	}
	
	// remove o destino procurado e reorganiza o array
	public void remover(String cidade) throws DestinoNaoEncontradoException {
		int indice = this.getIndice(cidade);
		int indiceAux = indice;
		
		// manda os elementos à direita do removido uma posição para a esquerda
		for (int i = 1; i < (arrayDestino.length - indice); i++) {
			arrayDestino[indiceAux] = arrayDestino [indiceAux + 1];
			indiceAux++;
		}
		arrayDestino[arrayDestino.length - 1] = null;
		contador = contador - 1;
	}
	
	// procura por um destino e o retorna dado o sua cidade
	public Destino procurar(String cidade) throws DestinoNaoEncontradoException {
		Destino resposta = null;
		boolean jaAchou = false;
		for (int i = 0; i < this.contador && !jaAchou; i++) {
			if (this.arrayDestino[i].getCidade().equals(cidade)) {
				resposta = this.arrayDestino[i];
				jaAchou = true;
			}
		}
		
		// retorna um erro se o destino procurado não foi encontrado
		if (jaAchou) {
			return resposta;
		} else {
			DestinoNaoEncontradoException e;
			e = new DestinoNaoEncontradoException();
			throw e;
		}
	}
	
	// recebe um destino, pocura por um com cidade igual, o remove e se insere no lugar
	public void atualizar(Destino destino) throws DestinoNaoEncontradoException {
		int indice = this.getIndice(destino.getCidade());
		arrayDestino[indice] = destino;	
	}
	
	// método interno para retornar o índice de um objeto dado seu identficador
	public int getIndice(String cidade) throws DestinoNaoEncontradoException {
		int resposta = 0;
		boolean jaAchou = false;
		for (int i = 0; i < this.contador && !jaAchou; i++) {
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
	
	// método interno para checar se existe um objeto com um dado id
	public boolean existe(String cidade) {
		boolean resposta = false;
		for (int i = 0; i < this.contador && !resposta; i++) {
			if (this.arrayDestino[i].getCidade().equals(cidade)) {
				resposta = true;
			}
		}
		return resposta;
	}
}