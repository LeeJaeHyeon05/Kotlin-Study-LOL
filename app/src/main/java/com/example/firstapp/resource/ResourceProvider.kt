package com.example.firstapp.resource

import android.content.Context
import javax.inject.Inject

/**
 * @author hanago
 * @email kottodat@naver.com
 * @since 2021/11/11
 **/
// hilt @Provide 샘플 대상
class ResourceProvider @Inject constructor(private val context: Context) {
    fun getString(resId: Int) = context.resources.getString(resId)
}