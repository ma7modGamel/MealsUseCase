package com.safwa.mealsusecase.ui.meals

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager

import com.safwa.mealsusecase.R
import com.safwa.mealsusecase.databinding.FragmentMainBinding
import com.safwa.mealsusecase.ui.meals.adapters.MealsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.observeOn
import kotlinx.coroutines.launch


@AndroidEntryPoint

class MealsFragment : Fragment() {

    companion object {
        fun newInstance() = MealsFragment()
    }

    private val viewModel: MealsViewModel by viewModels()

    private lateinit var binding: FragmentMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding= FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        getMeals()

    }

    private fun initViews() {
        mealsAdapter = MealsAdapter()
        binding.rv.adapter = mealsAdapter
        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager=LinearLayoutManager(context)
    }

    private lateinit var mealsAdapter: MealsAdapter
    private fun getMeals() {
        viewModel.getMeals()
        lifecycleScope.launch {
            viewModel.categories.collect{
                mealsAdapter.submitList(it?.categories)
            }
        }
    }
}