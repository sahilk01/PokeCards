package com.example.core

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ErrorUtil @Inject constructor(
    @ApplicationContext
    private val applicationContext: Context
) {
    val universalError get() = applicationContext.getString(com.example.palette.R.string.something_went_wrong)
    val networkError get() = applicationContext.getString(com.example.palette.R.string.please_connect_to_internet)
}