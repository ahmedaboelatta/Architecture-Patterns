package com.alyndroid.architecturepatternstutorialshomework.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alyndroid.architecturepatternstutorialshomework.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.R;
import com.alyndroid.architecturepatternstutorialshomework.pojo.NumberModel;

public class MainActivity extends AppCompatActivity implements NumberInterface{
    TextView plus_result, div_result, mul_result;
    Button plus_button, div_button, mul_button;
    int plusResult = 0;
    int divResult = 0;
    //MVC
    NumberPresenter presenter;
    //MVVM
    NumberViewModel mNumberViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plus_result = findViewById(R.id.plus_result_textView);
        if (savedInstanceState != null){
            plusResult = savedInstanceState.getInt("plus");
            plus_result.setText(""+ plusResult);
        }
        plus_button = findViewById(R.id.plus_button);
        div_result = findViewById(R.id.div_result_textView);
        if (savedInstanceState != null){
            divResult = savedInstanceState.getInt("div");
            div_result.setText(""+ divResult);
        }
        div_button = findViewById(R.id.div_button);
        mul_result = findViewById(R.id.mul_result_textView);
        mul_button = findViewById(R.id.mul_button);

        //MVC
        presenter = new NumberPresenter(this);
        //MVVM
        mNumberViewModel = ViewModelProviders.of(this).get(NumberViewModel.class);
        mNumberViewModel.numberMutableLifeData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mul_result.setText(s);
            }
        });
        //MVP
        plus_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getResult();
            }
        });
        //MVC
        div_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getNumbers();
            }
        });
        //MVVM
        mul_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNumberViewModel.getNumberResult();
            }
        });

    }


// MVP
    public void getResult() {

        plusResult = new DataBase().getNumbers().getFirstNum() + new DataBase().getNumbers().getSecondNum();
        plus_result.setText(""+ plusResult);
    }
 //MVC
    @Override
    public void onGetNumbers(int result) {
        divResult = result;
        div_result.setText("" + divResult);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("plus", plusResult);
        outState.putInt("div", divResult);
    }
}
