package model;

import java.util.ArrayList;
import java.util.List;

public class Vertex <T>{
    private T info;

    private boolean visited;

    private List<Vertex<T>> adyacents;

    public Vertex(T info) {
        this.info = info;
        visited = false;
        adyacents = new ArrayList<>();
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isAdyacent( Vertex<T> vertex ){

        return adyacents.contains( vertex );
    }

    public void addVertex( Vertex<T> vertex){
        adyacents.add( vertex );
    }
}
