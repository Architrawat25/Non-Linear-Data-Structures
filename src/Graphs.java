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


    public static void main(String[] args) {
        Graphs graph=new Graphs(6);
        graph.graph=new int[][]{
                {0,1,0,1,0,0},
                {1,0,1,0,0,0},
                {0,1,0,0,0,1},
                {1,0,0,0,1,0},
                {0,0,0,1,0,1},
                {0,0,1,0,1,0}
        };
        graph.dfs(0);
    }
}
