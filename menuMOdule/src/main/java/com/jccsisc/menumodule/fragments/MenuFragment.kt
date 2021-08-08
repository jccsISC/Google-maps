package com.jccsisc.menumodule.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.jccsisc.menumodule.R
import com.jccsisc.menumodule.databinding.FragmentMenuBinding

class MenuFragment : Fragment(R.layout.fragment_menu) {

    lateinit var mBinding : FragmentMenuBinding
    lateinit var navControllerMenu : NavController

    companion object {
        @JvmStatic
        fun newInstance() = MenuFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mBinding = FragmentMenuBinding.bind(view)
        super.onViewCreated(mBinding.root, savedInstanceState)

       initElements()

    }
}