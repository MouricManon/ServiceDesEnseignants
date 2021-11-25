package champollion;


import java.util.Date;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manon
 */
public class Intervention {
    private Date debut;
    private int duree;
    private boolean annuler = false ;
    private int heureDebut;
    private Salle salle;
    private TypeIntervention  TypeIntervention ;
    private UE ue ;

    public Intervention(Date debut, int duree, int heureDebut, Salle salle, TypeIntervention TypeIntervention, UE ue) {
        this.debut = debut;
        this.duree = duree;
        this.heureDebut = heureDebut;
        this.salle = salle;
        this.TypeIntervention = TypeIntervention;
        this.ue = ue;
    }

    public Date getDebut() {
        return debut;
    }

    public int getDuree() {
        return duree;
    }

    public boolean isAnnuler() {
        return annuler;
    }

    public int getHeureDebut() {
        return heureDebut;
    }

    public Salle getSalle() {
        return salle;
    }

    public TypeIntervention getTypeIntervention() {
        return TypeIntervention;
    }

    public UE getUe() {
        return ue;
    }
   
    
    
}
