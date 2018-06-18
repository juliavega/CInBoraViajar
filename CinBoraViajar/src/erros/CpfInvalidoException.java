package erros;

public class CpfInvalidoException extends Exception {
	public CpfInvalidoException() {
		super("Cpf INVALIDO, devem haver 11 digitos");
	}
}
