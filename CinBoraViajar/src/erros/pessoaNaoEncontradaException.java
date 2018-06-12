package erros;

public class pessoaNaoEncontradaException extends Exception {
	public pessoaNaoEncontradaException() {
		super("Pessoa nao encontrada");
	}
}