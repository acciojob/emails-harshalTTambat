package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character

        if (oldPassword.equals(getPassword()))
        {
            if (newPassword.length() < 8)
            {
                System.out.println("Password must contains at least 8 characters");
                return;
            }
            String upperCaseChars = "(.*[A-Z].*)";
            if (!newPassword.matches(upperCaseChars))
            {
                System.out.println("Password must contains at least one uppercase letter");
                return;
            }
            String lowerCaseChars = "(.*[a-z].*)";
            if (!newPassword.matches(lowerCaseChars ))
            {
                System.out.println("Password must have at least one lowercase character");
                return;
            }
            String numbers = "(.*[0-9].*)";
            if (!newPassword.matches(numbers ))
            {
                System.out.println("Password must have at least one number");
                return;
            }
            String specialChars = "(.*[@,#,$,%].*$)";
            if (!newPassword.matches(specialChars ))
            {
                System.out.println("Password must have at least one special character among @#$%");
                return;
            }

        }
        else {
            System.out.println("current password does not match...");
        }
    }
}
