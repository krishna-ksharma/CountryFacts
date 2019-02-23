package com.wipro.assignment

import android.os.Build
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * Created by krishnas on 2/23/2019.
 */
@RunWith(RobolectricTestRunner::class)
@Config(manifest = "app/src/main/AndroidManifest.xml", sdk = [Build.VERSION_CODES.P], application = TestFactsApplication::class)
abstract class FactsTestCase {

}