import java.util.ArrayList;

public class Paquet {
    private ArrayList Position;
    private Noeud NoeudDestination;
    private Noeud NoeudDepart;
    private int Priority;
    private ArrayList<Noeud> Trajet;
    private static int conteur = 0;
    private int id;


    public Paquet (Noeud NoeudDepart,Noeud NoeudDestination, int Priority, ArrayList<Noeud> Trajet)  {
        this.Position = new ArrayList();
        this.Position.add(NoeudDepart);
        this.Position.add(Trajet.get(1));
        this.Position.add(0);
        this.NoeudDestination = NoeudDestination;
        this.NoeudDepart = NoeudDepart;
        this.Priority = Priority;
        this.Trajet = Trajet;
        this.id = ++conteur;
    }

    public int getId() { return this.id; }


    public ArrayList getPosition() {
        return this.Position;
    };

    public Noeud getNoeudDestination() {
        return this.NoeudDestination;
    };

    public Noeud getNoeudDepart () {
        return this.NoeudDepart;
    };

    public int getPriority () {
        return this.Priority;
    };

    public ArrayList<Noeud> getTrajet () {
        return this.Trajet;
    };

}
