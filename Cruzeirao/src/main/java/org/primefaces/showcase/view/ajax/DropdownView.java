package org.primefaces.showcase.view.ajax;
 
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
 
@ManagedBean
@ViewScoped
public class DropdownView implements Serializable {
     
    public static String documento; 
    private Map<String,String> documentos;
     
    
    @PostConstruct
    public void init() {
        documentos  = new HashMap<String, String>();
        documentos.put("Rg", "Rg");
        documentos.put("Cpf", "Cpf");
        documentos.put("Crea", "Crea");

    }
 
    public String getDocumento() {
        return documento;
    }
 
    public void setDocumento(String documento) {
        this.documento = documento;
    }
 
    public Map<String, String> getDocumentos() {
        return documentos;
    }
     
    public void addDocumento() {
    	
    }
    
}