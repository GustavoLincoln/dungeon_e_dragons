import habilidades.AtributosPersonagens
import raca.Raca

class Personagem(
  val nome: String,
  val raca: Raca,
  val atributos: AtributosPersonagens,
  private val strategyDistribuicao: StrategyDistribuicaoPontos
) {
  init {
    strategyDistribuicao.pontosDistribuicao(27, atributos)
    applyBonusRaciais()
  }

  private fun applyBonusRaciais() {
    raca.bonus.forEach { (atributo, bonus) ->
      when (atributo) {
        "forca" -> atributos.forca += bonus
        "destreza" -> atributos.destreza += bonus
        "constituicao" -> atributos.constituicao += bonus
        "inteligencia" -> atributos.inteligencia += bonus
        "sabedoria" -> atributos.sabedoria += bonus
        "carisma" -> atributos.carisma += bonus
      }
    }
  }

  override fun toString(): String {
    return """
            Nome: $nome
            Raça: ${raca.name}
            Atributos:
              Força: ${atributos.forca}
              Destreza: ${atributos.destreza}
              Constituição: ${atributos.constituicao}
              Inteligência: ${atributos.inteligencia}
              Sabedoria: ${atributos.sabedoria}
              Carisma: ${atributos.carisma}
            Pontos de Vida: ${atributos.hitPoints}
        """.trimIndent()
  }
}
