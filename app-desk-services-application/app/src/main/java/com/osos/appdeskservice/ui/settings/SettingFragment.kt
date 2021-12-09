package com.osos.appdeskservice.ui.settings

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.osos.appdeskservice.R
import com.osos.appdeskservice.data.Temp
import com.osos.appdeskservice.preferences.PreferenceClass
import kotlinx.android.synthetic.main.fragment_setting.view.*


class SettingFragment : Fragment() {

    private lateinit var settingsViewModel: SettingsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        settingsViewModel =
            ViewModelProvider(this).get(SettingsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_setting, container, false)

        settingsViewModel.getUserName(requireActivity())

        settingsViewModel.userName.observe(viewLifecycleOwner) {
            root.text_username.text = it
        }


        when (PreferenceClass(requireContext()).getTemperature()) {
            Temp.CEL.name -> root.radio_group.check(R.id.cel_radio)
            Temp.FAH.name -> root.radio_group.check(R.id.fah_radio)
        }


        root.cel_radio.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Log.d("LOGS", "onCreateView: CEL")
                PreferenceClass(requireActivity()).insertTemperature(Temp.CEL)
            }

        }
        root.fah_radio.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {

                Log.d("LOGS", "onCreateView: FAH")
                PreferenceClass(requireActivity()).insertTemperature(Temp.FAH)
            }

        }









        return root
    }
}