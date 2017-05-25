package sistema.modelos;

import java.util.Date;
import java.util.List;

public class Campeonato {
	private String nome;
	private List<Local> locais;
	private List<Juiz> juizes;
	private List<Categoria> categorias;
	private Date dataInicioInscricao;
	private Date dataFimInscricao;
	private Date dataInicioCampeonato;
	private Date dataFimCampeonato;
	private double valorTaxa;
}
