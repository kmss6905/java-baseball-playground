package study;

import org.junit.jupiter.api.Test;

import java.util.Objects;

class StringCalculatorTest {

    /**
     * 계산식이 포함된 문자열이 들어온다.
     * 문자열을 공백을 기준으로 나누어 배열에 저장한다.
     * 저장된 배열을 순회하면서 숫자 문자가 아닌경우와 연산인 경우를 분리하여 생각한다.
     * 숫자 문자가 아닌 경우(연산문자)인 경우 따로 연산 변수에 저장
     * 숫자 문자인 경우 숫자 변수(before) 에 저장
     * 숫자 문자 이면서 연산 변수에 저장된 값이 있는 경우 이전 숫자(before) 해당 되는 연산을 현재 숫자에 적용함.
     */

    @Test
    void splitStringBySpace() {
        int before = 0;
        String value = "2 + 3 * 4 / 2";
        String operation = "";
        String[] values = value.split(" "); // 잘 나뉘어 들어갔는 지?

        for (String v: values) {
            // 연산 종류에 따라 잘 선택됬는 지?
            switch (v) {
                case "+":
                    operation = "+";
                    break;
                case "*":
                    operation = "*";
                    break;
                case "/":
                    operation = "/";
                    break;
                case "-":
                    operation = "-";
                    break;
                default:
                    int current = Integer.parseInt(v);
                    // 연산이 제대로 적용되었는 지?
                    if (operation == "*") {
                        before *= current;
                        break;
                    }
                    if (operation == "+") {
                        before += current;
                        break;
                    }

                    if (operation == "/") {
                        before /= current;
                        break;
                    }

                    if(operation == "-"){
                        before -= current;
                        break;
                    }
                    before = current;
            }
        }
        System.out.println(before);
    }
}