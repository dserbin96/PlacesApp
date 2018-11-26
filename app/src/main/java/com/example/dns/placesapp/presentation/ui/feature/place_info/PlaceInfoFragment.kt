package com.example.dns.placesapp.presentation.ui.feature.place_info

import android.location.Location
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.bumptech.glide.Glide
import com.example.dns.placesapp.R
import com.example.dns.placesapp.presentation.global.model.PlaceDetailViewModel
import com.example.dns.placesapp.presentation.mvp.feature.place_info.PlaceInfoPresenter
import com.example.dns.placesapp.presentation.mvp.feature.place_info.PlaceView
import com.example.dns.placesapp.presentation.ui.adapter.PhotoPlaceAdapter
import com.example.dns.placesapp.presentation.ui.global.base.BaseFragment
import com.example.dns.placesapp.presentation.ui.global.expansion.gone
import com.example.dns.placesapp.presentation.ui.global.expansion.visibile
import io.rmiri.skeleton.Master.IsCanSetAdapterListener
import kotlinx.android.synthetic.main.fragment_place_info.*
import kotlinx.android.synthetic.main.layout_place_card.*
import java.util.*
import javax.inject.Inject
import javax.inject.Provider

class PlaceInfoFragment : BaseFragment(), PlaceView {

    companion object {
        private const val KEY_MODEL = "KEY_MODEL"
        private const val KEY_LOCATION = "KEY_LOCATION"

        fun getInstance(model: PlaceDetailViewModel, location: Location): PlaceInfoFragment {
            val fragment = PlaceInfoFragment()
            val arg = Bundle()
            arg.putParcelable(KEY_MODEL, model)
            arg.putParcelable(KEY_LOCATION, location)
            fragment.arguments = arg
            return fragment
        }
    }

    @Inject
    lateinit var providePresenter: Provider<PlaceInfoPresenter>

    @InjectPresenter
    lateinit var presenter: PlaceInfoPresenter

    private lateinit var adapter: PhotoPlaceAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    @ProvidePresenter
    fun providePresenter(): PlaceInfoPresenter = providePresenter.get()

    override fun layoutRes() = R.layout.fragment_place_info

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.start()
        initView()
    }

    fun getArgumentModel(): PlaceDetailViewModel? = arguments?.getParcelable(KEY_MODEL)

    fun getArgumentLocation(): Location? = arguments?.getParcelable(KEY_LOCATION)

    override fun showError(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_LONG).show()
    }

    override fun showInfo(model: PlaceDetailViewModel, myLocation: Location) {
        groupContackt.visibile()
        if (model.basePhoto.isNullOrEmpty()) ivPlace.gone()
        else {
            Glide.with(this).load(model.basePhoto).into(ivPlace)
            Glide.with(this).load(model.basePhoto).into(ivCirclePlace)
        }
        tvName.text = model.name
        model.rating?.let { rbPlace.rating = it } ?: let { rbPlace.visibile(false) }
        tvStreat.text = model.address
        when (model.isOpen) {
            true -> {
                model.timeWork?.let { calendar ->
                    context?.let { tvTimeWork.setCompoundDrawablesRelative(ContextCompat.getDrawable(it, R.drawable.ic_current_place), null, null, null) }
                    val time = getString(R.string.open) + " " + calendar.get(Calendar.HOUR_OF_DAY).toString()
                    tvTimeWork.text = time
                    tvTimeWork.visibile()
                } ?: let {
                    tvTimeWork.gone()
                }
            }
            false -> tvTimeWork.text = getString(R.string.close)
            else -> tvTimeWork.gone()
        }
        model.latLng?.let {
            val floatMas = FloatArray(4)
            Location.distanceBetween(myLocation.latitude, myLocation.longitude,
                    it.latitude, it.longitude, floatMas)
            val strDistance = String.format("%.2f", (floatMas[0] / 1000)) +
                    " " + getString(R.string.distance)
            tvDistancePlace.text = strDistance
        } ?: let {
            tvDistancePlace.gone()
        }
        tvDescription.text = model.description
    }

    override fun showPhoto(photos: List<String>) {

        context?.let {
            adapter = PhotoPlaceAdapter(it, rvPlace, photos, IsCanSetAdapterListener {
                rvPlace.adapter = adapter
            })
            linearLayoutManager = LinearLayoutManager(it, LinearLayoutManager.HORIZONTAL, true)
            rvPlace.layoutManager = linearLayoutManager
        }
    }

    private fun initView() {

    }
}