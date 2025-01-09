package Steps.SelenIDESteps;

import Elements.SelenIDEElements.UploadFile;
import SetUp.FileUtils;
import SetUp.SelenIDESetUp;
import SetUp.URLClass;

import java.io.File;
import java.util.Optional;


public class UploadFileSteps extends UploadFile {
    SelenIDESetUp selenIDESetUp = new SelenIDESetUp();
    URLClass urlClass = new URLClass();

    public UploadFileSteps openFileUploadedURl () {
        selenIDESetUp.openPage(urlClass.fileUploadPage);
        return this;
    }

    public UploadFileSteps uploadFile () {
        Optional<File> foundFile = FileUtils.findFile(System.getProperty("user.home") + "\\Downloads", "invoice.pdf");
        foundFile.ifPresent(file -> fileUpload.uploadFile(file));
        return this;
    }

    public void submitUploadedFile () {
        System.out.println(fileUpload.getText());
        uploadSubmit.click();
    }

}