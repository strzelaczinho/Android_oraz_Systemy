package academy.learnprogramming.ps_1_zadanie1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView tv;
    String st;
    Button button2;
    Button third;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv=findViewById(R.id.tekstSecond);

         st = getIntent().getExtras().getString("Value"); // referencja
        tv.setText(st);

        button2 =   findViewById(R.id.button2);
        third = findViewById(R.id.button3);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        third.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
