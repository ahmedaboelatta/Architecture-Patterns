package com.alyndroid.architecturepatternstutorialshomework.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.alyndroid.architecturepatternstutorialshomework.pojo.NumberModel;

public class NumberViewModel extends ViewModel {
    //MVVM
    MutableLiveData<String> numberMutableLifeData = new MutableLiveData<>();

    public void getNumberResult(){
        int numberResult = getNumbersFromDatabase().getFirstNum() * getNumbersFromDatabase().getSecondNum();
        numberMutableLifeData.setValue("" + numberResult);
    }
    public NumberModel getNumbersFromDatabase(){
        return new NumberModel(4, 2);
    }

}
