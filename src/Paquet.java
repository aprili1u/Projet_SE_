packageNoeud;

public class Paquet {
    private Noeud NoeudPosition;
    private Noeud NoeudDestination;
    private Noeud NoeudDepart;
    private int Priority;
    private Noeud Trajet[];

    public Paquet (Noeud NoeudDepart,Noeud NoeudDestination, int Priority, Noeud Trajet[])  {
        this.NoeudPosition = NoeudDepart;
    }


    public getNoeudPosition() {
        return this.NoeudPosition;
    };

    public getNoeudDestination() {
        return this.NoeudPosition;
    };

    public getNoeudDepart () {
        return this.NoeudDepart;
    };

    public getPriority () {
        return this.Priority;
    };

    public getTrajet () {
        return this.Trajet;
    };

}
