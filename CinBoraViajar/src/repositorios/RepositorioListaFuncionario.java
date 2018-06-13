package repositorios;
import interfaces.RepositorioFuncionario;
import classesBasicas.Funcionario;
import erros.FuncionarioNaoEncontradoException;

public class RepositorioListaFuncionario implements RepositorioFuncionario{
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

	public void remover(Funcionario funcionario) throws FuncionarioNaoEncontradoException {
		if (this.funcionario != null) {
			if (this.funcionario.equals(funcionario)) {
				this.funcionario = this.proximo.funcionario;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(funcionario);
			}
		} else {
			FuncionarioNaoEncontradoException e;
			e = new FuncionarioNaoEncontradoException();
			throw e;
		}
	}

	public void atualizar(Funcionario funcionarioAnterior, Funcionario funcionarioNovo) {

	}

	public Funcionario procurar(String cpf) throws FuncionarioNaoEncontradoException {
		Funcionario resposta;
		resposta = null;
		if (this.funcionario != null) {
			if (this.funcionario.getCpf().equals(cpf)) {
				resposta = this.funcionario;
			} else {
				this.proximo.procurar(cpf);
			}
		} else {
			FuncionarioNaoEncontradoException e;
			e = new FuncionarioNaoEncontradoException();
			throw e;
		}
		return resposta;
	}
}