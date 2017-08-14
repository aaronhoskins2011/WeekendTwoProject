package com.example.aaron.weekendtwoproject;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

import static com.example.aaron.weekendtwoproject.R.drawable.alert;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener{
    private static final String ALERT_FRAGMENT_TAG = "ALERT";
    PDFView jokesPdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int id = getResources().getIdentifier("com.example.aaron.weekendtwoproject:drawable/" + "alert", null, null);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jokesPdf = (PDFView)findViewById(R.id.pdfView);
        jokesPdf.fromAsset("jokes.pdf").load();

        BlankFragment alertFragment = new BlankFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.alertFragment, alertFragment, "alserFragment").addToBackStack(ALERT_FRAGMENT_TAG).commit();

        final ProgressDialog loadProgeres=ProgressDialog.show(this, "Loading","" , true);
        ImageView iv = new ImageView(getApplicationContext());
        iv.setImageResource(id);
        loadProgeres.setContentView(iv);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                loadProgeres.dismiss();
                // show popup
            }
        }, 3000);

        
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
