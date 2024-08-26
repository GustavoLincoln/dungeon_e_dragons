import habilidades.AtributosPersonagens

interface StrategyDistribuicaoPontos {
  fun pontosDistribuicao(pontos: Int, atributos: AtributosPersonagens)
}

class DistribuicaoPontosCustom : StrategyDistribuicaoPontos {

  private val custoPontos = mapOf(
    8 to 0,
    9 to 1,
    10 to 2,
    11 to 3,
    12 to 4,
    13 to 5,
    14 to 7,
    15 to 9
  )

  override fun pontosDistribuicao(pontos: Int, atributos: AtributosPersonagens) {
    var pontosRestantes = pontos

    val distribuicaoInicial = mutableMapOf(
      "forca" to 8,
      "destreza" to 8,
      "constituicao" to 8,
      "inteligencia" to 8,
      "sabedoria" to 8,
      "carisma" to 8
    )

    while (pontosRestantes > 0) {

      val atributo = "forca"
      val valorAtual = distribuicaoInicial[atributo]!!
      val novoValor = valorAtual + 1

      if (novoValor in 8..15 && custoPontos[novoValor]!! <= pontosRestantes) {
        distribuicaoInicial[atributo] = novoValor
        pontosRestantes -= (custoPontos[novoValor]!! - custoPontos[valorAtual]!!)
      } else {
        break
      }
    }

    atributos.forca = distribuicaoInicial["forca"]!!
    atributos.destreza = distribuicaoInicial["destreza"]!!
    atributos.constituicao = distribuicaoInicial["constituicao"]!!
    atributos.inteligencia = distribuicaoInicial["inteligencia"]!!
    atributos.sabedoria = distribuicaoInicial["sabedoria"]!!
    atributos.carisma = distribuicaoInicial["carisma"]!!
  }
}
