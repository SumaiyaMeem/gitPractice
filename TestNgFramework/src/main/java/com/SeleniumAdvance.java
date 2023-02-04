package com;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class SeleniumAdvance {
	
	WebDriver dr;
	WebElement element;
	
	public void seleniumTest() {
		
		dr.close();
		WebElement ele = dr.findElement(By.id(""));
		ele.clear();
		ele.click();
		ele.getAttribute("id");
		ele.getLocation().getX();//to handle rectangle box;
		ele.getRect().getHeight();//to get highest
		ele.getScreenshotAs(OutputType.FILE);//to take screenshot
		int height = ele.getSize().height;
		ele.getTagName();
		ele.getText();
		ele.isDisplayed();
		ele.isEnabled();
		ele.isSelected();
		ele.sendKeys("");
		ele.sendKeys(Keys.ENTER);
		ele.submit();//like click method
		
		List<WebElement> elements = dr.findElements(By.id(""));
		elements.size();
		dr.get("");
		dr.getCurrentUrl();
		dr.getPageSource();
		dr.getWindowHandle();//to grab parent window
		Set<String> s = dr.getWindowHandles();// to grab child window// it returns set of string
		
		Options opt = dr.manage();
		opt.addCookie(new Cookie("", ""));//under options class we have all cookie related method
		Set<Cookie> cookie = opt.getCookies();
		opt.timeouts().implicitlyWait(20, TimeUnit.SECONDS);//any page loaded method
		opt.window().maximize();
		opt.window().minimize();//any window related methods.
		opt.window().fullscreen();
		
		Navigation nav = dr.navigate();
		nav.back();
		nav.forward();//these methods are all navigation purpose.
		nav.to("");
		nav.refresh();
		
		dr.quit();
		TargetLocator tr = dr.switchTo();
		tr.activeElement();
		tr.defaultContent();//to navigate back to main page.
		tr.frame(5);// method overloading concept
		tr.frame("");
		tr.frame(ele);

		Alert a = tr.alert();
		a.accept();
		a.dismiss();
		a.getText();
		a.sendKeys("");
		//to handle customized alert box or window based pop up box we need third party api
		//like sikulli, autoit, robot api.
				
		
	}
	
	public void selectFromDropdown(){

        Select select = new Select(dr.findElement(By.xpath("ele")));

        select.selectByIndex(0);
        select.selectByValue("Value");
        select.selectByVisibleText("January");
        int sizeOfDropdown =  select.getOptions().size();

        for (int i = 0; i<sizeOfDropdown;i++){
            select.selectByIndex(i);
        }
    }

    public  void mouseHandle(){
        Actions actions = new Actions(dr);
        // before performing we need to use build and perform  method
        actions.click();
        actions.clickAndHold();
        actions.clickAndHold(null);
        actions.contextClick().build().perform();
        actions.doubleClick();
        actions.dragAndDrop(element,element);
        actions.dragAndDropBy(element,100,150).build().perform();
        actions.keyDown(Keys.ARROW_UP);
        actions.moveToElement(element).build().perform();
        actions.pause(2).release();
        actions.sendKeys(Keys.chord(Keys.CONTROL,Keys.SHIFT),"p");
    }

    public void  multipleWindowHandle(){

        String parentWindow  = dr.getWindowHandle();

        Actions actions = new Actions(dr);
        actions.contextClick(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

        Set<String> childWindow = dr.getWindowHandles();
        for (String win : childWindow){
            if(!win.equals(parentWindow)){
                dr.switchTo().window(win);
                dr.findElement(By.id("id")).click();
                break;
            }
        }
        dr.switchTo().defaultContent();
    }

    public void handleDynamicFrame(String frameValue)
    {
       List<WebElement> allFrames =dr.findElements(By.tagName("iframe"));
       for (WebElement frame : allFrames){
           if (frame.getAttribute("class").equals(frameValue)){
               dr.switchTo().frame(frameValue);
           }
       }

    }

    public void takeScreenshot() throws IOException {
        File  file = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
        Files.copy(file, new File("filePath"));
    }

    public void  javaScriptExecutor(){
        JavascriptExecutor js = (JavascriptExecutor)element;
        js.executeScript("document.getElementById('id').click()");
    }


}
