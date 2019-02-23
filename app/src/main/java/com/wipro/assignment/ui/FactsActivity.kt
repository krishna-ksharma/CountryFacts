package com.wipro.assignment.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wipro.assignment.R
import dagger.android.AndroidInjection
import layout.FactsFragment

/**
 * Created by krishnas on 2/22/2019.
 */
class FactsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facts)
        addFragment()
    }

    private fun addFragment() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragment = FactsFragment.newInstance()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }
}
