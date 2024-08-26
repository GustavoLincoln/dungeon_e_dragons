import habilidades.AtributosPersonagens
import raca.Raca

class Personagem(val nome: String, val raca: Raca, val atributos: AtributosPersonagens, private val strategyDistribuicao: StrategyDistribuicaoPontos ) {
init {
  strategyDistribuicao.pontosDistribuicao(27, atributos)
  applyBonusRaciais()
}

  private fun StrategyDistribuicaoPontos() {
    raca.bonus.forEach {(atributos, b) ->
      when (atributos) {
        "forca" -> atributos.forca += b
        "destreza" -> atributos.destreza += b
        "constituicao" -> atributos.constituicao += b
        "sabedoria" -> atributos.sabedoria += b
        "carisma" -> atributos.carisma += b
      }
    }
  }
}
