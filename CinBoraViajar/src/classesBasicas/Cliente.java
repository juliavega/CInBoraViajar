package classesBasicas;

import erros.cpfInvalidoException;

public class Cliente extends Pessoa {

	// Atributos exclusivos da classe Cliente
	private String passaporte, email, numeroCartao;

	public Cliente(String nome, String cpf, String dataNascimento, String passaporte, String email, String numeroCartao) {
		super(nome, cpf, dataNascimento);
		this.passaporte = passaporte;
		this.email = email;
		this.numeroCartao = numeroCartao;
	}
}