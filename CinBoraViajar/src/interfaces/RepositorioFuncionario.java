package interfaces;

import classesBasicas.Funcionario;
import erros.FuncionarioJaCadastradoException;
import erros.FuncionarioNaoEncontradoException;

public interface RepositorioFuncionario {
	public void inserir(Funcionario funcionario) throws FuncionarioJaCadastradoException;
	public void atualizar(Funcionario funcionario) throws FuncionarioNaoEncontradoException, FuncionarioJaCadastradoException;
	public void remover(String cpf) throws FuncionarioNaoEncontradoException;
	public Funcionario procurar(String cpf) throws FuncionarioNaoEncontradoException;
}
