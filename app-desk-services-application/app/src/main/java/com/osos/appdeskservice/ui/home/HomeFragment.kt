package com.osos.appdeskservice.ui.home

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.location.*
import com.osos.appdeskservice.R
import com.osos.appdeskservice.preferences.PreferenceClass
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    lateinit var fusedLocationProviderClient: FusedLocationProviderClient


    @SuppressLint("MissingPermission")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // View Model Setup
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)


        val root = inflater.inflate(R.layout.fragment_home, container, false)

        // access location
        val locationRequest = LocationRequest().setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
        fusedLocationProviderClient.requestLocationUpdates(
            locationRequest, object : LocationCallback() {

                override fun onLocationResult(p0: LocationResult?) {
                    super.onLocationResult(p0)

                    if(PreferenceClass(requireContext()).getTemperature().equals("CEL")) {
                        homeViewModel.getWeather(
                            p0!!.lastLocation.latitude,
                            p0.lastLocation.longitude
                        )
                    }
                    else{
                        homeViewModel.getWeather(
                            p0!!.lastLocation.latitude,
                            p0.lastLocation.longitude,
                            "imperial"
                        )
                    }
                }
            },
            Looper.myLooper()
        )




        return root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        // view Model Observe
        homeViewModel.response.observe(viewLifecycleOwner) {
            progressBar2.visibility = View.GONE
            place_name.text = it.name
            temperature2.text = it.main.temp.toString()
            feels_like.text = it.main.feel.toString() + "°"
            min_temp.text = it.main.min.toString() + "°"
            max_temp.text = it.main.max.toString() + "°"
        }


    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        check()
    }


    fun check() {
        // fused api to access location
        fusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(requireActivity())

        // check permissions
        if (ActivityCompat.checkSelfPermission(
                requireActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(
                requireActivity(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                100
            )
            return
        }
    }
}