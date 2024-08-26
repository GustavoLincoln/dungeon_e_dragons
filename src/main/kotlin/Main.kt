import habilidades.AtributosPersonagens
import personagem.Personagem
import raca.Raca

fun main(args: Array<String>) {
  println("Digite o nome do personagem:")
  val nomePersonagem = readLine() ?: "Personagem sem nome"

  println("Escolha a raça do personagem:")
  Raca.values().forEachIndexed { index, raca -> println("$index: ${raca}") }
  val racaSelecionada = readLine()?.toIntOrNull()?.let { Raca.values().getOrNull(it) } ?: Raca.HUMANO

  val atributos = distribuirPontosIniciais()
  val personagem = Personagem(nomePersonagem, racaSelecionada, atributos, DistribuicaoPontosCustom())

  println("Personagem criado com sucesso!")
  println(personagem)

  distribuirPontosExtras(personagem)
  println("Distribuição de pontos extras concluída!")
  println(personagem)
}

fun distribuirPontosIniciais(): AtributosPersonagens {
  var pontosRestantes = 27
  val atributos = AtributosPersonagens(8, 8, 8, 8, 8, 8)

  val atributosNomes = listOf("forca", "destreza", "constituicao", "inteligencia", "sabedoria", "carisma")

  while (pontosRestantes > 0) {
    println("Pontos restantes: $pontosRestantes")
    atributosNomes.forEach { atributo ->
      println("Quantos pontos você deseja adicionar ao atributo $atributo? (Atual: ${atributoAtual(atributos, atributo)})")
      val pontosAdicionados = readLine()?.toIntOrNull()

      if (pontosAdicionados != null && pontosAdicionados >= 0 && calcularCusto(pontosAdicionados, atributoAtual(atributos, atributo)) <= pontosRestantes) {
        val custoParaAdicionar = calcularCusto(pontosAdicionados, atributoAtual(atributos, atributo))

        when (atributo) {
          "forca" -> atributos.forca += pontosAdicionados
          "destreza" -> atributos.destreza += pontosAdicionados
          "constituicao" -> atributos.constituicao += pontosAdicionados
          "inteligencia" -> atributos.inteligencia += pontosAdicionados
          "sabedoria" -> atributos.sabedoria += pontosAdicionados
          "carisma" -> atributos.carisma += pontosAdicionados
        }
        pontosRestantes -= custoParaAdicionar
        println("Pontos restantes após adicionar: $pontosRestantes")
      } else {
        println("Entrada inválida ou você tentou adicionar mais pontos do que o permitido.")
      }

      if (pontosRestantes <= 0) return atributos
    }
  }
  return atributos
}

fun distribuirPontosExtras(personagem: Personagem) {
  var pontosRestantes = personagem.raca.bonus.values.sum()

  personagem.raca.bonus.forEach { (atributo, bonusMaximo) ->
    var pontosAdicionados = 0
    println("Você tem $bonusMaximo pontos extras para distribuir para o atributo $atributo. Pontos restantes: $pontosRestantes")
    while (pontosAdicionados < bonusMaximo) {
      println("Quantos pontos você deseja adicionar ao atributo $atributo? (Atual: ${atributoAtual(personagem.atributos, atributo)})")
      val pontosExtra = readLine()?.toIntOrNull()

      if (pontosExtra != null && pontosExtra >= 0 && pontosExtra + pontosAdicionados <= bonusMaximo) {
        when (atributo) {
          "forca" -> personagem.atributos.forca += pontosExtra
          "destreza" -> personagem.atributos.destreza += pontosExtra
          "constituicao" -> personagem.atributos.constituicao += pontosExtra
          "inteligencia" -> personagem.atributos.inteligencia += pontosExtra
          "sabedoria" -> personagem.atributos.sabedoria += pontosExtra
          "carisma" -> personagem.atributos.carisma += pontosExtra
        }
        pontosRestantes -= pontosExtra
        pontosAdicionados += pontosExtra
        println("Pontos restantes após adicionar: $pontosRestantes")
      } else {
        println("Entrada inválida ou você tentou adicionar mais pontos do que o bônus máximo permitido para o atributo $atributo.")
      }
    }
  }
}

fun atributoAtual(atributos: AtributosPersonagens, atributo: String): Int {
  return when (atributo) {
    "forca" -> atributos.forca
    "destreza" -> atributos.destreza
    "constituicao" -> atributos.constituicao
    "inteligencia" -> atributos.inteligencia
    "sabedoria" -> atributos.sabedoria
    "carisma" -> atributos.carisma
    else -> 0
  }
}

fun calcularCusto(pontosAdicionados: Int, valorAtual: Int): Int {
  var custo = 0
  for (i in 1..pontosAdicionados) {
    val novoValor = valorAtual + i
    custo += when (novoValor) {
      in 8..13 -> 1
      14 -> 2
      15 -> 2
      else -> 0
    }
  }
  return custo
}
