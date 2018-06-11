package classesBasicas;

import erros.cpfInvalidoException;
import erros.nomeMuitoLongoException;

public class Funcionario extends Pessoa {

	// Atributos exclusivos da classe Funcionario
	private String cargo;
	private double salario;
	
	// Construtor classe Funcionario
	public Funcionario(String nome, String cpf, String dataNascimento, String cargo, double salario)
			throws nomeMuitoLongoException, cpfInvalidoException {
		super(nome, cpf, dataNascimento);
		this.cargo = cargo;
		this.salario = salario;
	}
	
	// Metodos
	public String getCargo() {
		return this.cargo;
	}

	public double getSalario() {
		return this.salario;
	}

	public String getNome() {
		return super.getNome();
	}

	public String getCpf() {
		return super.getCpf();
	}

	public String getDataNascimento() {
		return super.getDataNascimento();
	}
}