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

    public void enterPaquet(Paquet P){
        this.Queue.insertElement(P);
    }

    public Paquet exitPaquet(){
        return this.Queue.popElement();
    }
}
