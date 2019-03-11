package com.wipro.assignment

import android.os.Build
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProviders
import com.wipro.assignment.ui.FactsActivity
import com.wipro.assignment.ui.viewmodel.FactsViewModel
import kotlinx.android.synthetic.main.fragment_facts.*
import layout.FactsFragment
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * Created by krishnas on 2/24/2019.
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.P], application = TestFactsApplication::class)
class FactsFragmentTest {
    private lateinit var fragment: FactsFragment
    private lateinit var factsViewModel: FactsViewModel

    @Before
    fun setUp() {
        val activity = Robolectric.setupActivity(FactsActivity::class.java)
        fragment = activity.supportFragmentManager.findFragmentById(R.id.fragment_container) as FactsFragment
        factsViewModel = ViewModelProviders.of(fragment, fragment.viewModelFactory).get(FactsViewModel::class.java)
    }

    @Test
    fun validateErrorView() {
        assertTrue(fragment.error.isVisible)
        assertTrue(fragment.factsRecyclerView.isGone)
    }

    @Test
    fun validateRecyclerView() {
        factsViewModel.fetchFacts("canada")
        assertTrue(fragment.error.isGone)
        assertTrue(fragment.factsRecyclerView.isVisible)
    }

}