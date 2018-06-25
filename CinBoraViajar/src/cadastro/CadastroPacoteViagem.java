package cadastro;

import classesBasicas.PacoteViagem;
import erros.LimiteAtingidoException;
import erros.PacoteJaCadastradoException;
import erros.PacoteNaoEncontradoException;
import interfaces.RepositorioPacoteViagem;
import repositorios.RepositorioArrayPacoteViagem;
import repositorios.RepositorioListaPacoteViagem;

public class CadastroPacoteViagem {
	private RepositorioPacoteViagem pacotes;

	// se o construtor receber um parâmtro true, inicializa uma lista, senão, um array
	public CadastroPacoteViagem(boolean tipo) {
			if (tipo) {
				this.pacotes = new RepositorioListaPacoteViagem();
			} else {			
				this.pacotes = new RepositorioArrayPacoteViagem();
			}
		}

	// checa se o pacote de viagem já está cadastrado. Se não estiver, o cadastra
	public void cadastrar(PacoteViagem pacote) throws PacoteJaCadastradoException, LimiteAtingidoException {
		if (!this.pacotes.existe(pacote.getId())) {
			this.pacotes.inserir(pacote);
		} else {
			PacoteJaCadastradoException e;
			e = new PacoteJaCadastradoException();
			throw e;
		}
	}

	// chama o remover da interface
	public void remover(String id) throws PacoteNaoEncontradoException {
		this.pacotes.remover(id);
	}

	// chama o atualizar da interface
	public void atualizar(PacoteViagem pacote) throws PacoteNaoEncontradoException {
		this.pacotes.atualizar(pacote);
	}

	// chama o procurar da interface
	public PacoteViagem procurar(String id) throws PacoteNaoEncontradoException {
		return this.pacotes.procurar(id);
	}
	
	// chama o existe da interface
	public boolean existe (String id) {
		return this.pacotes.existe(id);
	}
}
