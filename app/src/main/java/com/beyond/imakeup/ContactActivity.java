package com.beyond.imakeup;

import android.net.Uri;
import android.view.View;
import android.os.Bundle;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

public class ContactActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView facebook, insta, whats, twitter;
    LinearLayout phone1, phone2, email, web, addr;

    private void LinkXMLwithJAVA() {
        phone1 = findViewById(R.id.phone1);
        phone2 = findViewById(R.id.phone2);
        email = findViewById(R.id.email);
        web = findViewById(R.id.web);
        addr = findViewById(R.id.addr);

        phone1.setOnClickListener(this);
        phone2.setOnClickListener(this);
        email.setOnClickListener(this);
        web.setOnClickListener(this);
        addr.setOnClickListener(this);

        /////

        facebook = findViewById(R.id.facebook);
        insta = findViewById(R.id.insta);
        whats = findViewById(R.id.whats);
        twitter = findViewById(R.id.twitter);

        facebook.setOnClickListener(this);
        insta.setOnClickListener(this);
        whats.setOnClickListener(this);
        twitter.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        LinkXMLwithJAVA();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.phone1: callPhone(); break;
            case R.id.phone2: callMobile(); break;
            case R.id.email: sentMail(); break;
            case R.id.web: visitWebsite(); break;
            case R.id.addr: goToAddress(); break;

            ////

            case R.id.facebook: openFacebook(); break;
            case R.id.insta: openInstagram(); break;
            case R.id.twitter: openTwitter(); break;
            case R.id.whats: openWhatsApp(); break;
        }
    }

    private void callPhone()
    {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("0788870028"));
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(callIntent);
    }

    private void callMobile ()
    {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("0795181767"));
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(callIntent);
    }

    private void sentMail ()
    {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL, "info@imakeup.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Contact iMakeup");
        startActivity(Intent.createChooser(intent, "Send Email"));
    }
    private void goToAddress ()
    {
        /*
        Intent r ;
        r = new Intent(this,MapsActivity.class);
        r.putExtra("type" , "location");
        startActivity(r);
        */
    }

    private void visitWebsite ()
    {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.iMakeup.com/")));
    }

    private void openFacebook ()
    {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/iMakeupApplication/")));
    }

    private void openInstagram ()
    {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/getneelrafat")));
    }

    private void openTwitter ()
    {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.Twitter.com/")));
    }

    private void openWhatsApp()
    {
        Intent waIntent = new Intent(Intent.ACTION_SEND);
        waIntent.setType("text/plain");
        waIntent.setPackage("com.whatsapp");
        waIntent.putExtra(Intent.EXTRA_TEXT, "whatsapp message");
        startActivity(waIntent);
    }
}
