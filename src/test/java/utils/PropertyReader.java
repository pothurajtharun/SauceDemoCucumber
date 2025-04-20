package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PropertyReader {

  private static final Logger log = LogManager.getLogger(PropertyReader.class);

  private static final Properties properties;

  static {
    try {
      FileInputStream fis =
          new FileInputStream(
              System.getProperty("user.dir") + "/src/test/resources/global.properties");
      properties = new Properties();
      properties.load(fis);
    } catch (IOException e) {
      throw new RuntimeException("Failed to load global.properties");
    }
  }

  public static String getValueByProperty(String key) {
    return properties.getProperty(key);
  }
}
