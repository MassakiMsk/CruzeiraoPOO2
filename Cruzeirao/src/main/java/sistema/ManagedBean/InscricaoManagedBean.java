package sistema.ManagedBean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;

import sistema.Service.InscricaoService;
import sistema.modelos.Inscricao;


@ManagedBean
@ViewScoped
public class InscricaoManagedBean {

	private Inscricao inscri = new Inscricao();
	private List<Inscricao> inscris;
	private InscricaoService service = new InscricaoService(); 
	
	
	public void onRowEdit(RowEditEvent event) {

		Inscricao a = ((Inscricao) event.getObject());
		service.update(a);
	}
	public void save() {
		inscri = service.save(inscri);
		
		if (inscris != null) 
			inscris.add(inscri);
		
		inscri = new Inscricao();
		
	}

	public Inscricao getInscri() {
		return inscri;
	}

	public void setInscri(Inscricao inscri) {
		this.inscri = inscri;
	}

	public List<Inscricao> getInscris() {
		if (inscris == null)
			inscris = service.getInscris();
		return inscris;
	}

	public void delete(Inscricao a) {
		service.remove(a);
		inscris.remove(a);
	}
	
	public String detailInfo(Inscricao a){
		inscri = a;
		return "LINKPARAOOUTRO SITE";
	}
	
	
	
	
	
	
	
}