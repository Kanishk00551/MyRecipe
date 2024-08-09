package com.example.myrecipeapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import androidx.versionedparcelable.VersionedParcelize

@Parcelize
data class Category(val idCategory:String,
                    val strCategory: String,
                    val strCategoryThumb: String,
                    val strCategoryDescription: String):Parcelable

data class CategoriesResponse(val categories: List<Category>)