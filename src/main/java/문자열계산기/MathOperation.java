package 문자열계산기;

import java.util.Arrays;

public enum MathOperation {
    PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/");
    private final String operator;
    MathOperation(String operator) {
        this.operator = operator;
    }

    public static MathOperation of(String operator) {
        return Arrays.stream(MathOperation.values())
                .filter(it -> it.operator.equals(operator))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("잘못된 사칙연산식 입니다."));
    }

    public static boolean isNotMathOperation(String operator) {
        return Arrays.stream(MathOperation.values())
                .noneMatch(it -> it.operator.equals(operator));
    }

    public int calculate(int before, int after) {
        int result = 0;
        switch (this) {
            case PLUS:
                result = before + after;
                break;
            case MINUS:
                result = before - after;
                break;
            case MULTIPLY:
                result = before * after;
                break;
            case DIVIDE:
                result = before / after;
                break;
        }
        return result;
    }
}
