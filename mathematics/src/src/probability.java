package src;
import java.util.ArrayList;
import java.util.Scanner;

public class probability{
	Scanner in = new Scanner(System.in);
	tools1 t = new tools1();
	public double vanilla_probab(int set1[]) //Computes P(A)
	{
		System.out.println("What condition do you want to check for?");
    	/*
    	 * Format for operations string:
    	 * operation operation number(single digit integers only)
    	 * Supported operations: <= >= =
    	 */
    	String operations = in.nextLine();
		double result = 0;
		int count =0;
		if(operations.contains(">=") == true || operations.contains("<=") == true || operations.contains("-=") == true )
    	{
    		if(operations.contains(">="))
    		{
    			int num = Integer.parseInt(Character.toString(operations.charAt(2)));
        		for(int i = 0; i < set1.length; i++)
        		{
        			if(set1[i] >= num)
        				count++;
        		}
        		/*
        		 * Computes P(A) where A is the condition 
        		 * where the element >= num
        		 * |
        		 * |
        		 * v
        		 */
        		result = count/set1.length;
    		}
    		else if(operations.contains("<="))
    		{
    			int num = Integer.parseInt(Character.toString(operations.charAt(2)));
        		for(int i = 0; i < set1.length; i++)
        		{
        			if(set1[i] <= num)
        				count++;
        		}
        		/*
        		 * Computes P(A) where A is the condition 
        		 * where the element <= num
        		 * |
        		 * |
        		 * v
        		 */
        		result = count/set1.length;
    		}
    		else if(operations.contains("-=") == true)
    		{
    			int num = Integer.parseInt(Character.toString(operations.charAt(2)));
        		for(int i = 0; i < set1.length; i++)
        		{
        			if(set1[i] == num)
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
        		result = count/set1.length;
    		}
    	}
		return result;
	}
	public double conditional_probab(int set1[], int set2[])
    /*
     * Computes conditional probability for
     * a set
     */
    {
    	double result;
    	String operations;
    	System.out.println("What operations do you wish to perform on the string? ");
    	operations = in.nextLine();
    	ArrayList<Double> result1 = t.get_subset(set1, set2, operations);
    	double result2 = vanilla_probab(set2);
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
	public double bayes_theorem(int[] set1, int[] set2)
	{
		double result = 0;
    	double result1 =  conditional_probab(set1, set2);//Computes P(A/B)
    	System.out.println("is there any other condtion you wish to check for?");
    	if(in.nextLine() == "no")
    	{
    		double result2 = vanilla_probab(set1);
    		double result3 = 1-result2;//Computes P(B)
    		result = (result1*result2)/result3;
    	}
    	else if(in.nextLine() == "yes")
    	{
    		double result3 = vanilla_probab(set2);
    		double result2 = 1 - result3; // Computes P(A)
    		result = (result1*result2)/result3; //Computes P(B/A)
    	}
    	return result;
	}
	
}