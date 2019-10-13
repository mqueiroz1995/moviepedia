package me.mqueiroz.home.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import me.mqueiroz.home.R
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
        viewModel.state.observe(this, Observer {
            when (it) {
                is HomeViewState.Loading -> setLoadingState(it)
                is HomeViewState.Success -> setSuccessState(it)
                is HomeViewState.Error -> setErrorState(it)
            }
        })

        viewModel.command.observe(this, Observer {

        })
    }

    private fun setLoadingState(state: HomeViewState.Loading) {
        progressBar.visibility = View.VISIBLE
        list.visibility = View.INVISIBLE
    }

    private fun setSuccessState(state: HomeViewState.Success) {
        progressBar.visibility = View.INVISIBLE
        list.visibility = View.VISIBLE

        adapter.elements = state.elements
    }

    private fun setErrorState(state: HomeViewState.Error) {
        progressBar.visibility = View.INVISIBLE
        list.visibility = View.INVISIBLE
    }
}