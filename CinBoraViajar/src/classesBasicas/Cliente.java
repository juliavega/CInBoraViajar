package classesBasicas;

import erros.cpfInvalidoException;
import erros.emailInvalidoException;
import erros.nomeMuitoLongoException;
import erros.numeroCartaoInvalidoException;
import erros.passaporteInvalidoException;

public class Cliente extends Pessoa {

	// Atributos exclusivos da classe Cliente
	private String passaporte, email, numeroCartao;

	// Construtor classe Cliente
	public Cliente(String nome, String cpf, String dataNascimento, String email, String numeroCartao)
			throws nomeMuitoLongoException, cpfInvalidoException, numeroCartaoInvalidoException, emailInvalidoException {
		super(nome, cpf, dataNascimento);
		
		this.passaporte = null;
		
		this.email = email;

		// Checa a quantidade de digitos do número do cartão
		if (numeroCartao.length() == 16) {
			this.numeroCartao = numeroCartao;

			// Erro se for inválido
		} else {
			numeroCartaoInvalidoException e;
			e = new numeroCartaoInvalidoException();
			throw e;
		}
	}

	// Metodos
	public void setPassaporte(String passaporte) throws passaporteInvalidoException {

		// Checa a quantidade de dígitos do passaporte se é valido
		if (passaporte.length() == 8) {
			this.passaporte = passaporte;

			// Erro se for inválido (diferente de 8)
		} else {
			passaporteInvalidoException e;
			e = new passaporteInvalidoException();
			throw e;
		}
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
	
	public boolean equals(Cliente cliente) {
		return (this.getCpf().equals(cliente.getCpf()));
	}
}