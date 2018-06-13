package repositorios;

import classesBasicas.Funcionario;
import erros.funcionarioNaoEncontradoException;

public class RepositorioListaFuncionario {
	private Funcionario funcionario;
	private RepositorioListaFuncionario proximo;

	public RepositorioListaFuncionario() {
		this.funcionario = null;
		this.proximo = null;
	}

	public void inserir(Funcionario funcionario) {
		if (this.funcionario == null) {
			this.funcionario = funcionario;
			this.proximo = new RepositorioListaFuncionario();
		} else {
			this.proximo.inserir(funcionario);
		}
	}

	public void remover(Funcionario funcionario) throws funcionarioNaoEncontradoException {
		if (this.funcionario != null) {
			if (this.funcionario.equals(funcionario)) {
				this.funcionario = this.proximo.funcionario;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(funcionario);
			}
		} else {
			funcionarioNaoEncontradoException e;
			e = new funcionarioNaoEncontradoException();
			throw e;
		}
	}

	public void atualizar() {

	}

	public Funcionario procurar(Funcionario funcionario) throws funcionarioNaoEncontradoException {
		Funcionario resposta;
		resposta = null;
		if (this.funcionario != null) {
			if (this.funcionario.equals(funcionario)) {
				resposta = this.funcionario;
			} else {
				this.proximo.procurar(funcionario);
			}
		} else {
			funcionarioNaoEncontradoException e;
			e = new funcionarioNaoEncontradoException();
			throw e;
		}
		return resposta;
	}
}