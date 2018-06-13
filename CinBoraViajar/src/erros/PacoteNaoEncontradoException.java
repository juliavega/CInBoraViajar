package erros;

public class PacoteNaoEncontradoException extends Exception {
	public PacoteNaoEncontradoException() {
		super("Pacote nao encontrado");
	}
}
