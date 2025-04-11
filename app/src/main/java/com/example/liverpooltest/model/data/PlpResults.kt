package com.example.liverpooltest.model.data

import com.example.liverpooltest.model.CustomUrlParam
import com.example.liverpooltest.model.MetaData
import com.example.liverpooltest.model.Navigation
import com.example.liverpooltest.model.PlpState
import com.example.liverpooltest.model.RefinementGroup
import com.example.liverpooltest.model.SortOption

data class PlpResults(
    val customUrlParam: CustomUrlParam,
    val label: String,
    val metaData: MetaData,
    val navigation: Navigation,
    val plpState: PlpState,
    val records: List<Record>,
    val refinementGroups: List<RefinementGroup>,
    val sortOptions: List<SortOption>
)