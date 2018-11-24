package com.example.dns.placesapp.presentation.global.model

import android.os.Parcel
import android.os.Parcelable
import com.google.android.gms.maps.model.LatLng
import java.util.*

data class PlaceDetailViewModel(val id: String,
                                val name: String,
                                val latLng: LatLng?,
                                val address: String?,
                                val rating: Float?,
                                val photosPath: List<String>?,
                                val basePhoto: String?,
                                val isOpen: Boolean?,
                                val timeWork: Calendar?) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readParcelable(LatLng::class.java.classLoader),
            parcel.readString(),
            parcel.readValue(Float::class.java.classLoader) as? Float,
            parcel.createStringArrayList(),
            parcel.readString(),
            parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
            Calendar.getInstance().apply { time = Date(parcel.readLong()) })

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeParcelable(latLng, flags)
        parcel.writeString(address)
        parcel.writeValue(rating)
        parcel.writeStringList(photosPath)
        parcel.writeString(basePhoto)
        parcel.writeValue(isOpen)
        parcel.writeLong(timeWork?.time?.time ?: 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PlaceDetailViewModel> {
        override fun createFromParcel(parcel: Parcel): PlaceDetailViewModel {
            return PlaceDetailViewModel(parcel)
        }

        override fun newArray(size: Int): Array<PlaceDetailViewModel?> {
            return arrayOfNulls(size)
        }
    }
}