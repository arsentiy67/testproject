package core.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.By.ByPartialLinkText;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.SkipException;
import utils.logging.VegaLogger;

public class WebElementsList extends CustomWebElement implements List<CustomWebElement> {

  public WebElementsList(WebDriver driver, String name) {
    super(driver, name);
  }

  public int size() {
    int size = getAll().size();
    VegaLogger.info("Size of list {} is " + size, name);
    return size;
  }

  @Override
  public boolean isEmpty() {
    return getAll().size() == 0;
  }

  @Override
  public boolean add(CustomWebElement webElement) {
    return true;
  }

  @Override
  public void add(int index, CustomWebElement element) {
  }

  @Override
  public boolean remove(Object o) {
    return false;
  }

  @Override
  public CustomWebElement remove(int index) {
    return null;
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    return false;
  }

  @Override
  public boolean addAll(Collection<? extends CustomWebElement> c) {
    return false;
  }

  @Override
  public boolean addAll(int index, Collection<? extends CustomWebElement> c) {
    return false;
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    return false;
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    return false;
  }

  @Override
  public CustomWebElement set(int index, CustomWebElement element) {
    return null;
  }

  @Override
  public int indexOf(Object o) {
    return 0;
  }

  @Override
  public int lastIndexOf(Object o) {
    return 0;
  }

  @Override
  public WebElementsList template(String text) {
    if (copiedByLocator == null) {
      copiedByLocator = byLocator.toString();
    }
    String locator = String.format(copiedByLocator, text).replaceAll("(By\\.)(\\w+)(: )", "").trim();
    if (ById.class.equals(byLocator.getClass())) {
      byLocator = new ById(locator);
    } else if (ByLinkText.class.equals(byLocator.getClass())) {
      byLocator = new ByLinkText(locator);
    } else if (ByPartialLinkText.class.equals(byLocator.getClass())) {
      byLocator = new ByPartialLinkText(locator);
    } else if (ByName.class.equals(byLocator.getClass())) {
      byLocator = new ByName(locator);
    } else if (ByTagName.class.equals(byLocator.getClass())) {
      byLocator = new ByTagName(locator);
    } else if (ByXPath.class.equals(byLocator.getClass())) {
      byLocator = new ByXPath(locator);
    } else if (ByClassName.class.equals(byLocator.getClass())) {
      byLocator = new ByClassName(locator);
    } else if (ByCssSelector.class.equals(byLocator.getClass())) {
      byLocator = new ByCssSelector(locator);
    }
    return this;
  }

  public List<String> getTexts() {
    List<CustomWebElement> allElements = getAll();
    allElements.forEach(CustomWebElement::waitToBeVisible);
    return allElements.stream().map(CustomWebElement::getText).collect(Collectors.toList());
  }

  public boolean contains(Object o) {
    return getAll().contains(o);
  }

  public Iterator<CustomWebElement> iterator() {
    return getAll().iterator();
  }

  public Object[] toArray() {
    return getAll().toArray();
  }

  public <T> T[] toArray(T[] a) {
    return getAll().toArray(a);
  }

  public CustomWebElement get(int index) {
    try {
      return getAll().get(index);
    } catch (IndexOutOfBoundsException e) {
      VegaLogger.error("Can't find elements for locator {}", getLocator().toString());
    }
    return null;
  }

  public ListIterator<CustomWebElement> listIterator() {
    return getAll().listIterator();
  }

  public ListIterator<CustomWebElement> listIterator(int index) {
    return getAll().listIterator(index);
  }

  public List<CustomWebElement> subList(int fromIndex, int toIndex) {
    return getAll().subList(fromIndex, toIndex);
  }

  public boolean isDisplayed() {
    return getWebElements().get(0).isDisplayed();
  }

  public List<CustomWebElement> getAll() {
    return getWebElements();
  }

  private List<CustomWebElement> getWebElements() {
    List<CustomWebElement> elElements = new ArrayList<>();
    try {
      wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(getLocator(), 0));
    } catch (Exception e) {
      VegaLogger.info("No webelements with locator {}", getLocator().toString());
    }
    getDriver().findElements(getLocator())
        .forEach(el -> elElements.add(new CustomWebElement(driver, name, getLocator(), el)));
    return elElements;
  }

  public CustomWebElement getChildWithText(String expectedText) {
    for (CustomWebElement element : getWebElements()) {
      if (element.getChild(By.xpath(String.format("//*[text()='%s']", expectedText))).isDisplayed()) {
        return element;
      }
    }
    throw new SkipException("No child with expected text");
  }

  public void clickAll() {
    getAll().forEach(CustomWebElement::click);
  }
}
