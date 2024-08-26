package habilidades

data class AtributosPersonagens (
  var forca: Int,
  var destreza: Int,
  var constituicao: Int,
  var inteligencia: Int,
  var sabedoria: Int,
  var carisma: Int
        ) {
  var hitPoints: Int
  get() = 10 + (constitution / 2 - 5)
}