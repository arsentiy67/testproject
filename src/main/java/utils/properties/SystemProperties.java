package utils.properties;

@FilePath(value = "./src/test/resources/env.properties")
public class SystemProperties {

  @Property(value = "base_url")
  public static String BASE_URL;

  @Property(value = "browser_version")
  public static String BROWSER_VERSION;

  @Property(value = "driver")
  public static String DRIVER;
}
