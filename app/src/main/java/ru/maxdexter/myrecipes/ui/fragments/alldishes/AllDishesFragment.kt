package ru.maxdexter.myrecipes.ui.fragments.alldishes

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.maxdexter.myrecipes.R
import ru.maxdexter.myrecipes.databinding.AllDishesFragmentBinding

class AllDishesFragment : Fragment() {


    private val viewModel: AllDishesViewModel by lazy {
        ViewModelProvider(this).get(AllDishesViewModel::class.java)
    }

    private lateinit var binding: AllDishesFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = AllDishesFragmentBinding.inflate(layoutInflater)
        initToolbar()
        return binding.root
    }

    private fun initToolbar() {
        binding.toolbarMain.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.add -> {

                    findNavController().navigate(AllDishesFragmentDirections.actionAllDishesFragmentToNewDishFragment())
                    true
                }
                else -> false
            }
        }
    }


}