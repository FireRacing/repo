package src;
import java.util.ArrayList;
import java.util.Scanner;

public class probability{
	Scanner in = new Scanner(System.in);
	tools1 t = new tools1();
	public double conditional_probab(int set1[], int set2[])
    /*
     * Computes conditional probability for
     * a set
     */
    {
    	double result = 0;
    	String operations;
    	System.out.println("What operations do you wish to perform on the string? ");
    	operations = in.nextLine();
    	ArrayList<Double> result1 = t.get_subset(set1, set2, operations);
    	System.out.println("What condition do you want to check for?");
    	/*
    	 * Format for operations string:
    	 * operation operation number(single digit integers only)
    	 * Supported operations: <= >= =
    	 */
    	operations = in.nextLine();
    	int count = 0;
    	int result2 = 0;
    	if(operations.contains(">=") == true || operations.contains("<=") == true || operations.contains("-=") == true )
    	{
    		if(operations.contains(">="))
    		{
    			int num = Integer.parseInt(Character.toString(operations.charAt(2)));
        		for(int i = 0; i < set2.length; i++)
        		{
        			if(set2[i] >= num)
        				count++;
        		}
        		/*
        		 * Computes P(A) where A is the condition 
        		 * where the element >= num
        		 * |
        		 * |
        		 * v
        		 */
        		result2 = count/set2.length;
    		}
    		else if(operations.contains("<="))
    		{
    			int num = Integer.parseInt(Character.toString(operations.charAt(2)));
        		for(int i = 0; i < set2.length; i++)
        		{
        			if(set2[i] <= num)
        				count++;
        		}
        		/*
        		 * Computes P(A) where A is the condition 
        		 * where the element <= num
        		 * |
        		 * |
        		 * v
        		 */
        		result2 = count/set2.length;
    		}
    		else if(operations.contains("-=") == true)
    		{
    			int num = Integer.parseInt(Character.toString(operations.charAt(2)));
        		for(int i = 0; i < set2.length; i++)
        		{
        			if(set2[i] == num)
        				count++;
        		}
        		/*
        		 * Computes P(A) where A is the  
        		 * condition where the element 
        		 * equals num
        		 * |
        		 * |
        		 * v
        		 */
        		result2 = count/set2.length;
    		}
    	}
    	/*
    	 * Computes P(A/B)
    	 * |
    	 * |
    	 * |
    	 * v
    	 */
    	result = (result1.size()/set2.length)/result2;
    	return result;
    }
}