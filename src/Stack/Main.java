package Stack;

public class Main {
    public static void main(String[] args){

    }
    static boolean isBalance(String str){
        if(str.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stringStack = new Stack<Character>();
        for (Character x: str.toCharArray()){
            stringStack.push(x);
        }

        while (stringStack.size() > 0) {
            if (stringStack.peek() == '(') {
                return false;
            }
            if (stringStack.peek() == '(') {


            }
            if (stringStack.peek()== ')') {

                
            }
            stringStack.pop();
        }
        return false;
    }
}
