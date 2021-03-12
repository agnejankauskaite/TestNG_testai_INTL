package specialistTests;

import org.testng.annotations.Test;

import generalMethods.GeneralMethods;

public class CreateAndDeleteNewKindergarten extends GeneralMethods {
  @Test
  public void createAndDeleteNewKindergarten() {
	  successfullyCreateNewKindergarten();
	  deleteNewKindergarten();
	  doLogout();
  }
}
