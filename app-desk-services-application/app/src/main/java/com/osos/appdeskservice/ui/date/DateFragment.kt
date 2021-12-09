package com.osos.appdeskservice.ui.date

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.osos.appdeskservice.R
import com.osos.appdeskservice.data.Places
import com.osos.appdeskservice.preferences.PreferenceClass
import kotlinx.android.synthetic.main.fragment_date.*
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

class DateFragment : Fragment() {



    private lateinit var viewModel: DateViewModel
    lateinit var city : Places
    var dt : Long? = null
    lateinit var unit :String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_date, container, false)
    }

    @SuppressLint("SimpleDateFormat")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DateViewModel::class.java)

        init()


        viewModel.history.observe(viewLifecycleOwner){
            if(it == null){
                Toast.makeText(requireActivity(),"Sorry the Particular Date Cannot be Processed",Toast.LENGTH_LONG).show()
            }
            else {
                result.text =
                    " ${it.current.temp.toString()} is the Temperature of ${city.name} for the selected date"
            }
        }



        // click listeners
        calendar_button.setOnClickListener() {

            val datePickerDialog = DatePickerDialog(
                requireContext(),
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    dt = convertToUnix(dayOfMonth, month, year)
                },

                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)

            ).show()

        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                when (position) {
                    1 -> { city = Places.Delhi }
                    2 -> { city = Places.Mumbai}
                    3 -> { city = Places.Noida}
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

        submit.setOnClickListener {
            // checking the date selected
            if(dt == null){
                Toast.makeText(requireContext(),"Select Some date",Toast.LENGTH_LONG).show()
            }
            else{

                // checking the temp scale
                if(PreferenceClass(requireContext()).getTemperature().equals("CEL")) {
                  viewModel.fetchResponse(city,dt!!)
                }
                else{
                    viewModel.fetchResponse(city,dt!!,"imperial")
                }
            }
        }


    }


    fun init() {
        ArrayAdapter.createFromResource(
            requireActivity(),
            R.array.cities,
            R.layout.support_simple_spinner_dropdown_item
        ).also {

            it.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
            spinner.adapter = it
        }




    }


    fun convertToUnix(dayOfMonth: Int, month: Int, year: Int): Long {
        val monthNew = month + 1

        val l = LocalDate.parse("$dayOfMonth-$monthNew-$year", DateTimeFormatter.ofPattern("dd-MM-yyyy"))

        date.text = "$dayOfMonth $monthNew $year"

        val unix = l.atStartOfDay(ZoneId.systemDefault()).toInstant().epochSecond

        Log.d("LOGS", "onActivityCreated: $unix")

        return unix

    }

}