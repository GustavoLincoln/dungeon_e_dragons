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

    // Exemplo de distribuição inicial
    val distribuicaoInicial = mutableMapOf(
      "forca" to 8,
      "destreza" to 8,
      "constituicao" to 8,
      "inteligencia" to 8,
      "sabedoria" to 8,
      "carisma" to 8
    )

    // A lógica para distribuir pontos deve garantir que você não exceda os 27 pontos disponíveis.
    while (pontosRestantes > 0) {
      // Aqui você pode usar qualquer lógica para distribuir os pontos, como por exemplo:
      // Incrementar um atributo aleatoriamente ou baseado em escolhas do usuário.
      // No caso mais simples, incrementaremos 'forca' até que os pontos acabem.

      val atributo = "forca" // Pode ser alterado para outros atributos dinamicamente
      val valorAtual = distribuicaoInicial[atributo]!!
      val novoValor = valorAtual + 1

      // Verifica se o novo valor é válido
      if (novoValor in 8..15 && custoPontos[novoValor]!! <= pontosRestantes) {
        // Atualiza o valor do atributo
        distribuicaoInicial[atributo] = novoValor
        pontosRestantes -= (custoPontos[novoValor]!! - custoPontos[valorAtual]!!)
      } else {
        break // Sai do loop se não for possível gastar mais pontos de forma válida
      }
    }

    // Aplicando a distribuição aos atributos do personagem
    atributos.forca = distribuicaoInicial["forca"]!!
    atributos.destreza = distribuicaoInicial["destreza"]!!
    atributos.constituicao = distribuicaoInicial["constituicao"]!!
    atributos.inteligencia = distribuicaoInicial["inteligencia"]!!
    atributos.sabedoria = distribuicaoInicial["sabedoria"]!!
    atributos.carisma = distribuicaoInicial["carisma"]!!
  }
}
