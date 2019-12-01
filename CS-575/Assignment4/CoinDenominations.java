import java.util.*;
import java.lang.Math;


public class CoinDenominations
{

	public static void main(String[] args) {
		System.out.println("\nEnter amount");
		Scanner input = new Scanner(System.in);
		int amount = input.nextInt();

		optimalChange(amount);

		System.out.println("\nEnter amount");
		amount = input.nextInt();
		System.out.println("\nEnter k");
		int k = input.nextInt();
		System.out.println("\nEnter c");
		int c = input.nextInt();

    greedyChange(amount,k,c);

    System.out.println("\nEnter amount");
    amount = input.nextInt();
    System.out.println("\nEnter k");
    k = input.nextInt();
    ArrayList<Integer> coins = new ArrayList<>();
    for(int i = 0; i < k; i++){
      System.out.println("Enter " + i);
      coins.add(input.nextInt());
    }
    Collections.sort(coins);
    System.out.println("\n ---------------- PART 3 -------------------\n");
    System.out.println("\n Denominations are : ");
    System.out.println("Coins are " + greedyNk(amount,coins,k));
	}

	static void optimalChange(int amount){
     
  ArrayList<Integer> ans = new ArrayList<>(); 
	int deno[] = {1, 2, 5, 10, 25};
  int count[] = new int[deno.length];

	int n = deno.length - 1; 
  do{
    	while(amount>=deno[n]){
    		amount = amount - deno[n];
    		ans.add(deno[n]);
        count[n] += 1;
    	}
    	n --;
    }while(amount>0);
    System.out.println("\n ---------------- PART 1 -------------------\n");
    System.out.println("\n Denominations are : ");
    for(int i = 0 ; i < deno.length ; i++ ){
      
    	System.out.println(" Count " + count[i] + " of Coin " +  deno[i] + " ");
    
    }
   }

   static void greedyChange(int amount, int k, int c){
   	ArrayList<Integer> deno = new ArrayList<>();
    ArrayList<Integer> ans = new ArrayList<>(); 
    for(int i = 0; i <= k; i++){
      deno.add((int) Math.pow(c,i));
    }
   	Collections.sort(deno);
    int count[] = new int[deno.size()];


   	System.out.println("\n ---------------- PART 2 -------------------\n");
   

    int n = deno.size() - 1;

    
    do{
      while(amount>=deno.get(n)){
        amount = amount - deno.get(n);
        ans.add(deno.get(n));
        count[n] += 1;
      }
      n --;
    }while(amount>0);
    System.out.println("\n ---------------- PART 1 -------------------\n");
    System.out.println("\n Denominations are : ");
    for(int i = 0 ; i < deno.size() ; i++ ){
      
      System.out.println(" Count " + count[i] + " of Coin " +  deno.get(i) + " ");
    
    }
   	
   }

   static int greedyNk(int amount, ArrayList<Integer> coin, int k){
    int temp;
    if(amount == 0){
      return 0;
    }
    for(int i = 0; i < k; i++ ){
      temp = coin.get(i);
      if(amount >= temp){
        return 1 + greedyNk(amount - temp, coin, k);
      }
    }
    return 0;
   }
}