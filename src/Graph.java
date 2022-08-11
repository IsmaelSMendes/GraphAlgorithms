public class Graph {
  
    private int countNodes;
    private int countEdges;
    private int adjMatrix [][];
  
     public Graph(int countNodes) {
       this.countNodes= countNodes;
       this.adjMatrix= new int[countNodes][countNodes];
     }
  
    public int getCountNodes() {
      return countNodes;
    }
  
    public int getCountEdges() {
      return countEdges;
    }
  
    public int[][] getAdjMatrix() {
      return this.adjMatrix;
    }
    
    public String toString() {
      String str= "";
      for(int i=0 ; i< this.adjMatrix.length; ++i) {
        for(int j=0 ; j< this.adjMatrix[i].length; ++j) {
          str+= this.adjMatrix[i][j] + "\t";
        }
        str+= "\n";
      }
      return str;
    }
    public void addEdge(int source, int sink, int weight) {
      if(source < 0 || source >= this.countNodes -1 || sink < 0 || 
          sink > this.countNodes -1 || weight <= 0) {
        System.err.println("Invalid adge: " + " " + source + " " + sink + " " + weight);
      }
      this.adjMatrix[source][sink]= weight;
      this.countEdges++;
    }
    
    public int degree(int node) {

      if(node> this.countNodes -1)
        System.out.println("Invalid node!\n\n");
      
      int degree= 0;
        
      for(int j= 0; j< this.adjMatrix.length; ++j) {
        if(this.adjMatrix[node][j] != 0) {
         ++degree;
        }
      }

      return degree;

    }

    public int highestDegree(){
      int max = 0;

      for(int i = 0; i < adjMatrix.length; i++){
        if(max < this.degree(i))
        max = this.degree(i);
      }

      return max;
    }

    public int lowestDegree(){
      int min = 0;

      for(int j = 0; j < adjMatrix.length; j++){
        if(min > this.degree(j))
        min = this.degree(j);
      }
      
      return min;
    }

    public Graph complement(){

      Graph g2 = new Graph(this.countNodes);
      
      for(int i = 0; i < g2.adjMatrix.length; i++){
        for(int j = 0; i < g2.adjMatrix.length; j++){
          if(i != j){
          if(this.adjMatrix[i][j] == 0)
          addEdge(i, j, 1);
          else 
          addEdge(i, j, 0);
          }
        }

        }

      return g2;
    }

  }