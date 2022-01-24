package com.example.firstapp.fragment.build.detail.mybuild.addmybuild

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.firstapp.databinding.FragmentSkillBuildDialogBinding
import timber.log.Timber

class SkillBuildDialogFragment : DialogFragment(){

    lateinit var binding: FragmentSkillBuildDialogBinding
    private val skillBuildDialogViewModel : SkillBuildDialogViewModel by activityViewModels()
    private var bindingList = listOf<RadioGroup>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSkillBuildDialogBinding.inflate(layoutInflater)

        bindingList = listOf(
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

        setRadioButtonFunction()
        setObserver()

        binding.skillBuildCancel.setOnClickListener {
            seeList()
            dismiss()
            clearRadioButtons()
        }
        binding.skillBuildConfirm.setOnClickListener {
            skillBuildDialogViewModel.saveSkillTree()
            seeList()
            dismiss()
        }

        return binding.root
    }

    private fun setRadioButtonFunction() {
        bindingList.forEachIndexed { index, it ->
            it.setOnCheckedChangeListener { radioGroup, _ ->
                var skill = ""
                for (i in 0 until radioGroup.childCount) {
                    if ((radioGroup.getChildAt(i) as RadioButton).isChecked) {
                        when (i) {
                            0 -> skill = "Q"
                            1 -> skill = "W"
                            2 -> skill = "E"
                            3 -> skill = "R"
                        }
                    }
                }
                skillBuildDialogViewModel.changeSkillTree(index, skill)
            }
        }
    }

    private fun setObserver() {
        skillBuildDialogViewModel.skillTree.observe(viewLifecycleOwner) { skillTree ->
            skillTree.forEachIndexed { index: Int, skill: String ->
                val rg = bindingList[index]
                for (i in 0 until rg.childCount) {
                    val rb = rg.getChildAt(i) as RadioButton
                    rb.text = ""
                }
                val num = index + 1
                when(skill){
                    "Q" -> (rg.getChildAt(0) as RadioButton).text = "$num"
                    "W" -> (rg.getChildAt(1) as RadioButton).text = "$num"
                    "E" -> (rg.getChildAt(2) as RadioButton).text = "$num"
                    "R" -> (rg.getChildAt(3) as RadioButton).text = "$num"
                }
            }
        }
    }

    private fun clearRadioButtons(){
        bindingList.forEach{
            it.clearCheck()
        }
    }

    private fun seeList(){
        Timber.d(skillBuildDialogViewModel.skillTree.value.toString())
        Timber.d(skillBuildDialogViewModel.skillTreeDisplay.value.toString())
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }
}