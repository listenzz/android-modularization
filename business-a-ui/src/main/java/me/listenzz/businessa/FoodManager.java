package me.listenzz.businessa;


import android.util.Log;

import javax.inject.Inject;


public class FoodManager {

    @Inject
    public FoodManager(){
        Log.w("Dagger", "FoodManager");
    }

    Food currentFood() {
        return new Food("湛江白切鸡");
    }


}
