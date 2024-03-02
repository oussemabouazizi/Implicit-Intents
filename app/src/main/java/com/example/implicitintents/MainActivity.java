package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public EditText edit1;
    public EditText edit2;
    public EditText edit3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1=findViewById(R.id.website_edittext);
        edit2=findViewById(R.id.location_edittext);
        edit3=findViewById(R.id.share_edittext);
        Intent intent=getIntent();
        Uri uri =intent.getData();
        if (uri!= null){
            String uri_string =getString(R.string.uri_label)+uri.toString();
            TextView textView=findViewById(R.id.text_url_message);
            textView.setText(uri_string);
        }
    }

    @SuppressLint("QueryPermissionsNeeded")
    public void openWebsite(View view) {

        String url =edit1.getText().toString();
        Uri webpage =Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW,webpage);
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
        else {
            Log.d( "ImplicitIntents", "cant handle this  ");
        }

    }

    @SuppressLint("QueryPermissionsNeeded")
    public void openLocation(View view) {
        String loc=edit2.getText().toString();  
        Uri addressUri;
        addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW,addressUri);
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
        else {
            Log.d( "ImplicitIntents", "cant handle this  ");
        }

    }

    public void shareText(View view) {
        String txt =edit3.getText().toString();
        String mimeType="text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(R.string.share_text)
                .setText(txt)
                .startChooser();
    }
}