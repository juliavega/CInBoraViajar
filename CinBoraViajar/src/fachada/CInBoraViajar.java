package fachada;

import cadastro.CadastroCliente;
import cadastro.CadastroDestino;
import cadastro.CadastroFuncionario;
import cadastro.CadastroPacoteViagem;
import classesBasicas.Cliente;
import classesBasicas.Destino;
import classesBasicas.PacoteViagem;
import erros.ClienteInvalidoException;
import erros.ClienteJaCadastradoException;
import erros.ClienteNaoEncontradoException;
import erros.DestinoInvalidoException;
import erros.LimiteAtingidoException;
import erros.PacoteJaCadastradoException;
import erros.PacoteNaoEncontradoException;

public class CInBoraViajar {
	private CadastroCliente clientes;
	private CadastroFuncionario funcionarios;
	private CadastroDestino destinos;
	private CadastroPacoteViagem pacotesViagem;
	
	public void cadastrarCliente(Cliente cliente) throws LimiteAtingidoException, ClienteJaCadastradoException{
		clientes.cadastrar(cliente);
	}
	
	public void removerCliente(String cpf) throws ClienteNaoEncontradoException {
		clientes.remover(cpf);
	}
	
	public void atualizarCliente(Cliente cliente) throws ClienteNaoEncontradoException {
		clientes.atualizar(cliente);
	}
	
	public Cliente procurarCliente(String cpf) throws ClienteNaoEncontradoException {
		return clientes.procurar(cpf);
	}
	
	public void cadastrarPacote(PacoteViagem pacote) throws PacoteJaCadastradoException, PacoteNaoEncontradoException, DestinoInvalidoException, ClienteInvalidoException {
		Destino d = pacote.getDestino();
		Cliente c = pacote.getCliente();
		if (destinos.existe(d.getCidade()) && clientes.existe(c.getCpf())) {
			pacotesViagem.cadastrar(pacote);
		} else if (!destinos.existe(d.getCidade())){
			DestinoInvalidoException e;
			e = new DestinoInvalidoException();
			throw e;
		} else {
			ClienteInvalidoException e;
			e = new ClienteInvalidoException();
			throw e;
		}
	}
	
	public void removerPacote(String id) throws PacoteNaoEncontradoException {
		pacotesViagem.remover(id);
	}
	
	public void atualizarPacote(PacoteViagem pacote) throws PacoteNaoEncontradoException {
		pacotesViagem.atualizar(pacote);
	}
	
	public PacoteViagem procurarPacote(String id) throws PacoteNaoEncontradoException {
		return pacotesViagem.procurar(id);
	}
	
	
	
}
