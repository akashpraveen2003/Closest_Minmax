package closest_MinMax;

import java.util.Scanner;

/*
 * Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the maximum value of the array 
 * and at least one occurrence of the minimum value of the array.
 */
public class Closest_MinMax {
	
	private static int closest_Minmax(int[] array) {
		
		
		int minimum=Integer.MAX_VALUE;		// minimum value
		int maximum=Integer.MIN_VALUE;		// maximum value
		int max_index=-1;					// maximum_value_index
		int min_index=-1;					// minimum_value_index
		int length=Integer.MAX_VALUE;		// length is assigned to maximum because we have to find the smallest length
		int i;
		for(i=0;i<array.length;i++)
		{
			if(array[i]<minimum)
			{
				minimum=array[i];
			}
			if(array[i]>maximum)
			{
				maximum=array[i];
			}
		}
		
		for(i=0;i<array.length;i++)
		{
			if(array[i]==minimum)
			{
				min_index=i;
			}
			if(array[i]==maximum)
			{
				max_index=i;
			}
			if(min_index!=-1 && max_index!=1)		// if we found the indices of both maximum and minimum value
			{
				length=Math.min(length,Math.abs(max_index-min_index)+1);		// comparing the length with current indices
			}										// we use abs because we want only the closest index and ordering doesnt matter
		}
		return length;
	}

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		int array_size=scanner.nextInt();
		int array[]=new int[array_size];
		for(int i=0;i<array_size;i++)
		{
			array[i]=scanner.nextInt();
		}
		System.out.println(closest_Minmax(array));
		
	}
}
/*
 	Input
		A = [1, 3, 2]

	Output
		2
		
	Input
		A = [2, 6, 1, 6, 9]

	Output
		3
*/
