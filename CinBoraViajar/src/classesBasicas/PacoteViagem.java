package classesBasicas;

public class PacoteViagem {
	
	//Atributos exclusivos da classe PacoteViagem
	private String tipo;
	private Cliente cliente;
	private Destino destino;
	private double valor;
	private int duracao;
	
	//Construtor da classe PacoteViagem
	public PacoteViagem (String tipo, Cliente cliente, Destino destino, double valor, int duracao) {
		this.tipo = tipo;
		this.cliente = cliente;
		this.destino = destino;
		this.valor = valor;
		this.duracao = duracao;
	}
}