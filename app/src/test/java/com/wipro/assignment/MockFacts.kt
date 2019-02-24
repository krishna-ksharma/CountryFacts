package com.wipro.assignment

import com.wipro.assignment.rest.model.Facts
import java.util.*

/**
 * Created by krishnas on 2/24/2019.
 */
class MockFacts {
    companion object {
        @JvmStatic
        fun mockFact(): Facts {
            val fact = Facts()
            fact.title = "About Canada"
            fact.rows = Collections.emptyList()
            return fact;
        }
    }
}