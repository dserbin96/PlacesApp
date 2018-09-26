package com.example.dns.placesapp.util.expansion

import android.view.View

fun View.visibile(isVisibile: Boolean = true) {
    this.visibility = if (isVisibile) View.VISIBLE else View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}