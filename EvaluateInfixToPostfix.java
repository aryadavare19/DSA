import java.util.Scanner;
import java.util.Stack;
//for infix to prefix reverse expression of infix , replace ) by ( and ( by ) apply postfix logic and then again reverse the final string
class Evaluate{
    boolean isOperand(char ch){
        return ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='^';
    }
    int precedence(char ch){
        switch (ch){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case 3:
                return 3;
        }
        return -1;
    }
    String convert(String exp){
        StringBuilder postfix=new StringBuilder();
        Stack<Character> st=new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char p=exp.charAt(i);
            if(p>='0' && p<='9'){
                postfix.append(p);
            }else if(isOperand(p)){
                while(!st.isEmpty() && precedence(p)<=precedence(st.peek())){
                    postfix.append(st.peek());
                    st.pop();
                }
                st.push(p);
            } else if (p=='(') {
                st.push(p);
            } else if (p==')') {
                while(!st.isEmpty() && st.peek()!='('){
                    postfix.append(st.peek());
                    st.pop();
                }
                st.pop();
            }

        }
        while(!st.isEmpty()){
            postfix.append(st.peek());
            st.pop();
        }
        return postfix.toString();
    }
    void evaluate(String postfix){
        int result=0;
        Stack<Integer> s=new Stack<>();
        for (int i = 0; i < postfix.length(); i++) {
            char p=postfix.charAt(i);
            if(p>='0' && p<='9'){
                s.push(p-'0');
            }else if(isOperand(p)){
                int b=s.pop();
                int a=s.pop();

            }
        }
    }
}

public class EvaluateInfixToPostfix {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter expression : ");
        String p=sc.nextLine();
        Evaluate obj=new Evaluate();
        System.out.println(obj.convert(p));
    }
}
