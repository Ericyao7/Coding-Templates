/*
Reference: https://aaronice.gitbooks.io/lintcode/content/two_pointers/triangle_count.html


Triangle Count

Question

Given an array of integers, how many three numbers can be found in the array, so that we can build an triangle whose three edges length is the three numbers that we find?
Example
Given array S = [3,4,6,7], return 3. They are:
[3,4,6]
[3,6,7]
[4,6,7]
Given array S = [4,4,4,4], return 4. They are:
[4(1),4(2),4(3)]
[4(1),4(2),4(4)]
[4(1),4(3),4(4)]
[4(2),4(3),4(4)]

分析
直白的想法是三重循环，i, j, k, 只要满足S[i] + S[j] > S[k]，或者S[i] + S[j] > S[k], 或者S[j] + S[k] > S[i]，该组合就计入总数。 不过显然，这种算法复杂度较高，为O(n^3)。+

可以对问题进行转化：
对数组排序，按照O(nlogn)计
对数组下标循环，则内部转化为一个two sum II问题，即寻找 S[j] + S[k] > S[i]有多少组，因为数组已排序，则可以使用two pointers的方法
对于每一个i，初始化left = 0, right = i - 1，如果有一个满足S[left] + S[right] > S[i], 那么对于left ~ right - 1 同样也满足，因此计入right-left到最终count中
以此类推，最终算法复杂度为O(n^2 + nlogn)
*/


public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int S[]) {
        Arrays.sort(S);
        int count = 0;
        //一摸一样的模版
        for (int i = 0; i < S.length; i++) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (S[left] + S[right] > S[i]) {
                    // The edge from S[left] to S[right - 1] will also form a triangle
                    count += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return count;
    }
}