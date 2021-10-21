package com.epam.testproject.ui.utils;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class MethodUtils {

    public static void selectItemFromList(List<WebElement> elements, String text) {
        elements.stream()
                .filter(webElement -> text.equalsIgnoreCase(webElement.getText()))
                .findFirst()
                .ifPresent(WebElement::click);
    }

    public static List<String> getTextsFromLabels(List<WebElement> labels) {
        return labels.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
