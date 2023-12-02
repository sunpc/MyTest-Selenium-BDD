package com.sunpc.mytest.base;

import com.sunpc.mytest.helper.VisibilityHelper;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;

public abstract class BasePage {

    @Autowired
    protected VisibilityHelper visibilityHelper;

    private WebElement getWebElementObject(String webElement) throws NoSuchFieldException, IllegalAccessException {
        Class<?> clazz = this.getClass();
        Field webElementField = clazz.getDeclaredField(webElement);
        webElementField.setAccessible(true);
        return (WebElement) webElementField.get(this);
    }

    public void sendKeys(String search, String webElement) throws NoSuchFieldException, IllegalAccessException {
        WebElement webElementObj = getWebElementObject(webElement);
        webElementObj.sendKeys(search);
    }

    public void click(String webElement) throws NoSuchFieldException, IllegalAccessException {
        WebElement webElementObj = getWebElementObject(webElement);
        webElementObj.click();
    }

    public void assertWebElementPresent(String webElement) throws NoSuchFieldException, IllegalAccessException {
        WebElement webElementObj = getWebElementObject(webElement);
        visibilityHelper.waitForVisibilityOf(webElementObj);
    }

}
