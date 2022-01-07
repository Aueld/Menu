package com.example.menudemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.file:
                Toast.makeText(this, "파일", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.phone_call:
                EditText phone = findViewById(R.id.phone_number);
                String number = phone.getText().toString();
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
                //intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));

                startActivity(intent);
                return true;

            case R.id.any_activity:
                intent = new Intent(Intent.ACTION_MAIN);
                startActivity(intent);
                return true;

            case R.id.help:
                return true;

            case R.id.file_new:
                Toast.makeText(this, "NEW", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.file_open:
                Toast.makeText(this, "OPEN", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}