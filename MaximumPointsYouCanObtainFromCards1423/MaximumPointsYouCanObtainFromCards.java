// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/

package MaximumPointsYouCanObtainFromCards1423;

public class MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k){
        int leftSum = 0;
        int rightSum = 0;

        for(int i=0; i<k; i++){
            leftSum += cardPoints[i];
        }
        int max = leftSum;
        int n = cardPoints.length;

        for(int i=0; i<k; i++){
            leftSum -= cardPoints[k - 1 - i];
            rightSum += cardPoints[n - 1 - i];
            max = Math.max(max, leftSum + rightSum);
        }

        return max;
    }
}
