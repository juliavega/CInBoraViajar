package classesBasicas;

import erros.cpfInvalidoException;

//abstrata
public abstract class Pessoa {
	private String nome, cpf, dataNascimento;
	
	protected Pessoa(String nome, String cpf, String dataNascimento) 
			throws cpfInvalidoException {
		
		this.nome = nome;
		
		if (cpf.length() == 11) {			
			this.cpf = cpf;
		} else {
			cpfInvalidoException e;
			e = new cpfInvalidoException();
			throw e;
		}
		
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