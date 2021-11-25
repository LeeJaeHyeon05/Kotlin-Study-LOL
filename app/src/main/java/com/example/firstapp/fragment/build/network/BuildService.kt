package com.example.firstapp.fragment.build.network


import com.example.firstapp.model.Champion.Champion
import com.skydoves.sandwich.ApiResponse


interface BuildService {

    suspend fun fetchChampions(): ApiResponse<Champion>
}