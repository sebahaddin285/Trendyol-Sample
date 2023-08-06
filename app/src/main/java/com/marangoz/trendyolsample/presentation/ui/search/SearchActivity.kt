package com.marangoz.trendyolsample.presentation.ui.search

import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.google.android.material.color.DynamicColors
import com.google.android.material.textfield.TextInputEditText
import com.marangoz.trendyolsample.R


class SearchActivity : AppCompatActivity() {
    private lateinit var searchEditText : TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        DynamicColors.applyToActivityIfAvailable(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)




    }

    override fun onResume() {
        super.onResume()
        searchEditText = findViewById(R.id.searchEditText)

        searchEditText.isEnabled = true
        searchEditText.requestFocus()
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)


    }


}