package src;
import java.util.Scanner;
import java.util.ArrayList;

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
	boolean verify_whether_subgroup(ArrayList<Double> d, int start_point, int end_point,char group_name,String operation)
	{
		if(operation.equals("--+") || operation.equals("---"))
		{
			for(int i = start_point;i < end_point;i++)
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
				for(int i = start_point;i < end_point; i++)
				{
					if(i+1<end_point&&((d.get(i)+d.get(i+1))==(d.get(i+1)+d.get(i))))
						count++;
				}
				if(count == end_point-2)
				{
					System.out.println(group_name+" is a group under addition");
					return true;
				}
			}
			else if(operation.equals("---"))
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
		if(operation.equals("--*") || operation.equals("--/"))
		{
			for(int i = start_point; i < end_point; i++)
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
				for(int i = start_point;i < end_point; i++)
				{
					if(i+1<end_point&&((d.get(i)*d.get(i+1))==(d.get(i+1)*d.get(i))))
						count++;
				}
				if(count == end_point-2)
				{
					System.out.println(group_name+" is a group under multiplication");
					return true;
				}
			}
			else if(operation.equals("--/"))
			{
				for(int i = start_point; i < end_point; i++)
				{
					if(i+1 < end_point&&((d.get(i)/d.get(i+1))==(d.get(i+1)/d.get(i))))
						count++;
					if(d.get(i)/d.get(i) == 1)
						count++;
				}
				if(count == end_point-2 && count1 == end_point-1)
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
}

public class group_theory{
	public static void main (String args[])
	{
		Scanner in = new Scanner(System.in);
	}
}