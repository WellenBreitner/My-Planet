package com.example.myplanet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class GetStartedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_get_started, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btn = view.findViewById<Button>(R.id.button_get_started)

        val mFragment = PlanetListFragment()
        btn.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                setCustomAnimations(
                    com.google.android.material.R.anim.abc_fade_in,
                    com.google.android.material.R.anim.abc_fade_out
                )
                replace(
                    R.id.fragment_Container,
                    mFragment,
                    PlanetListFragment::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }
    }

}