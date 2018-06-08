package classesBasicas;

public class Cliente extends Pessoa {
	
	//Atributos exclusivos da classe Cliente
	private String passaporte, email, numeroCartao;
	Cliente(String nome, String cpf, int idade, String passaporte, String email, String numeroCartao) {
		super(nome, cpf, idade);
		this.passaporte = passaporte;
		this.email = email;
		this.numeroCartao = numeroCartao;
	}
}
