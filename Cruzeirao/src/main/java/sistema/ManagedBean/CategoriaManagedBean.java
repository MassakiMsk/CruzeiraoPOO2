package sistema.ManagedBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import sistema.Service.CategoriaService;
import sistema.modelos.Categoria;

@ManagedBean
@ViewScoped
public class CategoriaManagedBean {

	private Categoria cat = new Categoria();
	private List<Categoria> cats;
	private CategoriaService service = new CategoriaService();

	public void onRowEdit(RowEditEvent event) {

		Categoria a = ((Categoria) event.getObject());
		service.update(a);
	}

	public void save() {
		cat = service.save(cat);

		if (cats != null)
			cats.add(cat);

		cat = new Categoria();
	}
	
	public Categoria getCat(){
		return cat;
	}
	public void setCat(Categoria cat){
		this.cat=cat;
	}
	
	public List<Categoria> getCats(){
		if(cats==null)
			cats=service.getCats();
		return cats;
	}
	
	public void delete(Categoria a){
		service.remove(a);
		cats.remove(a);
	}
	
	public String detailInfo(Categoria a){
		cat = a;
		return "LINK PARA OUTRO SITE";
	}
}
