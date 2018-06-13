package erros;

public class PacoteViagemJaCadastradoException extends Exception {
	public PacoteViagemJaCadastradoException() {
		super("Pacote ja cadastrado");
	}
}