package com.example.dns.placesapp.presentation.ui.global.widgets

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import com.example.dns.placesapp.R
import com.wang.avi.AVLoadingIndicatorView

class FragmentDialogLoader : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        context?.let {
            val builder = AlertDialog.Builder(it)
            val view = activity?.layoutInflater?.inflate(R.layout.fragment_loading_dialog, null)
            view?.findViewById<AVLoadingIndicatorView>(R.id.loader)?.show()
            builder.setView(view)
            return builder.create().apply {
                window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            }
        }
        return super.onCreateDialog(savedInstanceState)
    }
}
