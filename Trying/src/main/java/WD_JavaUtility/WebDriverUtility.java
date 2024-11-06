package WD_JavaUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	public Actions act=null;
	public Select sel=null;
	public void scrollToTheElement(WebDriver driver,WebElement ele) {
		act=new Actions(driver);
		act.scrollToElement(ele);
	}
	
	public void scrollToElementByValues(WebDriver driver,int x,int y) {
		act=new Actions(driver);
		act.scrollByAmount(x, y);
	}
	
	public void performRightClick(WebDriver driver,WebElement ele ) {
		act=new Actions(driver);
		act.contextClick(ele);
	}
	
	public void sendData(WebDriver driver,WebElement ele, String str) {
		act=new Actions(driver);
		act.sendKeys(ele, str);
	}
	
	public void chooseByVisibleText(WebElement ele,String text) {
		sel=new Select(ele);
		sel.selectByVisibleText(text);
	}
	
	public void chooseByIndex(WebElement ele,int index) {
		sel=new Select(ele);
		sel.selectByIndex(index);
	}
	
	public void chooseByValue(WebElement ele,String value) {
		sel=new Select(ele);
		sel.selectByValue(value);
	}
	
	public void unSelectByINdex(WebElement ele,int index) {
		sel=new Select(ele);
		sel.deselectByIndex(index);
	}
	
	public void unSelectByValue(WebElement ele,String value) {
		sel=new Select(ele);
		sel.deselectByValue(value);
	}
	
	public void unSelectByVisibleText(WebElement ele,String text) {
		sel=new Select(ele);
		sel.deselectByVisibleText(text);
	}
	
	public boolean checkIsMultipleSelect(WebElement ele) {
		sel=new Select(ele);
		return sel.isMultiple();
	}
	
	public void selectAllOptions(WebElement ele) {
		sel=new Select(ele);
		sel.deselectAll();
	}
	
	public void unselectAllOptions(WebElement ele) {
		sel=new Select(ele);
		sel.deselectAll();
	}
}
