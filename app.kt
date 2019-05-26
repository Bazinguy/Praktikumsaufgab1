import java.nio.charset.Charset
import java.util.*
import kotlin.collections.ArrayList


fun main (args: Array<String>) {
    val musikverwaltung = Musikverwaltung()
    val playlist = Playlist()
    var auswahl = ""
    var output: Song
    val Songadd:Array<Song>

    //Anlegen der Musikbibliothek

    musikverwaltung.songliste.add(Song("Hammer to Fall", "Queen", 202, 100))
    musikverwaltung.songliste.add(Song("Don't stop me now", "Queen", 197, 60))
    musikverwaltung.songliste.add(Song("Fat Bottomed Girls", "Queen", 254,60))
    musikverwaltung.songliste.add(Song("Crazy Little Thing Called Love", "Queen", 150, 60))
    musikverwaltung.songliste.add(Song("Bastian's Happy Flight", "Klaus Doldinger", 189, 80))
    musikverwaltung.songliste.add(Song("Shallow", "Lady Gaga", 225, 30))
    musikverwaltung.songliste.add(Song("November Rain", "Guns N' Roses", 549, 60))
    musikverwaltung.songliste.add(Song("Take on Me", "A-ha", 252, 60))

    //Benutzerwertungen prüfen

    for (p in musikverwaltung.songliste) p.bewertungaendern()


    //Hauptmenue

    while (auswahl != "beenden") {
        println("\n \n")
        println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
        println("x Was wollen sie machen?              x")
        println("x 1 für MusikBibliothek ausgeben      x")
        println("x 2 für Titel/Künstler suche          x")
        println("x 3 für besten Song ausgeben          x")
        println("x 4 für Random Playlist abspielen     x")
        println("x 5 für eigene Playlist abspielen     x")
        println("x 6 für beide Playlists abspielen     x")
        println("x 'beenden' zum Beenden des Programms x")
        println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
        auswahl = readLine().toString()
        when (auswahl) {

            // Ausgabe der Bibliothek
            "1" -> for (p in musikverwaltung.songliste) println("${p.interpret} - ${p.titel}")

            //Suche nacht Künstlern und Titeln
            "2" -> {
                var auswahl = ""
                while (auswahl != "stop") {
                    println("was/wen suchen sie?")
                    println("'stop' für Hauptmenue")
                    auswahl = readLine().toString()
                    musikverwaltung.songsuche(auswahl).abspielen()
                }
            }

            //Den besten Song ausgeben
            "3" -> {
                output = musikverwaltung.bestersong()
                println("${output.interpret} mit ${output.titel} hat die beste Bewertung mit ${output.bewertung} Punkten")
            }

            //Eine Random Playlist erstellen und abspielen
            "4" -> for (p in musikverwaltung.rndplaylist()) p.abspielen()

            //Eigene Playlist erstellen
            "5" -> {
                for (p in 1..3) {
                    println("Geben sie den $p Song ein:")
                    auswahl = readLine().toString()
                    playlist.songliste += musikverwaltung.songsuche(auswahl)
                }
                playlist.playlistspielen()
            }

            //Random Playlist und eigene abspielen
            "6" -> {
                for (p in musikverwaltung.rndplaylist()) p.abspielen()
                playlist.playlistspielen()
            }
        }
    }
}
