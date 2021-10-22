package utils;

import org.testng.Assert;

public class CustomAssert extends Assert {

  public static final Character OPENING_CHARACTER = '[';
  public static final Character CLOSING_CHARACTER = ']';

  public static final String ASSERT_LEFT = "expected " + OPENING_CHARACTER;
  public static final String ASSERT_RIGHT = Character.toString(CLOSING_CHARACTER);
  public static final String ASSERT_CONTAINS = CLOSING_CHARACTER + " to contain " + OPENING_CHARACTER;
  public static final String ERROR_MESSAGE = " but it doesn't ";

  public static void assertContains(String actual, String expected, String message) {
    if (!actual.contains(expected)) {
      fail(format(actual, expected, message));
    }
  }

  static String format(Object actual, Object expected, String message) {
    String formatted = "";
    if (null != message) {
      formatted = message + ": ";
    }

    return formatted + ASSERT_LEFT + expected + ASSERT_CONTAINS + actual + ASSERT_RIGHT + ERROR_MESSAGE;
  }
}
