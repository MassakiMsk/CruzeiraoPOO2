package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import sistema.modelos.Campeonato;
import sistema.Service.CampeonatoService;



@FacesConverter("converterCampeonato")
public class CampeonatoConverter implements Converter {

	private CampeonatoService servico = new CampeonatoService();
	
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

		
		if (value != null && !value.isEmpty()) {
			
			  for(Campeonato f : servico.getChamps())
				 if(f.getNome().equals(value))
				  	return f;
					
		}

		return null;

	}

	public String getAsString(FacesContext fc, UIComponent uic,
			Object campeonato) {
		if (campeonato == null || campeonato.equals("")) {
			return null;
		} else {
			return ((Campeonato) campeonato).getNome();

		}
	}

}
