import java.util.*

//Klasse Musikverwaltung

class Musikverwaltung() {

    //Songlister erstellen

    val songliste = arrayListOf<Song>()

    // song hinzufuegen

    fun songhinzufuegen(song: Song) {
        songliste.add(song)
        return
    }

    // songsuche

    fun songsuche(search: String):Song {
        for (p in songliste) {
            val result = p.suchbegriffpruefen(search)
            if (result) {
                return p
            }
        }

        return songliste[0]
    }

    //bester song

    fun bestersong(): Song {
        var max = songliste[0]
        for (p in songliste) {
            if (p.bewertung >= max.bewertung) {
                max = p
            }
        }
        return max
    }

    //random Playlist

    fun rndplaylist(): ArrayList<Song> {
        val playlist = arrayListOf<Song>()
        val rndgenerator = Random()

        var counter = 0
        for (p in songliste) {
            val rndnumber = rndgenerator.nextInt(songliste.size)
            playlist += songliste[rndnumber]
            counter ++
        }
        return playlist
    }



}
