/*************************************************************************
 *  Compilation:  javac RandomWalker.java
 *  Execution:    java RandomWalker 10
 *
 *  @author:Aswathy Aji, aa1881@scarletmail.rutgers.edu, aa1881
 *
 * The program RandomWalker that takes an int command-line argument n
 * and simulates the motion of a random walk for n steps. Print the
 * location at each step (including the starting point), treating the
 * starting point as the origin (0, 0). Also, print the square of the
 * final Euclidean distance from the origin.
 *
 *  % java RandomWalker 10
 * (0,0)
 * (-1,0)
 * (-1,-1)
 * (-1,-2)
 * (-1,-3)
 * (-1,-4)
 * (-1,-5)
 * (0,-5)
 * (-1,-5)
 * (-2,-5)
 * (-2,-4)
 * Squared distance = 20.0
 *
 *************************************************************************/

public class RandomWalker {

    public static void main(String[] args) {

	// WRITE YOUR CODE HERE
    	int n = Integer.parseInt(args[0]);
    	int originx = 0;
    	int originy = 0;

    	double randomMove = Math.random()*5;

    	double currentx = 0;
    	double currenty = 0;

    	System.out.println("("+ originx + ","+ originy+")");

    	for(int i = 0; i<n; i++){
    		if (randomMove == 1){
    			currenty = currenty + 1.0;
    		}
    		else if(randomMove == 2){
    			currenty = currenty - 1.0;
    		}
    		else if(randomMove == 3){
    			currentx = currentx + 1.0;
    		}
    		else if(randomMove == 4){
    			currentx = currentx - 1.0;
    		}
    		System.out.println("(" + currentx + ","+ currenty + ")");
    	}
    

    	double distancex = Math.pow(currentx,2);
    	double distancey = Math.pow(currenty,2);

    	double squaredDistance = distancex + distancey;

    	System.out.println("Squared Distance = " + squaredDistance);
    }
}
