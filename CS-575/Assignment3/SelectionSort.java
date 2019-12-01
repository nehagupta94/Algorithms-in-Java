import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {  
	Scanner input = new Scanner (System.in);
	float median;
	System.out.println("Enter size");
	int size = input.nextInt();
	int[] customArr = new int[size];
	int[] outputArr = new int[size];
	for(int i =0;i<size;i++){
		System.out.println("Enter a["+(i+1)+"]");
		int c=input.nextInt();
		customArr[i] = c;
	}
		System.out.println("Inputted array");
		printArray(customArr);
		outputArr = selectionSort(customArr);
		System.out.println("Sorted Array");
		printArray(customArr);
		System.out.println("Enter k");
		int k = input.nextInt();
		System.out.println("Sorted Array");
		printArray(selectionKSort(customArr,k));
		System.out.println("Median of output : " + median(selectionKSort(customArr,k)));

    }

    public static void printArray(int[] arr){
    	for(int i : arr ){
    		System.out.print(i + "  ");
    	}
	System.out.println();
    }

    public static float median(int[] arr){
    	int n = arr.length;
	    if(n %2 == 0){
		    int a = arr[n/2];
		    int b = arr[(n/2)-1];
		return (float)(a+b)/2;
	    }else{
	    	return (float)arr[n/2];
	    }
	
    }

    public static int[] selectionSort(int[] arr){
	for (int i = 0; i < arr.length - 1; i++)
	        {
		      int min = i;
		      for (int j = i + 1; j < arr.length; j++){ //locate smallest element between 1 and i
			         if (arr[j] < arr[min]) 
				        min = j; //searching for lowest index
		      }
	    // swap lowest element with i
		int temp = arr[min];  
            	arr[min] = arr[i];
            	arr[i] = temp;
        }
        return arr;	
    } 

    public static int[] selectionKSort(int[] arr,int k){
	    int[] kelement = new int[k];
	    for(int i=0;i<k;i++){
    			int min=i;
			for(int j=i+1; j<arr.length;j++){
				if(arr[j]<arr[min])
					min=j;
			}
			int temp = arr[min];
			arr[min] = arr[i];
			kelement[i] = temp;
		}
	return kelement;
	} 

}
