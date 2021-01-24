/*************************************************************************
 *  Compilation:  javac Gas.java
 *  Execution:    java Gas 3.40 15.0 true
 *
 *  @author:Aswathy Aji, aa1881@scarletmail.rutgers.edu, aa1881
 *
 * The program Gas computes and displays the price a
 * person will pay for gas at the gas station.
 *
 *  % java Gas 3.40 15.0 false
 *  56.1
 *
 *  % java Gas 3.40 15.0 true
 *  51.0
 *
 *************************************************************************/

public class Gas {

    public static void main(String[] args) {

	// WRITE YOUR CODE HERE
    	double priceGal = Double.parseDouble(args[0]);
    	double numGal = Double.parseDouble(args[1]);
    	boolean cash = Boolean.parseBoolean(args[2]);
    	double total = 0;

    	if(priceGal <= 0 || numGal <= 0){
    		System.out.println("Illegal Input");
    	}
    	if(cash == true){
    		total = priceGal * numGal;
    		System.out.println(total);
    	}
    	else {
    		total = (priceGal * numGal) * 1.1;
    		System.out.println(total);
    	}
    	
    }
}
