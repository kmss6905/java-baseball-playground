import java.util.Objects;

public class StringCalculator {

    // 문자를 받아들이는 부분
    private String[] parse(String formula) {
        String[] elements = formula.split(" ");
        return formula.split(" ");
    }

    // 주어진 문자열을 검증합니다.
    public void validateFormula(String[] elements) {
        if (Objects.isNull(elements) || elements[0] == null) {
            throw new IllegalArgumentException("수식입력은 필수입니다.");
        }

        // 짝수번 째는 무조건 숫자
        for (int i = 0; i < elements.length; i+=2) {
            if (!elements[i].matches("\\d")) {
                throw new IllegalArgumentException("잘못된 수식입니다.");
            }
        }

        // 홀 수 번째는 무조건 연산이 와야한다.
        for (int i = 1; i < elements.length; i+=2) {
            if (!MathOperation.isNotMathOperation(elements[i])) {
                throw new IllegalArgumentException("잘못된 수식입니다.");
            }
        }

        // 마지막은 반드시 숫자로 끝나야 합니다.
        if (!elements[elements.length - 1].matches("\\d")) {
            throw new IllegalArgumentException("잘못된 수식입니다.");
        }
    }
}
