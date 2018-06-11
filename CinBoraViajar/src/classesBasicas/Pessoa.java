package classesBasicas;

//abstrata
public abstract class Pessoa {
	private String nome, cpf, dataNascimento;
	
	protected Pessoa(String nome, String cpf, String dataNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}
	
	protected String getNome() {
		return this.nome;
	}
	
	protected String getCpf() {
		return this.cpf;
	}
	
	protected String getDataNascimento() {
		return this.dataNascimento;
	}
	
}