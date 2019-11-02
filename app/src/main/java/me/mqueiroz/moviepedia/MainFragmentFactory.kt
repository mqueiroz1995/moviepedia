package me.mqueiroz.moviepedia

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import me.mqueiroz.home.presentation.HomeFragment
import org.koin.core.KoinComponent
import org.koin.core.inject
import kotlin.reflect.KClass

class MainFragmentFactory : FragmentFactory(), KoinComponent {

    private val home: HomeFragment by inject()

    fun <T : Fragment> instantiate(classLoader: ClassLoader, fragment: KClass<T>): Fragment =
        instantiate(classLoader, fragment.java.canonicalName.orEmpty())

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            HomeFragment::class.java.canonicalName -> home
            else -> TODO("Missing fragment $className")
        }
    }
}
