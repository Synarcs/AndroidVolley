package com.example.jsonplaceholder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Intent getNameScreenIntent;
    private Button button;
    public void nextScreen(){
        button = (Button)findViewById(R.id.bt1);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent nextScreen = new Intent(MainActivity.this,SecondScreen.class);
                startActivity(nextScreen);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextScreen();
    }
}
