package co.anbora.labs.localstores.data.local

interface AssetFileReader {

    fun read(nameFile: String): String
}