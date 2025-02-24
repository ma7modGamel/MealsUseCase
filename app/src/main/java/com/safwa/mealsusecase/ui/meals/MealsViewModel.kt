package com.safwa.mealsusecase.ui.meals

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.safwa.domain.models.CategoryResponse
import com.safwa.domain.usecase.GetMealsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MealsViewModel @Inject constructor(private val useCase: GetMealsUseCase) : ViewModel() {
    // TODO: Implement the ViewModel
    private val _categories: MutableStateFlow<CategoryResponse?> = MutableStateFlow(null)

    val categories : StateFlow<CategoryResponse?> = _categories

    fun getMeals() {
        viewModelScope.launch {
         try {
             Log.e("xxx",Gson().toJson(_categories.value))
            _categories.value = useCase.invoke()
         }catch (e:Exception){
             Log.e("MealsViewModel",e.message.toString())
         }
        }
    }

}