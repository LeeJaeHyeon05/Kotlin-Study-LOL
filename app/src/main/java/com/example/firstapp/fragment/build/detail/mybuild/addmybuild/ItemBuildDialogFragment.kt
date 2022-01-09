package com.example.firstapp.fragment.build.detail.mybuild.addmybuild

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.firstapp.databinding.FragmentItemBuildDialogBinding


class ItemBuildDialogFragment : DialogFragment() {

    lateinit var binding: FragmentItemBuildDialogBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentItemBuildDialogBinding.inflate(inflater, container, false)

        val tagArrayList = arrayListOf(
            binding.itemBuildDialogTagStartingitems,
            binding.itemBuildDialogTagCore,
            binding.itemBuildDialogTagBoots,
            binding.itemBuildDialogTagSituational,
            binding.itemBuildDialogTagOffensive,
            binding.itemBuildDialogTagDefensive
        )

        for (i in tagArrayList){
            i.setOnClickListener {
                binding.itemBuildDialogMyTag.setText(i.text)
            }
        }

        binding.itemBuildCancel.setOnClickListener {
            dismiss()
        }

        binding.itemBuildConfirm.setOnClickListener {
            dismiss()
        }
        return binding.root
    }


}