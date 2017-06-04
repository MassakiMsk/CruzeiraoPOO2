package org.primefaces.showcase.view.data;
 
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import sistema.modelos.Partida;
 
@ManagedBean
@ViewScoped
public class DataGridView implements Serializable {
     
    private List<Partida> partidas;
     
    private Partida selectedPartida;
     
    @PostConstruct
    public void init() {
        
    }
 
    public List<Partida> getPartidas() {
        return partidas;
    }
 
    public Partida getSelectedPartida() {
        return selectedPartida;
    }
 
    public void setSelectedPartida(Partida selectedPartida) {
        this.selectedPartida = selectedPartida;
    }
}