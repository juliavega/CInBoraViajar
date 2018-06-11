package erros;

public class nomeMuitoLongoException extends Exception{
	public nomeMuitoLongoException() {
		super("Nome muito longo");
	}
}