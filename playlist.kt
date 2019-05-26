class Playlist(){
    val songliste= arrayListOf<Song>()
    fun gesamtspieldauer():Double{
        var gesamt=0.0
        for(p in songliste){
            gesamt+= p.spieldauer
        }
        return gesamt
    }

    fun playlistspielen(){
        for (p in songliste) p.abspielen()
        return
    }
}
