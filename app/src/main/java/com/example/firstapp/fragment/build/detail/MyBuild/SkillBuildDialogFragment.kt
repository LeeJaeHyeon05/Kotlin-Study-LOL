package com.example.firstapp.fragment.build.detail.MyBuild

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentSkillBuildDialogBinding
import com.example.firstapp.fragment.build.BuildDetailActivity

class SkillBuildDialogFragment : DialogFragment(){

    lateinit var binding: FragmentSkillBuildDialogBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSkillBuildDialogBinding.inflate(inflater, container, false)

        binding.skillBuildCancel.setOnClickListener { dismiss() }
        binding.skillBuildConfirm.setOnClickListener {
            dismiss()
        }
        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }


}