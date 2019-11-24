package me.mqueiroz.home.presentation

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_home.*
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
    }

    private fun setRecyclerView() {
        list.apply {
            val orientation = RecyclerView.HORIZONTAL
            val leftDivider = MarginListItemDecoration(MarginListItemDecoration.Direction.LEFT)

            adapter = this@HomeFragment.adapter
            layoutManager = LinearLayoutManager(context, orientation, false)
            addItemDecoration(leftDivider)
        }
    }

    private fun setStateChangeListener() = onStateChange(viewModel) {
        progressBar.isVisible = it.isProgressBarVisible
        list.isVisible = it.isListVisible
        adapter.elements = it.listItems
    }
}