package com.example.firstapp.fragment.build.network

import com.skydoves.sandwich.ApiResponse

interface BuildService {

    suspend fun fetchChampions(): ApiResponse<List<Avenger>>
}