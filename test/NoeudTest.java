import static org.junit.jupiter.api.Assertions.*;

class NoeudTest {

    @org.junit.jupiter.api.Test
    void getID() {
        Noeud node = new Noeud(7);
        assertEquals(node.getID(),7);
    }

    @org.junit.jupiter.api.Test
    void getQueue() {
        Noeud node = new Noeud(7);
        assertTrue(node.getQueue().isEmpty());
    }

    @org.junit.jupiter.api.Test
    void enterPaquet() {
        Noeud node = new Noeud(7);
        Paquet pack = new Paquet(node, node, 5, null);
        node.enterPaquet(pack);
        assertFalse(node.getQueue().isEmpty());
        assertEquals(node.getQueue().element(), pack);
    }

    @org.junit.jupiter.api.Test
    void exitPaquet() {
        Noeud node = new Noeud(7);
        Paquet pack = new Paquet(node,node,5,null);
        Paquet pack2 = new Paquet(node,node,7,null);
        Paquet pack3 = new Paquet(node,node,3,null);
        node.enterPaquet(pack);
        node.enterPaquet(pack2);
        node.enterPaquet(pack3);
        assertEquals(node.exitPaquet(),pack2);
        assertEquals(node.exitPaquet(),pack);
        assertEquals(node.exitPaquet(),pack3);
        assertTrue(node.getQueue().isEmpty());
    }
}