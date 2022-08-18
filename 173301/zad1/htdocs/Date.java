import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class Date {

    public static void main(String[] args) {

        java.util.Date currentDate = new java.util.Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateTimeFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String errorMessage = "INVALID OPERATION - the service only functions either without any parameters or with the parameter \"time\", used with or without a value";
        StringBuilder sb = new StringBuilder("Content-type: text/html\n\n");
        sb.append("<html><head><title>Current Date</title></head><body>");


        java.util.Map<String, String> env = System.getenv();
        java.util.Map<String, String> paramsMap = parseParams(env.get("QUERY_STRING"));

        switch (paramsMap.size()) {
            case 0:
                sb.append(dateFormat.format(currentDate));
                break;
            case 1:
                if (paramsMap.containsKey("time")) {
                    sb.append(dateTimeFormat.format(currentDate));
                } else {
                    sb.append(errorMessage);
                }
                break;
            default:
                sb.append(errorMessage);
                break;
        }

        sb.append("</body></html>");
        System.out.println(sb);
    }

    private static Map<String, String> parseParams(String queryString) {
        Map<String, String> paramsMap = new HashMap<>();
        if (queryString != null && queryString.length() > 0) {
            String[] queryParams = queryString.split("&");

            for (String param : queryParams) {
                String[] pair = param.split("=");
                if(pair.length == 2) {
                    paramsMap.put(pair[0], pair[1]);
                } else {
                    paramsMap.put(pair[0], "");
                }
            }
        }

        return paramsMap;
    }
}