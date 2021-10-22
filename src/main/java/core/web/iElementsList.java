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
import utils.logging.iLogger;

public class iElementsList extends iWebElement implements List<iWebElement> {

  public iElementsList(WebDriver driver, String name) {
    super(driver, name);
  }

  public int size() {
    int size = getAll().size();
    iLogger.info("Size of list {} is " + size, name);
    return size;
  }

  @Override
  public boolean isEmpty() {
    return getAll().size() == 0;
  }

  @Override
  public boolean add(iWebElement webElement) {
    return true;
  }

  @Override
  public void add(int index, iWebElement element) {
  }

  @Override
  public boolean remove(Object o) {
    return false;
  }

  @Override
  public iWebElement remove(int index) {
    return null;
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    return false;
  }

  @Override
  public boolean addAll(Collection<? extends iWebElement> c) {
    return false;
  }

  @Override
  public boolean addAll(int index, Collection<? extends iWebElement> c) {
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
  public iWebElement set(int index, iWebElement element) {
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
  public iElementsList template(String text) {
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
    List<iWebElement> allElements = getAll();
    allElements.forEach(iWebElement::waitToBeVisible);
    return allElements.stream().map(iWebElement::getText).collect(Collectors.toList());
  }

  public boolean contains(Object o) {
    return getAll().contains(o);
  }

  public Iterator<iWebElement> iterator() {
    return getAll().iterator();
  }

  public Object[] toArray() {
    return getAll().toArray();
  }

  public <T> T[] toArray(T[] a) {
    return getAll().toArray(a);
  }

  public iWebElement get(int index) {
    try {
      return getAll().get(index);
    } catch (IndexOutOfBoundsException e) {
      iLogger.error("Can't find elements for locator {}", getLocator().toString());
    }
    return null;
  }

  public ListIterator<iWebElement> listIterator() {
    return getAll().listIterator();
  }

  public ListIterator<iWebElement> listIterator(int index) {
    return getAll().listIterator(index);
  }

  public List<iWebElement> subList(int fromIndex, int toIndex) {
    return getAll().subList(fromIndex, toIndex);
  }

  public boolean isDisplayed() {
    return getWebElements().get(0).isDisplayed();
  }

  public List<iWebElement> getAll() {
    return getWebElements();
  }

  private List<iWebElement> getWebElements() {
    List<iWebElement> elElements = new ArrayList<>();
    try {
      wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(getLocator(), 0));
    } catch (Exception e) {
      iLogger.info("No webelements with locator {}", getLocator().toString());
    }
    getDriver().findElements(getLocator())
        .forEach(el -> elElements.add(new iWebElement(driver, name, getLocator(), el)));
    return elElements;
  }

  public iWebElement getChildWithText(String expectedText) {
    for (iWebElement element : getWebElements()) {
      if (element.getChild(By.xpath(String.format("//*[text()='%s']", expectedText))).isDisplayed()) {
        return element;
      }
    }
    throw new SkipException("No child with expected text");
  }

  public void clickAll() {
    getAll().forEach(iWebElement::click);
  }
}
