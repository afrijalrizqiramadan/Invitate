package com.asyabab.fastechqr.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.asyabab.fastechqr.DPApp
import com.asyabab.fastechqr.data.Repository
import com.asyabab.fastechqr.utils.DialogHelper

//import com.google.firebase.auth.FirebaseAuth


open class DPBaseFragment : Fragment() {
    private lateinit var progressBar: AlertDialog

    protected val repository: Repository?
        get() = (activity!!.application as DPApp).repository

    protected val loadingDialog: AlertDialog?
        get() = progressBar

//    protected val mAuth: FirebaseAuth?
//        get() = FirebaseAuth.getInstance()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBar = DialogHelper.loading(context)

    }
}
