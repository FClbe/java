import java.util.Scanner;
import java.util.Stack;

/**
 * Before you finish this task, we recommend you read
 * how we calculate an arithmetic expression by using stack.
 * Of course, you can change anything below if you like.
 * This class is just to help you understand algorithm better.
 */
public class MyString {

    // constant value that means '(' '+' '*'
    private static final int BRACKETS = 3;
    private static final int MULTIPLY = 2;
    private static final int ADD = 1;

    // flag that indicate if current character is between '(' and ')'
    private static int isRev = 0;
    private static int haveM = 0;

    // get your input from terminal
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String input = in.next();
            System.out.println(calculate(input));
        }
    }

    /**
     * Your main task is to finish this function.
     * Don't forget to check if you miss something.
     */
    private static int calculate(String in) {
        // Stack 'num' store number
        // Stack 'sym' store symbol
        Stack<Integer> num = new Stack<>();
        Stack<Integer> sym = new Stack<>();
        int len = in.length();
        for (int i = 0; i < len; i++) {
            char s = in.charAt(i);
            if (Character.isDigit(s)) {
                int oneNumber = 0;
                char sNext  = in.charAt(i);
                while(i < len && Character.isDigit(sNext)){
                    oneNumber = oneNumber * 10 + Integer.parseInt(String.valueOf(sNext));
                    i++;
                    if(i < len) {
                        sNext = in.charAt(i);
                    }
                }
                i--;
                /*char sNext;
                if (i < len - 1){
                    sNext = in.charAt(i + 1);
                }else{
                    sNext = 'a';
                }
                int oneNumber;
                if(Character.isDigit(sNext)){
                    i++;
                    oneNumber = Integer.parseInt(String.valueOf(s)) * 10 + Integer.parseInt(String.valueOf(sNext));
                }else {
                    oneNumber =  Integer.parseInt(String.valueOf(s));
                }*/
                num.add(oneNumber);
                /**
                 * You should get the number which begin at position i.
                 * And jump to the end of this number.
                 */
            } else {
                switch (s) {
                    case '(': {
                        isRev++;
                        sym.push(BRACKETS);
                        break;
                    }
                    case ')': {
                        isRev--;
                        if (!sym.empty() && sym.peek() != BRACKETS)
                            deal(num, sym);
                        break;
                    }
                    case '*': {
                        /*if (isRev != 0){
                            deal(num, sym);
                        }*/
                        /**
                         * You should think carefully what you should write here.
                         */
                        sym.push(MULTIPLY);
                        break;
                    }
                    case '+': {
                        /**
                         * You should think carefully what you should write here.
                         */
                        sym.push(ADD);
                        break;
                    }
                }
            }
        }
        if(!sym.isEmpty()) {
            dealNormol(num, sym);
        }

        return num.pop();
    }

    /**
     * This method is used to get two number from the stack,
     * get one symbol from another stack and operate them.
     * You should finish your code here.
     */
    private static void deal(Stack<Integer> num, Stack<Integer> sym) {
        Stack<Integer> waitNum = new Stack<>();
        Stack<Integer> waitSym = new Stack<>();
        int a = num.pop();
        int b = num.pop();
        int c = sym.pop();
        while(c != BRACKETS){
            if(c == ADD){
                a = combine(a, b, c);
                if(!num.isEmpty() && sym.peek() != BRACKETS){
                    b = num.pop();
                }
            }else{
                waitNum.add(a);
                a = b;
                if(!num.isEmpty() && sym.peek() != BRACKETS){
                    b = num.pop();
                }
                waitSym.add(c);
            }
            c = sym.pop();
        }
        while (!waitSym.empty()){
             a = combine(a, waitNum.pop(), waitSym.pop());
        }
        num.add(a);

    }

    private static void dealNormol(Stack<Integer> num, Stack<Integer> sym) {
        Stack<Integer> waitNum = new Stack<>();
        Stack<Integer> waitSym = new Stack<>();
        int a = num.pop();
        int b;
        int c = sym.pop();
        do{
            b = num.pop();
            if(c == MULTIPLY){
                a = combine(a, b, c);
                /*if(!num.isEmpty()){
                    b = num.pop();
                }*/
            }else{
                waitNum.add(a);
                a = b;
                /*if(!num.isEmpty()){
                    b = num.pop();
                }*/
                waitSym.add(c);
            }
            if (!sym.isEmpty())
            c = sym.pop();
        }
        while(!num.isEmpty());

        while (!waitSym.empty()){
            a = combine(a, waitNum.pop(), waitSym.pop());
        }
        num.add(a);

    }

    private static int combine(int a, int b, int c) {
        if (c == MULTIPLY)
            return a * b;
        if (c == ADD)
            return a + b;
        else
            return 0;
    }
}