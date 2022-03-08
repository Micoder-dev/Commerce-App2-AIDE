package com.periyar.commerce;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AlertDialogLayout;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
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
            //when exit menu clicked alert dialog
            Toast.makeText(getApplicationContext(),
                    "Click 'yes' to exit",
                    Toast.LENGTH_LONG)
                    .show();
            new AlertDialog.Builder(this)
                    .setMessage("Are you sure want to exit???")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();
        }
        return super.onOptionsItemSelected(item);

    }
    //when back button pressed alret dialog
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure want to exit???")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}