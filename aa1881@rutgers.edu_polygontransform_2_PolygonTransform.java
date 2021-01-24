/*************************************************************************
 *  Compilation:  javac PolygonTransform.java
 *  Execution:    java PolygonTransform
 *
 *  @author:Aswathy Aji, aa1881@scarletmail.rutgers.edu, aa1881
 *
 *************************************************************************/

public class PolygonTransform {


    // Returns a new array that is an exact copy of the given array. 
    // The given array is not mutated. 
    public static double[] copy(double[] array) {

	// WRITE YOUR CODE HERE
    	double[] copyArray = new double[array.length];
    	for(int i = 0; i < array.length; i++){
    		copyArray[i]=array[i];
    	}
    	return copyArray;
    }
    
    // Scales the given polygon by the factor alpha. 
    public static void scale(double[] x, double[] y, double alpha) {

	// WRITE YOUR CODE HERE
    	for(int i = 0 ;i<x.length ; i++){
			x[i] = x[i] * alpha;
			y[i] = y[i] * alpha;
		}
    }
    
    // Translates the given polygon by (dx, dy). 
    public static void translate(double[] x, double[] y, double dx, double dy) {

	// WRITE YOUR CODE HERE
    	for(int i = 0 ;i<x.length ; i++){
			x[i] = x[i] + dx;
			y[i] = y[i] + dy;
		}
    }
    
    // Rotates the given polygon theta degrees counterclockwise, about the origin. 
    public static void rotate(double[] x, double[] y, double theta) {

	// WRITE YOUR CODE HERE
    	double d = theta*Math.PI/180;
		double sine = Math.sin(d);
		double cosine = Math.cos(d);
		for(int i = 0 ;i<x.length ; i++){
			double xa =0,ya=0;
			xa = x[i]*cosine - y[i]*sine;
			ya = y[i]*cosine + x[i]*sine;
			x[i] = xa;
			y[i] = ya;	
		}
    }

    // Tests each of the API methods by directly calling them. 
    public static void main(String[] args) {

	// WRITE YOUR CODE HERE
    	StdDraw.setScale(-5.0, +5.0);
		double arrX[] = {0,1,1,0};
		double arrY[] = {0,0,2,1};
		double alpha = 2.0;
		double dx = 2.0,dy = 1.0;
		double theta = 90.0;
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.polygon(arrX,arrY);
		rotate(arrX,arrY,theta);
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.polygon(arrX,arrY);
    }
}
