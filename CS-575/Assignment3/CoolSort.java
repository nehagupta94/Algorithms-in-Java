import java.util.*;

public class CoolSort{
	static Scanner input = new Scanner(System.in);
	public static void coolSort(int arr[],int n) 
    { 
        //int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
    }

    public static int[] enterArray(int size){
    	int[] arr = new int[size];
    	System.out.println("Enter elements of array");
    	for(int i = 0;i<size;i++){
    			System.out.println("Enter array element a["+(i+1)+"]");
    			arr[i] = input.nextInt();
    	}
    	return arr;
    }

    public static int[] enterSteps(int size){
    	int[] arr = new int[size];
    	System.out.println("Enter elements of step");
    	for(int i = 0;i<size;i++){
    			System.out.println("Enter array element a["+(i+1)+"]");
    			arr[i] = input.nextInt();
    	}
    	return arr;
    }

    public static void printArray(int[] arr, int size){
      System.out.println("\n-----------------------\n\n");
    	System.out.println("Array is :  ");
    	for(int i = 0 ; i< size; i ++){
    		System.out.print("\t" +arr[i]);
    	}
    }

    public static void main (String args[]){
    	int subArrSize = 0;
    	int counter = 0;
    	int[] subArr = new int[50];
    	System.out.println("Enter size");
    	int arraySize = input.nextInt();
    	int[] arr = enterArray(arraySize);
    	System.out.println("\n---------------------------------\n\n");
    	System.out.println("Enter step size");
    	int stepSize = input.nextInt();
    	int[] steps = enterSteps(stepSize);
    	System.out.println("\n---------------------------------\n\n");
    	for(int i : steps){
    		do{
    			subArr[subArrSize] = arr[counter];
    			counter = counter + i;
    			subArrSize++;
    		}while(counter < arraySize);
        //printArray(subArr,subArrSize);
        coolSort(subArr,subArrSize);
        //printArray(subArr,subArrSize);
       // System.out.println("Counter : " + counter);
       // System.out.println("Size of sub array : " + subArrSize);
      

         	do{
        //  System.out.println("a[counter - 1] "+arr[counter-1]);
        //  System.out.println("subArr[subArrSize-1] "+subArr[subArrSize-1]);
        //  System.out.println("After swap");
          		counter = counter - i;
          		arr[counter] = subArr[subArrSize-1];
        //  printArray(arr,arraySize);
          //counter = counter - i;
        //  System.out.println("Counter: "+ counter);
         		subArrSize -- ;
         // System.out.println("sub Arr Size: "+ subArrSize);

        	}while(subArrSize>0); 
        //System.out.println("Step:  "+i);
    		printArray(arr,arraySize);
    		//break;
    	}
    }
}