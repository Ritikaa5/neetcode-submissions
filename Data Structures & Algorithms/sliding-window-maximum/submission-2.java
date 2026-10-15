class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        // Answer array
        int[] result = new int[n - k + 1];

        // Deque mein indices store karenge
        int[] deque = new int[n];

        int front = 0;
        int rear = 0;

        int resultIndex = 0;

        for (int i = 0; i < n; i++) {

            // Step 1:
            // Jo index current window se bahar ho gaya,
            // usko deque se remove karo
            if (front < rear && deque[front] <= i - k) {
                front++;
            }

            // Step 2:
            // Chhote elements ko remove karo
            // kyunki current element unse bada hai
            while (front < rear &&
                   nums[deque[rear - 1]] <= nums[i]) {
                rear--;
            }

            // Step 3:
            // Current element ka index deque mein add karo
            deque[rear] = i;
            rear++;

            // Step 4:
            // Jab first window complete ho jaye
            if (i >= k - 1) {

                // Deque ka first element
                // current window ka maximum hai
                result[resultIndex] = nums[deque[front]];

                resultIndex++;
            }
        }

        return result;
    }
}