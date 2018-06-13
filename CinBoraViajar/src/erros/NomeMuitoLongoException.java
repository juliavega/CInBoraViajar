package erros;

public class NomeMuitoLongoException extends Exception{
	public NomeMuitoLongoException() {
		super("Nome muito longo");
	}
}