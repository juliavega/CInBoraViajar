package cadastro;

import classesBasicas.Cliente;
import erros.LimiteAtingidoException;
import interfaces.RepositorioCliente;

public class CadastroCliente {
	private RepositorioCliente clientes;
	
	public CadastroCliente(RepositorioCliente rep) {
		this.clientes = rep;
	}
	public void cadastrar (Cliente cliente) throws LimiteAtingidoException,  {
		this.clientes.inserir(cliente);
	}
}
