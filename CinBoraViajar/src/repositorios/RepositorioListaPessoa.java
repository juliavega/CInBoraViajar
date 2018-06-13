package repositorios;

import classesBasicas.Pessoa;
import erros.PessoaNaoEncontradaException;

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
	
	public void remover(Pessoa pessoa) throws PessoaNaoEncontradaException {
		if (this.pessoa != null) {
			if (this.pessoa.equals(pessoa)) {
				this.pessoa = this.proximo.pessoa;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(pessoa);
			}
		} else {
			PessoaNaoEncontradaException e;
			e = new PessoaNaoEncontradaException();
			throw e;
		}
	}
	
	public void atualizar() {
		
	}
	
	public Pessoa procurar(Pessoa pessoa) throws PessoaNaoEncontradaException {
		Pessoa resposta;
		resposta = null;
		if (this.pessoa != null) {
			if (this.pessoa.equals(pessoa)) {
				resposta = this.pessoa;
			} else {
				this.proximo.procurar(pessoa);
			}
		} else {
			PessoaNaoEncontradaException e;
			e = new PessoaNaoEncontradaException();
			throw e;
		}
		return resposta;
	}
}