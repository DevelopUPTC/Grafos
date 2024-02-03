package model;

import java.util.*;

public class Graph <T>{
    private final List<Vertex<T>> vertexList;
    private final Comparator<T> comparator;

    public static final int DIRECT = 0;
    public static final int INDIRECT = 1;

    public Graph(Comparator<T> comparator) {
        this.comparator = comparator;
        vertexList = new ArrayList<>();
    }

    public void addVertex( T info ){
        vertexList.add( new Vertex<>( info ) );
    }

    public boolean addEdge( Vertex<T> source, Vertex<T> target, int direct){
        boolean success = false;

        if( !source.isAdyacent( target ) ){
            source.addVertex( target );

            success = true;
        }

        if( direct == INDIRECT ){
            if ( !target.isAdyacent( source) ){
                target.addVertex( source );

                success = true;
            }
        }

        return success;
    }

    public Vertex<T> findVertex( T info ){

        Optional<Vertex<T>>  aux = vertexList.stream()
                .filter( vertex -> comparator.compare(info,vertex.getInfo()) == 0)
                .findFirst();

        return aux.isPresent() ? aux.get() : null;
    }

    public List<T> getAdyacents( Vertex<T> vertex){

        return vertex.getAdyacents().stream().map( Vertex::getInfo ).toList();

    }

    public List<T> listGraph( Vertex<T> vertex){

        List<T> list = new LinkedList<>();

        ArrayDeque<Vertex<T>> tail = new ArrayDeque<>();
        tail.add( vertex );
        vertex.setVisited( true );
        while( !tail.isEmpty( ) ){
            Vertex<T> vertAux = tail.poll();
            for( Vertex<T> vert : vertAux.getAdyacents()){
                if( !vert.isVisited( ) ){
                    vert.setVisited( true );
                    tail.add( vert );
                }
            }

            list.add( vertAux.getInfo());
        }

        for ( Vertex<T>  aux : vertexList ){
            aux.setVisited( false );
        }

        return list;
    }

    public boolean isAdyacent(Vertex<T> vertex1, Vertex<T> vertex2){

        return vertex1.isAdyacent( vertex2 );

    }
}
