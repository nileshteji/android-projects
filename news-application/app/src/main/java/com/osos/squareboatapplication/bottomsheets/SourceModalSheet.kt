package com.osos.squareboatapplication.bottomsheets

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.osos.squareboatapplication.core.welcome.MainActivity
import com.osos.squareboatapplication.R
import kotlinx.android.synthetic.main.sources_bottom_sheet.view.*

class SourceModalSheet(var mainActivity: MainActivity) :BottomSheetDialogFragment() {

   var array = mutableListOf<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view=inflater.inflate(R.layout.sources_bottom_sheet,container,false)

        //CheckBox Listeners
        view.timesofindia.setOnCheckedChangeListener { buttonView, isChecked ->
            if( isChecked ) {
                array.add(getString(R.string.timesofIndiaid))
                Log.d("LOGS","onCreateView: ${array}")
            }
            else{
                array.remove(getString(R.string.timesofIndiaid))
            }
        }

        view.googlenews.setOnCheckedChangeListener { buttonView, isChecked ->
            if( isChecked ) {
                array.add(getString(R.string.googlenewsID))
            }
            else{
                array.remove(getString(R.string.googlenewsID))
            }
        }

        view.abpnews.setOnCheckedChangeListener { buttonView, isChecked ->
            if( isChecked ){
                array.add(getString(R.string.abpid))
            }
            else{
                array.remove(getString(R.string.abpid))
            }
        }

        view.bbc.setOnCheckedChangeListener { buttonView, isChecked ->
            if(!isChecked){
                array.add(getString(R.string.bbcID))
            }
            else{
                array.remove(getString(R.string.bbcID))
            }
        }

        view.nextweb.setOnCheckedChangeListener { buttonView, isChecked ->
            if( isChecked ){
                array.add(getString(R.string.nextWebID))
            }
            else{
                array.remove(getString(R.string.nextWebID))
            }
        }

        view.techcrunch.setOnCheckedChangeListener { buttonView, isChecked ->
            if( isChecked ){
                array.add(getString(R.string.techcrunchID))
            }
            else{
                array.remove(getString(R.string.techcrunchID))
            }
        }

        view.engadget.setOnCheckedChangeListener { buttonView, isChecked ->
            if( isChecked ){
                array.add(getString(R.string.engadgetID))
            }
            else{
                array.remove(getString(R.string.engadgetID))
            }
        }


        view.applyfilter.setOnClickListener {
            Log.d("LOGS", "onCreateView: $array")
            mainActivity.filterSources(array)
            dismiss()
        }
        return view
    }

}