import habilidades.AtributosPersonagens
import raca.Raca

fun main(args: Array<String>) {
  val atributos = AtributosPersonagens(8, 8, 8, 8, 8, 8)
  val personagem = Personagem("Aragorn", Raca.HUMANO, atributos, DistribuicaoPontosCustom())

  println("Personagem criado com sucesso!")
  println(personagem)

  distribuirPontosExtras(personagem)
  println("Distribuição de pontos extras concluída!")
  println(personagem)
}

fun distribuirPontosExtras(personagem: Personagem) {
  var pontosRestantes = personagem.raca.bonus.values.sum()

  personagem.raca.bonus.forEach { (atributo, bonusMaximo) ->
    var pontosAdicionados = 0
    println("Você tem $bonusMaximo pontos extras para distribuir para o atributo $atributo. Pontos restantes: $pontosRestantes")
    while (pontosAdicionados < bonusMaximo) {
      println("Quantos pontos você deseja adicionar ao atributo $atributo? (Atual: ${atributoAtual(personagem, atributo)})")
      val pontosExtra = readLine()?.toIntOrNull()

      if (pontosExtra != null && pontosExtra >= 0 && pontosExtra + pontosAdicionados <= bonusMaximo) {
        val custoParaAdicionar = calcularCustoAdicional(atributo, pontosExtra, personagem)
        if (custoParaAdicionar <= pontosRestantes) {
          // Atualiza o valor do atributo com pontos extras
          when (atributo) {
            "forca" -> personagem.atributos.forca += pontosExtra
            "destreza" -> personagem.atributos.destreza += pontosExtra
            "constituicao" -> personagem.atributos.constituicao += pontosExtra
            "inteligencia" -> personagem.atributos.inteligencia += pontosExtra
            "sabedoria" -> personagem.atributos.sabedoria += pontosExtra
            "carisma" -> personagem.atributos.carisma += pontosExtra
            else -> println("Atributo desconhecido.")
          }
          pontosRestantes -= custoParaAdicionar
          pontosAdicionados += pontosExtra
        } else {
          println("Você não tem pontos suficientes. Pontos restantes: $pontosRestantes.")
        }
      } else {
        println("Entrada inválida ou você tentou adicionar mais pontos do que o bônus máximo permitido para o atributo $atributo.")
      }
    }
  }
}

fun atributoAtual(personagem: Personagem, atributo: String): Int {
  return when (atributo) {
    "forca" -> personagem.atributos.forca
    "destreza" -> personagem.atributos.destreza
    "constituicao" -> personagem.atributos.constituicao
    "inteligencia" -> personagem.atributos.inteligencia
    "sabedoria" -> personagem.atributos.sabedoria
    "carisma" -> personagem.atributos.carisma
    else -> 0
  }
}

fun calcularCustoAdicional(atributo: String, pontosExtras: Int, personagem: Personagem): Int {
  val valorAtual = atributoAtual(personagem, atributo)
  var custo = 0
  for (i in 1..pontosExtras) {
    val novoValor = valorAtual + i
    if (novoValor in 8..15) {
      custo += custoPontos[novoValor]!! - custoPontos[valorAtual + i - 1]!!
    }
  }
  return custo
}

val custoPontos = mapOf(
  8 to 0,
  9 to 1,
  10 to 2,
  11 to 3,
  12 to 4,
  13 to 5,
  14 to 7,
  15 to 9
)
