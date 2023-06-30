package 문자열계산기;

import java.util.Objects;

public class StringCalculator {
    private MathOperation mathOperation;
    private int before;

    StringCalculator() {
    }

    // 문자를 받아들이는 부분
    public String[] parse(String formula) {
        String[] elements = formula.split(" ");
        validateFormula(elements);
        return elements;
    }


    /**
     * Feedback 필수
     * 1. 단위테스트를 할 수 있는 코드인가?
     * 2. 메서드를 더 불리 할 수 없는가?
     * 3. 읽기 좋은 코드인가?
     * 4. 더 개선할 수 없는가?
     */
    public int calculate(String elements) {
        String[] parsedElements = this.parse(elements);

        for (String e : parsedElements) {
            // 숫자인 경우
            if (MathOperation.isNotMathOperation(e)) {
                int current = Integer.parseInt(e);
                if (mathOperation != null) {
                    before = mathOperation.calculate(before, current);
                } else {
                    before = current;
                }
            } else {
                mathOperation = MathOperation.of(e);
            }
        }
        return before;
    }

    // 주어진 문자열을 검증합니다.
    public void validateFormula(String[] elements) {
        if (Objects.isNull(elements) || elements[0] == null) {
            throw new IllegalArgumentException("수식입력은 필수입니다.");
        }

        // 짝수번 째는 무조건 숫자
        for (int i = 0; i < elements.length; i += 2) {
            if (!elements[i].matches("\\d")) {
                throw new IllegalArgumentException("잘못된 수식입니다.");
            }
        }

        // 홀 수 번째는 무조건 연산이 와야한다.
        for (int i = 1; i < elements.length; i += 2) {
            if (MathOperation.isNotMathOperation(elements[i])) {
                throw new IllegalArgumentException("잘못된 수식입니다.");
            }
        }

        // 마지막은 반드시 숫자로 끝나야 합니다.
        if (!elements[elements.length - 1].matches("\\d")) {
            throw new IllegalArgumentException("잘못된 수식입니다.");
        }
    }
}
