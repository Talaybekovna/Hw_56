package com.example.hw_5644

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class ConfirmationDialogFragment(private val listener: ItemDeleteListener) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val positionFromMA = arguments?.getInt("position")!!

        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle(getString(R.string.confirmation_delete))
                .setMessage(getString(R.string.confirmation))
                .setCancelable(true)
                .setPositiveButton(getString(R.string.yes)) { _, _ ->
                    listener.onItemDelete(positionFromMA)
                }
                .setNegativeButton(getString(R.string.no),
                    DialogInterface.OnClickListener { dialog, _ ->
                        dialog.dismiss()
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}