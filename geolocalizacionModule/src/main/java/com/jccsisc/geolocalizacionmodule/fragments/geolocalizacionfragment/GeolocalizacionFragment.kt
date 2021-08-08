package com.jccsisc.geolocalizacionmodule.fragments.geolocalizacionfragment

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.jccsisc.geolocalizacionmodule.R
import com.jccsisc.geolocalizacionmodule.databinding.FragmentGeolocalizacionBinding

class GeolocalizacionFragment : Fragment(R.layout.fragment_geolocalizacion) {

    lateinit var mBinding: FragmentGeolocalizacionBinding
    private val viewModelGeo: GeolocalicacionViewModel by viewModels()
    val REQUEST_CODE = 1

    val requestPermission = registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
        viewModelGeo.onPermissionResult(granted)
    }


    companion object {

        @JvmStatic
        fun newInstance() = GeolocalizacionFragment()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mBinding = FragmentGeolocalizacionBinding.bind(view)
        super.onViewCreated(mBinding.root, savedInstanceState)

        mBinding.apply {

            viewModelGeo.getStatusText().observe(requireActivity()) {
                txtStatusPermission.text = it
            }

            viewModelGeo.colorStatus.observe(requireActivity()) { status ->
                if (status) {
                    txtStatusPermission.setTextColor(ContextCompat.getColor(requireContext(), R.color.verde))
                } else {
                    txtStatusPermission.setTextColor(ContextCompat.getColor(requireContext(), R.color.red))
                }
            }
        }


        requestPermission.launch(Manifest.permission.ACCESS_FINE_LOCATION)

        initElements()
    }

    fun obtenerCoordenada() {
        viewModelGeo.onPermissionResult(true)
//        try {
//            mBinding.progressBar.visibility = View.VISIBLE
//            //almacenar los parametros de solicitudes en el proveedor de ubicacion combinada
//            var locationRequest : LocationRequest = LocationRequest()
//            locationRequest.interval = 10000
//            locationRequest.fastestInterval = 3000
//            locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
//            if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                viewModelGeo.onPermissionResult(false)
//                return
//            }
//
//            LocationServices.getFusedLocationProviderClient(requireActivity()).requestLocationUpdates(locationRequest, )
//
//        }catch ()
    }

    fun isLocationPermissionGranted() = ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED



    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == REQUEST_CODE && grantResults.isNotEmpty()) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                obtenerCoordenada()
            } else {
                viewModelGeo.onPermissionResult(false)
            }
        }
    }
}