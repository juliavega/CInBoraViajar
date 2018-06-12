package erros;

public class clienteNaoEncontradoException extends Exception {
	public clienteNaoEncontradoException() {
		super("Cliente nao encontrado");
	}
}
