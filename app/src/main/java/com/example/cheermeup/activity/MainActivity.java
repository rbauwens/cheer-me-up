package com.example.cheermeup.activity;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.cheermeup.R;
import com.example.cheermeup.fragment.CheerMeUpFragment;
import com.example.cheermeup.fragment.HomeFragment;
import com.example.cheermeup.fragment.SettingsFragment;
import com.example.cheermeup.photos.PhotoList;
import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    private NavigationView navigationView;
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private ActionBarDrawerToggle drawerToggle;
    private Fragment savedFragment;

    @Override
    protected void onSaveInstanceState(@NotNull Bundle outState) {
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState, "myFragmentName", savedFragment);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        savedFragment = null;

        if (savedInstanceState != null) {
            savedFragment = getSupportFragmentManager().getFragment(savedInstanceState, "myFragmentName");
        }

        setContentView(R.layout.activity_main);

        if (savedFragment != null) {
            loadFragment(savedFragment);
        } else {
            int intentFragment = R.id.nav_home;
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                intentFragment = extras.getInt("fragmentToLoad");
            }
            loadFragment(intentFragment);
        }

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        drawerToggle = setupDrawerToggle();
        drawer.addDrawerListener(drawerToggle);
        navigationView = findViewById(R.id.nav_view);

        // initialize navigation menu
        setupDrawerContent();

        PhotoList.initialiseList(this.getApplicationContext());

    }

    private void loadFragment(Fragment fragmentToLoad) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragmentToLoad).commit();
        savedFragment = fragmentToLoad;
    }

    private void loadFragment(int fragment) {
        Class fragmentClass;
        String title;
        Fragment fragmentToLoad = null;

        switch (fragment) {
            case R.id.nav_home:
                title = getString(R.string.nav_home);
                fragmentClass = HomeFragment.class;
                break;
            case R.id.nav_settings:
                title = getString(R.string.nav_settings);
                fragmentClass = SettingsFragment.class;
                break;
            default:
                title = getString(R.string.nav_home);
                fragmentClass = HomeFragment.class;
        }

        try {
            fragmentToLoad = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (fragmentToLoad != null) {
            loadFragment(fragmentToLoad);
            setTitle(title);
        }

    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        // NOTE: Make sure you pass in a valid toolbar reference.  ActionBarDrawToggle() does not require it
        // and will not render the hamburger icon without it.
        return new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open,  R.string.navigation_drawer_close);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }

    private void setupDrawerContent() {

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NotNull MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }


    public void selectDrawerItem(MenuItem menuItem) {

        loadFragment(menuItem.getItemId());
        menuItem.setChecked(true);
        drawer.closeDrawers();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawers();
            return;
        }

        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void cheerMeUpFragment(View view) {
        loadFragment(new CheerMeUpFragment());
        setTitle("Cheer Me Up");
    }


}

