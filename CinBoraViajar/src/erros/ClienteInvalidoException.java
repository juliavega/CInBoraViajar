package erros;

public class ClienteInvalidoException extends Exception{
	public ClienteInvalidoException() {
		super("Cliente não cadastrado");
	}
}
