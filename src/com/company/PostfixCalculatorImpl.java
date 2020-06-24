package com.company;

import java.util.*;

public class PostfixCalculatorImpl implements PostfixCalculator {
    private final static String EMPTY = "";
    private final static String DELIMITER = " ";
    private final static String TABS = "\t";

    private final static String ADD_OPERATOR = "+";
    private final static String SUB_OPERATOR = "-";
    private final static String MUL_OPERATOR = "*";
    private final static String INC_OPERATOR = "i";
    private final  static String DEC_OPERATOR = "d";

    private Stack<Integer> stack;

    @Override
    public int parse(String input) {
        stack = new Stack<>();

        for(String token : tokenize(input)) {
            handle(token);
        }
        return stack.pop();
    }

    private void handle(String token) {
        switch(token) {
        case EMPTY:
            return;
        case ADD_OPERATOR:
            add();
            break;
        case SUB_OPERATOR:
            stack.push(stack.pop() * -1);
            add();
            break;
        case MUL_OPERATOR:
            mul();
            break;
        case INC_OPERATOR:
            stack.push(1);
            add();
            break;
        case DEC_OPERATOR:
            stack.push(-1);
            add();
            break;
        default:
            stack.push(Integer.valueOf(token));
        }
    }

    private void add() {
        Integer op1 = stack.pop();
        Integer op2 = stack.pop();
        stack.push(op1 + op2);
    }

    private void mul() {
        Integer op1 = stack.pop();
        Integer op2 = stack.pop();
        stack.push(op1 * op2);
    }

    private String[] tokenize(String input){
        input = input.replaceAll(TABS, DELIMITER);
        return input.split("\\s+");
    }
}
