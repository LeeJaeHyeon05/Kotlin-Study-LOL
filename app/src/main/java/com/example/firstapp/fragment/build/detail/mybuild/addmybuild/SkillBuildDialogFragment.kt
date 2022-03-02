package com.example.firstapp.fragment.build.detail.mybuild.addmybuild

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import com.example.firstapp.databinding.FragmentSkillBuildDialogBinding

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