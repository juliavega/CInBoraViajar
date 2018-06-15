package cadastro;

import classesBasicas.PacoteViagem;
import erros.PacoteJaCadastradoException;
import erros.PacoteNaoEncontradoException;
import interfaces.RepositorioPacoteViagem;
import repositorios.RepositorioArrayPacoteViagem;
import repositorios.RepositorioListaPacoteViagem;

public class CadastroPacoteViagem {
	private RepositorioPacoteViagem pacotes;

	public CadastroPacoteViagem(boolean tipo) {
			if (tipo) {
				this.pacotes = new RepositorioListaPacoteViagem();
			} else {			
				this.pacotes = new RepositorioArrayPacoteViagem();
			}
		}

	public void cadastrar(PacoteViagem pacote) throws PacoteJaCadastradoException, PacoteNaoEncontradoException {
		if (!this.pacotes.existe(pacote.getId())) {
			this.pacotes.inserir(pacote);
		} else {
			PacoteJaCadastradoException e;
			e = new PacoteJaCadastradoException();
			throw e;
		}
	}

	public void remover(String id) throws PacoteNaoEncontradoException {
		this.pacotes.remover(id);
	}

	public void atualizar(PacoteViagem pacote) throws PacoteNaoEncontradoException {
		this.pacotes.atualizar(pacote);
	}

	public PacoteViagem procurar(String id) throws PacoteNaoEncontradoException {
		return this.pacotes.procurar(id);
	}
}
