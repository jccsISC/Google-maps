package com.jccsisc.geolocalizacionmodule.fragments.geolocalizacionfragment

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.jccsisc.geolocalizacionmodule.R

fun GeolocalizacionFragment.initElements() {
    mBinding.apply {

        btnObtenerCoordenadas.setOnClickListener {
           if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
               if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                   ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), REQUEST_CODE)
               }else {
                   obtenerCoordenada()
               }
           }
        }

        txtClick.setOnClickListener {
            findNavController().navigate(R.id.action_geolocalizacionFragment_to_otherFragment)
        }
    }
}