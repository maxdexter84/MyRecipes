package ru.maxdexter.myrecipes.ui.fragments.adddishes

import android.Manifest
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ru.maxdexter.myrecipes.R
import ru.maxdexter.myrecipes.databinding.DialogImageSelectionBinding
import ru.maxdexter.myrecipes.databinding.NewDishFragmentBinding

class NewDishFragment : Fragment() {


    private val viewModel: NewDishViewModel by lazy {
        ViewModelProvider(this).get(NewDishViewModel::class.java)
    }
    private lateinit var dialogBinding: DialogImageSelectionBinding
    private val multiPermission = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){
        it.forEach { (t, u) ->
            if (t == Manifest.permission.CAMERA && !u){
                dialogBinding.ibtnPhotoImage .isEnabled = false
            }else if (t == Manifest.permission.READ_EXTERNAL_STORAGE && !u){
                dialogBinding.ibtnGalleryImage.isEnabled = false
            }
            Log.i("TAG_PERMISSION", "Permission: $t, granted: $u")
        }
    }
    private lateinit var binding: NewDishFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = NewDishFragmentBinding.inflate(inflater)

        initToolbar()
        return binding.root
    }

    private fun initToolbar() {
        binding.addDishToolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        binding.addDishToolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        binding.addDishToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.add_photo -> {
                    customDialog()
                    true
                }
                else -> false
            }
        }
    }

    private fun customDialog() {
        val dialog = Dialog(requireContext())
        multiPermission.launch(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA,Manifest.permission.READ_EXTERNAL_STORAGE))
        dialogBinding =  DialogImageSelectionBinding.inflate(layoutInflater)
        dialog.setContentView(dialogBinding.root)
        dialog.show()
        dialogBinding.ibtnGalleryImage.setOnClickListener {

        }

    }





}