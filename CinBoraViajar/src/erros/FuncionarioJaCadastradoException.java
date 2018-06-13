package erros;

public class FuncionarioJaCadastradoException extends Exception {
	public FuncionarioJaCadastradoException() {
		super("Funcionario ja cadastrado");
	}
}