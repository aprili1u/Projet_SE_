import java.util.ArrayList;
import java.util.List;
//require Junit4 to run

import static org.junit.jupiter.api.Assertions.*;

class PriorityQTest {
    @org.junit.jupiter.api.Test
    public void insertElementTest() {
        PriorityQ F = new PriorityQ(50);
        Paquet p = new Paquet(1, null,null,50,null);
        F.insertElement(p);
        assertEquals(F.size(), 1);
    }


    @org.junit.jupiter.api.Test
    public void popElementTest() {
        PriorityQ F = new PriorityQ(50);
        Paquet p = new Paquet(1, null,null,50,null);
        Paquet p1 = new Paquet(2, null,null,50,null);

        F.insertElement(p);
        F.insertElement(p1);

        int s = F.size();
        F.popElement();
        assertEquals(F.size(), s - 1);
    }

    @org.junit.jupiter.api.Test
    public void isEmptyTest() {
        PriorityQ F = new PriorityQ(10);
        Paquet p = new Paquet(1, null,null,50,null);
        F.insertElement(p);
        assertFalse(F.isEmpty());
        F.popElement();
        assertTrue(F.isEmpty());
    }

    @org.junit.jupiter.api.Test
    public void sizeTest() {
        PriorityQ F = new PriorityQ(10);
        assertEquals(F.size(), 0);
        Paquet p = new Paquet(1, null,null,50,null);
        Paquet p1 = new Paquet(2, null,null,50,null);
        F.insertElement(p);
        F.insertElement(p1);
        assertEquals(F.size(), 2);
        F.popElement();
        assertEquals(F.size(), 1);
    }
    @org.junit.jupiter.api.Test
    public void toStringTest() {
        PriorityQ F = new PriorityQ(3);
        Paquet p = new Paquet(1, null,null,50,null);
        Paquet p1 = new Paquet(2, null,null,50,null);
        F.insertElement(p);
        F.insertElement(p1);
        assertEquals("["+p.toString()+", "+p1.toString()+", null]", F.toString());
    }

}