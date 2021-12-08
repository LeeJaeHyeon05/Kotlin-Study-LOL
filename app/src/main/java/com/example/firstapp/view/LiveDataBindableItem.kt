package com.example.firstapp.view

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import com.xwray.groupie.databinding.BindableItem
import com.xwray.groupie.databinding.GroupieViewHolder

/**
 * @author hanago
 * @email kottodat@naver.com
 * @since 2021/11/24
 **/
abstract class LiveDataBindableItem<T : ViewDataBinding> : BindableItem<T>(),
    LifecycleOwner {

    private val lifecycleRegistry by lazy { LifecycleRegistry(this) }
    override fun getLifecycle(): Lifecycle = lifecycleRegistry

    override fun onViewAttachedToWindow(viewHolder: GroupieViewHolder<T>) {
        super.onViewAttachedToWindow(viewHolder)
        lifecycleRegistry.markState(Lifecycle.State.RESUMED)
    }

    override fun onViewDetachedFromWindow(viewHolder: GroupieViewHolder<T>) {
        super.onViewDetachedFromWindow(viewHolder)
        lifecycleRegistry.markState(Lifecycle.State.CREATED)
    }


}