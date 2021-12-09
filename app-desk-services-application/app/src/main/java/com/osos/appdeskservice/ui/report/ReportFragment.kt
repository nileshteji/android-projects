package com.osos.appdeskservice.ui.report

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
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.location.*
import com.osos.appdeskservice.R
import com.osos.appdeskservice.adapter.SevenReport
import com.osos.appdeskservice.preferences.PreferenceClass
import kotlinx.android.synthetic.main.fragment_report.*
import kotlinx.android.synthetic.main.fragment_report.view.*
import kotlinx.android.synthetic.main.fragment_setting.view.*

class ReportFragment : Fragment() {

    private lateinit var dashboardViewModel: ReportViewModel
    lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    @SuppressLint("MissingPermission")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        dashboardViewModel = ViewModelProvider(this).get(ReportViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_report, container, false)


        val locationRequest = LocationRequest().setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
        fusedLocationProviderClient.requestLocationUpdates(
            locationRequest, object : LocationCallback() {

                override fun onLocationResult(p0: LocationResult?) {
                    super.onLocationResult(p0)

                    if(PreferenceClass(requireContext()).getTemperature().equals("CEL")) {
                        dashboardViewModel.getReport(
                            p0!!.lastLocation.latitude,
                            p0.lastLocation.longitude
                        )
                    }
                    else{
                        dashboardViewModel.getReport(
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

        val linearLayoutManager = LinearLayoutManager(requireContext())
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recycler_view.layoutManager = linearLayoutManager

        dashboardViewModel.getUserName(requireActivity())
        dashboardViewModel.userName.observe(viewLifecycleOwner){
            text_usernameOne.text = it
        }

        dashboardViewModel.sevenDayResponse.observe(viewLifecycleOwner){

            val adapter =SevenReport(it.daily)
            recycler_view.adapter = adapter
            progressBar.visibility = View.GONE

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