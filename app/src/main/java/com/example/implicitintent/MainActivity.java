package com.example.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=findViewById(R.id.editText);
    }

    public void call(View view) {
        Uri uri=Uri.parse("tel:"+et.getText().toString());
        Intent i=new Intent(Intent.ACTION_DIAL,uri);
        //try all apps which will suite the dail operation
        if (i.resolveActivity(getPackageManager())!=null){
            startActivity(i);
        }
    }

    public void openWebsite(View view) {
        Uri u=Uri.parse("https://www.google.com/search?q="+et.getText().toString());
        Intent i=new Intent(Intent.ACTION_VIEW,u);
        //try all apps which will suite the dail operation
        if (i.resolveActivity(getPackageManager())!=null){
            startActivity(i);
        }
    }

    public void openLoaction(View view) {
        Uri location=Uri.parse("geo:0,0?q="+et.getText().toString());
        Intent i=new Intent(Intent.ACTION_VIEW,location);
        //try all apps which will suite the dail operation
        if (i.resolveActivity(getPackageManager())!=null){
            startActivity(i);
        }
    }
}
