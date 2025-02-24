package com.safwa.mealsusecase.ui.meals

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.safwa.mealsusecase.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint

class MealsFragment : Fragment() {

    companion object {
        fun newInstance() = MealsFragment()
    }

    private val viewModel: MealsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

}