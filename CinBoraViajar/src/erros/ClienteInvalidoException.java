package erros;

public class ClienteInvalidoException extends Exception{
	public ClienteInvalidoException() {
		super("Cliente n�o cadastrado");
	}
}
