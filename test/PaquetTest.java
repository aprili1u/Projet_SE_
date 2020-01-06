import org.junit.*;

import java.util.ArrayList;


public class PaquetTest {

    @Test
    public void main() {
        ArrayList s = new ArrayList(3);
        s.add(new Noeud(1));s.add(new Noeud(5));s.add(new Noeud(3));
        Noeud noeud_depart = new Noeud(1);
        Noeud noeud_destination = new Noeud(3);
        Paquet paquet = new Paquet(1, noeud_depart,noeud_destination,50,s);


        Paquet paquet2 = new Paquet(2, noeud_depart,noeud_destination,50,s);

        System.out.println(paquet.getId());
        System.out.println(paquet2.getId());
        Assert.assertEquals(paquet.getId(), 1);
        Assert.assertEquals(paquet2.getId(), 2);
    }
}
