package com.periyar.commerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AlertDialogLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainPage extends AppCompatActivity {
    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        BottomNavigationView bottomNav=findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();


        mToolBar=findViewById(R.id.toolbarMain);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_search:
                            selectedFragment = new SearchFragment();
                            Toast.makeText(getApplicationContext(),
                                    "Loading...",
                                    Toast.LENGTH_LONG)
                                    .show();
                            break;
                        case R.id.nav_settings:
                            selectedFragment = new SettingsFragment();
                            break;
                        case R.id.nav_profile:
                            selectedFragment = new ProfileFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };

    //Menu bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    //Top Menu bar
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