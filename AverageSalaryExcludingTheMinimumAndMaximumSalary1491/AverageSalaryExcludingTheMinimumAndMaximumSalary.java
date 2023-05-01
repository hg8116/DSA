// https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/description/

package AverageSalaryExcludingTheMinimumAndMaximumSalary1491;

public class AverageSalaryExcludingTheMinimumAndMaximumSalary {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int ans = 0;

        for (int i = 0; i < salary.length; i++) {
            if (salary[i] < min)
                min = salary[i];
            if (salary[i] > max)
                max = salary[i];
        }

        for (int i = 0; i < salary.length; i++) {
            if (salary[i] != min && salary[i] != max)
                ans += salary[i];
        }
        return (double) ((double) ans / (salary.length - 2));
    }
}
