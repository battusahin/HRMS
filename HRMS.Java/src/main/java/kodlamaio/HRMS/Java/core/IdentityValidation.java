package kodlamaio.HRMS.Java.core;

import kodlamaio.HRMS.Java.services.FakeMernis;

public class IdentityValidation {
    public static boolean isRealPerson(String tcno) {

        return FakeMernis.validate(tcno);
    }
}
