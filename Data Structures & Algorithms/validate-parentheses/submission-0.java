class Solution {
    public boolean isValid(String s) {
         // brackets store karne ke liye stack
        Stack<Character> stack = new Stack<>();

        // string ke har character par loop
        for(int i = 0; i < s.length(); i++) {

            // current character nikalo
            char ch = s.charAt(i);

            // agar opening bracket hai
            // to stack me daal do
            if(ch == '(' || ch == '{' || ch == '[') {

                stack.push(ch);
            }

            // agar closing bracket mila
            else {

                // agar stack empty hai
                // matlab opening bracket hi nahi mila
                // example: ")"
                if(stack.isEmpty()) {
                    return false;
                }

                // stack ka top element nikalo
                // last opening bracket milega
                char top = stack.pop();

                // matching check karo

                // agar ')' aaya hai
                // lekin top '(' nahi hai
                if(ch == ')' && top != '(') {
                    return false;
                }

                // agar '}' aaya hai
                // lekin top '{' nahi hai
                if(ch == '}' && top != '{') {
                    return false;
                }

                // agar ']' aaya hai
                // lekin top '[' nahi hai
                if(ch == ']' && top != '[') {
                    return false;
                }
            }
        }

        // agar stack empty hai
        // matlab sab brackets properly match hue
        // example: "()[]{}"

        // agar empty nahi hai
        // matlab kuch opening bracket bache hue hain
        // example: "((("

        return stack.isEmpty();
    }
}
