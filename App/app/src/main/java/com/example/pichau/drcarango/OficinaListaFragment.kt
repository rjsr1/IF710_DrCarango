package com.example.pichau.drcarango

import android.os.Bundle
import android.support.annotation.NonNull
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pichau.drcarango.databinding.ListaOficinasViewBinding

class OficinasFragment : Fragment() {

    lateinit var viewModel: OficinasViewModel


    companion object {
        fun newInstance(viewModel: OficinasViewModel): OficinasFragment {
            val fragment = OficinasFragment()
            fragment.viewModel = viewModel
            return fragment
        }
    }

    override fun onCreateView(@NonNull inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding : ListaOficinasViewBinding  = ListaOficinasViewBinding.inflate(inflater, container, false)
        binding = viewModel
        binding.recyclerView.adapter = OficinasAdapter(emptyList())
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        return binding.root
    }
    override fun onStart() {
        super.onStart()
        viewModel.load()
    }

}