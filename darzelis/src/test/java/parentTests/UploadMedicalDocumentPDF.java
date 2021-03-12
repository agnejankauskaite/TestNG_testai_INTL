package parentTests;
import org.testng.annotations.Test;

import generalMethods.GeneralMethods;

public class UploadMedicalDocumentPDF extends GeneralMethods {
  
  @Test  (groups = "regression")
  public void successfullyUploadAndDeletePDF() {
	  // create test user (parent)
	  createNewParent(2);
	  doLogout();
	  doLogin(createNewUserParentEmail, createNewUserParentEmail);
	  
	  // go to "Mano pazymos" page
	  clickNavButtonMyDocumentsParent();
	  
	  // assert page
	  assertThatMyDocumentsPageLoaded();
	  
	  // upload document
	  uploadPDF();
	  
	  // delete document
	  deletePDF();
	  doLogout();
	  
	  // delete the user created for this test
	  doLoginAsAdmin();
	  deleteNewUser();
  }
}
