class Song (val titel:String, val interpret:String, val spieldauer:Int, var bewertung:Int) {

    fun abspielen() {
        var runden = spieldauer / 60 +1
        while (runden > 0) {
            println("Spiele: $titel von $interpret (Bewertung: $bewertung Punkte)")
            runden --
        }
        return
    }

    fun bewertungaendern(){

        if(bewertung <= 0 && bewertung < 100){
            bewertung=1
        }
        return
    }

    fun suchbegriffpruefen(search:String) :Boolean{
        return titel.contains(search) || interpret.contains(search)
    }
}
