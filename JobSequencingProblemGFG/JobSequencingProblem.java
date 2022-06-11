// https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1#

package JobSequencingProblemGFG;

public class JobSequencingProblem {
    int[] JobScheduling(Job arr[], int n){
        int maxi = 0;
        for(int i=0; i<n; i++){
            if(arr[i].deadline > maxi){
                maxi = arr[i].deadline;
            }
        }

        int[] result = new int[maxi+1];

        for(int i=1; i<=maxi; i++){
            result[i] = -1;
        }

        int countJobs = 0, jobProfit = 0;

        for(int i=0; i<n; i++){
            for(int j=arr[i].deadline; j>0; j--){
                if(result[j] == -1){
                    result[j] = i;
                    countJobs++;
                    jobProfit += arr[i].profit;
                    break;
                }
            }
        }

        return new int[]{countJobs, jobProfit};
    }

    // Already defined in question
    class Job{
        int id, profit, deadline;
        Job(int x, int y, int z){
            id = x;
            profit = y;
            deadline = z;
        }
    }
}
