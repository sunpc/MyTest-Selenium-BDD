package com.sunpc.mytest.helper;

import com.sunpc.mytest.helper.VisibilityHelper;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class PageHelper {

    @Autowired
    private VisibilityHelper visibilityHelper;

    private Object page;

    private WebElement getWebElementObject(String webElement) throws NoSuchFieldException, IllegalAccessException {
        Class<?> clazz = this.page.getClass();
        Field webElementField = clazz.getDeclaredField(webElement);
        webElementField.setAccessible(true);
        return (WebElement) webElementField.get(this.page);
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

    public void setPage(Object page) {
        this.page = page;
    }

    public Object getPage() {
        return this.page;
    }
}
