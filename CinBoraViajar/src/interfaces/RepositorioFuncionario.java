package interfaces;

import classesBasicas.Funcionario;
import erros.FuncionarioNaoEncontradoException;

public interface RepositorioFuncionario {
	public void inserir(Funcionario funcionario) throws FuncionarioNaoEncontradoException;
	public void atualizar(Funcionario funcionario) throws FuncionarioNaoEncontradoException;
	public void remover(Funcionario funcionario) throws FuncionarioNaoEncontradoException;
	public Funcionario procurar(Funcionario funcionario) throws FuncionarioNaoEncontradoException;
}
