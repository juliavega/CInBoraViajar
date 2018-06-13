package classesBasicas;

import erros.CpfInvalidoException;
import erros.DataNascimentoInvalidaException;
import erros.NomeMuitoLongoException;

//abstrata
public abstract class Pessoa {
	private String nome, cpf, dataNascimento;

	protected Pessoa(String nome, String cpf, String dataNascimento)
			throws NomeMuitoLongoException, CpfInvalidoException, DataNascimentoInvalidaException {

		// Checa se o nome tem mais que 200 caracteres (Invalido)
		if (nome.length() < 200) {
			this.nome = nome;
		} else {
			NomeMuitoLongoException e;
			e = new NomeMuitoLongoException();
			throw e;
		}

		// Checa se o cpf tem 11 caracteres
		if (cpf.length() == 11) {
			this.cpf = cpf;
		} else {
			CpfInvalidoException e;
			e = new CpfInvalidoException();
			throw e;
		}
		
		// Checa a quantidade de digitos da data de nascimento
		if (splitDataNascimento(dataNascimento)) {
			this.dataNascimento = dataNascimento;			
		} else {
			DataNascimentoInvalidaException e;
			e = new DataNascimentoInvalidaException();
			throw e;
		}
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

	private boolean splitDataNascimento(String dataNascimento) {
		String[] array = new String[3];
		array = dataNascimento.split("/");
		return array [0].length() == 2 && array [1].length() == 2 && array [2].length() == 4;
	}
}