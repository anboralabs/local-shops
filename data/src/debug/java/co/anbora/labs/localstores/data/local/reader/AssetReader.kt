package co.anbora.labs.localstores.data.local.reader

import android.content.Context
import co.anbora.labs.localstores.data.local.AssetFileReader

class AssetReader(private val context: Context): AssetFileReader {
    override fun read(nameFile: String): String {
        return context.assets.open(nameFile).bufferedReader().use { it.readText() }
    }
}