package erros;

public class pacoteNaoEncontradoException extends Exception {
	public pacoteNaoEncontradoException() {
		super("Pacote nao encontrado");
	}
}
