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
        int countOpenZ = 0;
        while (stringStack.size() > 0) {
            if (stringStack.peek() == '(' && countOpenZ == 0) {
                return false;
            }
            if (stringStack.peek() == '(') {
               countOpenZ++;

            }
            if (stringStack.peek()== ')') {
                countOpenZ--;
            }
            stringStack.pop();
        }
        return countOpenZ == 0;
    }
}
