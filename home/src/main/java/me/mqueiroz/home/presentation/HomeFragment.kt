package me.mqueiroz.home.presentation

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import me.mqueiroz.home.R
import me.mqueiroz.core_presentation.onStateChange
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModel()

    private val adapter by lazy {
        HomeListAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView()
        setObservers()
    }

    private fun setRecyclerView() {
        list.layoutManager = LinearLayoutManager(context)
        list.adapter = adapter
    }

    private fun setObservers() {
        onStateChange(viewModel) {
            progressBar.isVisible = it.isProgressBarVisible
            list.isVisible = it.isListVisible
            adapter.elements = it.listItems
        }
    }
}