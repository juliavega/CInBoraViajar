package erros;

public class funcionarioNaoEncontradoException extends Exception {
	public funcionarioNaoEncontradoException() {
		super("Funcionario nao encontrado");
	}
}
