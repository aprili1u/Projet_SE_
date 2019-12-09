import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
//require Junit4 to run

import static org.junit.jupiter.api.Assertions.*;

class PriorityQTest {
    @Test
    public void insertElementTest() {
        PriorityQ F = new PriorityQ(50);
        Paquet p = new Paquet(null,null,50,null);
        F.insertElement(p);
        assertEquals(F.size(), 1);
    }


    @Test
    public void popElementTest() {
        PriorityQ F = new PriorityQ(50);
        Paquet p = new Paquet(null,null,50,null);
        Paquet p1 = new Paquet(null,null,50,null);

        F.insertElement(p);
        F.insertElement(p1);

        Integer s = F.size();
        F.popElement();
        assertEquals(F.size(), s - 1);
    }

    @Test
    public void isEmptyTest() {
        PriorityQ F = new PriorityQ(10);
        Paquet p = new Paquet(null,null,50,null);
        F.insertElement(p);
        assertEquals(F.isEmpty(), false);
        F.popElement();
        assertEquals(F.isEmpty(), true);
    }

    @Test
    public void sizeTest() {
        PriorityQ F = new PriorityQ(10);
        assertEquals(F.size(), 0);
        Paquet p = new Paquet(null,null,50,null);
        Paquet p1 = new Paquet(null,null,50,null);
        F.insertElement(p);
        F.insertElement(p1);
        assertEquals(F.size(), 2);
        F.popElement();
        assertEquals(F.size(), 1);
    }
    @Test
    public void toStringTest() {
        PriorityQ F = new PriorityQ(3);
        Paquet p = new Paquet(null,null,50,null);
        Paquet p1 = new Paquet(null,null,50,null);
        F.insertElement(p);
        F.insertElement(p1);
        assertEquals(F.toString(),"[5, 2, null]");

    }

}