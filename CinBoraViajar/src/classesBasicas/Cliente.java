package classesBasicas;

import erros.cpfInvalidoException;
import erros.nomeMuitoLongoException;

public class Cliente extends Pessoa {

	// Atributos exclusivos da classe Cliente
	private String passaporte, email, numeroCartao;

	public Cliente(String nome, String cpf, String dataNascimento, String passaporte, String email, String numeroCartao)
			throws nomeMuitoLongoException, cpfInvalidoException {
		super(nome, cpf, dataNascimento);
		this.passaporte = passaporte;
		this.email = email;
		this.numeroCartao = numeroCartao;
	}

	public String getPassaporte() {
		return this.passaporte;
	}

	public String getEmail() {
		return this.email;
	}

	public String getNumeroCartao() {
		return this.numeroCartao;
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