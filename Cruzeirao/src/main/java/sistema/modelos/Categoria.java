package sistema.modelos;

import java.util.List;

public class Categoria {
	private String nome;
	private int nascidosApartirDe;
	private List<Inscricao> inscricoes;
	private Campeonato campeonato;
	private int minJogadores;
	private int maxJogadores;
	private Enum sexo;
}
