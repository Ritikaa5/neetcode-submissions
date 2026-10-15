class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        

         int n = temperatures.length;

        // Har din ke wait time ko store karega
        int[] answer = new int[n];

        // Stack mein temperatures ke indices store honge
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            // Jab current temperature, stack ke top wale
            // temperature se zyada ho
            while (!stack.isEmpty() &&
                   temperatures[i] > temperatures[stack.peek()]) {

                // Previous day ka index nikalo
                int previousIndex = stack.pop();

                // Kitne din wait karna pada
                answer[previousIndex] = i - previousIndex;
            }

            // Current index ko stack mein daalo
            stack.push(i);
        }

        // Final answer return karo
        return answer;
    }
}
