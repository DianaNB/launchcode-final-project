package com.launchcode.adrienne.FinalProjectTest.models.forms;

import org.springframework.data.annotation.Transient;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Register extends Login {
//
////    public void setConfirmPassword(String password) {
////        confirmPassword=checkPassword(confirmPassword);
////        this.confirmPassword = confirmPassword;
////    }
////    private String checkPassword(String confirmPassword) {
////        if (confirmPassword != null
////                && !getPassword().equals(confirmPassword)) {
////            return null;
////        }
////        return confirmPassword;
////    }
//
//
//
//
////NEW
//
@NotNull
@Pattern(regexp = "(\\S){4,20}", message = "Password must have 4-20 characters")
private String confirmPassword;


public Register() {
}

public String getConfirmPassword() {
    return confirmPassword;
}

public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;

}

//private void checkPassword() {
////    if (password != null && confirmPassword != null
////            && !password.equals(confirmPassword)) {
////        confirmPassword = null;
////    }
}


//
//




//WHAT I HAD BEFORE

//    @Override
//    public void setPassword(String password) {
//        super.setPassword(password);
//        checkPasswordForRegistration();
//    }
//
//    public String getConfirmPassword() {
//        return confirmPassword;
//    }
//
//    public void setConfirmPassword(String confirmPassword) {
//        this.confirmPassword = confirmPassword;
//
//        checkPasswordForRegistration();
//    }
//
//    private void checkPasswordForRegistration() {
//        if (!getPassword().equals(confirmPassword)) {
//            confirmPassword = null;





