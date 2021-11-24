package com.example.firstapp.fragment.build

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.firstapp.databinding.FragmentBuildMainBinding
import com.example.firstapp.fragment.build.retrofit.RetrofitData
import com.example.firstapp.fragment.build.retrofit.championData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception


class BuildMainFragment : Fragment() {

    lateinit var binding: FragmentBuildMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBuildMainBinding.inflate(inflater,container,false)

        val dummyData = dummy()
        val adapter = BuildMainAdapter(this.context,dummyData)
        binding.buildMainRv.adapter = adapter
        binding.buildMainRv.layoutManager = GridLayoutManager(
            this.context,4, GridLayoutManager.VERTICAL, false)

        getAPI()
        return binding.root
    }

    private fun getAPI() {

        GlobalScope.launch(Dispatchers.IO){
            try{
                val call = RetrofitData.networkService.getChampionList()
                call?.enqueue(object : Callback<championData> {
                    override fun onResponse(
                        call: Call<championData>,
                        response: Response<championData>
                    ) {
                        var championList = response?.body()?.data

                        Log.d("test", "Success : $championList")
                    }

                    override fun onFailure(call: Call<championData>, t: Throwable) {
                        Log.d("test", "Failure : $t")
                    }

                })
            } catch (e: Exception){
                Log.d("test", "Error: ..... $e")
            }
        }
    }
    private fun dummy(): MutableList<String> {
        val dummyList = mutableListOf<String>(
            "가렌", "갈리오", "갱플랭크", "그라가스",
            "그레이브즈", "그웬", "나르", "나미",
            "나서스", "노틸러스", "녹턴", "누누와 윌럼프",
            "니달리", "니코", "다리우스", "다이애나",
            "드레이븐", "라이즈", "라칸", "람머스",
            "럭스", "럼블", "레넥톤", "레오나",
            "렉사이", "렐", "렝가", "루시안",
            "룰루", "르블랑", "리신", "리븐",
            "리산드라", "릴리아", "마스터 이", "마오카이",
            "말자하", "말파이트", "모데카이저", "모르가나")
        return dummyList
    }
}