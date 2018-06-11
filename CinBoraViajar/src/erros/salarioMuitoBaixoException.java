package erros;

public class salarioMuitoBaixoException extends Exception{
	public salarioMuitoBaixoException() {
		super("Salario abaixo do minimo");
	}
}
