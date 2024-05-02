package grafo_model;

import java.util.ArrayList;

public class Graph {

    private ArrayList<Vertex> vertices;
    private ArrayList<Vertex> edges;



    public Graph(){
        this.vertices = new ArrayList<Vertex>();
    }


    public Vertex addVertex(String data){
        Vertex newVertex = new Vertex(data);
        this.vertices.add(newVertex);
        return newVertex;
    }

    public void addEdge(Vertex initialVertex, Vertex finalVertex, Integer weight){
        initialVertex.addEdge(finalVertex, weight);
        finalVertex.addEdge(initialVertex, weight);
    }

    public void removeEdge(Vertex initialVertex, Vertex finalVerte){
        initialVertex.removeEdge(finalVerte);
        finalVerte.removeEdge(initialVertex);
    }

    public void removeVertex(Vertex vertex){
        vertices.remove(vertex);
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    public void print(){
        for(Vertex v: this.vertices){
            v.print();
        }
    }

    private static String[] generateProvinceArgentinaStrings() {
		return new String[]{ 
            "Buenos Aires", "Ciudad Autonoma de Buenos Aires", "Catamarca",
            "Chaco", "Chubut", "Cordoba", "Corrientes", "Entre Rios",
            "Formosa", "Jujuy", "La Pampa", "La Rioja", "Mendoza",
            "Misiones", "Neuquen", "Rio Negro", "Salta", "San Juan",
            "San Luis", "Santa Cruz", "Santa Fe", "Santiago del Estero",
            "Tierra del Fuego, Antartida e Islas del Atlantico Sur",
            "Tucuman"
			};

        }

    public static void main(String[] args) {
        Graph Argentina = new Graph();

        String[] provinceNames = generateProvinceArgentinaStrings();
        Vertex[] provinces = new Vertex[provinceNames.length];
        for (int i = 0; i < provinceNames.length; i++) {
            provinces[i] = Argentina.addVertex(provinceNames[i]);
        }
    
        //Esto es una prueba no es algo definitivo pero es para ver si funciona los metodos
    
        // Ejemplo de cómo agregar algunos Edges o Artistas
        Argentina.addEdge(provinces[0], provinces[1], 1); // Ejemplo de borde entre Buenos Aires y capital
        Argentina.addEdge(provinces[0], provinces[2], 5); // Ejemplo de borde entre Buenos Aires y Catamarca
    
        // Imprime el grafo
        Argentina.print();


    }

}
