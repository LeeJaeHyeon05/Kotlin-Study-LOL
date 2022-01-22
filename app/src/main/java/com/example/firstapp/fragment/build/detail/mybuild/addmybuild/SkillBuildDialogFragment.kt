package com.example.firstapp.fragment.build.detail.mybuild.addmybuild

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.RadioButton
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.example.firstapp.databinding.FragmentSkillBuildDialogBinding

class SkillBuildDialogFragment : DialogFragment(){

    lateinit var binding: FragmentSkillBuildDialogBinding
    private val skillBuildDialogViewModel : SkillBuildDialogViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSkillBuildDialogBinding.inflate(inflater, container, false)

        val bindingList = listOf(
            binding.skillLv1,
            binding.skillLv2,
            binding.skillLv3,
            binding.skillLv4,
            binding.skillLv5,
            binding.skillLv6,
            binding.skillLv7,
            binding.skillLv8,
            binding.skillLv9,
            binding.skillLv10,
            binding.skillLv11,
            binding.skillLv12,
            binding.skillLv13,
            binding.skillLv14,
            binding.skillLv15,
            binding.skillLv16,
            binding.skillLv17,
            binding.skillLv18,
        )

        binding.skillBuildCancel.setOnClickListener { dismiss() }
        binding.skillBuildConfirm.setOnClickListener {

            dismiss()
        }

        skillBuildDialogViewModel.skillNum.observe(viewLifecycleOwner){ num ->
            bindingList.forEachIndexed { index, it ->
                it.setOnCheckedChangeListener { radioGroup, _ ->
                    for (i in 0 until radioGroup.childCount){
                        val rb = radioGroup.getChildAt(i) as RadioButton
                        if (rb.isChecked) {
                            skillBuildDialogViewModel.changeSkillNum(index + 1)
                            rb.text = "$num"
                        } else {
                            rb.text = ""
                        }
                    }
                }
            }
        }

        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }
}