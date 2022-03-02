package com.example.firstapp.fragment.summoner

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatAutoCompleteTextView


class AutoFirstTextView : AppCompatAutoCompleteTextView {
    private var mContext: Context

    constructor(context: Context) : super(context) {
        mContext = context
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        mContext = context
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        mContext = context
    }

    override fun enoughToFilter(): Boolean {
        return true
    }

    override fun performFiltering(text: CharSequence, keyCode: Int) {
//mFilter.filter(text, this);
    }

    override fun onFilterComplete(count: Int) {}
}