package sistema.modelos;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Equipe {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigoEquipe;
	
	private String nome;
	@Temporal(TemporalType.DATE)
	private Date dataFundacao;
	private String cidade;
	@ManyToMany
	private List<Usuario> diretores;
	private Campeonato campeonato;
	
	public Campeonato getCampeonato() {
		return campeonato;
	}
	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}
	public int getCodigoEquipe() {
		return codigoEquipe;
	}
	public void setCodigoEquipe(int codigoEquipe) {
		this.codigoEquipe = codigoEquipe;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataFundacao() {
		return dataFundacao;
	}
	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public List<Usuario> getDiretores() {
		return diretores;
	}
	public void setDiretores(List<Usuario> diretores) {
		this.diretores = diretores;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
