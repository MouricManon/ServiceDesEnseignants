package champollion;

public class ServicePrevu {
	private int volumeCM;
        private int volumeTP;
        private int volumeTD;
        private UE myUE;
        private Enseignant monEnseignant;

    public ServicePrevu(int volumeCM, int volumeTP, int volumeTD, UE myUE, Enseignant monEnseignant) {
        this.volumeCM = volumeCM;
        this.volumeTP = volumeTP;
        this.volumeTD = volumeTD;
        this.myUE = myUE;
        this.monEnseignant = monEnseignant;
    }

    public int getVolumeCM() {
        return volumeCM;
    }

    public int getVolumeTP() {
        return volumeTP;
    }

    public int getVolumeTD() {
        return volumeTD;
    }

    public UE getMyUE() {
        return myUE;
    }
        
        
        
        

}
