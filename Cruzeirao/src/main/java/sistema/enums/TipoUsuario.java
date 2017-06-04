package sistema.enums;

public enum TipoUsuario {
	ADMINISTRADOR("Administrador"),USUARIO("Usuario"),ORGANIZADOR("Organizador"),
	JOGADOR("Jogador"),DIRETOR("Diretor"),PREPARADOR_FISICO("Preparador Fisico"),
	MASSAGISTA("Massagista"),TECNICO("Tecnico");
	private String tipo;

	TipoUsuario(String tipo) {
		setTipo(tipo);
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
