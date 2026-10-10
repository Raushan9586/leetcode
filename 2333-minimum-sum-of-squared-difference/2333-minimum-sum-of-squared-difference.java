
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
    long operations = (long) k1 + k2;
    int n = nums1.length;
    int[] diff = new int[n];

    long total = 0;
    int maxDiff = 0;

    for (int i = 0; i < n; i++) {
    diff[i] = Math.abs(nums1[i] - nums2[i]);
    total += diff[i];
    maxDiff = Math.max(maxDiff, diff[i]);
    }
if (operations >= total) {
    return 0L;
    }

    int left = 0;
    int right = maxDiff;

    while (left < right) {
    int mid = left + (right - left) / 2;
    long required = 0;

    for (int d : diff) {
    if (d > mid) {
    required += d - mid;
    }
    }

    if (required <= operations) {
    right = mid;
    } else {
    left = mid + 1;
    }
    }

    int limit = left;
    long remaining = operations;
    long answer = 0;

    for (int d : diff) {
    if (d > limit) {
    remaining -= d - limit;
    d = limit;
    }
    answer += (long) d * d;
    }

    long count = 0;
    for (int d : diff) {
    if (d >= limit && limit > 0) {
    count++;
                                                                                                    }
                                                                                                    }
                                                                                                                                                                                                    long reductions = Math.min(remaining, count);
    answer -= reductions * (2L * limit - 1);

    return answer;
    }
}