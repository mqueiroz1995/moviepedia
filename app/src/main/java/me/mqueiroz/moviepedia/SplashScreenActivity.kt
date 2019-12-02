package me.mqueiroz.moviepedia

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import me.mqueiroz.network.serverconfig.domain.FetchServerConfigUseCase
import org.koin.core.KoinComponent
import org.koin.core.inject

class SplashScreenActivity : AppCompatActivity(R.layout.activity_splash_screen), KoinComponent {

    private val disposable = CompositeDisposable()

    private val fetchServerConfig: FetchServerConfigUseCase by inject()

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        fetchServerConfig()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onComplete = {
                    startActivity(Intent(this, MainActivity::class.java))
                },
                onError = {
                    // TODO: improve error handling
                    Toast.makeText(this, "ERROR LOADING SERVER CONFIG", Toast.LENGTH_LONG).show()
                }
            )
            .addTo(disposable)
    }

    override fun onDestroy() {
        disposable.clear()
        super.onDestroy()
    }
}