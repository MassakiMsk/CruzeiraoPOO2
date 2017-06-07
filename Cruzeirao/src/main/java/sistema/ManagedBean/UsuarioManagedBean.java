package sistema.ManagedBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import sistema.Service.UsuarioService;
import sistema.modelos.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioManagedBean {

	private Usuario user = new Usuario();
	private List<Usuario> users;
	private UsuarioService service = new UsuarioService(); 
	
	
	public void onRowEdit(RowEditEvent event) {

		Usuario a = ((Usuario) event.getObject());
		service.update(a);
	}
	public void save() {
		user = service.save(user);
		
		if (users != null) 
			users.add(user);
		
		user = new Usuario();
		
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public List<Usuario> getUsers() {
		if (users == null)
			users = service.getUsers();
		return users;
	}

	public void delete(Usuario a) {
		service.remove(a);
		users.remove(a);
	}
	
	public String detailInfo(Usuario a){
		user = a;
		return "LINKPARAOOUTRO SITE";
	}
	
}
