package com.jccsisc.geolocalizacionmodule.fragments.fragmentother

import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.jccsisc.geolocalizacionmodule.R

fun OtherFragment.initElements() {
    mBinding.apply {

        //recomendable hacerlo de esta maner
        navController = Navigation.findNavController(root)

        txtNext.setOnClickListener {
            navController.navigate(R.id.action_otherFragment_to_fragmentThree)
        }
    }
}