package cadastro;

import classesBasicas.Funcionario;
import erros.ClienteNaoEncontradoException;
import erros.FuncionarioJaCadastradoException;
import erros.FuncionarioNaoEncontradoException;
import erros.LimiteAtingidoException;
import interfaces.RepositorioFuncionario;
import repositorios.RepositorioArrayFuncionario;
import repositorios.RepositorioListaFuncionario;

public class CadastroFuncionario {
	private RepositorioFuncionario funcionarios;

	public CadastroFuncionario(boolean tipo) {
		if (tipo) {
			this.funcionarios = new RepositorioListaFuncionario();
		} else {
			this.funcionarios = new RepositorioArrayFuncionario();
		}
	}

	public void cadastrar(Funcionario funcionario) throws LimiteAtingidoException, FuncionarioJaCadastradoException {
		if (!this.funcionarios.existe(funcionario.getCpf())) {
			this.funcionarios.inserir(funcionario);
		} else {
			FuncionarioJaCadastradoException e;
			e = new FuncionarioJaCadastradoException();
			throw e;
		}
	}
	
	public void remover(String cpf) throws FuncionarioNaoEncontradoException{
		this.funcionarios.remover(cpf);
	}
	
	public void atualizar(Funcionario funcionario) throws FuncionarioNaoEncontradoException, FuncionarioJaCadastradoException {
		this.funcionarios.atualizar(funcionario);
	}
	
	public Funcionario procurar(String cpf) throws FuncionarioNaoEncontradoException {
		return this.funcionarios.procurar(cpf);
	}
	public boolean existe(String cpf) {
		return this.funcionarios.existe(cpf);
	}
}
