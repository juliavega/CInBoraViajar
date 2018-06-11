package classesBasicas;

import erros.cpfInvalidoException;

public class Funcionario extends Pessoa {

	// Atributos exclusivos da classe Funcionario
	private String cargo;
	private double salario;

	public Funcionario(String nome, String cpf, String dataNascimento, String cargo, double salario)
			throws cpfInvalidoException {
		super(nome, cpf, dataNascimento);
		this.cargo = cargo;
		this.salario = salario;
	}

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