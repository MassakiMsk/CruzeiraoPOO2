package org.primefaces.showcase.view.panel;
 
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.xml.ws.RespectBinding;

import org.primefaces.event.FlowEvent;
import org.primefaces.showcase.domain.User;
import org.primefaces.showcase.view.ajax.*;

@ManagedBean
@ViewScoped
public class UserWizard implements Serializable {
 
    private User user = new User();
    private String documento;
    private DropdownView dv = new DropdownView();
    private boolean skip;
    
    public Map<String, String> getDocumentos() {
        return dv.getDocumentos();
    }
    
    public void addDocumento(String documento) {
    	this.documento = documento;
    	String infoDoc;
    	infoDoc = DropdownView.documento;
    	user.addInfoDoc(documento, infoDoc);
    }
    
    public User getUser() {
        return user;
    }
 
    public void setUser(User user) {
        this.user = user;
    }
     
    
    public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public void save() throws IOException {        
        FacesMessage msg = new FacesMessage("Successful", "Welcome :" + user.getNome());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
    }
     
    public boolean isSkip() {
        return skip;
    }
 
    public void setSkip(boolean skip) {
        this.skip = skip;
    }
     
    public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
    
}