class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canEatAll(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    boolean canEatAll(int[] piles, int speed, int hours) {
        int timeTaken = 0;
        for (int pile : piles) {
            timeTaken += pile / speed;
            timeTaken += ((pile % speed > 0) ? 1 : 0);
        }

        return timeTaken <= hours;
    }
}
