package sistema.modelos;

import java.util.Date;
import java.util.List;

public class Usuario {
	private String email;
	private String nome;
	private Date dataNascimento;
	private List<Equipe> equipes;
	private List<Inscricao> inscricoes;
	private List<Campeonato> campeonatos;
	private Enum tipo;
	private String telefoneFixo;
	private String telefoneMovel;
	private String endereco;
	private String rg;
	private String cpf;
	private String cref;
	private Enum sexo;
	private String foto;
}
