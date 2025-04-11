package com.example.liverpooltest.model

data class Navigation(
    val ancester: List<Ancester>,
    val childs: List<Any>,
    val current: List<Current>
)