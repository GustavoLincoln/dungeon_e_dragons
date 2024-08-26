package raca

enum class Raca(val nome: String, val bonus: Map<String, Int>) {
  HUMANO("Humano", mapOf("forca" to 1, "destreza" to 1, "constituicao" to 1, "inteligencia" to 1, "sabedoria" to 1, "carisma" to 1)),
  ELFO("Elfo", mapOf("destreza" to 2, "inteligencia" to 1)),
  ELFO_NEGRO_DROW("Elfo Negro 'Drow'", mapOf("carisma" to 1)),
  ANAO("Anão", mapOf("constituicao" to 2, "sabedoria" to 1)),
  MEIO_ORC("Meio-Orc", mapOf("forca" to 2, "constituicao" to 1)),
  DRACONATO("Draconato", mapOf("forca" to 2, "carisma" to 1)),
  GNOMO("Gnomo", mapOf("inteligencia" to 2)),
  GNOMO_DA_FLORESTA("Gnomo da Floresta", mapOf("destreza" to 1)),
  GNOMO_DA_PEDRA("Gnomo da Pedra", mapOf("constituicao" to 1));

  override fun toString(): String {
    return nome
  }
}
