package talentLMS.page.categories;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talentLMS.page.base.BasePage;

public class DeleteCategoryPage extends BasePage {

     @FindBy(xpath = "//a[@class=\"btn btn-danger\" and @href=\"javascript:void(0)\" ]")
     public WebElement deleteCategoryBtn;

     @FindBy(xpath = "//a[@id=\"tl-confirm-submit\"]")
    public WebElement finalDeleteCategoryBtn;

    public DeleteCategoryPage deleteCategory(String categoryName){
      WebElement xpath = driver.findElement(By.xpath("//a[contains(text(),'"+ categoryName + "')]"));
        if (categoryName != null) {
            xpath.click();
        } else {
            throw new NoSuchElementException("Категория с именем " + categoryName + " не найдена.");
        }
        webElementActions.click(deleteCategoryBtn)
                          .click(finalDeleteCategoryBtn);
        return this;
    }

    public boolean isCategoryPresent(String categoryName) {
        try {
            WebElement category = driver.findElement(By.xpath("//a[contains(text(),'" + categoryName + "')]"));
            return false;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
