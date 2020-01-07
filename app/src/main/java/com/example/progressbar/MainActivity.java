package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buttonStart;
    ProgressBar progressBar1, progressBar2;
    TextView textView1, textView2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progressbar);

        buttonStart=(Button)findViewById(R.id.button_1);
        progressBar1=(ProgressBar)findViewById(R.id.progress_bar_1);
        progressBar2=(ProgressBar)findViewById(R.id.progress_bar_2);
        textView1=(TextView)findViewById(R.id.text_view_1);
        textView2=(TextView)findViewById(R.id.text_view_2);


        buttonStart.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                new Thread(){
                    public void run(){
                        for (int i=progressBar1.getProgress();i<progressBar1.getMax(); i++){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    progressBar1.setProgress(progressBar1.getProgress()+1);
                                    textView1.setText("Progress: "+progressBar1.getProgress()+"%");
                                }
                            });
                            SystemClock.sleep(1);
                        }
                    }
                }.start();
                new Thread(){
                    public void run(){
                        for (int i=progressBar2.getProgress();i<progressBar2.getMax(); i++){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    progressBar2.setProgress(progressBar2.getProgress()+1);
                                    textView2.setText("Progress: "+progressBar2.getProgress()+"%");
                                }
                            });
                            SystemClock.sleep(100);
                        }
                    }
                }.start();

            }
        });


    }
}
