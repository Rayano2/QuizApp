package com.example.android.quizapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int Total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler();
        Runnable r=new Runnable() {
            @Override
            public void run() {
                finish();
            }
        };
        handler.postDelayed(r, 200000);


    }


    public void submit(View view) {
        EditText name = (EditText) findViewById(R.id.name);
          String nameStudent = name.getText().toString();
//Declartion of the First Queastion
        CheckBox Stack = (CheckBox) findViewById(R.id.trueanswer);
        boolean stackans = Stack.isChecked();
        CheckBox queue = (CheckBox) findViewById(R.id.extent);
        boolean queueans = queue.isChecked();

        CheckBox intans = (CheckBox) findViewById(R.id.supper);
        boolean intselect = intans.isChecked();
//--------------------------------------------------------------------------
        //Declartion of the Scond Queastion
        RadioButton objectselect = (RadioButton) findViewById(R.id.object1);
        boolean objectans = objectselect.isChecked();
        RadioButton packageselect = (RadioButton) findViewById(R.id.package1);
        boolean pacjageans = packageselect.isChecked();
        RadioButton interfaceselect = (RadioButton) findViewById(R.id.interface1);
        boolean interfaceans = interfaceselect.isChecked();
//-------------------------------------------------------------------------------
        //Declartion of the Third Queastion
        RadioButton trueselect = (RadioButton) findViewById(R.id.true_box);
        boolean trueans = trueselect.isChecked();
        RadioButton falseselect = (RadioButton) findViewById(R.id.false_box);
        boolean falseans = falseselect.isChecked();
        //------------------------------------------------------------------------
        //Declartion of the Fourth Queastion
        EditText answeer = (EditText) findViewById(R.id.answer_box);
        String answer = answeer.getText().toString();
     display(stackans,queueans,intselect, interfaceans, falseans, answer);
        Toast.makeText(this, "Your Score is :" + Total, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Total Mark for Student : " + nameStudent);
        intent.putExtra(Intent.EXTRA_TEXT, "The Total mark is :" + Total);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);

            Total =0;

        }
    }

    private void display(boolean Stackans,boolean queue,boolean intans, boolean interfaceans, boolean falsans,String answer) {
        if (Stackans && queue &&! intans ) {
           Total+=1;

        }
        if (interfaceans) {
            Total += 1;
        }
        if(falsans){
            Total+=1;
        }

        if(answer.equals("java")){
            Total+=1;
        }
        else {
            return;
        }

    }

}