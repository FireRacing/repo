package src;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import java.util.Stack;
/*
 * Note:- Have not tested the transpose functions have not been tested
 */

public class matrix_manipulation {
    ArrayList<Double> conatiner  = new ArrayList<Double>();
    tools1 t = new tools1();
    public String[] convert(String[] expression)
    {
        String s;
        for(int i=0;i<expression.length;i++)
        {
            if(expression[i]=="")
            {
                s = expression[i];
                s = "pi";
                expression[i] = s;
            }
        }
        return expression;
    }
    public double[][] transpose_2D_double(double d[][],int size[], int size1[]) //Transposes a 2D double matrix (Haven't tested)
    {
    	int i,j;
    	double new_array[][] = null;
    	ArrayList<Double>temp = new ArrayList<>();
    	if(size[0]==size[1])
    	{
    		for(i=0;i<size[0];i++)
    			for(j=0;j<size[0];j++)
    			{
    				temp.add(d[i][j]);
    			}
    		new_array = new double[size[0]][size[0]];
    		for(j = 0; i < size[0]; i++)
    			for(i = 0; j < size[0]; j++)
    				new_array[i][j] = temp.get(i+j);
    	}
    	else
    	{
    		for(i=0;i<size[0];i++)
    			for(j=0;j<size[1];j++)
    			{
    				temp.add(d[i][j]);
    			}
    		new_array = new double[size[1]][size[0]];
    		for(j = 0; i < size[1]; i++)
    			for(i = 0; j < size[0]; j++)
    				new_array[i][j] = temp.get(i+j);
    	}
    	temp.clear();
    	return new_array;
    }
    public long[][] transpose_2D_long(long d[][], int size[], int size1[]) //Transposes a 2D long matrix (Haven't tested)
    {
    	int i,j;
    	long new_array[][] = null;
    	ArrayList<Long>temp = new ArrayList<>();
    	if(size[0]==size[1])
    	{
    		for(i=0;i<size[0];i++)
    			for(j=0;j<size[0];j++)
    			{
    				temp.add(d[i][j]);
    			}
    		new_array = new long[size[0]][size[0]];
    		for(j = 0; i < size[0]; i++)
    			for(i = 0; j < size[0]; j++)
    				new_array[i][j] = temp.get(i+j);
    	}
    	else
    	{
    		for(i=0;i<size[0];i++)
    			for(j=0;j<size[1];j++)
    			{
    				temp.add(d[i][j]);
    			}
    		new_array = new long[size[1]][size[0]];
    		for(j = 0; i < size[1]; i++)
    			for(i = 0; j < size[0]; j++)
    				new_array[i][j] = temp.get(i+j);
    	}
    	temp.clear();
    	return new_array;
    }
    public int[][] transpose_2D_int(int d[][], int size[], int size1[]) //Transposes a 2D Integer matrix (Haven't tested)
    {
    	int i,j;
    	int new_array[][] = null;
    	ArrayList<Integer>temp = new ArrayList<>();
    	if(size[0]==size[1])
    	{
    		for(i=0;i<size[0];i++)
    			for(j=0;j<size[0];j++)
    			{
    				temp.add(d[i][j]);
    			}
    		new_array = new int[size[0]][size[0]];
    		for(j = 0; i < size[0]; i++)
    			for(i = 0; j < size[0]; j++)
    				new_array[i][j] = temp.get(i+j);
    	}
    	else
    	{
    		for(i=0;i<size[0];i++)
    			for(j=0;j<size[1];j++)
    			{
    				temp.add(d[i][j]);
    			}
    		new_array = new int[size[1]][size[0]];
    		for(j = 0; i < size[1]; i++)
    			for(i = 0; j < size[0]; j++)
    				new_array[i][j] = temp.get(i+j);
    	}
    	temp.clear();
    	return new_array;
    }
    public String[][] transpose_2D_String(String d[][], int size[]) //Transposes a 2D String matrix (Haven't tested)
    {
    	int i,j;
    	String new_array[][] = null;
    	ArrayList<String>temp = new ArrayList<>();
    	if(size[0]==size[1])
    	{
    		for(i=0;i<size[0];i++)
    			for(j=0;j<size[0];j++)
    			{
    				temp.add(d[i][j]);
    			}
    		new_array = new String[size[0]][size[0]];
    		for(j = 0; i < size[0]; i++)
    			for(i = 0; j < size[0]; j++)
    				new_array[i][j] = temp.get(i+j);
    	}
    	else
    	{
    		for(i=0;i<size[0];i++)
    			for(j=0;j<size[1];j++)
    			{
    				temp.add(d[i][j]);
    			}
    		new_array = new String[size[1]][size[0]];
    		for(j = 0; i < size[1]; i++)
    			for(i = 0; j < size[0]; j++)
    				new_array[i][j] = temp.get(i+j);
    	}
    	temp.clear();
    	return new_array;
    }
    public float[][] transpose_2D_float(float d[][], int size[],int size1[]) //Transposes a 2D float matrix (Haven't tested)
    {
    	int i,j;
    	float new_array[][] = null;
    	ArrayList<Float>temp = new ArrayList<>();
    	if(size[0]==size[1])
    	{
    		for(i=0;i<size[0];i++)
    			for(j=0;j<size[0];j++)
    			{
    				temp.add(d[i][j]);
    			}
    		new_array = new float[size[0]][size[0]];
    		for(j = 0; i < size[0]; i++)
    			for(i = 0; j < size[0]; j++)
    				new_array[i][j] = temp.get(i+j);
    	}
    	else
    	{
    		for(i=0;i<size[0];i++)
    			for(j=0;j<size[1];j++)
    			{
    				temp.add(d[i][j]);
    			}
    		new_array = new float[size[1]][size[0]];
    		for(j = 0; i < size[1]; i++)
    			for(i = 0; j < size[0]; j++)
    				new_array[i][j] = temp.get(i+j);
    	}
    	temp.clear();
    	return new_array;
    }
    double return_result(char c,double point)
    {
    	double res = 0;
    	switch(c)
    	{
    	case 'a':
    	case 'b':
    	case 'c':
    	case 'd':
    	case 'f':
    	case 'g':
    	case 'h':
    	case 'j':
    	case 'k':
    	case 'l':
    	case 'm':
    	case 'n':
    	case 'o':
    	case 'p':
    	case 'q':
    	case 'r':
    	case 's':
    	case 't':
    	case 'u':
    	case 'v':
    	case 'w':
    	case 'x':
    	case 'y':
    	case 'z': res = point;
    	break;
    	}
    	return res;
    }
    double get_x0(String x,double point)//for a one variable equation
    {
    	double res = 0;
    	ArrayList<Double> conatiner = new ArrayList<Double>();
    	return res;
    }
}