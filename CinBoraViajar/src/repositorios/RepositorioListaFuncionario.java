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

	public void remover(String cpf) throws FuncionarioNaoEncontradoException {
		Funcionario funcionarioAchado;
		funcionarioAchado = this.procurar(cpf);
		
		if (this.funcionario != null) {
			if (this.funcionario.equals(funcionarioAchado)) {
				this.funcionario = this.proximo.funcionario;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(cpf);
			}
		} else {
			FuncionarioNaoEncontradoException e;
			e = new FuncionarioNaoEncontradoException();
			throw e;
		}
	}

	public void atualizar(Funcionario funcionario) throws FuncionarioNaoEncontradoException {
		Funcionario funcionarioAnterior;
		funcionarioAnterior = procurar(funcionario.getCpf());
		remover (funcionarioAnterior.getCpf());
		inserir (funcionario);
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