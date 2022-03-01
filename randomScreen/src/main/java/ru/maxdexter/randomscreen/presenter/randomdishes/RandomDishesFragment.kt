package ru.maxdexter.randomscreen.presenter.randomdishes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.maxdexter.randomscreen.R

class RandomDishesFragment : Fragment() {

    private val viewModel: RandomDishesViewModel by lazy {
        ViewModelProvider(this).get(RandomDishesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.random_dishes_fragment, container, false)
    }


}