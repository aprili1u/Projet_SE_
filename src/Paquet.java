import java.util.ArrayList;

public class Paquet {
    private Noeud NoeudPosition;
    private Noeud NoeudDestination;
    private Noeud NoeudDepart;
    private int Priority;
    private int ID;
    private ArrayList<Noeud> Trajet;

    public Paquet (int ID, Noeud NoeudDepart, Noeud NoeudDestination, int Priority, ArrayList<Noeud> Trajet)  {
        this.NoeudPosition = NoeudDepart;
        this.NoeudDestination = NoeudDestination;
        this.NoeudDepart = NoeudDepart;
        this.Priority = Priority;
        this.Trajet = Trajet;
        this.ID = ID;
    }

    public Noeud getNoeudPosition() {
        return this.NoeudPosition;
    };

    public void setNoeudPosition(Noeud position) { this.NoeudPosition = position; }

    public Noeud getNoeudDestination() {
        return this.NoeudDestination;
    };

    public Noeud getNoeudDepart () {
        return this.NoeudDepart;
    };

    public int getPriority () {
        return this.Priority;
    };

    public int getId() { return this.ID; };

    public ArrayList<Noeud> getTrajet () {
        return this.Trajet;
    };


    public void setTrajet(ArrayList<Noeud> trajet) { this.Trajet = trajet;}


    public boolean equals(Paquet other) {
        return this.ID == other.ID;
    }

    public String toString(){
        return String.valueOf(this.ID);
    }
}
