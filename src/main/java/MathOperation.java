import java.util.Arrays;

public enum MathOperation {
    PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/");
    private final String operator;
    MathOperation(String operator) {
        this.operator = operator;
    }

    public static boolean isNotMathOperation(String operator) {
        return Arrays.stream(MathOperation.values())
                .noneMatch(it -> it.operator.equals(operator));
    }
}
