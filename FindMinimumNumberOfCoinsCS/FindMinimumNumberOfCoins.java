// https://www.codingninjas.com/codestudio/problems/975277?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

package FindMinimumNumberOfCoinsCS;

public class FindMinimumNumberOfCoins {
    public static int findMinimumCoins(int amount)
    {
        int[] deno = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int count = 0;

        for(int i=deno.length-1; i>=0; i--){
            if(amount / deno[i] >= 1){
                count += amount / deno[i];
                amount = amount % deno[i];
            }
            if(amount == 0) break;
        }

        return count;
    }
}
