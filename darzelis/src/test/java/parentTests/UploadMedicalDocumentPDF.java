package parentTests;
import org.testng.annotations.Test;

import generalMethods.GeneralMethods;

public class UploadMedicalDocumentPDF extends GeneralMethods {
	
	/**
	 * Test scenario:
	 * Upload medical document (pdf) to parent account
	 * 
	 * Preconditions:
	 * admin@admin.lt is already created. New user user123@parent.lt is created during the test
	 * 
	 * Test steps:
	 * 1. Login as admin
	 * 2. Create new parent 
	 * 3. Logout
	 * 4. Login as the newly created parent
	 * 5. Go to "Mano pazymos" page
	 * 6. Upload pdf
	 * 7. Delete it
	 * 8. Logout
	 * 9. Login as admin
	 * 10. Delete the test user
	 */
  
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
