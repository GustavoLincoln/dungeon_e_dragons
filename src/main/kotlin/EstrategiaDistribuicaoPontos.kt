import habilidades.AtributosPersonagens

interface StrategyDistribuicaoPontos {
  fun pontosDistribuicao(pontos: Int, atributos: AtributosPersonagens)
}

class DistribuicaoPontosCustom : StrategyDistribuicaoPontos {
  override fun pontosDistribuicao(pontos: Int, atributos: AtributosPersonagens) {
    TODO("Not yet implemented")
  }
}