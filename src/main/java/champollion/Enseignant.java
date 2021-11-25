package champollion;

import static java.lang.Math.round;
import java.util.ArrayList;
import java.util.HashMap;

public class Enseignant extends Personne {
private ArrayList<Intervention> lesInterventions = new  ArrayList<Intervention>();
//private ArrayList<UE> lesUE;
private ArrayList<ServicePrevu> servicePrevu= new ArrayList<ServicePrevu>(); ;
    // TODO : rajouter les autres méthodes présentes dans le diagramme UML

    public Enseignant(String nom, String email) {
        super(nom, email);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        float heuresPrevues = 0;
      for(ServicePrevu c : servicePrevu){
          heuresPrevues+= c.getVolumeTD();
           heuresPrevues+= (c.getVolumeCM()*1.5);
            heuresPrevues+= (c.getVolumeTP()*0.75);
      }
      return round(heuresPrevues) ;
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        float heuresPrevues = 0;
        for(ServicePrevu c : this.servicePrevu){
            if(c.getMyUE() ==ue){
          heuresPrevues+= c.getVolumeTD();
           heuresPrevues+= (c.getVolumeCM()*1.5);
            heuresPrevues+= (c.getVolumeTP()*0.75);
        }
        }
      return round(heuresPrevues) ;
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        ServicePrevu service= new ServicePrevu(volumeCM,volumeTP,volumeTD,ue,this);
        servicePrevu.add(service);
    }
    
    public void ajouteintervention(Intervention interv){
        lesInterventions.add(interv);
    }

    public boolean enSousService(){
        boolean ensous = true;
        if(this.heuresPrevues()>=192){
        ensous = false; 
        }
        return ensous;
    }
    
    public int resteAPlanifier(UE ue, TypeIntervention type){
        int planifier = 0;
        int total = 0;
        for(ServicePrevu p :servicePrevu){
            if(p.getMyUE()==ue){
            if(TypeIntervention.CM==type){
                total+= (p.getVolumeCM());
            }
            if(TypeIntervention.TD==type){
                total+= (p.getVolumeTD());
            }
            if(TypeIntervention.TP==type){
                total+= (p.getVolumeTP());
            }
        }
        }
        for(Intervention i : lesInterventions){
            if(i.getUe()==ue){
            if(i.getTypeIntervention()== TypeIntervention.CM){
                    planifier+= (i.getDuree());
            }
            if(i.getTypeIntervention()== TypeIntervention.TD){
                    planifier+= (i.getDuree());
            }
            if(i.getTypeIntervention()== TypeIntervention.TP){
                    planifier+= (i.getDuree());
            }
        }
        }
          return total-planifier;
    }
    
}
