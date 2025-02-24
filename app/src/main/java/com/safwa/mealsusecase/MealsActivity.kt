package com.safwa.mealsusecase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.safwa.mealsusecase.ui.meals.MealsFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MealsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meals)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MealsFragment.newInstance())
                .commitNow()
        }
    }
}