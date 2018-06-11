package classesBasicas;

//abstrata
public abstract class Pessoa {
	private String nome, cpf, dataNascimento;
	
	protected Pessoa(String nome, String cpf, String dataNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}
	
}