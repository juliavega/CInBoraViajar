package classesBasicas;

import erros.CpfInvalidoException;
import erros.DataNascimentoInvalidaException;
import erros.EmailInvalidoException;
import erros.NomeMuitoLongoException;
import erros.NumeroCartaoInvalidoException;
import erros.PassaporteInvalidoException;

public class Cliente extends Pessoa {

	// Atributos exclusivos da classe Cliente
	private String passaporte, email, numeroCartao;

	// Construtor classe Cliente
	public Cliente(String nome, String cpf, String dataNascimento, String email, String numeroCartao)
			throws NomeMuitoLongoException, CpfInvalidoException, NumeroCartaoInvalidoException, EmailInvalidoException,
			DataNascimentoInvalidaException {
		super(nome, cpf, dataNascimento);

		this.passaporte = null;

		this.email = email;

		// Checa a quantidade de digitos do número do cartão
		if (numeroCartao.length() == 16) {
			this.numeroCartao = numeroCartao;

			// Erro se for inválido
		} else {
			NumeroCartaoInvalidoException e;
			e = new NumeroCartaoInvalidoException();
			throw e;
		}
	}

	// Metodos
	public void setPassaporte(String passaporte) throws PassaporteInvalidoException {

		// Checa a quantidade de dígitos do passaporte se é valido
		if (passaporte.length() == 8) {
			this.passaporte = passaporte;

			// Erro se for inválido (diferente de 8)
		} else {
			PassaporteInvalidoException e;
			e = new PassaporteInvalidoException();
			throw e;
		}
	}

	public String getPassaporte() {
		return this.passaporte;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) throws EmailInvalidoException {
		if (email.contains("@")) {
			this.email = email;
		} else {
			EmailInvalidoException e;
			e = new EmailInvalidoException();
			throw e;
		}
	}

	public String getNumeroCartao() {
		return this.numeroCartao;
	}

	public String getNome() {
		return super.getNome();
	}

	// Chama o método setNome da abstrata
	public void setNome(String nome) throws NomeMuitoLongoException {
		super.setNome(nome);
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