package com.example.liverpooltest

import com.example.liverpooltest.model.others.VariantsColor

data class Product(
    val productDisplayName: String?,
    val listPrice: String?,
    val promoPrice: String?,
    val lgImage: String?,
    val color: List<VariantsColor>?
)