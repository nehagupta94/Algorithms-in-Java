import java.util.Scanner;

public class Search{
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter size of input array");
		int size = input.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter elements of array");
		for(int i = 0; i < size ; i ++){
			System.out.println("Enter a["+(i+1)+"]");
			int c = input.nextInt();
			arr[i] = c;
		}
		System.out.println(search_function(arr,0,arr.length-1));
		//System.out.println("Output : " + output);
	}

	public static int search_function(int[] arr, int min, int max){
		if(max>min){
			int mid = (max + min) /2;
			if(mid == arr[mid]){
				return mid;
			}
			else if(mid > arr[mid]){
				return search_function(arr,(mid + 1),max);
			}
			else{
				return search_function(arr, min, (mid - 1));
			}
		}
	return -1;
	}
}

