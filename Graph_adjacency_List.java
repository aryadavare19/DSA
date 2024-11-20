import java.util.ArrayList;

public class Graph_adjacency_List {
    static class Edge{
        int src;
        int dest;
        int weight;
        public Edge(int s,int d,int weight){
            src=s;
            dest=d;
            this.weight=weight;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,2,2));

        graph[1].add(new Edge(1,2,10));
        graph[1].add(new Edge(1,3,0));

        graph[2].add(new Edge(2,0,2));
        graph[2].add(new Edge(2,1,10));
        graph[2].add(new Edge(2,3,-1));

        graph[3].add(new Edge(3,1,0));
        graph[3].add(new Edge(3,2,-1));
    }
    public static void display(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e=graph[i].get(j);
                System.out.println(e.src+" has neighbour "+e.dest+" with edge weight "+e.weight);
            }
        }
    }
    public static void main(String[] args) {
      int v=4;
        ArrayList<Edge> graph[]=new ArrayList[v];//here this graph will have null values right now
        //so we need to initialize every box of that array with a empty arraylist
        createGraph(graph);
        display(graph);
    }
}
