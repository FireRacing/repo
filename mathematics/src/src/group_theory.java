package src;
import java.util.Scanner;
import java.util.ArrayList;

/*
 * TO DO:- Add support for multi-digit integers in verify_whether_group
 *         Add support for <> and = operators in verify_whether_subgroup
 */
class group{
	boolean verify_whether_group(ArrayList<Integer> d,char group_name,String operation)
	/*
	 * Format for operation string (operation1 operation2 (number or operation3))
	 * How the function will check for group validity:
	 * Apply first two operations on the group and then check for validity with respect to the third operation (if there exists one)
	 * If the 2nd operation is a '%' the first operation is applied and then moduloed with the number present after the modulo
	 */
	{
		if(operation.equals("--+") || operation.equals("---"))
		{
			for(int i = 0;i < d.size(); i++)
			{
				if(d.get(i)==0)
					System.out.println("Identity element exists");
				else
				{
					System.out.println("Identity element does not exist");
					return false;
				}
			}
			int count =0,count1 = 0;
			if(operation.equals("--+"))
			{
				System.out.println("Inverse exists");
				for(int i=0;i<d.size();i++)
				{
					if(i+1<d.size()&&((d.get(i)+d.get(i+1))==(d.get(i+1)+d.get(i))))
						count++;
				}
				if(count==d.size()-2)
				{
					System.out.println(group_name+"is a group under addition");
					return true;
				}
			}
			else if(operation.equals("---"))
			{
				for(int i=0;i<d.size();i++)
				{
					if(i+1<d.size()&&((d.get(i)-d.get(i+1))==(d.get(i+1)-d.get(i))))
						count++;
					if(d.get(0)-d.get(0) == 0)
						count++;
				}
				if(count==d.size()-2 && count1 == d.size()-1)
				{
					System.out.println(group_name+" is a group under subtraction");
					return true;
				}
				else
					System.out.println(+group_name+" is not a group under subtraction");
			}
		}
		if(operation.equals("--*") || operation.equals("--/"))
		{
			for(int i = 0; i < d.size(); i++)
			{
				if(d.get(0) == 1)
					System.out.println("Identity element exists");
				else
				{
					System.out.println("Identity element does not exist.");
					return false;
				}
			}
			int count =0,count1 = 0;
			if(operation.equals("--*"))
			{
				System.out.println("Inverse exists");
				for(int i=0;i<d.size();i++)
				{
					if(i+1<d.size()&&((d.get(i)*d.get(i+1))==(d.get(i+1)*d.get(i))))
						count++;
				}
				if(count==d.size()-2)
				{
					System.out.println(group_name+" is a group under multiplication");
					return true;
				}
			}
			else if(operation.equals("--/"))
			{
				for(int i=0;i<d.size();i++)
				{
					if(i+1<d.size()&&((d.get(i)/d.get(i+1))==(d.get(i+1)/d.get(i))))
						count++;
					if(d.get(0)/d.get(0) == 1)
						count++;
				}
				if(count==d.size()-2 && count1 == d.size()-1)
				{
					System.out.println(group_name+" is a group under division");
					return true;
				}
				else
					System.out.println(group_name+" is not a group under division");
			}
		}
		return false;
	}
	boolean verify_whether_subgroup(ArrayList<Double> d,char group_name,String operations)
	/*
	 * % followed by a number will be considered as a single
	 * operation. A modulus table will be constructed to see whether
	 * there exists an identity element
	 * Supported operations: - + - * / ^(modulo only) <= (less than or equal to) >= (greater than or equal to) <>(not) =
	 * @param d - the group to be verified
	 * @param group_name - for labeling purposes
	 * @param operations - operations to be performed
	 */
	{
		if(operations.equals("--+") || operations.equals("---"))
		{
			for(int i = 0;i < d.size();i++)
			{
				if(d.get(i)==0)
					System.out.println("Identity element exists");
				else
				{
					System.out.println("Identity element does not exist");
					return false;
				}
			}
			int count =0,count1 = 0;
			if(operations.equals("--+"))
			{
				System.out.println("Inverse exists");
				for(int i = 0; i < d.size(); i++)
				{
					if(i+1<d.size()&&((d.get(i)+d.get(i+1))==(d.get(i+1)+d.get(i))))
						count++;
				}
				if(count == d.size()-2)
				{
					System.out.println(group_name+" is a group under addition");
					return true;
				}
			}
			else if(operations.equals("---"))
			{
				for(int i=0;i<d.size();i++)
				{
					if(i+1<d.size()&&((d.get(i)-d.get(i+1))==(d.get(i+1)-d.get(i))))
						count++;
					if(d.get(i)-d.get(i) == 0)
						count++;
				}
				if(count==d.size()-2 && count1 == d.size()-1)
				{
					System.out.println(group_name+" is a group under subtraction");
					return true;
				}
				else
					System.out.println(group_name+" is not a group under subtraction");
			}
		}
		if(operations.equals("--*") || operations.equals("--/"))
		{
			for(int i = 0; i < d.size(); i++)
			{
				if(d.get(0) == 1)
					System.out.println("Identity element exists");
				else
				{
					System.out.println("Identity element does not exist.");
					return false;
				}
			}
			int count =0,count1 = 0;
			if(operations.equals("--*"))
			{
				System.out.println("Inverse exists");
				for(int i = 0; i < d.size(); i++)
				{
					if(i+1<d.size()&&((d.get(i)*d.get(i+1))==(d.get(i+1)*d.get(i))))
						count++;
				}
				if(count == d.size()-2)
				{
					System.out.println(group_name+" is a group under multiplication");
					return true;
				}
			}
			else if(operations.equals("--/"))
			{
				for(int i = 0; i < d.size(); i++)
				{
					if(i+1 < d.size()&&((d.get(i)/d.get(i+1))==(d.get(i+1)/d.get(i))))
						count++;
				}
				if(count == d.size()-2)
				{
					System.out.println(group_name+" is a group under division");
					return true;
				}
				else
				{
					System.out.println(group_name+" is not a group under division");
					return false;
				}
			}
		}
		String s = new String();
		for(int i = 0; i < 2 ; i++)
			s.concat(Character.toString(operations.charAt(i)));
		if(s.equals("<=") && Character.isDigit(operations.charAt(3)) == true)
		{
			if(Character.isDigit(operations.charAt(3)) == true)
			{
				int i = 3;
				s = "";
				while(i+1 < operations.length() && Character.isDigit(operations.charAt(i+1)) == true)
					s.concat(Character.toString(operations.charAt(i)));
				double d1 = Double.parseDouble(s);
				boolean identity_exists = false;
				for(i = 0; i < d.size();i++)
				{
					if(d.get(i) == d1)
						identity_exists = true;
				}
				if(identity_exists == true)
				{
					System.out.println("Identity element exists");
					for(i = 0; i < d.size(); i++)
					{
						
					}
				}
				else
					return false;
				i = 0;
				for(i = 0; i < d.size(); i++)
				{
					
				}
				i = 0;
			}
		}
		else if(s.equals("-<") && Character.isDigit(operations.charAt(3)))
		{
			int i = 3;
			s = "";
			while(i+1 < operations.length() && Character.isDigit(operations.charAt(i+1)) == true)
				s.concat(Character.toString(operations.charAt(i)));
			double d1 = Double.parseDouble(s);
			boolean identity_exists = false;
			for(i = 0; i < d.size();i++)
			{
				if(d.get(i) == d1)
					identity_exists = true;
			}
			if(identity_exists == true)
			{
				int count = 0;
				System.out.println("Identity element exists");
				for(i = 0; i < d.size(); i++)
				{
					if(d.get(i) > d1)
						count++;
				}
				if(count == d.size()/2) //Doesn't take into consideration each element but rather the number of elements
					System.out.println("Inverse elements exist for the amount of non-inverse elements");
				else
					return false;
			}
			else
				return false;
		}
		else if(s.equals(">=") && Character.isDigit(operations.charAt(3)))
		{
			
		}
		else if(s.charAt(1) == '%')
		{
			boolean identity_exists;
			if(s.charAt(0) == '+')
			{
				int i = 0;
				while(i+1 < operations.length() && Character.isDigit(operations.charAt(i+1)) == true)
					s.concat(Character.toString(operations.charAt(i)));
				double d1 = Double.parseDouble(s);
				int d2[][] = new int[d.size()][d.size()]; //Needs optimizing
				for(i = 0; i < d.size(); i++)
				{
					for(int j = 0; j < d.size(); j++)
						d2[i][j] = (int)((d.get(i)+d.get(j))%d1);
				}
				for(i = 0; i < d.size(); i++)
				{
					for(int j = 0; j < d.size(); j++)
					{
						if(d2[i][j] == 0)
						{
							System.out.println("Identity element exists");
							identity_exists = true;
						}
					}
				}
				for(i = 0; i < d.size() ; i++)
				{
					for(int j = 0 ; j < d.size(); j++)
						d2[i][j] = 0; //To free up memory
				}
				d2 = null;
			}
			else if(s.charAt(0) == '-')
			{
				int i = 0, count = 0;
				while(i+1 < operations.length() && Character.isDigit(operations.charAt(i+1)) == true)
					s.concat(Character.toString(operations.charAt(i)));
				double d1 = Double.parseDouble(s);
				int d2[][] = new int[d.size()][d.size()]; //Needs optimizing
				for(i = 0; i < d.size(); i++)
				{
					for(int j = 0; j < d.size(); j++)
						d2[i][j] = (int)((d.get(i)-d.get(j))%d1);
				}
				for(i = 0; i < d.size(); i++)
				{
					for(int j = 0; j < d.size(); j++)
					{
						if(d2[i][j] == 0)
						{
							System.out.println("Identity element exists");
							identity_exists = true;
						}
					}
					
				}
				for(i = 0; i < d.size() ; i++)
				{
					for(int j = 0 ; j < d.size(); j++)
						d2[i][j] = 0; //To free up memory
				}
				d2 = null;
			}
			else if(s.charAt(0) == '*')
			{
				int i = 0, count = 0;
				while(i+1 < operations.length() && Character.isDigit(operations.charAt(i+1)) == true)
					s.concat(Character.toString(operations.charAt(i)));
				double d1 = Double.parseDouble(s);
				int d2[][] = new int[d.size()][d.size()]; //Needs optimizing
				for(i = 0; i < d.size(); i++)
				{
					for(int j = 0; j < d.size(); j++)
						d2[i][j] = (int)((d.get(i)*d.get(j))%d1);
				}
				for(i = 0; i < d.size(); i++)
				{
					for(int j = 0; j < d.size(); j++)
					{
						if(d2[i][j] == 0)
						{
							System.out.println("Identity element exists");
							identity_exists = true;
						}
					}
					
				}
				for(i = 0; i < d.size() ; i++)
				{
					for(int j = 0 ; j < d.size(); j++)
						d2[i][j] = 0; //To free up memory
				}
				d2 = null;
			}
			else if(s.charAt(0) == '/')
			{
				int i = 0, count = 0;
				while(i+1 < operations.length() && Character.isDigit(operations.charAt(i+1)) == true)
					s.concat(Character.toString(operations.charAt(i)));
				double d1 = Double.parseDouble(s);
				int d2[][] = new int[d.size()][d.size()]; //Needs optimizing
				for(i = 0; i < d.size(); i++)
				{
					for(int j = 0; j < d.size(); j++)
						d2[i][j] = (int)((d.get(i)/d.get(j))%d1);
				}
				for(i = 0; i < d.size(); i++)
				{
					for(int j = 0; j < d.size(); j++)
					{
						if(d2[i][j] == 0)
						{
							System.out.println("Identity element exists");
							identity_exists = true;
						}
					}
					
				}
				for(i = 0; i < d.size() ; i++)
				{
					for(int j = 0 ; j < d.size(); j++)
						d2[i][j] = 0; //To free up memory
				}
				d2 = null;
			}
			else if(s.charAt(0) == '^')
			{
				int i = 0, count = 0;
				while(i+1 < operations.length() && Character.isDigit(operations.charAt(i+1)) == true)
					s.concat(Character.toString(operations.charAt(i)));
				double d1 = Double.parseDouble(s);
				int d2[][] = new int[d.size()][d.size()]; //Needs optimizing
				for(i = 0; i < d.size(); i++)
				{
					for(int j = 0; j < d.size(); j++)
						d2[i][j] = (int)(Math.pow(d.get(i), d.get(j))%d1);
				}
				for(i = 0; i < d.size(); i++)
				{
					for(int j = 0; j < d.size(); j++)
					{
						if(d2[i][j] == 0)
						{
							System.out.println("Identity element exists");
							identity_exists = true;
						}
					}
					
				}
				for(i = 0; i < d.size() ; i++)
				{
					for(int j = 0 ; j < d.size(); j++)
						d2[i][j] = 0; //To free up memory
				}
				d2 = null;
			}
		}
		return false;
	}
}

public class group_theory{
	public static void main (String args[])
	{
		Scanner in = new Scanner(System.in);
		
	}
}