package sistema.ManagedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import sistema.Service.CampeonatoService;
import sistema.Service.CategoriaService;
import sistema.modelos.Campeonato;
import sistema.modelos.Categoria;

@ManagedBean (name = "categoriaManagedBean")
@ViewScoped
public class CategoriaManagedBean implements Serializable {

	private Categoria cat = new Categoria();
	private List<Categoria> cats;
	private CategoriaService service = new CategoriaService();
	private CampeonatoService campService = new CampeonatoService();
	private Campeonato campeonato;

	public void onRowEdit(RowEditEvent event) {

		Categoria a = ((Categoria) event.getObject());
		service.update(a);
	}

	public void save() {
		cat.setCampeonato(campeonato);
		cat = service.save(cat);
		campeonato.getCategorias().add(cat);

		if (cats != null)
			cats.add(cat);

		cat = new Categoria();
		campeonato = null;
	}
	public List<Campeonato> getCampeonatos()
	{
		return campService.getChamps();
	}
	public Categoria getCat(){
		return cat;
	}
	public void setCat(Categoria cat){
		this.cat=cat;
	}
	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
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
