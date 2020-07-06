package com.alyndroid.architecturepatternstutorialshomework.ui;

import com.alyndroid.architecturepatternstutorialshomework.pojo.NumberModel;

public class NumberPresenter {
    //MVP
    NumberInterface view;

    public NumberPresenter(NumberInterface view) {
        this.view = view;
    }
    public NumberModel getNumbersFromDatabase(){
        return new NumberModel(4, 2);
    }
    public void getNumbers(){
        int result = 0;
        result = getNumbersFromDatabase().getFirstNum() / getNumbersFromDatabase().getSecondNum();
        view.onGetNumbers(result);
    }
}
