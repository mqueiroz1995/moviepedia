package me.mqueiroz.moviepedia

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.dsl.koinApplication
import org.koin.test.KoinTest
import org.koin.test.check.checkModules

@RunWith(AndroidJUnit4::class)
class KoinApplicationProviderTest : KoinTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val application: Application =
        InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as Application

    @Test
    fun getModules() {
        koinApplication(KoinApplicationProvider.get(application)).checkModules()
    }
}
