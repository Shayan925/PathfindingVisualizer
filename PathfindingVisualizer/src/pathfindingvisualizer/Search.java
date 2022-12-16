/*
 * Names: Kabir, Shayan, Pareesh
 * Date: December 16, 2022
 * Description: A search class to represent the searching algorithms being used in the visualizer
 */
package pathfindingvisualizer;


public class Search {
    //attributes of the search class
    private Node[] shortestPath;
    
    /**
     * Primary Constructor to set default attribute values 
     */
    public Search(){
        shortestPath = new Node[50];
    }
    
    public static void aStarSearch(Node[][] grid){
        
    }
    
    public static void breadthFirstSearch(Node[][] grid){
        
    }
    
    public static void dijkstraSearch(Node[][] grid){
        
    }

    /**
     * Method to get the shortest path
     * @return - returns the shortest path
     */
    public Node[] getShortestPath() {
        return shortestPath;
    }

    /**
     * Method to set the shortest path
     * @param shortestPath - node with the shortest path being set as shortest path
     */
    public void setShortestPath(Node[] shortestPath) {
        this.shortestPath = shortestPath;
    }
    
    
}
