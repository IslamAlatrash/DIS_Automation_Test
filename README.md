# DIS_Automation_Test

# Selenium 4

# Maven Dependency
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.0.0-alpha-3</version>
</dependency>


# Take Screen Shot of a WebElement (EX)
@Test
  public void screenshotTest() throws IOException {
 
    WebDriverManager.chromedriver().setup();
 
    WebDriver driver = new ChromeDriver();
    driver.navigate().to("https://www.swtestacademy.com");
 
    WebElement logo = driver.findElement(By.className("fusion-logo-link"));
 
    File file = logo.getScreenshotAs(OutputType.FILE);
    
    FileUtils.copyFile(file,new File("logo.png"));
  }
 
  
  # Open Window of Tab (EX)
  @Test
  public void openNewWindow(){
 
    WebDriverManager.chromedriver().setup();
 
    WebDriver driver = new ChromeDriver();
    driver.navigate().to("https://www.google.com");
    driver.switchTo().newWindow(WindowType.WINDOW);
    driver.navigate().to("https://www.swtestacademy.com");
  }
  
  
  # Getting Object Location and Size (EX)
  
@Test
  public void location(){
 
    WebDriverManager.chromedriver().setup();
 
    WebDriver driver = new ChromeDriver();
    driver.navigate().to("https://www.swtestacademy.com");
 
    WebElement logo = driver.findElement(By.className("fusion-logo-link"));
 
    System.out.println("Height is "+logo.getRect().getDimension().getHeight());
    System.out.println("Width is "+logo.getRect().getDimension().getWidth());
    System.out.println("Location X is "+logo.getRect().getX());
    System.out.println("Location Y is "+logo.getRect().getY());
  }
  
  
