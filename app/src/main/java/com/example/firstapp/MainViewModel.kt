package com.example.firstapp

import androidx.lifecycle.ViewModel
import com.example.firstapp.resource.ResourceProvider
import dagger.hilt.android.lifecycle.HiltViewModel

/**
 * @author hanago
 * @email kottodat@naver.com
 * @since 2021/11/11
 **/
// hilt를 사용 할 경우 viewModel클래스에 해당 어노테이션을 붙여줌
@HiltViewModel
class MainViewModel constructor(
    /// AppModule의 @Provide 샘플
    private val resourceProvider: ResourceProvider
) : ViewModel() {

}