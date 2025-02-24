package com.safwa.domain.usecase

import com.safwa.domain.models.CategoryResponse
import com.safwa.domain.repository.MealsRepository

class GetMealsUseCase(private val repository: MealsRepository) {

   suspend operator fun invoke() : CategoryResponse {
        return repository.getMealsFromApi()
    }

}