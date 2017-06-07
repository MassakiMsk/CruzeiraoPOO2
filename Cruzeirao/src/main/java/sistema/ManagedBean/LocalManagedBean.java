package sistema.ManagedBean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;

import sistema.Service.LocalService;
import sistema.modelos.Local;

@ManagedBean
@ViewScoped
public class LocalManagedBean {
	
	private Local local = new Local();
	private List<Local> locais;
	private LocalService service = new LocalService();
	
	public void onRowEdit(RowEditEvent event){
		Local l = ((Local) event.getObject());
		service.update(l);
	}
	public void save(){
		local = service.save(local);
		
		if(locais != null)
			locais.add(local);
		
		local = new Local();
	}
	public Local getLocal() {
		return local;
	}
	public void setLocal(Local local) {
		this.local = local;
	}
	public List<Local> getLocais() {
		if (locais == null)
			locais = service.getLocais();
		return locais;
	}
	public void delete(Local l) {
		service.remove(l);
		locais.remove(l);
	}
	public String detailInfo(Local l) {
		local = l;
		return "LINKPARAOOUTRO SITE";
	}
}
