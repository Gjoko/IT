import java.util.HashMap;
import java.util.Map;

public class GuessNumber {

  private static String errorMessage =
          "INVALID OPERATION - the guess_number service expects a GET or POST parameter "
                  + "operand1 with an integer value and will output if you guessed the imagined number correctly or will output"
                  + " that your guess was higher or lower than the imagined number";
  private static int number = 3;

  public static void main(String[] args) {

    System.out.println("Content-type: text/html\n\n");

    StringBuilder sb = new StringBuilder("<html><head><title>Current Date</title></head><body>");

    Map<String, String> env = System.getenv();
    Map<String, String> paramsMap = parseParams(env.get("QUERY_STRING"));
    String requestMethod = env.get("REQUEST_METHOD");

    if (requestMethod.equals("GET") && paramsMap.containsKey("operand1")) {
      try {
        int guessedNumber = Integer.parseInt(paramsMap.get("operand1"));
        compareNumberAndPrint(guessedNumber, sb);
      } catch (Exception e) {
        sb.append(errorMessage);
      }
    } else if (requestMethod.equals("POST")) {
      long len_ = Long.parseLong(env.get("CONTENT_LENGTH"));
      if (len_ > 0) {
        String requestBody =
                new java.io.BufferedReader(
                        new java.io.InputStreamReader(
                                System.in, java.nio.charset.StandardCharsets.UTF_8))
                        .lines()
                        .collect(java.util.stream.Collectors.joining("\n"));
        Map<String, String> bodyMap = parseBody(requestBody);
        if(bodyMap.containsKey("operand1")) {
          try {
            int guessedNumber = Integer.parseInt(bodyMap.get("operand1"));
            compareNumberAndPrint(guessedNumber, sb);
          } catch (Exception e) {
            sb.append(e);
            sb.append(errorMessage);
          }
        } else {
          sb.append(errorMessage);
        }
      } else {
        sb.append(errorMessage);
      }
    } else {
      sb.append(errorMessage);
    }

    sb.append("</body></html>");
    System.out.println(sb);
  }

  private static Map<String, String> parseBody(String body) {
    Map<String, String> paramsMap = new HashMap<>();
    String pairDelimiter = ",";
    String keyValueDelimiter = ":";
    if (!body.contains("{") && !body.contains("}")) {
      pairDelimiter = "&";
      keyValueDelimiter = "=";
    }
    body = body.replaceAll("\\{", "").replaceAll("\\}", "");
    String[] bodyPairs = body.split(pairDelimiter);
    for (String bodyPair : bodyPairs) {
      String[] keyValuePair = bodyPair.trim().split(keyValueDelimiter);
      if(keyValuePair.length == 2) {
        paramsMap.put(keyValuePair[0].trim().replaceAll("\"", ""), keyValuePair[1].trim().replaceAll("\"", ""));
      } else {
        paramsMap.put(keyValuePair[0].trim().replaceAll("\"", ""), null);
      }
    }
    return paramsMap;
  }

  private static Map<String, String> parseParams(String queryString) {
    Map<String, String> paramsMap = new HashMap<>();
    if (queryString != null && queryString.length() > 0) {
      String[] queryParams = queryString.split("&");

      for (String param : queryParams) {
        String[] pair = param.split("=");
        if (pair.length == 2) {
          paramsMap.put(pair[0], pair[1]);
        } else {
          paramsMap.put(pair[0], null);
        }
      }
    }
    return paramsMap;
  }

  private static void compareNumberAndPrint(int guessedNumber, StringBuilder sb) {
    if (guessedNumber == number) {
      sb.append("You guessed correctly!");
    } else if (guessedNumber > number) {
      sb.append("Your guess is incorrect. The number I imagined is lower.");
    } else {
      sb.append("Your guess is incorrect. The number I imagined is higher.");
    }
  }
}