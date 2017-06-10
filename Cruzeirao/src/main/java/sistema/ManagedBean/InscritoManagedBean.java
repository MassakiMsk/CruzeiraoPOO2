package sistema.ManagedBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import sistema.Service.InscritoService;
import sistema.modelos.Inscrito;

@ManagedBean
@ViewScoped
public class InscritoManagedBean {
	private Inscrito inscrito = new Inscrito();
	private List<Inscrito> inscritos;
	private InscritoService service = new InscritoService(); 
	
	
	public void onRowEdit(RowEditEvent event) {

		Inscrito a = ((Inscrito) event.getObject());
		service.update(a);
	}
	public void save() {
		inscrito = service.save(inscrito);
		
		if (inscritos != null) 
			inscritos.add(inscrito);
		
		inscrito = new Inscrito();
		
	}

	public Inscrito getInscrito() {
		return inscrito;
	}

	public void setInscrito(Inscrito inscrito) {
		this.inscrito = inscrito;
	}

	public List<Inscrito> getInscritos() {
		if (inscritos == null)
			inscritos = service.getInscritos();
		return inscritos;
	}

	public void delete(Inscrito a) {
		service.remove(a);
		inscritos.remove(a);
	}
	
	public String detailInfo(Inscrito a){
		inscrito = a;
		return "LINKPARAOOUTRO SITE";
	}
}
