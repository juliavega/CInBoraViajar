package classesBasicas;

public class Destino {
	
	//Atributos exclusivos da classe Destino
	private String pais, cidade, hospedagem;
	
	//Construtor da classe Destino
	public Destino(String pais, String cidade, String hospedagem) {
		this.pais = pais;
		this.cidade = cidade;
		this.hospedagem = hospedagem;	
	}

	public String getPais() {
		return this.pais;
	}
	
	public String getCidade() {
		return this.cidade;
	}

	public String getHospedagem() {
		return this.hospedagem;	
	}
	
	public void setHospedagem(String hospedagem) {
		this.hospedagem = hospedagem;
	}
}