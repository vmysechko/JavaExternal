package ua.ejc.vitaliy.javagamemvc;

import java.util.Arrays;

public class Model {

    private int[] userData;

    public Model() {
    }

    public int[] getUserData() {
        return userData;
    }

    public void setUserData(int length) {
        this.userData = new int[length];
    }

    public void extendUserData(int place, int value){
        this.userData[place] = value;
    }


    public void updateUserData(int amountOfAttempts) {
        this.userData = Arrays.copyOf(userData, amountOfAttempts);
    }
}
