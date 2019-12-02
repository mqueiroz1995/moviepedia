package me.mqueiroz.network.serverconfig.domain

import io.reactivex.Single
import java.util.*

// TODO: move to core-user-settings
class GetLanguageUseCase(
    private val serverConfigRepository: ServerConfigRepository
) {

    operator fun invoke(): Single<String> {
        val deviceLanguage = Locale.getDefault().language

        return serverConfigRepository.getSupportedLanguages()
            .flattenAsObservable { it }
            .filter { it.code == deviceLanguage }
            .first(DEFAULT_LANGUAGE)
            .map { it.code }
    }

    companion object {

        private val DEFAULT_LANGUAGE =
            Language(
                code = "en",
                name = "English"
            )
    }
}