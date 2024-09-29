package com.example.hw8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hw8.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding viewBinding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(viewBinding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



     viewBinding.button.setOnClickListener(view -> {
         Thread thread = new Thread(){
             @Override
             public void run() {
                 super.run();

                 for (int i = 0; i <=100 ; i++) {
                      Integer progress = i;
                     runOnUiThread(new Runnable() {
                         @Override
                         public void run() {

                         }
                     });
                     viewBinding.textView.setText(i+"%");
                     viewBinding.progress.setProgress(i,true);
                     try {Thread.sleep(500);

                     } catch (InterruptedException e){
                         throw  new RuntimeException(e) ;
                     }
                 }


             }


         };
       thread.start();
 });

     viewBinding.btnOpenSecond.setOnClickListener(view -> {
         startActivity(new Intent(MainActivity.this,ScrollingActivity.class));
     });
    }
    }