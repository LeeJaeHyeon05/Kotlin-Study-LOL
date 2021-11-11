package com.example.firstapp.navigator

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.example.firstapp.MainActivity
import javax.inject.Inject

/**
 * @author hanago
 * @email kottodat@naver.com
 * @since 2021/11/11
 **/
// hilt @Bind 샘플 대상
class AppNavigatorImpl @Inject constructor(private val activity: FragmentActivity) : AppNavigator {
    override fun openSetting() {
        // todo 설정 액티비티를 만들고 MainActivity가 아니라 설정Activity를 호출 하도록 수정해야함
        activity.startActivity(Intent(activity, MainActivity::class.java))
    }
}