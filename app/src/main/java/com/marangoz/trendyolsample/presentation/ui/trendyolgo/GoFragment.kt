package com.marangoz.trendyolsample.presentation.ui.trendyolgo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.marangoz.trendyolsample.R
import com.marangoz.trendyolsample.databinding.FragmentGoBinding
import com.marangoz.trendyolsample.databinding.FragmentMainPageBinding
import com.marangoz.trendyolsample.presentation.adapter.ProductAdqapter
import com.marangoz.trendyolsample.presentation.adapter.RickAdapter
import com.marangoz.trendyolsample.presentation.ui.anasayfa.MainPageFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GoFragment : Fragment() {

    private val viewModel by viewModels<GoFragmentViewModel>()
    private lateinit var _binding : FragmentGoBinding

    val adap: RickAdapter by lazy { RickAdapter() }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = FragmentGoBinding.inflate(inflater,container,false)

        _binding.productRv.apply {
            setHasFixedSize(true)
            adapter = adap
        }
        viewModel.getRickData()
        viewModel.liveData.observe(viewLifecycleOwner){
            lifecycleScope.launch {
                adap.submitData(it)
            }
        }



        return _binding.root
    }


}