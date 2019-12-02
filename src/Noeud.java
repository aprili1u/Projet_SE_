public class Noeud {

    private Integer id;
    private PriorityQ Queue;

    public Noeud(Integer number){
        this.id = number;
        this.Queue = new PriorityQ();
    }

    public Integer getID(){
        return this.id;
    }

    public PriorityQ getQueue(){
        return this.Queue;
    }

    public void enterPackage(Paquet P){
    }

    public Paquet exitPackage(){
        return new Paquet();
    }
}
