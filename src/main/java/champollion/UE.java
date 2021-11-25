package champollion;

import java.util.ArrayList;

public class UE {
    private final String myIntitule;
    private int heureTD;
    private int heureTP;
    private int heureCM;
    private ArrayList<Intervention> lesInterventions;
    private ArrayList<Enseignant> lesEnseignants ;

    public UE(String intitule) {
        myIntitule = intitule;
    }

    public String getIntitule() {
        return myIntitule;
    }

    public int getHeureTD() {
        return heureTD;
    }

    public int getHeureTP() {
        return heureTP;
    }

    public int getHeureCM() {
        return heureCM;
    }
    

    
}
