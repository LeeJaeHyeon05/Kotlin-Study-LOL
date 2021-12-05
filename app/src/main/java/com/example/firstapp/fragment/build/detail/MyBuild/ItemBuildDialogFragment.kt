package com.example.firstapp.fragment.build.detail.MyBuild

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentItemBuildDialogBinding
import com.example.firstapp.databinding.FragmentSkillBuildDialogBinding


class ItemBuildDialogFragment : DialogFragment() {

    lateinit var binding: FragmentItemBuildDialogBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentItemBuildDialogBinding.inflate(inflater, container, false)

        binding.itemBuildCancel.setOnClickListener { dismiss() }
        binding.itemBuildConfirm.setOnClickListener {
            dismiss()
        }
        return binding.root
    }


}