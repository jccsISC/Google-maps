package com.jccsisc.geolocalizacionmodule.fragments.fragmentother

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.jccsisc.geolocalizacionmodule.R
import com.jccsisc.geolocalizacionmodule.databinding.FragmentOtherBinding


class OtherFragment : Fragment(R.layout.fragment_other) {

    lateinit var mBinding : FragmentOtherBinding
    lateinit var navController : NavController

    companion object {

        @JvmStatic
        fun newInstance() = OtherFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mBinding = FragmentOtherBinding.bind(view)
        super.onViewCreated(mBinding.root, savedInstanceState)

        initElements()
    }
}