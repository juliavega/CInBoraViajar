<<<<<<< HEAD
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
=======
package classesBasicas;

public class Cliente extends Pessoa {
	
	//Atributos exclusivos da classe Cliente
	private String passaporte, email, numeroCartao;
	public Cliente(String nome, String cpf, String dataNascimento, String passaporte, String email, String numeroCartao) {
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
>>>>>>> branch 'master' of https://github.com/tiagomoraes/CInBoraViajar.git
}