package com.example.demomvvm.features.username

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.demomvvm.R
import com.example.demomvvm.databinding.FragmentEditUsernameNameBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * Main UI for the edit full name screen. Users can enter a full name.
 */
class EditUserNameFragment : Fragment() {

    companion object {

        const val ARGUMENT_DISPLAY_NAME = "ARGUMENT_DISPLAY_NAME"

        fun newInstance() = EditUserNameFragment()
    }

    private lateinit var viewDataBinding: FragmentEditUsernameNameBinding

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupActionBar()
        loadData()
    }

    private fun loadData() {
        // Edit an existing user name?
        viewDataBinding.viewModel?.start(arguments?.getString(ARGUMENT_DISPLAY_NAME))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_edit_username_name, container, false)
        viewDataBinding = FragmentEditUsernameNameBinding.bind(root).apply {
            viewModel = (activity as EditUserNameActivity).obtainViewModel()
        }

        viewDataBinding.setLifecycleOwner(this.viewLifecycleOwner)

        setHasOptionsMenu(true)
        retainInstance = false

        setupFab()

        return viewDataBinding.root
    }

    private fun setupFab() {
        activity?.findViewById<FloatingActionButton>(R.id.fab_edit_user_name_done)?.let {
            it.setOnClickListener { viewDataBinding.viewModel?.saveUserName() }
        }
    }

    private fun setupActionBar() {
        (activity as AppCompatActivity).supportActionBar?.setTitle(R.string.edit_user_name_label)
    }

}
