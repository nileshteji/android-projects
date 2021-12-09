package com.osos.squareboatapplication.bottomsheets

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.osos.squareboatapplication.core.welcome.MainActivity
import com.osos.squareboatapplication.R

import com.osos.squareboatapplication.databinding.LocationBottomBinding
import kotlinx.android.synthetic.main.location_bottom.*

class LocationModalSheet(var mainActivity: MainActivity) : BottomSheetDialogFragment() {

    var country:String="in"


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var locationBottomSheetBinding=LocationBottomBinding.inflate(inflater,container,false)







        locationBottomSheetBinding.apply.setOnClickListener {

            when( radioGroup3.checkedRadioButtonId ) {

                R.id.brazil -> country = "br"
                R.id.usa -> country = "us"
                R.id.india -> country = "in"
                R.id.argetina -> country = "ar"
                R.id.china -> country = "cn"
                R.id.aus -> country = "au"
                R.id.pakistan -> country = "pk"
            }

            mainActivity.showHeadlines(country)
            dismiss()
        }
        return locationBottomSheetBinding.root
    }


    override fun onDetach() {
        super.onDetach()
        Log.d("LOGS", "onDetach: ")
    }




}