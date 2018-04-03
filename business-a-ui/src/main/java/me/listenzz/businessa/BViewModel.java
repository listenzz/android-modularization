package me.listenzz.businessa;

import android.arch.lifecycle.ViewModel;
import android.util.Log;

import javax.inject.Inject;

public class BViewModel extends ViewModel {

    private int counter;

    private FoodManager foodManager;

    @Inject
    BViewModel(FoodManager foodManager) {
        this.foodManager = foodManager;
        Log.w("Dagger", "BViewModel");
    }

    public int incrementAndGet() {
        return ++counter;
    }


    public String currentFood() {
        return foodManager.currentFood().name + "-" +incrementAndGet();
    }

}
