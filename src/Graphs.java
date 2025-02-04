import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graphs {
//    Connected graph: n(E)>=n(V)-1
//    Tree: n(E)=n(V)-1

    int V;
    int[][] graph;
    Graphs(int V){
        this.V=V;
        this.graph=new int[V][V];
    }

//    Depth First Search
    public void dfs(int start){
        boolean[] visited=new boolean[V];
        System.out.print("DFS: ");
        dfsUtil(start, visited);
//        System.out.println();
    }
    public void dfsUtil(int start, boolean[] visited){
        visited[start]=true;
        System.out.print(start+" ");
        for(int i=0;i<V;i++){
            if(graph[start][i]==1 && !visited[i]){
                dfsUtil(i,visited);
            }
        }
    }

    public void bfs(int start){
        boolean[] visited=new boolean[V];
        ArrayList<Integer> q=new ArrayList<>();
        System.out.print("BFS: ");
        q.add(start);
        visited[start]=true;
        int current;
        while(!q.isEmpty()){
            current=q.getFirst();
            System.out.print(current+" ");
            q.removeFirst();
            for (int i = 0; i < V; i++) {
                if(graph[current][i]==1 && !visited[i]){
                    q.add(i);
                    visited[i]=true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Graphs graph=new Graphs(6);
        graph.graph=new int[][]{
                {0,1,0,1,0,0},
                {1,0,1,0,0,0},
                {0,1,0,0,0,1},
                {0,0,0,0,1,0},
                {0,0,0,1,0,1},
                {0,0,1,0,1,0}
        };
        graph.dfs(0);
        System.out.println();
        graph.bfs(0);
    }
}
