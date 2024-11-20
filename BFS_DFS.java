import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BFS_DFS {
    static class Edge{
        int src;
        int dest;
        //int weight;
        public Edge(int s,int d){
            src=s;
            dest=d;
           // this.weight=weight;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));
        graph[6].add(new Edge(6, 5));
    }
        public static void bfs(ArrayList<Edge>[] graph, int v) {
            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[v];

            // Traverse all components of the graph
            for (int start = 0; start < v; start++) {
                if (!visited[start]) {
                    q.add(start);

                    while (!q.isEmpty()) {
                        int curr = q.remove();

                        if (!visited[curr]) {
                            System.out.print(curr + " ");
                            visited[curr] = true;

                            // Traverse neighbors of the current node
                            for (int i = 0; i < graph[curr].size(); i++) {
                                Edge e = graph[curr].get(i);
                                q.add(e.dest);
                            }
                        }
                    }
                }}}
    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis) {
        System.out.print(curr + " ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }
 public static void src_to_target(ArrayList<Edge> graph[],boolean visited[],int curr,String path,int tar){
if(curr==tar){
    System.out.println(path);
    return;
}
     for (int i = 0; i < graph[curr].size(); i++) {
         Edge e=graph[curr].get(i);
         if(!visited[e.dest]){
             visited[curr]=true;
             src_to_target(graph,visited,e.dest,path+e.dest,tar);
             visited[curr]=false;
         }
     }
 }
    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge>[] graph = new ArrayList[v];

        // Initialize graph
        createGraph(graph);

        // Visited array for DFS
        boolean[] visited = new boolean[v];

        // Perform DFS for disconnected graphs
//        for (int i = 0; i < v; i++) {
//            if (!visited[i]) {
//                dfs(graph, i, visited); // Start DFS from the current node
//            }
//        }
//        System.out.println();

        int src=0;
        int tar=5;
        src_to_target(graph,visited,src,"0",tar);
    }
}
