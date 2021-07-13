 static boolean splitArray(int[] nums) {
        if (nums.length < 7) {
            return false;
        }

        int n = nums.length;
        int[] preSum = new int[n];
        preSum[0] = nums[0];

        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }

        for (int j = 3; j < n - 3; j++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i < j - 1; i++) {
                int sumLeftOne = preSum[i - 1];
                int sumLeftTwo = preSum[j - 1] - preSum[i];
                if (sumLeftOne == sumLeftTwo) {
                    set.add(sumLeftOne);
                }
            }

            for (int k = j + 2; k < n - 1; k++) {
                int sumRightOne = preSum[k - 1] - preSum[j];
                int sumRightTwo = preSum[n - 1] - preSum[k];
                if (sumRightOne == sumRightTwo && set.contains(sumRightOne)) {
                    return true;
                }
            }
        }
        return false;
    }
