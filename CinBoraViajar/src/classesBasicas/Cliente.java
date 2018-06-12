package classesBasicas;

import erros.cpfInvalidoException;
import erros.nomeMuitoLongoException;
import erros.passaporteInvalidoException;

public class Cliente extends Pessoa {

	// Atributos exclusivos da classe Cliente
	private String passaporte, email, numeroCartao;

	// Construtor classe Cliente
	public Cliente(String nome, String cpf, String dataNascimento, String email, String numeroCartao)
			throws nomeMuitoLongoException, cpfInvalidoException {
		super(nome, cpf, dataNascimento);
		this.passaporte = null;
		this.email = email;
		this.numeroCartao = numeroCartao;
	}

	// Metodos
	public void setPassaporte(String passaporte) throws passaporteInvalidoException {
		
		// Checa o tamanho do passaporte v�lido
		if (passaporte.length() == 8) {
			this.passaporte = passaporte;
			
		// Erro se for inv�lido (diferente de 8)
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
}