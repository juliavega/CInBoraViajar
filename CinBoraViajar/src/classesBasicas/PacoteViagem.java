package classesBasicas;

import erros.valorPacoteInvalidoException;

public class PacoteViagem {
	
	//Atributos exclusivos da classe PacoteViagem
	private String tipo;
	private Cliente cliente;
	private Destino destino;
	private double valor;
	private int duracao;
	
	//Construtor da classe PacoteViagem
	public PacoteViagem (String tipo, Cliente cliente, Destino destino, double valor, int duracao) 
			throws valorPacoteInvalidoException {
		this.tipo = tipo;
		this.cliente = cliente;
		this.destino = destino;
		
		// Verifica se o valor do pacote é menor que 0
		if (valor >= 0) {			
			this.valor = valor;
		} else {
			valorPacoteInvalidoException e;
			e = new valorPacoteInvalidoException();
			throw e;
		}
		this.duracao = duracao;
	}
}