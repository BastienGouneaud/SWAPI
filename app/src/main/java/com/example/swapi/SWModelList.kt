package com.example.swapi

import android.text.TextUtils
import java.io.Serializable
import java.util.ArrayList

/**
 * Created by Oleur on 22/12/2014.
 * Generic list model
 */
class SWModelList<T> : Serializable {
    var count = 0
    var next: String? = null
    var previous: String? = null
    var results: ArrayList<T>? = null
    fun hasMore(): Boolean {
        return !TextUtils.isEmpty(next)
    }
}