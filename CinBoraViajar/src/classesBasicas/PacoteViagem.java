package classesBasicas;

import erros.ValorPacoteInvalidoException;

public class PacoteViagem {
	
	//Atributos exclusivos da classe PacoteViagem
	private String tipo;
	private Cliente cliente;
	private Destino destino;
	private double valor;
	private int duracao;
	private String id;
	//Construtor da classe PacoteViagem
	public PacoteViagem (String tipo, Cliente cliente, Destino destino, double valor, int duracao, String id) 
			throws ValorPacoteInvalidoException {
		this.tipo = tipo;
		this.cliente = cliente;
		this.destino = destino;
		
		// *FALTA CRIAR ERRO ID JA EXISTE
		this.id = id;
		
		// Verifica se o valor do pacote � menor que 0
		if (valor >= 0) {			
			this.valor = valor;
		} else {
			ValorPacoteInvalidoException e;
			e = new ValorPacoteInvalidoException();
			throw e;
		}
		this.duracao = duracao;
	}
	public String getId() {
		return this.id;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	public Destino getDestino() {
		return this.destino;
	}
	
	public Double getValor() {
		return this.valor;
	}
	
	public int getDuracao() {
		return this.duracao;
	}
	
}