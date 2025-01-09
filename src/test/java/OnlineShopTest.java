import SetUp.SeleniumSetUp;
import Steps.SeleniumSteps.*;
import org.testng.annotations.Test;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class OnlineShopTest extends SeleniumSetUp {
    GeneratePersonInformationSteps generatePersonInformationSteps = new GeneratePersonInformationSteps();
    RegisterSteps registerSteps = new RegisterSteps();
    TestBasketSteps testBasketSteps = new TestBasketSteps();
    CollectCoursesToBasketSteps collectCoursesToBasketSteps = new CollectCoursesToBasketSteps ();
    CheckoutCourseSteps checkoutCourseSteps = new CheckoutCourseSteps();
    OrderCourseSteps orderCourseSteps = new OrderCourseSteps();
    ChangePasswordSteps changePasswordSteps = new ChangePasswordSteps();
    ReLoginSteps reLoginSteps = new ReLoginSteps();


   @Test (priority = 1)
   public void getUserInformation () {
       generatePersonInformationSteps.openDataGeneratorURL()
                                        .getAllInformation();
   }


    @Test (priority = 2)
    public void onlineShopping () throws IOException, UnsupportedFlavorException {
        registerSteps.openURl()
                .switchToNeTab()
                        .copyEmail()
                        .openNeTab()
                        .switchToNeTab()
                        .setEmailInput()
                        .setPasswordInput()
                        .assertLogin();
    }

    @Test (priority = 3)
    public void testBasket ()  {
        testBasketSteps.clickShopButton()
                        .clickOrderByLowToHigh()
                        .assertPriceOrder()
                        .clickFilterJavaScript()
                        .assertAllFilteredJavasScriptElements()
                        .assertHeaderOfJavascriptCourses()
                        .priceFilterBar()
                        .clickFilterButton()
                        .assertOneItem()
                        .clickFilterButton()
                        .clickAdToBasket()
                        .seleniumRubyCoursePrice()
                        .refreshPage()
                        .assertBasketPrice()
                        .moveToBasket()
                        .assertAddedItem()
                        .clickRemoveItem()
                        .assertBasket();
    }
    @Test (priority = 4)
    public void collectCourse () {
        collectCoursesToBasketSteps.backToShop()
                                .addHTML5FormsBook()
                                .addSeleniumRubyBook();
    }

    @Test (priority = 5)
    public void addCourseOnBasket () {
        checkoutCourseSteps
                            .findTotalPriceBeforeCoupon()
                            .couponIsDisplayed()
                            .findTotalPriceAfterCoupon()
                            .assertCouponEffect()
                            .clickRemoveCoupon()
                            .findTotalPriceAfterDeletingCoupon()
                            .assertRemovingCoupon()
                            .saveOrderItemQuantityInformation()
                            .couponIsDisplayed()
                            .clickApplyCoupon()
                            .clickCheckOut();
    }

    @Test (priority = 6)
    public void placeOrder () {
        orderCourseSteps.sendFirstName()
                        .sendLastName()
                        .sendPhoneNumber()
                        .sendAddress()
                        .sendCity()
                        .sendPostalCode()
                        .clickPaymentMethod()
                        .placeOrder()
                        .assertPaymentMethod()
                        .assertProductQuantity()
                        .assertTotalPrice()
                        .moveToMyAccount()
                        .openOrders()
                        .assertOrderDisplayed();
    }

    @Test (priority = 7)
    public void changePassword () {
        changePasswordSteps.moveToAccountDetails()
                            .sendAccountFirstName()
                            .sendAccountLastName()
                            .sendCurrentPassword()
                            .sendNewPassword()
                            .repeatPassword()
                            .clickSaveChangedPassword()
                            .assertChangedPassword();
    }

    @Test (priority = 8)
    public void reLogin () {
        reLoginSteps.logOut()
                    .sendUsername1()
                    .sendPassword1()
                    .logIn1()
                    .assertLogIn();
    }
}