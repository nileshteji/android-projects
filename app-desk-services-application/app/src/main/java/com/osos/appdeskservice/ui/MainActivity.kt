package com.osos.appdeskservice.ui

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Bundle
import android.os.Looper
import android.provider.Settings
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.gms.location.*
import com.osos.appdeskservice.R
import kotlinx.android.synthetic.main.activity_main2.*
import java.security.Permission
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val navController = findNavController(R.id.nav_host_fragment)
        nav_view.setupWithNavController(navController)




    }




    override fun onStart() {
        super.onStart()

        // checking permissions
        if(checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),0)

        }

        val locationManager:LocationManager =getSystemService(LOCATION_SERVICE) as LocationManager

        // accessing GPS
        if(!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) or !locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)){
            AlertDialog.Builder(this)
                .setTitle("Enable GPS")
                .setMessage("Essential For Application")
                .setCancelable(false)
                .setPositiveButton("Enable") { _, _ ->
                    startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
                }
                .show()
        }
        }
    }
