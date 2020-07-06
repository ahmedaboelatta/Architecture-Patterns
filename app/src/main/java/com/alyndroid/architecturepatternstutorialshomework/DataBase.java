package com.alyndroid.architecturepatternstutorialshomework;

import com.alyndroid.architecturepatternstutorialshomework.pojo.NumberModel;

public class DataBase {
    //MVC
    public NumberModel getNumbers(){
        return new NumberModel(4, 2);
    }
}
