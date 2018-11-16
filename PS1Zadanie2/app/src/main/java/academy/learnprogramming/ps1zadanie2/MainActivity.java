package academy.learnprogramming.ps1zadanie2;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private EditText pobierzTeskt;
    private Button btn;
    private ListView itemsList;
    private ClipData.Item item;
    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;
    private DajColor daj = new DajColor();//color
    Vibrator vibrator; // vibrator
    //flashlight
    private CameraManager mCameraManager;
    private String mCameraId;
    private boolean status= true;
    String s;
  //  private ToggleButton toggleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pobierzTeskt = findViewById(R.id.item_edit_text);
        btn = findViewById(R.id.add_btn);
        itemsList = findViewById(R.id.items_list);

        items = FileHelper.readData(this);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        itemsList.setAdapter(adapter);

        btn.setOnClickListener(this);
        itemsList.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.add_btn:
                v.setBackgroundColor(daj.getRandomColor());
                String wpisanaWiadomosc = pobierzTeskt.getText().toString();
                wpisanaWiadomosc.toUpperCase().indexOf(1);
                adapter.add(wpisanaWiadomosc);
                s = wpisanaWiadomosc;
                pobierzTeskt.setText("");
                FileHelper.writeData(items, this);
                Toast.makeText(this, "Dodano Item o numerze id = "+adapter.getCount(), Toast.LENGTH_SHORT).show();
                break;
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0)
        {

       //      Intent przeslij = YouTubeStandalonePlayer.createVideoIntent(this, YoutubeActivity.GOOGLE_API_KEY, YoutubeActivity.YOUTUBE_VIDEO_ID, 0, true, false);
            Intent  intent = new Intent(this, YoutubeActivity.class);
                    startActivity(intent);
                    finish();
        }
        else if (position == 1)
        {
            Intent przeslij = YouTubeStandalonePlayer.createPlaylistIntent(this, YoutubeActivity.GOOGLE_API_KEY, YoutubeActivity.YOUTUBE_PLAYLIST, 0, 0, true, true);
            startActivity(przeslij);
            finish();
        }
        else
        {

            items.remove(position);
            adapter.notifyDataSetChanged(); // refresh
            FileHelper.writeData(items, this);// zapis
            Toast.makeText(this, "Usunieto Item z numerem id = "+adapter.getItemId(position+1), Toast.LENGTH_SHORT).show();
        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);// // Inflate the menu; Dodaje ajtemy do action bara , jesli jest obecne

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
   //     int id = item.getItemId();
        Snackbar snackbar;
        switch(item.getItemId())
        {
            case R.id.action_settings:
                Toast.makeText(this, "Lista posiada  "+adapter.getCount()+" elementy ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Zadanie1:
                 snackbar = Snackbar
                        .make(getWindow().getDecorView(), "Sprawdz polaczenie", Snackbar.LENGTH_LONG)
                        .setAction("Retry", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(MainActivity.this,"Kliknales OK",Toast.LENGTH_LONG).show();
                            }
                        });
                 snackbar.setDuration(3000);//3 sec
                 snackbar.show();
                break;

            case R.id.Zadanie2:
                String yourText = "Pierwsza linia\nDruga linia\nTrzecia linia";
                 snackbar = Snackbar.make(getWindow().getDecorView(), yourText, Snackbar.LENGTH_SHORT).setAction("-> OK <-", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,"Kliknales OK",Toast.LENGTH_LONG).show();
                    }
                });
                //mozliwosc pisania wieu linii
                TextView textView = (TextView) snackbar.getView().findViewById(android.support.design.R.id.snackbar_text);
                textView.setSingleLine(false);
                snackbar.setDuration(3000);
                //color Przycisku snackbara
                snackbar.setActionTextColor(Color.GREEN);
                View sb = snackbar.getView(); // pobiera textView snackbara
                TextView tv = (TextView)sb.findViewById(android.support.design.R.id.snackbar_text);
                tv.setTextColor(Color.GRAY);
                // pokaz na koniec
                snackbar.show();
                break;
            case R.id.Zadanie3:
                adapter.remove(s);
                adapter.notifyDataSetChanged();
                break;
            case R.id.action_settings2:
                vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                //vibrate in ms
                vibrator.vibrate(500);
                break;
                //zarówka
            case R.id.zarowkaOn:
//                boolean isFlashAvailable = getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
//                if (!isFlashAvailable) {
//                    showNoFlashError();
//                }
                mCameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
                try {
                    mCameraId = mCameraManager.getCameraIdList()[0];
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
                switchFlashLight(status);
                status = !status;
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }

    public void switchFlashLight(boolean status) {
        try {
            mCameraManager.setTorchMode(mCameraId, status);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }
    //
//    public void showNoFlashError() {
//        AlertDialog alert = new AlertDialog.Builder(this)
//                .create();
//        alert.setTitle("Oops!");
//        alert.setMessage("Flash not available in this device...");
//        alert.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int which) {
//                finish();
//            }
//        });
//        alert.show();
//    }

}

