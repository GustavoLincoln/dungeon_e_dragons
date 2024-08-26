package raca

enum class Raca(val bonus: Map<String, Int>) {
  HUMANO(mapOf("forca" to 1, "destreza" to 1, "constituicao" to 1, "inteligencia" to 1, "sabedoria" to 1, "carisma" to 1)),
  ELFO(mapOf("destreza" to 2, "inteligencia" to 1)),
  ANAO(mapOf("constituicao" to 2, "sabedoria" to 1)),
  MEIO_ORC(mapOf("forca" to 2, "constituicao" to 1))
}
