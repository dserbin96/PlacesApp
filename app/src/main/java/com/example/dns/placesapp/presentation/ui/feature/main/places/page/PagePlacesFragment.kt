package com.example.dns.placesapp.presentation.ui.feature.main.places.page

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.dns.placesapp.FakeDate
import com.example.dns.placesapp.R
import com.example.dns.placesapp.presentation.ui.global.base.BaseFragment
import com.example.dns.placesapp.presentation.ui.adapter.PlacesAdapter
import com.example.dns.placesapp.presentation.global.model.PlaceViewModel
import kotlinx.android.synthetic.main.fragment_page_places.*

class PagePlacesFragment : BaseFragment(), PagePlacesView {

    //добавить di
    val adapter = PlacesAdapter()

    companion object {
        fun getInstance() = PagePlacesFragment()
    }

    override fun layoutRes(): Int = R.layout.fragment_page_places

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        showList(FakeDate.getList())//delete
    }

    override fun showList(list: List<PlaceViewModel>) {
        adapter.setList(list)
    }

    private fun initRecyclerView() {
        rvPagePlaces.layoutManager = LinearLayoutManager(context)
        rvPagePlaces.adapter = adapter
    }
}