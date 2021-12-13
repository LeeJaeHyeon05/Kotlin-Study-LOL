package com.example.firstapp.adapter.SummorSpell

import android.app.AlertDialog
import android.app.Dialog
import android.provider.Settings.Global.getString
import android.view.View
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.firstapp.ItemsViewModel
import com.example.firstapp.R

data class ItemsViewModel(val image: Int, val text: String, val dialogText: String, val dialogIcon: Int, val dialogTitle: String)


