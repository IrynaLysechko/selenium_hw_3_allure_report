package com.epam.decorator.elements;

import com.epam.decorator.AbstractElement;
import org.openqa.selenium.WebElement;

public class Button extends AbstractElement {

    public Button(WebElement webElement) {
        super(webElement);
    }

    public void click() {
        webElement.click();
    }
}
