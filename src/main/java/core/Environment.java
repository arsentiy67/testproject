package core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import utils.logging.VegaLogger;
import utils.properties.EnvProperties;
import utils.properties.SystemProperties;

public class Environment {

  public static String getBaseUrl() {
    Pattern p = Pattern.compile("^\\w+\\.([\\w\\.-]+)(?::\\d+)?$");
    Matcher m = p.matcher(SystemProperties.BASE_URL);
    if (m.find()) {
      VegaLogger.info("Get base URL: " + m.group(1));
      return m.group(1);
    } else {
      VegaLogger.info("Get base URL: No match");
      return SystemProperties.BASE_URL;
    }
  }

  public static String getSiteUrl(String property) {
    String localPort = EnvProperties.USE_LOCAL_PORT;
    String http;
    String portColon;

    if (localPort.isEmpty()) {
      http = "https";
      portColon = "";
    } else {
      http = "http";
      portColon = ":";
    }

    return String.format("%s://%s%s%s", http, property, portColon, localPort);
  }
}
