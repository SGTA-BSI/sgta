package com.sgta.usuario.negocio;
import com.sgta.usuario.dominio.Pessoa;

public class SessaoUsuario {
	private Pessoa usuarioLogado;
	private Pessoa alunoSelecionado;
	private static SessaoUsuario instancia = new SessaoUsuario();
	/** M�todo construtor da Classe.
	 */
	private SessaoUsuario() {
	}
	/** M�todo respons�vel para o retorno da inst�ncia do objeto SessaoUsuario
	 * @return instancia do tipo 'SessaoUsuario'.
	 */
	public static SessaoUsuario getInstancia() {
		return instancia;
	}
	public Pessoa getUsuarioLogado() {
		return this.usuarioLogado;
	}
	public void setUsuarioLogado(Pessoa usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	public Pessoa getAlunoSelecionado() {
		return this.alunoSelecionado;
	}
	public void setAlunoSelecionado(Pessoa alunoSelecionado) {
		this.alunoSelecionado = alunoSelecionado;
	}

	
}

