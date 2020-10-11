/*
 * Note:- Have not tested the report size functions.
 */
package src;
import java.text.DecimalFormat;
import java.util.UUID;
import java.util.ArrayList;
import java.util.Scanner;

class node{
	double data;
	String coeff;
	char operator;
	node next;
	node prev;
	String id;
}

class linked_list{
	node cur = null;
	node temp = null;
	node prev = null;
	int list_num = 0;
	ArrayList<String> id_list = new ArrayList<String>();
	node create_node(double data1, String coeff1, char operator1)
	{
		node new_node = new node();
		new_node.data = data1;
		new_node.coeff = coeff1;
		new_node.operator = operator1;
		new_node.next = null;
		new_node.prev = null;
		new_node.id = UUID.randomUUID().toString();
		id_list.add(new_node.id);
		return new_node;
	}
	node insert_node(node start,double data, String coeff, char operator)
	{
		if(start == null)
			start = create_node(data,coeff,operator);
		else {
			cur = start;
			prev = cur;
			while(cur != null)
			{
				prev = cur;
				cur = cur.next;
			}
			temp = create_node(data,coeff,operator);
			prev.next = temp;
			temp.prev = prev;
			temp.next = null;
		}
		return start;
	}
	node insert__node_at_beginning(node start, double data, String coeff, char operator)
	{
		temp = create_node(data, coeff, operator);
		temp.next = start;
		temp.prev = null;
		start = temp;
		return start;
	}
	node delete_node(node start, double key, String id1) //deletes a node with the given id
	{
		if(start.data == key && start.id == id1)
		{
			temp = start.next;
			start = null;
			start = temp;
		}
		else
		{
			cur = start;
			while(cur != null && cur.id != id1)
				cur = cur.next;
			if(cur.id == id1 && cur != null)
			{
				node prev1 = cur.prev;
				node next1 = cur.next;
				cur = null;
				prev1.next = next1;
				next1.prev = prev1;
			}
			else if(cur == null)
			{
				System.out.println("Node not found");
			}
		}
		return start;
	}
	node clear(node start)
	{
		while(start != null)
			start = delete_node(start,start.data,start.id); 
		return null;
	}
}
class tools1{
	int num1=1;
    DecimalFormat df = new DecimalFormat("#.##");
    int size[] = new int[2];
    int size1[] = new int[2];
    Scanner in = new Scanner(System.in);
    public double[][] sigmoid_gradient(double d[][])
    {
    	size = reportSize(d);
    	for(int i = 0; i < size[0]; i++)
    		for(int j = 0; j < size[1]; j++)
    			d[i][j] = sigmoid(d[i][j])*(1-sigmoid(d[i][j]));
    	return d;
    }
    public double[][] sigmoid_gradient(long d[][])
    {
    	size = reportSize(d);
    	double d1[][] = new double[size[0]][size[1]];
    	for(int i = 0; i < size[0]; i++)
    		for(int j = 0; j < size[1]; j++)
    			d1[i][j] = sigmoid(d[i][j])*(1-sigmoid(d[i][j]));
    	return d1;
    }
    public double[][] sigmoid_gradient(int d[][])
    {
    	size = reportSize(d);
    	double d1[][] = new double[size[0]][size[1]];
    	for(int i = 0; i < size[0]; i++)
    		for(int j = 0; j < size[1]; j++)
    			d1[i][j] = sigmoid(d[i][j])*(1-sigmoid(d[i][j]));
    	return d1;
    }
    public double[][] sigmoid_gradient(float d[][])
    {
    	size = reportSize(d);
    	double d1[][] = new double[size[0]][size[1]];
    	for(int i = 0; i < size[0]; i++)
    		for(int j = 0; j < size[1]; j++)
    			d1[i][j] = sigmoid(d[i][j])*(1-sigmoid(d[i][j]));
    	return d1;
    }
    public int[] reportSize(double d[][])
    {
    	int counter = 0,i=0,j=0;;
    	while(true)
    	{
    		try {
    			double ele = d[i][j+1];
    			counter++;
    		}catch(ArrayIndexOutOfBoundsException e)
    		{
    			break;
    		}
    	}
    	size[0] = d.length/counter;
    	size[1] = counter;
    	return size;
    }
    public int[] reportSize(String d[][])
    {
    	int counter = 0,i=0,j=0;;
    	while(true)
    	{
    		try {
    			String ele = d[i][j+1];
    			counter++;
    		}catch(ArrayIndexOutOfBoundsException e)
    		{
    			break;
    		}
    	}
    	size[0] = d.length/counter;
    	size[1] = counter;
    	return size;
    }
    public int[] reportSize(int d[][])
    {
    	int counter = 0,i=0,j=0;;
    	while(true)
    	{
    		try {
    			double ele = d[i][j+1];
    			counter++;
    		}catch(ArrayIndexOutOfBoundsException e)
    		{
    			break;
    		}
    	}
    	size[0] = d.length/counter;
    	size[1] = counter;
    	return size;
    }
    public int[] reportSize(long d[][])
    {
    	int counter = 0,i=0,j=0;;
    	while(true)
    	{
    		try {
    			long ele = d[i][j+1];
    			counter++;
    		}catch(ArrayIndexOutOfBoundsException e)
    		{
    			break;
    		}
    	}
    	size[0] = d.length/counter;
    	size[1] = counter;
    	return size;
    }
    public int[] reportSize(float d[][])
    {
    	int counter = 0,i=0,j=0;;
    	while(true)
    	{
    		try {
    			float ele = d[i][j+1];
    			counter++;
    		}catch(ArrayIndexOutOfBoundsException e)
    		{
    			break;
    		}
    	}
    	size[0] = d.length/counter;
    	size[1] = counter;
    	return size;
    }
	public double factorial(int num)// limit - 31
    {
        num1 = 1;
        for(int i=num1+1;i<=num;i++)
            num1 = num1*i;
        return num1;
    }
    public double sigmoid(double x)//Sigmoid function for double values
    {
        double res = 1/(1+(Math.pow(Math.E, -x)));
        String s1 = df.format(res);
        res = Double.parseDouble(s1);
        return res;
    }
    public double sigmoid(float x)//Sigmoid function for float values
    {
        double res = 1/(1+(Math.pow(Math.E, -x)));
        String s1 = df.format(res);
        res = Double.parseDouble(s1);
        return res;
    }
    public double sigmoid(long x)//Sigmoid function for long values
    {
        double res = 1/(1+(Math.pow(Math.E, -x)));
        String s1 = df.format(res);
        res = Double.parseDouble(s1);
        return res;
    }
    public double sigmoid(int x)//Sigmoid function for integer values
    {
        double res = 1/(1+(Math.pow(Math.E, -x)));
        String s1 = df.format(res);
        res = Double.parseDouble(s1);
        return res;
    }
    public ArrayList<Double> get_subset(int[] set1, int set2[],String operations)
    /*
     * format for operations string: operation, (number or operation), operation, (number(single digit integers only)). Leave blank if you want to get a set that contains members of the second set only
     * Supported operations: <, >, +, -, *, /. =. <=, >=, ^ (exponation), %
     */
    {
    	int i,j;
    	ArrayList<Double> subset = new ArrayList<Double>();
    	if(Character.isDigit(operations.charAt(3)) == true && Character.isDigit(operations.charAt(1)) == false)
    	{
    		int num = Integer.parseInt(Character.toString(operations.charAt(1)));
    		int num1 = Integer.parseInt(Character.toString(operations.charAt(3)));
    		char c = operations.charAt(0);
			ArrayList<Double> temp = new ArrayList<Double>();
			if(operations.charAt(2) == '>' || operations.charAt(2) == '<')
			{
				if(operations.charAt(2) == '>')
				{
					if(c == '+')
						/*
		        		 * adds the first set with the number and then, compares
		        		 * it with the second number
		        		 */
					{
						for(i = 0; i < set1.length;i++)
	    					set1[i] += num;
	    				for(i = 0; i < set1.length; i++)
	    				{
	    					if(set1[i] > num1)
	    						subset.add((double) set1[i]);
	    				}
	    			}
	    			else if(c == '-')
	    				/*
		        		 * subtracts the first set with the number and then, compares
		        		 * it with the second number
		        		 */
	    			{
	    				for(i = 0; i < set1.length;i++)
	    					set1[i] -= num;
	    				for(i = 0; i < set1.length; i++)
	    				{
	    					if(set1[i] > num1)
	    						subset.add((double) set1[i]);
	    				}
	    			}
	    			else if(c == '*')
	    				/*
		        		 * multiplies the first set with the number and then, compares
		        		 * it with the second number
		        		 */
	    			{
	    				for(i = 0; i < set1.length;i++)
	    					set1[i] *= num;
	    				for(i = 0; i < set1.length; i++)
	    				{
	    					if(set1[i] > num1)
	    						subset.add((double) set1[i]);
	    				}
	    			}
	    			else if(c == '/')
	    				/*
		        		 * divides the first set with the number and then, compares
		        		 * it with the second number
		        		 */
	    			{
	    				for(i = 0; i < set1.length;i++)
	    					set1[i] /= num;
	    				for(i = 0; i < set1.length; i++)
	    				{
	    					if(set1[i] > num1)
	    						subset.add((double) set1[i]);
	    				}
	    			}
	    			else if(c == '=' && operations.charAt(1) != '<' && operations.charAt(1) != '>')
	    				/*
		        		 * compares the first set with the number and then, compares
		        		 * it with the second number
		        		 */
	    			{
	    				for(i = 0; i < set1.length;i++)
	    				{
	    					if(set1[i] == num)
	    						temp.add((double) set1[i]);
	    				}
	    				for(i = 0; i < temp.size(); i++)
	    				{
	    					if(temp.get(i) > num1)
	    						subset.add(temp.get(i));
	    				}
	    				temp.clear();
	    			}
	    			else if(c == '^')
	    				/*
		        		 * exponates the first set with the number and then, compares
		        		 * it with the second number
		        		 */
	    			{
	    				double d = 0;
	    				for(i = 0; i < set1.length;i++)
	    				{
	    					d = Math.pow(set1[i], num);
	    					if(d > num1)
	    						subset.add(d);
	    				}
	    			}
	    			else if(c == '%')
	    				/*
		        		 * mods the first set with the number and then, compares
		        		 * it with the second number
		        		 */
	    			{
	    				for(i = 0; i < set1.length;i++)
	    				{
	    					set1[i] %=num;
	    					if(set1[i] > num1)
	    						subset.add((double) set1[i]);
	    				}
	    			}
				}
				if(operations.charAt(2) == '<')
				{
					if(c == '+')
						/*
		        		 * adds the first set with the number and then, compares
		        		 * it with the second number
		        		 */
					{
	    				for(i = 0; i < set1.length;i++)
	    				{
	    					set1[i] += num;
	    					if(set1[i] < num1)
	    						subset.add((double)set1[i]);
	    				}
	    			}
	    			else if(c == '-')
	    				/*
		        		 * subtracts the first set with the number and then, compares
		        		 * it with the second number
		        		 */
	    			{
	    				for(i = 0; i < set1.length;i++)
	    				{
	    					set1[i] -= num;
	    					if(set1[i] < num1)
	    						subset.add((double) set1[i]);
	    				}
	    			}
	    			else if(c == '*')
	    				/*
		        		 * multipliess the first set with the number and then, compares
		        		 * it with the second number
		        		 */
	    			{
	    				for(i = 0; i < set1.length;i++)
	    				{
	    					set1[i] *= num;
	    					if(set1[i] < num1)
	    						subset.add((double) set1[i]);
	    				}
	    			}
	    			else if(c == '/')
	    				/*
		        		 * divides the first set with the number and then, compares
		        		 * it with the second number
		        		 */
	    			{
	    				for(i = 0; i < set1.length;i++)
	    				{
	    					set1[i] /= num;
	    					if(set1[i] < num1)
	    						subset.add((double) set1[i]);
	    				}
	    			}
	    			else if(c == '=' && operations.charAt(1) != '<' && operations.charAt(1) != '>')
	    				/*
		        		 * compares the first set with the number and then, compares
		        		 * it with the second number
		        		 */
	    			{
	    				for(i = 0; i < set1.length;i++)
	    				{
	    					if(set1[i] == num)
	    						temp.add((double) set1[i]);
	    				}
	    				for(i = 0; i < temp.size(); i++)
	    				{
	    					if(temp.get(i) < num1)
	    						subset.add(temp.get(i));
	    				}
	    				temp.clear();
	    			}
	    			else if(c == '^')
	    				/*
		        		 * exponates the first set with the number and then, compares
		        		 * it with the second number
		        		 */
	    			{
	    				double d = 0;
	    				for(i = 0; i < set1.length;i++)
	    				{
	    					d = Math.pow(set1[i], num);
	    					if(d < num1)
	    						subset.add(d);
	    				}
	    			}
	    			else if(c == '%')
	    				/*
		        		 * mods the first set with the number and then, compares
		        		 * it with the second number
		        		 */
	    			{	
	    				for(i = 0; i < set1.length;i++)
	    				{
	    					set1[i] %=num;
	    					if(set1[i] < num1)
	    						subset.add((double) set1[i]);
	    				}
	    			}
				}
			}
    	}
    	else if(Character.isDigit(operations.charAt(3)) == true && Character.isDigit(operations.charAt(1)) == false)
    	{
    		int num1 = Integer.parseInt(Character.toString(operations.charAt(3)));
    		if(operations.charAt(0) == '-' && (Character.isDigit(operations.charAt(1)) == false))
    		{
    			char c = operations.charAt(2);
    			boolean added = false;
    			ArrayList<Double> temp = new ArrayList<Double>();
    			if(c == '+')
    			/*
        		 * adds the first set with the number and then, compares
        		 * the second set with the first set to get the subset
        		 */
    			{
    				for(i = 0; i < set1.length;i++)
    					set1[i] += num1;
    				for(i = 0; i < set1.length; i++)
                	{
                		for(j = 0; j < set2.length; j++)
                		{
                			if(set1[i] == set2[j])
                				subset.add((double)set2[j]);
                		}
                	}
    			}
    			else if(c == '-')
    			/*
        		 * subtracts the first set with the number and then, compares
        		 * the second set with the first set to get the subset
        		 */
    			{
    				for(i = 0; i < set1.length;i++)
    					set1[i] -= num1;
    				for(i = 0; i < set1.length; i++)
                	{
                		for(j = 0; j < set2.length; j++)
                		{
                			if(set1[i] == set2[j])
                				subset.add((double)set2[j]);
                		}
                	}
    			}
    			else if(c == '*')
    			/*
        		 * multiplies the first set with the number and then, compares
        		 * the second set with the first set to get the subset
        		 */
    			{
    				for(i = 0; i < set1.length;i++)
    					set1[i] *= num1;
    				for(i = 0; i < set1.length; i++)
                	{
                		for(j = 0; j < set2.length; j++)
                		{
                			if(set1[i] == set2[j])
                				subset.add((double)set2[j]);
                		}
                	}
    			}
    			else if(c == '/')
    			/*
    			 * divides the first set with the number and then, compares
    			 * the second set with the first set to get the subset
    			 */
    			{
    				for(i = 0; i < set1.length;i++)
    					set1[i] /= num1;
    				for(i = 0; i < set1.length; i++)
                	{
                		for(j = 0; j < set2.length; j++)
                		{
                			if(set1[i] == set2[j])
                				subset.add((double)set2[j]);
                		}
                	}
    			}
    			else if(c == '=' && operations.charAt(1) != '<' && operations.charAt(1) != '>')
    			/*
    			 * compares the set with the number
    			 */
    			{
    				for(i = 0; i < set1.length;i++)
    				{
    					if(set1[i] == num1)
    						subset.add((double) set1[i]);
    				}
    			}
    			else if(c == '=' && (operations.charAt(1) == '<' || operations.charAt(1) == '>'))
    			/*
    			 * compares the set with the number to see if that number exists in the set
    			 */
    			{
    				if(operations.charAt(1) == '>')
    				{
    					for(i = 0; i < set1.length;i++)
        				{
        					if(set1[i] >= num1)
        						subset.add((double) set1[i]);
        				}
    				}
    				else if(operations.charAt(1) == '<')
    				{
    					for(i = 0; i < set1.length;i++)
        				{
        					if(set1[i] <= num1) 
        						subset.add((double) set1[i]);
        				}
    				}
    			}
    			else if(c == '^') // Exponates the set with the first number and then compares it with the second number
    			{
    				for(i = 0; i < set1.length;i++)
    					temp.add(Math.pow(set1[i],num1));
    				for(i = 0; i < set1.length; i++)
                	{
                		for(j = 0; j < set2.length; j++)
                		{
                			if(temp.get(i) == set2[j])
                				subset.add((double)set2[j]);
                		}
                	}
    				temp.clear();
    			}
    			else if(c == '%')
    			{
    				for(i = 0; i < set1.length;i++)
    					set1[i] %= num1;
    				for(i = 0; i < set1.length; i++)
                	{
                		for(j = 0; j < set2.length; j++)
                		{
                			if(set1[i] == set2[j])
                				subset.add((double)set2[j]);
                		}
                	}
    			}
    			if(added == false)
    			{
    				for(i = 0; i < set1.length; i++)
                	{
                		for(j = 0; j < set2.length; j++)
                		{
                			if(set1[i] == set2[j])
                				subset.add((double)set2[j]);
                		}
                	}
    			}
    		}
    	}
    	else if(operations == "----") {
    		for(i = 0; i < set1.length; i++)
        	{
        		for(j = 0; j < set2.length; j++)
        		{
        			if(set1[i] == set2[j])
        				subset.add((double)set2[j]);
        		}
        	}
    	}
    	return subset;
    }
    public ArrayList<Double> get_subset(int[] set1, double set2[])
    {
    	int i,j;
    	ArrayList<Double> subset = new ArrayList<Double>();
    	for(i = 0; i < set1.length; i++)
    	{
    		for(j = 0; j < set2.length; j++)
    		{
    			if(set1[i] == set2[j])
    				subset.add((double)set2[j]);
    		}
    	}
    	return subset;
    }
    public ArrayList<Double> get_subset(double[] set1, int set2[])
    {
    	int i,j;
    	ArrayList<Double> subset = new ArrayList<Double>();
    	for(i = 0; i < set1.length; i++)
    	{
    		for(j = 0; j < set2.length; j++)
    		{
    			if(set1[i] == set2[j])
    				subset.add((double)set2[j]);
    		}
    	}
    	return subset;
    }
    public ArrayList<Double> get_subset(long[] set1, int set2[])
    {
    	int i,j;
    	ArrayList<Double> subset = new ArrayList<Double>();
    	for(i = 0; i < set1.length; i++)
    	{
    		for(j = 0; j < set2.length; j++)
    		{
    			if(set1[i] == set2[j])
    				subset.add((double)set2[j]);
    		}
    	}
    	return subset;
    }
    public ArrayList<Double> get_subset(int[] set1, long set2[])
    {
    	int i,j;
    	ArrayList<Double> subset = new ArrayList<Double>();
    	for(i = 0; i < set1.length; i++)
    	{
    		for(j = 0; j < set2.length; j++)
    		{
    			if(set1[i] == set2[j])
    				subset.add((double)set2[j]);
    		}
    	}
    	return subset;
    }
    public ArrayList<Long> get_subset(long[] set1, long set2[])
    {
    	int i,j;
    	ArrayList<Long> subset = new ArrayList<Long>();
    	for(i = 0; i < set1.length; i++)
    	{
    		for(j = 0; j < set2.length; j++)
    		{
    			if(set1[i] == set2[j])
    				subset.add((long)set2[j]);
    		}
    	}
    	return subset;
    }
    public ArrayList<Double> get_subset(double[] set1, float set2[])
    {
    	int i,j;
    	ArrayList<Double> subset = new ArrayList<Double>();
    	for(i = 0; i < set1.length; i++)
    	{
    		for(j = 0; j < set2.length; j++)
    		{
    			if(set1[i] == set2[j])
    				subset.add((double)set2[j]);
    		}
    	}
    	return subset;
    }
    public ArrayList<Double> get_subset(double[] set1 ,double set2[])
    {
    	int i,j;
    	ArrayList<Double> subset = new ArrayList<Double>();
    	for(i = 0; i < set1.length; i++)
    	{
    		for(j = 0; j < set2.length; j++)
    		{
    			if(set1[i] == set2[j])
    				subset.add((double)set2[j]);
    		}
    	}
    	return subset;
    }
    public ArrayList<Double> get_subset(float[] set1, double set2[])
    {
    	int i,j;
    	ArrayList<Double> subset = new ArrayList<Double>();
    	for(i = 0; i < set1.length; i++)
    	{
    		for(j = 0; j < set2.length; j++)
    		{
    			if(set1[i] == set2[j])
    				subset.add((double)set2[j]);
    		}
    	}
    	return subset;
    }
    public ArrayList<Float> get_subset(float[] set1, float set2[])
    {
    	int i,j;
    	ArrayList<Float> subset = new ArrayList<Float>();
    	for(i = 0; i < set1.length; i++)
    	{
    		for(j = 0; j < set2.length; j++)
    		{
    			if(set1[i] == set2[j])
    				subset.add((float)set2[j]);
    		}
    	}
    	return subset;
    }
    public double conditional_probab(int set1[], int set2[])
    {
    	double result = 0;
    	String operations;
    	System.out.println("What operations do you wish to perform on the string? ");
    	operations = in.nextLine();
    	ArrayList<Double> result1 = get_subset(set1, set2, operations);
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
public class tools{
	public static void main (String args[])
	{
		tools1 t = new tools1();
		int i[][] = new int[1][2];
		for(int i1=0;i1<1;i1++)
		{
			for(int j=0;j<2;j++)
				i[i1][j] = i1+j;
		}
		int size[] = t.reportSize(i);
		System.out.println("Number of rows: "+size[0]);
		System.out.println("Number of columns: "+size[1]);
	}
}