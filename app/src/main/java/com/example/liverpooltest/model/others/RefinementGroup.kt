package com.example.liverpooltest.model.others

data class RefinementGroup(
    val dimensionName: String,
    val multiSelect: Boolean,
    val name: String,
    val refinement: List<Refinement>
)