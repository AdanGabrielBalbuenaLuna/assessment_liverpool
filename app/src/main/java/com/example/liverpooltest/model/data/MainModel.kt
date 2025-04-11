package com.example.liverpooltest.model.data

import com.example.liverpooltest.model.others.Status

data class MainModel(
    val pageType: String,
    val plpResults: PlpResults,
    val status: Status
)