package ru.maxdexter.myrecipes.ui.fragments.favouriteDishes

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.maxdexter.myrecipes.R

class FavouriteDishesFragment : Fragment() {

    companion object {
        fun newInstance() = FavouriteDishesFragment()
    }

    private lateinit var viewModel: FavouriteDishesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.favourite_dishes_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FavouriteDishesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}