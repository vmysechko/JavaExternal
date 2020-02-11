package ua.ejc.vitaliy.javagamemvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model {

    private int minBarrier;

    private int maxBarrier;

    private int secretNumber;

    private List<Integer> userData = new ArrayList<>();

    //Empty constructor with use Global Constants for min and max barriers.
    public Model() {
    }

    public boolean checkValue(int value){
        userData.add(value);
        if(value == secretNumber){
            return true;
        } else if(value > secretNumber){
            maxBarrier = value;
        } else {
            minBarrier = value;
        }
        return false;
    }

    public void setBarriers(int minBarrier, int maxBarrier){
        this.minBarrier = minBarrier;
        this.maxBarrier = maxBarrier;
    }

    public int getMinBarrier() {
        return minBarrier;
    }

    public void setMinBarrier(int minBarrier) {
        this.minBarrier = minBarrier;
    }

    public int getMaxBarrier() {
        return maxBarrier;
    }

    public void setMaxBarrier(int maxBarrier) {
        this.maxBarrier = maxBarrier;
    }

    public int getSecretNumber() {
        return secretNumber;
    }

    public void setSecretNumber() {
        this.secretNumber = (int) Math.ceil(Math.random() *
                (maxBarrier - minBarrier -1) + minBarrier);
    }

    public List<Integer> getUserData() {
        return userData;
    }

}
