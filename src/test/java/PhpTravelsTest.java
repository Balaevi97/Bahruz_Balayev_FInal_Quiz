import SetUp.SelenIDESetUp;
import Steps.SelenIDESteps.*;
import org.testng.annotations.Test;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;


public class PhpTravelsTest extends SelenIDESetUp {
GeneratePersonInformationSteps generatePersonInformationSteps = new GeneratePersonInformationSteps();
    GenerateEmailSteps generateEmailSteps = new GenerateEmailSteps();
    SignUpSteps signUpSteps = new SignUpSteps();
    LogInSteps logInSteps = new LogInSteps();
    SearchHotelSteps searchHotelSteps = new SearchHotelSteps ();
    MaximumPriceHotelSteps maximumPriceHotelSteps = new MaximumPriceHotelSteps();
    RoomBookingSteps roomBookingSteps = new RoomBookingSteps();
    UploadFileSteps uploadFileSteps = new UploadFileSteps();


    @Test (priority = 1)
    public void getUserInformation () {
        generatePersonInformationSteps.openDataGeneratorLink()
                                        .getUserInformation();

    }


    @Test (priority = 1)
    public void signUP () throws IOException, UnsupportedFlavorException {
        generateEmailSteps.openURl()
                            .copyEmail();
        signUpSteps.signUpMethod();
        generateEmailSteps.clickActivateAccount()
                            .assertActivation();
    }

    @Test (priority = 2)
    public void logIn ()  {
        logInSteps.getLoginPage()
                    .setEmail()
                    .setPassword()
                    .clickLoginBTN()
                    .assertLogin();

    }

    @Test (priority = 3)
    public void searchHotel () {
        searchHotelSteps.clickOnHotels()
                        .chooseCity()
                        .setCheckInDate()
                        .setCheckOutDate()
                        .decreaseAdultQuantity()
                        .clickSearchButton()
                        .assertSearchedHotel();
    }

    @Test (priority = 4)
    public void findMaxPriceHotel () {
        maximumPriceHotelSteps.filterWithStar5()
                                .applyFilter()
                                .findMaxPriceHotel()
                                .findMaxPriceHotelName()
                                .selectMaxPriceHotel()
                                .findMaxPriceRoom()
                                .findMaxPriceRoomName()
                                .selectRoomForReserve()
                                .findSelectedRoomPrice()
                                .assertSelectedRoom();
    }

    @Test (priority = 5)
    public void bookRoom ()  {
        roomBookingSteps
                        .setAdultFirstName()
                        .setAdultLastName()
                        .clickPayPayLater()
                        .clickAgreeToAll()
                        .clickBooking()
                        .assertNightQuantity()
                        .assertPaymentMethod()
                        .assertCheckInDate()
                        .assertCheckOutDate()
                        .downloadInvoice()
                        .assertFile();
    }

    @Test (priority = 6)
    public void uploadFile () {
        uploadFileSteps.openFileUploadedURl()
                        .uploadFile()
                        .submitUploadedFile();
    }

}
