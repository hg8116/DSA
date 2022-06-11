// https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1

package FractionalKnapsackGFG;

import java.util.Arrays;
import java.util.Comparator;

class Item{
    int value, weight;
    Item(int value, int weight){
        this.value = value;
        this.weight = weight;
    }
}


class itemComparator implements Comparator<Item> {
    @Override
    public int compare(Item a, Item b){
        double r1 = (double)(a.value) / (double)(a.weight);
        double r2 = (double)(b.value) / (double)(b.weight);
        if(r1 < r2) return 1;
        else if(r1 > r2) return -1;
        return 0;
    }
}

public class FractionalKnapsack {
    double fractionalKnapsack(int W, Item arr[], int n){
        Arrays.sort(arr, new itemComparator());

        int currWeight = 0;
        double finalValue = 0.0;

        for(int i=0; i<n; i++){
            if(currWeight + arr[i].weight <= W){
                currWeight += arr[i].weight;
                finalValue += arr[i].value;
            }
            else{
                int remain = W - currWeight;
                finalValue += ((double)arr[i].value / (double)arr[i].weight) * (double)remain;
                break;
            }
        }

        return finalValue;
    }


}
