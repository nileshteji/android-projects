package com.example.navigationactivity;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, BlankFragment.OnFragmentInteractionListener {
DrawerLayout obj;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

     obj = findViewById(R.id.drawer_layout);

      navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, obj, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        obj.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public void onBackPressed() {

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);

        }
        else {
            super.onBackPressed();
            for (int i = 0; i < navigationView.getMenu().size(); i++) {
                navigationView.getMenu().getItem(i).setChecked(false);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Bundle obj=new Bundle();
        BlankFragment obj1=new BlankFragment();

        if (id == R.id.nav_home) {
       obj.putString("id","home");
       getSupportFragmentManager().beginTransaction().replace(R.id.id1,obj1).addToBackStack(null).commit();
       obj1.setArguments(obj);

            // Handle the camera action
        }
        else if (id == R.id.nav_gallery) {
            obj.putString("id","gallery");
            getSupportFragmentManager().beginTransaction().replace(R.id.id1,obj1).addToBackStack(null).commit();
            obj1.setArguments(obj);


        } else if (id == R.id.nav_slideshow) {
            obj.putString("id","slideshow");
            getSupportFragmentManager().beginTransaction().replace(R.id.id1,obj1).addToBackStack(null).commit();
            obj1.setArguments(obj);
        } else if (id == R.id.nav_tools) {
            obj.putString("id","tools");
            getSupportFragmentManager().beginTransaction().replace(R.id.id1,obj1).addToBackStack(null).commit();
            obj1.setArguments(obj);

        } else if (id == R.id.nav_share) {
            obj.putString("id","share");
            getSupportFragmentManager().beginTransaction().replace(R.id.id1,obj1).addToBackStack(null).commit();
            obj1.setArguments(obj);

        } else if (id == R.id.nav_send) {
            obj.putString("id","send");
            getSupportFragmentManager().beginTransaction().replace(R.id.id1,obj1).addToBackStack(null).commit();
            obj1.setArguments(obj);


        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
   item.setChecked(false);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
