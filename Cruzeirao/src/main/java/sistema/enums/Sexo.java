package sistema.enums;

public enum Sexo {
	MASCULINO("Masculino"), FEMININO("Feminino");
	private String sexo;
	
	private Sexo(String valor)
	{
		setSexo(valor);
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}
