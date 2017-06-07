package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import sistema.modelos.Equipe;
import sistema.Service.EquipeService;



@FacesConverter("converterEquipe")
public class EquipeConverter implements Converter {

	private EquipeService servico = new EquipeService();
	
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

		
		if (value != null && !value.isEmpty()) {
			
			  for(Equipe f : servico.getEquis())
				 if(f.getNome().equals(value))
				  	return f;
					
		}

		return null;

	}

	public String getAsString(FacesContext fc, UIComponent uic,
			Object equipe) {
		if (equipe == null || equipe.equals("")) {
			return null;
		} else {
			return ((Equipe) equipe).getNome();

		}
	}

}
