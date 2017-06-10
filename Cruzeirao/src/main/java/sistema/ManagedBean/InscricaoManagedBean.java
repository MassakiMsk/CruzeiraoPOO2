package sistema.ManagedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import sistema.Service.InscricaoService;
import sistema.modelos.Equipe;
import sistema.modelos.Inscricao;
import sistema.modelos.Inscrito;
import sistema.modelos.Usuario;

@ManagedBean
@ViewScoped
public class InscricaoManagedBean {
	private Inscricao inscricao = new Inscricao();
	private List<Inscricao> inscricaos;
	private Inscrito inscrito = new Inscrito();
	private InscricaoService service = new InscricaoService(); 
	private Equipe equipe = new Equipe();
	
	
	public ArrayList<Usuario> jogadores(Equipe e) {
		ArrayList<Usuario> a = new ArrayList<Usuario>();
		for(Inscricao i : inscricaos) {
			if(i.getEquipe().equals(e))
				for(Inscrito u : i.getInscritos())
				a.add(u.getUsuario());
		}
		
		return a;
	}
	
	public void onRowEdit(RowEditEvent event) {

		Inscricao a = ((Inscricao) event.getObject());
		service.update(a);
	}
	public void save() {
		inscricao.setEquipe(equipe);
		inscricao.getInscritos().add(inscrito);
		equipe = new Equipe();
		inscrito = new Inscrito();
		inscricao = service.save(inscricao);
		
		if (inscricaos != null) 
			inscricaos.add(inscricao);
		
		inscricao = new Inscricao();
		
	}

	public Inscrito getInscrito() {
		return inscrito;
	}
	public void setInscrito(Inscrito inscrito) {
		this.inscrito = inscrito;
	}
	public Equipe getEquipe() {
		return equipe;
	}
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	public Inscricao getInscricao() {
		return inscricao;
	}

	public void setInscricao(Inscricao inscricao) {
		this.inscricao = inscricao;
	}

	public List<Inscricao> getInscricaos() {
		if (inscricaos == null)
			inscricaos = service.getInscricaos();
		return inscricaos;
	}

	public void delete(Inscricao a) {
		service.remove(a);
		inscricaos.remove(a);
	}
	
	public String detailInfo(Inscricao a){
		inscricao = a;
		return "LINKPARAOOUTRO SITE";
	}
}
