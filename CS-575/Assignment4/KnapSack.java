import java.util.*;


public class KnapSack{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("\nEnter knapsack capacity");
		int capacity = input.nextInt();
	
		System.out.println("\nEnter items");
		int n = input.nextInt();

		int[] items = new int[n];
		int[] weight = new int[n+1];
		int[] value = new int[n+1];

		for (int i = 1; i <= n; i++){
			System.out.println("\nEnter " + i + " weight");
			weight[i] = input.nextInt();
			System.out.println("\nEnter " + i + " value");
			value[i] = input.nextInt();
		}

		int table[][] = new int[n+1][capacity+1];

		System.out.println("Table is \n\n");


		for(int i = 1; i <=n ; i++){
			for(int j=0; j<= capacity; j++){
				if(j==0 ){
					table[i][j] =0;
				}
				if(i==0){
					table[i][j] =0;
				}
				if(i == 1){
					if(j >= weight[i]){
						table[i][j] = value[i];
					}
				}
				else{
					table[i][j] = table[i - 1][j];
					if( j >= weight[i]){
						int temp = j - weight[i];
						//System.out.println([j - weight[i]);
						table[i][j] = max(table[i - 1][temp] + value[i], table[i][j]);
					}
				}				
			}
		}


		display(table,n,capacity);
	}

	static int max(int a, int b)  
	{ 
	return (a > b) ? a : b; 
	} 

	static void display(int table[][], int n, int capacity){
	for (int i = 1; i <= n ; i++)
	{
		for (int j = 0; j <= capacity; j++)
		{
			System.out.print(table[i][j] + "  ");
		}
		System.out.println("\n");
	}
	}
	
	
}