package com.safwa.mealsusecase.ui.meals.adapters

import android.icu.text.Transliterator.Position
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil

import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.safwa.domain.models.Category

import com.safwa.mealsusecase.databinding.ItemMealsBinding


class MealsAdapter() : ListAdapter<Category,MealsAdapter.MealsViewHolder>(MealsDiffCallBack()) {
    class MealsViewHolder(private val binding: ItemMealsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category) {

            binding.txt.text = category.idCategory + " " + category.strCategory
            Glide.with(binding.root.context).load(category.strCategoryThumb).into(binding.imageView)

        }
    }


    class MealsDiffCallBack : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem.idCategory == newItem.idCategory
        }

        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealsViewHolder {
        val inflater = ItemMealsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MealsViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MealsViewHolder, position: Int) {
        val category = getItem(position)
        holder.bind(category)

    }
}