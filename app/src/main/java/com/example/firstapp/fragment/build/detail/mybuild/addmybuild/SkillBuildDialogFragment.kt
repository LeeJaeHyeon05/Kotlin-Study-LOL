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
import timber.log.Timber

class SkillBuildDialogFragment : DialogFragment(){

    lateinit var binding: FragmentSkillBuildDialogBinding
    private val skillBuildDialogViewModel : SkillBuildDialogViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSkillBuildDialogBinding.inflate(layoutInflater)

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

        skillBuildDialogViewModel.skillTree.observe(viewLifecycleOwner) { skillTree ->
            skillTree.forEachIndexed { index: Int, skill: String ->
                val rg = bindingList[index]
                for (i in 0 until rg.childCount) {
                    val rb = rg.getChildAt(i) as RadioButton
                    if(rb.isChecked){
                        val skillNum = index + 1
                        rb.text = "$skillNum"
                    } else {
                        rb.text = ""
                    }
                }
            }
        }

        bindingList.forEachIndexed { index, it ->
            it.setOnCheckedChangeListener { radioGroup, it ->
                var skill = ""
                for (i in 0 until radioGroup.childCount) {
                    val rb = radioGroup.getChildAt(i) as RadioButton
                    if (rb.isChecked) {
                        when (i) {
                            0 -> skill = "Q"
                            1 -> skill = "W"
                            2 -> skill = "E"
                            3 -> skill = "R"
                        }
                    }
                }
                Timber.d(index.toString())
                Timber.d(skill)
                skillBuildDialogViewModel.changeSkillTree(index, skill)
                val a = skillBuildDialogViewModel.skillTree.value
                Timber.d(a.toString())
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