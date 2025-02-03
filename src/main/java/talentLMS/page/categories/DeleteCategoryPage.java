package talentLMS.page.categories;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import talentLMS.page.base.BasePage;

public class DeleteCategoryPage extends BasePage {

//    @FindBy(xpath = "//a[@id=\"tl-confirm-submit\"]")
//    public WebElement deleteCategoryBtn;

     @FindBy(xpath = "//a[@class=\"btn btn-danger\" and @href=\"javascript:void(0)\" ]")
     public WebElement deleteCategoryBtn;

     @FindBy(xpath = "//a[@id=\"tl-confirm-submit\"]")
    public WebElement finalDeleteCategoryBtn;

     @FindBy(xpath = "//input[@value=\"Update category\"]")
    public WebElement updateCategoryBtn;

    public DeleteCategoryPage deleteCategory(String categoryName){
        driver.findElement(By.xpath("//a[contains(text(),'"+ categoryName + "')]"));
        if (categoryName != null) {
            driver.findElement(By.xpath("//a[contains(text(),'"+ categoryName + "')]")).click();
        } else {
            throw new NoSuchElementException("Категория с именем " + categoryName + " не найдена.");
        }
        webElementActions.click(deleteCategoryBtn)
                          .click(finalDeleteCategoryBtn);

        return this;
    }
}
