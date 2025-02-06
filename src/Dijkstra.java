import java.util.Arrays;

public class Dijkstra {

//    Single source shortest path
    int V;
    int[][] graph;
    Dijkstra(int V){
        this.V=V;
        this.graph=new int[V][V];
    }
    public void dijkstra(int start){
        boolean[] visited =new boolean[V];
        int[] cost=new int[V];
        int[] parent =new int[V];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[start]=0;
        for(int i=0;i<V-1;i++){
            int u=minVertex(cost, visited);
            visited[u]=true;
//            neighbours of u;
            for(int v=0;v<V;v++){
                if(graph[u][v]!=0 && !visited[v] && cost[v]>=cost[u]+graph[v][u]){
                    cost[v]=cost[u] + graph[u][v];
                    parent[v]=u;
                }
            }
        }
        System.out.println("s to d\tcost");
        for(int i=0;i<V;i++){
            System.out.println(i+" "+cost[i]);

        }

    }
    public int minVertex(int[] cost, boolean[] visited){
        int minVertex=-1;
        int mincost=Integer.MAX_VALUE;
        for(int i=0;i<V;i++){
            if(cost[i]<mincost && !visited[i]){
                minVertex=i;
                mincost=cost[i];
            }
        }
        return minVertex;
    }

    public static void main(String[] args) {
        Dijkstra graph=new Dijkstra(9);
        graph.graph=new int[][]{
                {0,4,0,0,0,0,0,8,0},
                {4,0,8,0,0,0,0,11,0},
                {0,8,0,7,0,4,0,0,2},
                {0,0,7,0,9,14,0,8,0},
                {0,0,0,9,0,10,0,0,0},
                {0,0,4,14,10,0,2,0,0},
                {0,4,0,0,0,2,0,1,6},
                {0,11,0,0,0,0,1,0,7},
                {0,0,2,0,0,0,6,7,0}
        };
        graph.dijkstra(0);
    }
}
