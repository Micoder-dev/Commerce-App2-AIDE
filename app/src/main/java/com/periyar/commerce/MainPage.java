package com.periyar.commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainPage extends AppCompatActivity {
    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        mToolBar=findViewById(R.id.toolbarMain);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

    }

    //Menu bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.about) {
            Toast.makeText(getApplicationContext(),
                    "About clicked",
                    Toast.LENGTH_LONG)
                    .show();
        }
        if (item.getItemId() == R.id.help) {
            Toast.makeText(getApplicationContext(),
                    "Help clicked",
                    Toast.LENGTH_LONG)
                    .show();
        }
        if (item.getItemId() == R.id.settings) {
            Toast.makeText(getApplicationContext(),
                    "Settings clicked",
                    Toast.LENGTH_LONG)
                    .show();
        }
        if (item.getItemId() == R.id.exit) {
            finish();
            System.exit(0);
            Toast.makeText(getApplicationContext(),
                    "Exiting...",
                    Toast.LENGTH_LONG)
                    .show();
        }
        return super.onOptionsItemSelected(item);

    }
}