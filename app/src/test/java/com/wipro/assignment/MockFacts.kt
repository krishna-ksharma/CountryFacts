package com.wipro.assignment

import com.wipro.assignment.database.entitiy.Fact

/**
 * Created by krishnas on 2/24/2019.
 */
class MockFacts {
    companion object {
        @JvmStatic
        fun mockEntityFact(): Fact {
            val fact = Fact()
            fact.country = "About Canada"
            return fact;
        }
    }
}