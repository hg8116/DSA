// https://www.codingninjas.com/codestudio/problems/chess-tournament_981299?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

package ChessTournamentCS;

import java.util.Arrays;

public class ChessTournament {
    public static int chessTournament(int[] positions, int n,  int c){
        Arrays.sort(positions);

        int low = 1, high = positions[n-1] - positions[0];

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(positions, n, c, mid)){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return high;
    }

    public static boolean isPossible(int[] a, int n, int c, int minDist){
        int cnt = 1;
        int last = a[0];

        for(int i=1; i<n; i++){
            if(a[i] - last >= minDist){
                cnt++;
                last = a[i];
            }
        }
        if(cnt >= c) return true;
        return false;
    }
}
