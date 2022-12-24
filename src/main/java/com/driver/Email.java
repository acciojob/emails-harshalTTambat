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
           if(isValidPassword(newPassword))
           {
               oldPassword = newPassword;
           }
        }
        else {
            System.out.println("current password does not match...");
        }

    }
    public boolean isValidPassword(String password)
    {
        boolean isValid = true;
        if (password.length() < 8)
        {
            System.out.println("Password must be less than 20 and more than 8 characters in length.");
            isValid = false;
        }
        String upperCaseChars = "(.*[A-Z].*)";
        if (!password.matches(upperCaseChars ))
        {
            System.out.println("Password must have at least one uppercase character");
            isValid = false;
        }
        String lowerCaseChars = "(.*[a-z].*)";
        if (!password.matches(lowerCaseChars ))
        {
            System.out.println("Password must have at least one lowercase character");
            isValid = false;
        }
        String numbers = "(.*[0-9].*)";
        if (!password.matches(numbers ))
        {
            System.out.println("Password must have atleast one number");
            isValid = false;
        }
        String specialChars = "(.*[@,#,$,%].*$)";
        if (!password.matches(specialChars ))
        {
            System.out.println("Password must have atleast one special character among @#$%");
            isValid = false;
        }
        return isValid;
    }
}
