import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveDuplicateLetters {

    public static void main(String[] args) {
        String s = "bcabc";
        System.out.println(removeDuplicateLetters(s));
    }

    public static String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(stack.contains(s.charAt(i)))
                continue;
            while(!stack.isEmpty()&&s.charAt(i)<stack.peek()&&s.indexOf(stack.peek(),i)!=-1){
                stack.pop();
            }
            stack.push(s.charAt(i));
        }
        StringBuffer sb =new StringBuffer();
        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
        }
        return sb.toString();
    }
}
