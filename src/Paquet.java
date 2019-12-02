public class Paquet {
    private Noeud NoeudPosition;
    private Noeud NoeudDestination;
    private Noeud NoeudDepart;
    private int Priority;
    private Noeud Trajet[];

    public Paquet (Noeud NoeudDepart,Noeud NoeudDestination, int Priority, Noeud Trajet[])  {
        this.NoeudPosition = NoeudDepart;
        this.NoeudDestination = NoeudDestination;
        this.NoeudDepart = NoeudDepart;
        this.Priority = Priority;
        this.Trajet = Trajet;
    }


    public Noeud getNoeudPosition() {
        return this.NoeudPosition;
    };

    public Noeud getNoeudDestination() {
        return this.NoeudPosition;
    };

    public Noeud getNoeudDepart () {
        return this.NoeudDepart;
    };

    public int getPriority () {
        return this.Priority;
    };

    public Noeud[] getTrajet () {
        return this.Trajet;
    };

}
