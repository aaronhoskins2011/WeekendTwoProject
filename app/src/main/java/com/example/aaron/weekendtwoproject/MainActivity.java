package com.example.aaron.weekendtwoproject;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
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
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("The page has loaded.  Are you sure you want to read it");
        alertDialogBuilder.setPositiveButton("yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });

        alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
