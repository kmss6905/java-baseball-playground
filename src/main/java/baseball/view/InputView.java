package baseball.view;

public class InputView {

  public static final String PROMPT_MESSAGE = "숫자를 입력해 주세요: ";

  void getUserInput(String userInput) {
    printNumberPrompt();
  }

  private void validateUserInput() {

  }

  public void printNumberPrompt() {
    System.out.print(PROMPT_MESSAGE);
  }
}
