package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VertexTest {
    private Vertex<Character> j;
    private Vertex<Character> a;
    private Vertex<Character> i;
    private Vertex<Character> r;
    private Vertex<Character> o;

    void setup(){
        j = new Vertex<>('J');
        a = new Vertex<>('A');
        i = new Vertex<>('I');
        r = new Vertex<>('R');
        o = new Vertex<>('O');

        j.addVertex(a);
        j.addVertex(r);
        j.addVertex(i);

        r.addVertex(j);
        r.addVertex(o);

        a.addVertex(j);
        a.addVertex(i);

        o.addVertex(r);

        i.addVertex(o);
        i.addVertex(a);
        i.addVertex(r);
    }

    @Test
    void isAdyacent() {
        setup();
        assertTrue( j.isAdyacent(a));
        assertTrue( j.isAdyacent(r));
        assertTrue( j.isAdyacent(i));
        assertFalse( j.isAdyacent(o));

        assertTrue( r.isAdyacent(j));
        assertTrue( r.isAdyacent(o));
        assertFalse(r.isAdyacent(i));
        assertFalse(r.isAdyacent(a));

        assertTrue( a.isAdyacent(j));
        assertTrue( a.isAdyacent(i));
        assertFalse(a.isAdyacent(r));
        assertFalse(a.isAdyacent(o));

        assertTrue( o.isAdyacent(r));
        assertFalse( o.isAdyacent(i));
        assertFalse( o.isAdyacent(j));
        assertFalse( o.isAdyacent(a));

        assertTrue( i.isAdyacent(o));
        assertTrue( i.isAdyacent(a));
        assertTrue( i.isAdyacent(r));
        assertFalse(i.isAdyacent( j ) );
    }

    @Test
    void addVertex() {
    }

    @Test
    void getAdyacents() {
        setup();
        assertEquals(3, j.getAdyacents().size());
        assertEquals('A',j.getAdyacents().get(0).getInfo());
        assertEquals('R',j.getAdyacents().get(1).getInfo());
        assertEquals('I',j.getAdyacents().get(2).getInfo());

        assertEquals(1,o.getAdyacents().size());
        assertEquals(3,i.getAdyacents().size());
    }
}