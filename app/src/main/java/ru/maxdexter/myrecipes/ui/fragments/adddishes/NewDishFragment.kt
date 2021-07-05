package ru.maxdexter.myrecipes.ui.fragments.adddishes

import android.Manifest
import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import ru.maxdexter.myrecipes.R
import ru.maxdexter.myrecipes.databinding.DialogImageSelectionBinding
import ru.maxdexter.myrecipes.databinding.NewDishFragmentBinding
import ru.maxdexter.myrecipes.ui.model.DishUi

class NewDishFragment : Fragment() {


    private val viewModel: NewDishViewModel by lazy {
        ViewModelProvider(this).get(NewDishViewModel::class.java)
    }

    private val getPhoto = registerForActivityResult(ActivityResultContracts.TakePicture()) {

    }

    private val getImage = registerForActivityResult(ActivityResultContracts.GetContent()) {

    }
    private lateinit var dialogBinding: DialogImageSelectionBinding
    private val multiPermission =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            it.forEach { (t, u) ->
                if (t == Manifest.permission.CAMERA && !u) {
                    //dialogBinding.ibtnPhotoImage.isEnabled = false
                } else if (t == Manifest.permission.READ_EXTERNAL_STORAGE && !u) {
                    //dialogBinding.ibtnGalleryImage.isEnabled = false
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

    private fun madeNewImage() {
        dialogBinding.ibtnGalleryImage.setOnClickListener {
            goToAppSettings(shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE))
            getImage.launch("image/*")
        }
    }

    private fun madeNewPhoto() {
        dialogBinding.ibtnPhotoImage.setOnClickListener {
            goToAppSettings(shouldShowRequestPermissionRationale(Manifest.permission.CAMERA))
            val uri = DishUi.createFileImage(requireContext())
            viewModel.dish.dishImage = uri.toString()
            getPhoto.launch(uri)
        }
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
        multiPermission.launch(
            arrayOf(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE
            )
        )
        dialogBinding = DialogImageSelectionBinding.inflate(layoutInflater)
        madeNewImage()
        madeNewPhoto()
        dialog.setContentView(dialogBinding.root)
        dialog.show()

    }

    private fun goToAppSettings(showRequestPermission: Boolean) {
        if (showRequestPermission) {
            Snackbar.make(
                dialogBinding.root,
                getString(R.string.permission_rationale_false),
                Snackbar.LENGTH_LONG
            ).setAction("YES") {
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                val uri = Uri.fromParts("package", "ru.maxdexter.myrecipes", null)
                intent.data = uri
                startActivity(intent)

            }.show()
        }
    }


}