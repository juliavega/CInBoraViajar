package erros;

public class IdRepetidaException extends Exception {
	public IdRepetidaException() {
		super("ID ja existente");
	}
}