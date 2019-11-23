package me.mqueiroz.home.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_home.*
import me.mqueiroz.core_presentation.arch.onAction
import me.mqueiroz.core_presentation.arch.onStateChange
import me.mqueiroz.home.R

class HomeFragment(
    private val viewModel: HomeViewModel
) : Fragment(R.layout.fragment_home) {

    private val adapter by lazy {
        HomeListAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView()

        setStateChangeListener()
        setActionListener()
    }

    private fun setRecyclerView() {
        list.layoutManager = LinearLayoutManager(context)
        list.adapter = adapter
    }

    private fun setStateChangeListener() = onStateChange(viewModel) {
        progressBar.isVisible = it.isProgressBarVisible
        list.isVisible = it.isListVisible
        adapter.elements = it.listItems
    }

    private fun setActionListener() = onAction(viewModel) {
        when (it) {
            is HomeViewAction.Success -> showToast("SUCCESS")
            is HomeViewAction.Error -> showToast("ERROR")
        }
    }

    private fun showToast(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show()
    }
}