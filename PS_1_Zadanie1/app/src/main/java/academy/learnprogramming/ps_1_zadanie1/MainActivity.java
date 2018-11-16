package academy.learnprogramming.ps_1_zadanie1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText;
    EditText editText2;
    RatingBar ratingBar;
    RadioGroup radioGroup;
    RadioButton guzik;
    CheckBox checkBox;
    String st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        editText = findViewById(R.id.tekst);
        editText2 = findViewById(R.id.telefon);
        ratingBar = findViewById(R.id.ratingBar);
        radioGroup = findViewById(R.id.radioGroup);
        guzik = findViewById(R.id.radioButton8);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                int radioId = radioGroup.getCheckedRadioButtonId();
                guzik = findViewById(radioId);
                checkBox = (CheckBox) findViewById(R.id.checkBox2);
                boolean wynik = checkBox.isChecked();
                st = "Imie " + editText.getText().toString() + " \nTelefon = " + editText2.getText().toString() + " \nIlosc gwiazdek = " + ratingBar.getRating() + " \nGuzik  o nazwie " + guzik.getText()+
                 "\n Checkbox selected ? "+wynik;
                i.putExtra("Value", st);
                startActivity(i);
                finish();
            }
        });


    }
}

