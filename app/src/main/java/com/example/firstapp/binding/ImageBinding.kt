package com.example.firstapp.binding

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import coil.load
import de.hdodenhof.circleimageview.CircleImageView

/**
 * FirstApp
 * Class: ImageBinding
 * Created by 82102 on 2021-11-26.
 *
 * Description:
 */
object ImageBinding {
    @JvmStatic
    @BindingAdapter("setImageView")
    fun bindImage(view: CircleImageView, champion: String) {

        view.load("http://ddragon.leagueoflegends.com/cdn/11.23.1/img/champion/${champion}.png")

    }

}