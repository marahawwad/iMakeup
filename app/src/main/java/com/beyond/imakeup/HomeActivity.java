package com.beyond.imakeup;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.ColorInt;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        displaySelectedScreen(R.id.nav_home);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void displaySelectedScreen(int itemId) {

        Fragment fragment = null;

        switch (itemId) {
            case R.id.nav_home:
                fragment = new HomeFragment();
                break;
            case R.id.nav_book:
                fragment = new BookFragment();
                break;
            case R.id.nav_offer:
                fragment = new OfferFragment();
                break;
            case R.id.nav_notfiy:
                fragment = new NotfiyFragment();
                break;
            case R.id.nav_like:
                fragment = new LikeFragment();
                break;
            case R.id.nav_call:
                Intent in=new Intent(HomeActivity.this,ContactActivity.class);
                startActivity(in);
                break;
            case R.id.nav_aboutus:

                AboutDialog();

                break;
            case R.id.nav_logout:

                LogDialog();

                break;

        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        displaySelectedScreen(item.getItemId());
        return true;
    }

    void LogDialog(){

        AlertDialog dialog = new AlertDialog.Builder(this).create();

        dialog.setTitle("iMakeUp");
        dialog.setIcon(R.drawable.logo);
        dialog.setMessage("هل تريد الخروج؟");

        dialog.setButton(AlertDialog.BUTTON_NEUTRAL,"نعم", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                HomeActivity.this.finish();

            }
        });

        dialog.setButton(AlertDialog.BUTTON_NEGATIVE,"لا", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });

        new Dialog(getApplicationContext());
        dialog.show();
    }

    void AboutDialog(){

        AlertDialog dialog = new AlertDialog.Builder(this).create();

        dialog.setTitle("iMakeUp");
        dialog.setIcon(R.drawable.logo);
        dialog.setMessage("شكرا لدعمكم");

        dialog.setButton(AlertDialog.BUTTON_NEUTRAL,"ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();

            }
        });

        new Dialog(getApplicationContext());
        dialog.show();


    }
}
