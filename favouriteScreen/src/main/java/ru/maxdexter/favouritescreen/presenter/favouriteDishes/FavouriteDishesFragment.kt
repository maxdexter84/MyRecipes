package ru.maxdexter.favouritescreen.presenter.favouriteDishes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.maxdexter.favouritescreen.databinding.FavouriteDishesFragmentBinding

class FavouriteDishesFragment : Fragment() {


    private val viewModel: FavouriteDishesViewModel by lazy {
        ViewModelProvider(this).get(FavouriteDishesViewModel::class.java)
    }

    private lateinit var binding: FavouriteDishesFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FavouriteDishesFragmentBinding.inflate(inflater)
        return binding.root
    }


}