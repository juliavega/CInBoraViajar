package repositorios;

import classesBasicas.Funcionario;
import erros.FuncionarioNaoEncontradoException;
import interfaces.RepositorioFuncionario;

public class RepositorioArrayFuncionario implements RepositorioFuncionario {

	@Override
	public void inserir(Funcionario funcionario) throws FuncionarioNaoEncontradoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Funcionario funcionario)
			throws FuncionarioNaoEncontradoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(String cpf) throws FuncionarioNaoEncontradoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Funcionario procurar(String cpf) throws FuncionarioNaoEncontradoException {
		// TODO Auto-generated method stub
		return null;
	}

}
