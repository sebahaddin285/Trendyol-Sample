package com.marangoz.trendyolsample.presentation.ui.anasayfa

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.color.DynamicColors
import com.marangoz.trendyolsample.R
import com.marangoz.trendyolsample.databinding.FragmentMainPageBinding
import com.marangoz.trendyolsample.domain.model.ProductsItem
import com.marangoz.trendyolsample.domain.model.Response
import com.marangoz.trendyolsample.presentation.adapter.CategoryAdapter
import com.marangoz.trendyolsample.presentation.adapter.ProductAdqapter
import com.marangoz.trendyolsample.presentation.adapter.ServiceAdapter
import com.marangoz.trendyolsample.presentation.adapter.ViewPagerAdapter
import com.marangoz.trendyolsample.presentation.ui.search.SearchActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainPageFragment : Fragment() {

    private val viewModel by viewModels<MainPageFragmentViewModel>()
    private lateinit var _binding : FragmentMainPageBinding

    val adap: ProductAdqapter by lazy { ProductAdqapter() }
    val serviceAdap: ServiceAdapter by lazy { ServiceAdapter() }
    val categoryAdap: CategoryAdapter by lazy { CategoryAdapter() }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        DynamicColors.applyToActivityIfAvailable(requireActivity())
        _binding = FragmentMainPageBinding.inflate(inflater,container,false)


        val viewPagerAdapter by lazy { ViewPagerAdapter(null,requireContext()) }
        _binding.viewPager2.adapter = viewPagerAdapter


        _binding.productRv.apply {
            setHasFixedSize(true)
          //  layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = adap
        }
        _binding.serviceRecycler.apply {
            setHasFixedSize(true)
            //  layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = serviceAdap
        }
        _binding.rv.apply {
            setHasFixedSize(true)
            //  layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = categoryAdap
        }
        viewModel.getData()
        viewModel.liveProduct.observe(viewLifecycleOwner){
            when(it) {
                is Response.Error -> {

                }
                Response.Loading -> {

                }
                is Response.Success -> {
                    Log.e("error", it.data?.products.toString())
                    adap.setList(it.data?.products?.mapNotNull { model -> model } ?: listOf())
                }
            }

        }

        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getServiceData().collect(){
                serviceAdap.setList(it)
            }
        }
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getViewPagerPhotos().collect(){
               viewPagerAdapter.setList(it)
            }
        }
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getCategory().collect(){
                categoryAdap.setList(it)
            }
        }


        return _binding.root
    }


    override fun onResume() {
        super.onResume()


        _binding.searchView.setOnClickListener(){
            startActivity(Intent(requireContext(), SearchActivity::class.java))
        }
    }






}