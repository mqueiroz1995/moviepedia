package me.mqueiroz.moviepedia

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.dsl.koinApplication
import org.koin.test.KoinTest
import org.koin.test.check.checkModules

@RunWith(AndroidJUnit4::class)
class KoinModulesProviderTest : KoinTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun getModules() {
        koinApplication {
            modules(
                KoinModulesProvider.getModules()
            )
        }.checkModules()
    }
}
