package champollion;

import java.util.Date;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {

    Enseignant untel;
    UE uml, java;

    @BeforeEach
    public void setUp() {
        untel = new Enseignant("untel", "untel@gmail.com");
        uml = new UE("UML");
        java = new UE("Programmation en java");
    }

    @Test
    public void testNouvelEnseignantSansService() {
        assertEquals(0, untel.heuresPrevues(),
                "Un nouvel enseignant doit avoir 0 heures prévues");
    }

    @Test
    public void testAjouteHeures() {
        // 10h TD pour UML
        untel.ajouteEnseignement(uml, 0, 10, 0);

        assertEquals(10, untel.heuresPrevuesPourUE(uml),
                "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

        // 20h TD pour UML
        untel.ajouteEnseignement(uml, 0, 20, 0);

        assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");

    }

    @Test
    public void testHeurePrevues() {
        untel.ajouteEnseignement(uml, 2, 10, 4);
        assertEquals(16, untel.heuresPrevues(),
                "Le nombre d'heures prévues ne correspond pas");

    }

    @Test
    public void testSousService() {
        untel.ajouteEnseignement(uml, 2, 10, 4);
        assertTrue(untel.enSousService(), "L'enseignant est sensé être en sous service");
    }

    @Test
    public void testSousServicenon() {
        untel.ajouteEnseignement(uml, 2, 192, 4);
        assertFalse(untel.enSousService(), "L'enseignant est sensé ne pas être en sous service");
    }

    @Test
    public void testResteaplanifCMBon() {
        untel.ajouteEnseignement(uml, 4, 0, 0);
        Date debut = new Date();
        Salle s = new Salle("umlsalle");
        Intervention inter = new Intervention(debut, 4, 14, s, TypeIntervention.CM, uml);
        untel.ajouteintervention(inter);
        assertEquals(0, untel.resteAPlanifier(uml, TypeIntervention.CM), "le nbre d'heures à planifier est de 0");
    }

    @Test
    public void testResteaplanifTPbon() {
        untel.ajouteEnseignement(uml, 0, 0, 4);
        Date debut = new Date();
        Salle s = new Salle("umlsalle");
        Intervention interv = new Intervention(debut, 4, 14, s, TypeIntervention.TP, uml);
        untel.ajouteintervention(interv);
        untel.resteAPlanifier(uml, TypeIntervention.TP);
        assertEquals(0, untel.resteAPlanifier(uml, TypeIntervention.TP), "le nbre d'heures à planifier est de 0");
    }

    @Test
    public void testResteaplanifTDbon() {
        untel.ajouteEnseignement(uml, 0, 4, 0);
        Date debut = new Date();
        Salle s = new Salle("umlsalle");
        Intervention interv = new Intervention(debut, 4, 14, s, TypeIntervention.TD, uml);
        untel.ajouteintervention(interv);
        untel.resteAPlanifier(uml, TypeIntervention.TD);
        assertEquals(0, untel.resteAPlanifier(uml, TypeIntervention.TD), "le nbre d'heures à planifier est de 0");
    }

    @Test
    public void testResteaplanifCMPasBon() {
        untel.ajouteEnseignement(uml, 4, 0, 0);
        Date debut = new Date();
        Salle s = new Salle("umlsalle");
        Intervention interv = new Intervention(debut, 2, 14, s, TypeIntervention.CM, uml);
        untel.ajouteintervention(interv);
        assertEquals(2, untel.resteAPlanifier(uml, TypeIntervention.CM), "Il ne manque pas 2 h à planifier");
    }

    @Test
    public void testResteaplanifTPPasbon() {
        untel.ajouteEnseignement(uml, 0, 0, 4);
        Date debut = new Date();
        Salle s = new Salle("umlsalle");
        Intervention interv = new Intervention(debut, 2, 14, s, TypeIntervention.TP, uml);
        untel.ajouteintervention(interv);
        assertEquals(2, untel.resteAPlanifier(uml, TypeIntervention.TP), "Il ne manque pas 2 h à planifier");

    }

    @Test
    public void testResteaplanifTDPasbon() {
        untel.ajouteEnseignement(uml, 0, 4, 0);
        Date debut = new Date();
        Salle s = new Salle("umlsalle");
        Intervention interv = new Intervention(debut, 2, 14, s, TypeIntervention.TD, uml);
        untel.ajouteintervention(interv);
        assertEquals(2, untel.resteAPlanifier(uml, TypeIntervention.TD), "Il ne manque pas 2 h à planifier");

    }
}
