package habilidades

data class AtributosPersonagens(
  var forca: Int,
  var destreza: Int,
  var constituicao: Int,
  var inteligencia: Int,
  var sabedoria: Int,
  var carisma: Int
) {
  val hitPoints: Int
    get() = 10 + (constituicao / 2 - 5)
}
