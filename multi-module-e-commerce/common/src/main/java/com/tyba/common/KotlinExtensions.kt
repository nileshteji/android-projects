package com.tyba.common

import android.util.Log
import com.tyba.common.data.Exclusion
import com.tyba.common.data.ExclusionBaseObject


fun <T> MutableList<T>.changeData(list: List<T>) {
    this.clear()
    this.addAll(list)
}

fun List<List<Exclusion>>.changeToBaseObject(): MutableList<ExclusionBaseObject> {
    val modifiedList: MutableList<ExclusionBaseObject> = mutableListOf()
    var counter: Int = 1;
    this.forEach {
        modifiedList.add(ExclusionBaseObject(list = it, id = counter++))
    }
    return modifiedList;
}

fun List<ExclusionBaseObject>.toMap(): MutableMap<String, String> {
    val map: MutableMap<String, String> = mutableMapOf()
    this.forEach {
        val key = "${it.list[0].feature_id}|${it.list[0].options_id}"
        val value = "${it.list[1].feature_id}|${it.list[1].options_id}"
        map.put(key, value)
    }
    return map
}

fun List<String>.containsKey(map: MutableMap<String, String>, featureSelected: String): Boolean {
    Log.d("MainActivityExtensionFunction", "Map: ${map}")
    Log.d("MainActivityExtensionFunction", "Selected Features List: ${this}")
    Log.d("MainActivityExtensionFunction", "Feature Selected: ${featureSelected}")

    map.forEach {
        if (it.value.equals(featureSelected)) {
            Log.d("MainActivity", "containsKey: ${it.value} Key->${it.key}")
            return this.contains(it.key)
        }
    }
    return false
}

//Node one  <--> Node two
//
