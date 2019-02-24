package com.wipro.assignment

import com.wipro.assignment.data.FactsRepositoryTest
import com.wipro.assignment.viewmodel.FactsViewModelTest
import org.junit.runner.RunWith
import org.junit.runners.Suite


/**
 * Created by krishnas on 2/24/2019.
 */
@RunWith(Suite::class)
@Suite.SuiteClasses(FactsViewModelTest::class, FactsRepositoryTest::class, FactsFragmentTest::class)
class TestsSuite {}