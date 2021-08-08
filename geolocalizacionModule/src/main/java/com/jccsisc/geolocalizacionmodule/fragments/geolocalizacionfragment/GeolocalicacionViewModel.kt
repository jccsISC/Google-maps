package com.jccsisc.geolocalizacionmodule.fragments.geolocalizacionfragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jccsisc.geolocalizacionmodule.R

class GeolocalicacionViewModel(application: Application) : AndroidViewModel(application) {

    var latitud = MutableLiveData("")
    var longitud = MutableLiveData("")

    private val statusText = MutableLiveData<CharSequence>(application.getString(R.string.permission_result_pending))

    fun getStatusText(): LiveData<CharSequence> = statusText
    var colorStatus = MutableLiveData(false)

    fun onPermissionResult(result: Boolean) {
        statusText.value = getApplication<Application>().getString(if (result) R.string.permission_result_granted else R.string.permission_result_denied)
        colorStatus.value = result
    }

}