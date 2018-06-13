package repositorios;

import classesBasicas.Pessoa;
import erros.pessoaNaoEncontradaException;

public class RepositorioListaPessoa {
	private Pessoa pessoa;
	private RepositorioListaPessoa proximo;
	
	public RepositorioListaPessoa() {
		this.pessoa = null;
		this.proximo = null;
	}
	
	public void inserir(Pessoa pessoa) {
		if (this.pessoa == null) {
			this.pessoa = pessoa;
			this.proximo = new RepositorioListaPessoa();
		} else {
			this.proximo.inserir(pessoa);
		}
	}
	
	public void remover(Pessoa pessoa) throws pessoaNaoEncontradaException {
		if (this.pessoa != null) {
			if (this.pessoa.equals(pessoa)) {
				this.pessoa = this.proximo.pessoa;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(pessoa);
			}
		} else {
			pessoaNaoEncontradaException e;
			e = new pessoaNaoEncontradaException();
			throw e;
		}
	}
	
	public void atualizar() {
		
	}
	
	public Pessoa procurar(Pessoa pessoa) throws pessoaNaoEncontradaException {
		Pessoa resposta;
		resposta = null;
		if (this.pessoa != null) {
			if (this.pessoa.equals(pessoa)) {
				resposta = this.pessoa;
			} else {
				this.proximo.procurar(pessoa);
			}
		} else {
			pessoaNaoEncontradaException e;
			e = new pessoaNaoEncontradaException();
			throw e;
		}
		return resposta;
	}
}