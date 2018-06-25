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
	
	// checa se há posição disponível no array e insere o pacote
	public void inserir(PacoteViagem pacoteViagem) throws LimiteAtingidoException {
		if (this.contador < this.arrayPacoteViagem.length) {
			this.arrayPacoteViagem[contador] = pacoteViagem;
			this.contador++;
		} else {
			LimiteAtingidoException e;
			e = new LimiteAtingidoException();
			throw e;
		}
	}
	
	// remove o pacote procurado e reorganiza o array
	public void remover(String id) throws PacoteNaoEncontradoException {
		int indice = this.getIndice(id);
		int indiceAux = indice;
		
		// manda os elementos à direita do removido uma posição para a esquerda
		for (int i = 1; i < (arrayPacoteViagem.length - indice); i++) {
			arrayPacoteViagem[indiceAux] = arrayPacoteViagem [indiceAux + 1];
			indiceAux++;
		}
		arrayPacoteViagem[arrayPacoteViagem.length - 1] = null;
		contador = contador - 1;
	}
	
	// procura por um pacote e o retorna dado o seu id
	public PacoteViagem procurar(String id) throws PacoteNaoEncontradoException {
		PacoteViagem resposta = null;
		boolean jaAchou = false;
		for (int i = 0; i < this.contador && !jaAchou; i++) {
			if (this.arrayPacoteViagem[i].getId().equals(id)) {
				resposta = this.arrayPacoteViagem[i];
				jaAchou = true;
			}
		}
		
		// retorna um erro se o pacote procurado não foi encontrado
		if (jaAchou) {
			return resposta;
		} else {
			PacoteNaoEncontradoException e;
			e = new PacoteNaoEncontradoException();
			throw e;
		}
	}
	
	// recebe um pacote, pocura por um com id igual, o remove e se insere no lugar
	public void atualizar(PacoteViagem pacoteViagem) throws PacoteNaoEncontradoException {
		int indice = this.getIndice(pacoteViagem.getId());
		arrayPacoteViagem[indice] = pacoteViagem;
	}
	
	// método interno para retornar o índice de um objeto dado seu identficador
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
	
	// método interno para checar se existe um objeto com um dado id
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
