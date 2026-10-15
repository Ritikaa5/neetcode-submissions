class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int[] leftMax = new int[n];   // leftMax[i] = i tak (including i) sabse badi height left se
        int[] rightMax = new int[n];  // rightMax[i] = i tak (including i) sabse badi height right se

        // STEP 1: leftMax array bharo - sirf EK baar left se right jao
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // STEP 2: rightMax array bharo - sirf EK baar right se left jao
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // STEP 3: ab har index ke liye seedha array se value utha lo, dobara scan nahi karna
        int water = 0;
        for (int i = 0; i < n; i++) {
            int waterHeight = Math.min(leftMax[i], rightMax[i]);
            water += Math.max(0, waterHeight - height[i]);
        }

        return water;
    }
}