package environment

object Environment {

    const val host = "\"API_HOST\""
    const val key = "\"API_KEY\""

    object Debug {
        const val host = "\"https://api.themoviedb.org/3/\""
        const val key = "\"693d7f88796c8ef92c2cc2c279ffbb20\""
    }

    object Release {
        const val host = "\"https://api.themoviedb.org/3/\""
        const val key = "\"693d7f88796c8ef92c2cc2c279ffbb20\""
    }
}