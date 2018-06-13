package repositorios;

import classesBasicas.Funcionario;
import erros.FuncionarioNaoEncontradoException;
import erros.LimiteAtingidoException;
import interfaces.RepositorioFuncionario;

public class RepositorioArrayFuncionario implements RepositorioFuncionario {
	private Funcionario[] arrayFuncionario = new Funcionario[1000];
	private int contador = 0;

	public void inserir(Funcionario funcionario) throws LimiteAtingidoException {
		if (this.contador < this.arrayFuncionario.length) {
			this.arrayFuncionario[contador] = funcionario;
			this.contador++;
		} else {
			LimiteAtingidoException e;
			e = new LimiteAtingidoException();
			throw e;
		}
	}

	public void remover(String cpf) throws FuncionarioNaoEncontradoException {
		
	}

	public Funcionario procurar(String cpf) throws FuncionarioNaoEncontradoException {
		Funcionario resposta = null;
		boolean jaAchou = false;
		for (int i = 0; i <= this.contador && !jaAchou; i++) {
			if (this.arrayFuncionario[i].getCpf().equals(cpf)) {
				resposta = this.arrayFuncionario[i];
				jaAchou = true;
			}
		}
		if (jaAchou) {
			return resposta;
		} else {
			FuncionarioNaoEncontradoException e;
			e = new FuncionarioNaoEncontradoException();
			throw e;
		}
	}

	public void atualizar(Funcionario funcionario) throws FuncionarioNaoEncontradoException {
		int indice = this.getIndice(funcionario.getCpf());
		arrayFuncionario[indice] = funcionario;
	}
	
	public int getIndice(String cpf) throws FuncionarioNaoEncontradoException {
		int resposta = 0;
		boolean jaAchou = false;
		for (int i = 0; i < this.contador && !jaAchou; i++) {
			if (this.arrayFuncionario[i].getCpf().equals(cpf)) {
				resposta = i;
				jaAchou = true;
			}
		}
		if (jaAchou) {
			return resposta;
		} else {
			FuncionarioNaoEncontradoException e;
			e = new FuncionarioNaoEncontradoException();
			throw e;
		}
	}
}