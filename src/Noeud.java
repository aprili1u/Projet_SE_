public class Noeud {

    private Integer id;
    private PriorityQ Queue;

    public Noeud(Integer number){
        this.id = number;
        this.Queue = new PriorityQ(20);
    }

    public Integer getID(){
        return this.id;
    }

    public PriorityQ getQueue(){
        return this.Queue;
    }


    public boolean equals(Noeud other){
        return this.id == other.id;
    }

    public String toString(){
        return String.valueOf(this.id);
    }

    public void enterPaquet(Paquet P){
        this.Queue.insertElement(P);
    }

    public Paquet exitPaquet(){
        return this.Queue.popElement();
    }

}
