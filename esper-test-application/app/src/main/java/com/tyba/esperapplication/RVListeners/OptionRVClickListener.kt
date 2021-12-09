package com.tyba.esperapplication.RVListeners

import com.tyba.common.data.Option

interface OptionRVClickListener {
     fun checkIfFeatureIncluded(featureSelected:String,option:Option):Boolean
     fun removeSelectedItem(featureSelected: String,option: Option)
}