package ru.maxdexter.myrecipes.ui.fragments.alldishes

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.maxdexter.myrecipes.R

class AllDishesFragment : Fragment() {

    companion object {
        fun newInstance() = AllDishesFragment()
    }

    private lateinit var viewModel: AllDishesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.all_dishes_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AllDishesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}