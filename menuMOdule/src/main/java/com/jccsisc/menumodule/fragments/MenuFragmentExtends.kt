package com.jccsisc.menumodule.fragments

import androidx.navigation.Navigation
import com.jccsisc.menumodule.R

fun MenuFragment.initElements() {
    mBinding.apply {
        navControllerMenu = Navigation.findNavController(root)

        btnFlujoUno.setOnClickListener {
            navControllerMenu.navigate(R.id.action_menuFragment_to_main_graph)
        }
    }
}