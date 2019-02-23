package layout

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.wipro.assignment.R
import com.wipro.assignment.di.ViewModelFactory
import com.wipro.assignment.rest.model.Facts
import com.wipro.assignment.ui.FactsAdapter
import com.wipro.assignment.ui.viewmodel.FactsViewModel
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_facts.*
import javax.inject.Inject

/**
 * Created by krishnas on 2/22/2019.
 */
class FactsFragment : Fragment() {
    private lateinit var factsViewModel: FactsViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var adapter: FactsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        factsViewModel = ViewModelProviders.of(this, viewModelFactory).get(FactsViewModel::class.java)
        onRefresh()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_facts, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupAdapter(ArrayList<Facts.Row>())
        factsViewModel.factsResult().observe(this, Observer { facts ->
            if (facts == null) {
                factsRecyclerView.isVisible = false
                error.isVisible = true
            } else {
                factsRecyclerView.isVisible = true
                error.isVisible = false
                activity?.title = facts.title
                refreshAdapter(facts)
            }

        })
        swipeRefresh.setOnRefreshListener {
            swipeRefresh.isRefreshing = false
            onRefresh()
        }
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    private fun refreshAdapter(facts: Facts) {
        adapter.facts.clear()
        adapter.facts.addAll(facts.rows)
        adapter.notifyDataSetChanged()
    }

    private fun setupAdapter(facts: MutableList<Facts.Row>) {
        adapter = FactsAdapter(context!!, facts)
        val itemDecorator = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        factsRecyclerView.addItemDecoration(itemDecorator)
        factsRecyclerView.setHasFixedSize(true)
        factsRecyclerView.layoutManager = LinearLayoutManager(context)
        factsRecyclerView.adapter = adapter
    }

    private fun onRefresh() {
        factsViewModel.fetchFacts("2iodh4vg0eortkl")
    }

    companion object {
        fun newInstance(): FactsFragment {
            return FactsFragment()
        }
    }
}