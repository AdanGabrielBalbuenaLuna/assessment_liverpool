package com.example.liverpooltest.model.data

import com.example.liverpooltest.model.others.CustomUrlParam
import com.example.liverpooltest.model.others.MetaData
import com.example.liverpooltest.model.others.Navigation
import com.example.liverpooltest.model.others.PlpState
import com.example.liverpooltest.model.others.RefinementGroup
import com.example.liverpooltest.model.others.SortOption

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