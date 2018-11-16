package academy.learnprogramming.ps_1_zadanie1;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
@RequiresApi(api = Build.VERSION_CODES.O)
public class ThirdActivity extends AppCompatActivity {
    private static final String TAG = "ThirdActivity";   // log t + enter
    Button powrot;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        text = findViewById(R.id.textView);
        text.append("\nStart on Create "+pobierzCzas());
        Log.d(TAG, "Start onCreate " +pobierzCzas());

        powrot =   findViewById(R.id.button4);
        powrot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ThirdActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        Log.d(TAG, "Koniec onCreate "+pobierzCzas());


    }
    @Override
    protected void onStart() {

        text.append("\nStan Onstart  on  "+pobierzCzas());
        Log.d(TAG, "Stan onStart() "+pobierzCzas());
        super.onStart();


    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        text.append("\nStan onRestoreInstaceState on "+pobierzCzas());
        Log.d(TAG, "Stan onRestoreInstanceState "+pobierzCzas());
        super.onRestoreInstanceState(savedInstanceState);


    }

    protected void onRestart() {
        text.append("\nStan on restart  "+pobierzCzas());
        Log.d(TAG, "Stan onRestart "+pobierzCzas());
        super.onRestart();


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        text.append("\nStan onSaveInstanceState on "+pobierzCzas());
        Log.d(TAG, "Stan onSaveInstanceState ");
 //       outState.putString(TEXT_CONTENTS, textView.getText().toString());                                      // sejvuje dane przed super.onSave// caly kontent przed obroceniem telefonu
        super.onSaveInstanceState(outState);


    }

    @Override
    protected void onStop() {
        text.append("\nStan onStop on "+pobierzCzas());
        Log.d(TAG, "Stan onStop "+pobierzCzas());
        super.onStop();


    }

    @Override
    protected void onResume() {
        text.append("\nStan onResume on "+pobierzCzas());
        Log.d(TAG, "Stan onResume "+pobierzCzas());
        super.onResume();


    }

    protected void onPuase() {
        text.append("\nStan onPause on "+pobierzCzas());
        Log.d(TAG, "Stan onPuase "+pobierzCzas());
        super.onPause();


    }
//    public long pobierzCzas()
//    {
//        long currentTime=System.currentTimeMillis()%1000;
//        return currentTime;
//    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private String pobierzCzas(){

        LocalDateTime data  = LocalDateTime.now();

        String czasik = data.format(DateTimeFormatter.ISO_TIME);
        return czasik;
    }
//    @RequiresApi(Build.VERSION_CODES.O)
//    private fun czas() : String{
//        val aktualny_czas = LocalDateTime.now()
//        val czasik = aktualny_czas.format(DateTimeFormatter.ISO_TIME)
//        return czasik
//    }
}

