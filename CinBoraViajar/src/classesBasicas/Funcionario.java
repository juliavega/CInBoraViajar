package classesBasicas;

import erros.cpfInvalidoException;

public class Funcionario extends Pessoa {
	private String cargo;
	private double salario;

	public Funcionario(String nome, String cpf, String dataNascimento, String cargo, double salario) {
		super(nome, cpf, dataNascimento);
		this.cargo = cargo;
		this.salario = salario;
	}
}