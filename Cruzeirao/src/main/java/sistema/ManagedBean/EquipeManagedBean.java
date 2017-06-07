package sistema.ManagedBean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;

import sistema.Service.EquipeService;
import sistema.modelos.Equipe;


@ManagedBean
@ViewScoped
public class EquipeManagedBean {

	private Equipe equi= new Equipe();
	private List<Equipe> equis;
	private EquipeService service = new EquipeService(); 
	
	
	public void onRowEdit(RowEditEvent event) {

		Equipe a = ((Equipe) event.getObject());
		service.update(a);
	}
	public void save() {
		equi= service.save(equi);
		
		if (equis != null) 
			equis.add(equi);
		
		equi= new Equipe();
		
	}

	public Equipe getEqui() {
		return equi;
	}

	public void setEqui(Equipe equi) {
		this.equi= equi;
	}

	public List<Equipe> getEquis() {
		if (equis == null)
			equis = service.getEquis();
		return equis;
	}

	public void delete(Equipe a) {
		service.remove(a);
		equis.remove(a);
	}
	
	public String detailInfo(Equipe a){
		equi= a;
		return "LINKPARAOOUTRO SITE";
	}
	
	
	
	
	
	
	
}