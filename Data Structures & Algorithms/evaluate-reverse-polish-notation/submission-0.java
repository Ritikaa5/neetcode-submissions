

class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            // Agar token number hai, toh stack mein push karo
            if (!token.equals("+") &&
                !token.equals("-") &&
                !token.equals("*") &&
                !token.equals("/")) {

                stack.push(Integer.parseInt(token));

            } else {

                // Pehle second operand niklega
                int b = stack.pop();

                // Phir first operand niklega
                int a = stack.pop();

                int result = 0;

                // Operator ke according calculation
                switch (token) {

                    case "+":
                        result = a + b;
                        break;

                    case "-":
                        result = a - b;
                        break;

                    case "*":
                        result = a * b;
                        break;

                    case "/":
                        result = a / b;
                        break;
                }

                // Calculation ka result wapas stack mein daalo
                stack.push(result);
            }
        }

        // Final answer return karo
        return stack.pop();
    }
}