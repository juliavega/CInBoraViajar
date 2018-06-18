package classesBasicas;

import erros.CpfInvalidoException;
import erros.DataNascimentoInvalidaException;
import erros.EmailInvalidoException;
import erros.NomeMuitoLongoException;
import erros.NumeroCartaoInvalidoException;
import erros.PassaporteInvalidoException;

public class Cliente extends Pessoa {

	// Atributos exclusivos da classe Cliente
	private String email, numeroCartao;

	// Construtor classe Cliente
	public Cliente(String nome, String cpf, String dataNascimento, String email, String numeroCartao)
			throws NomeMuitoLongoException, CpfInvalidoException, NumeroCartaoInvalidoException, EmailInvalidoException,
			DataNascimentoInvalidaException {
		super(nome, cpf, dataNascimento);
		
		if (email.contains("@")) {
			this.email = email;
		} else {
			EmailInvalidoException e;
			e = new EmailInvalidoException();
			throw e;
		}

		// Checa a quantidade de digitos do n�mero do cart�o
		if (numeroCartao.length() == 16) {
			this.numeroCartao = numeroCartao;

			// Erro se for inv�lido
		} else {
			NumeroCartaoInvalidoException e;
			e = new NumeroCartaoInvalidoException();
			throw e;
		}
	}

	// Metodos
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

	// Chama o m�todo setNome da abstrata
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