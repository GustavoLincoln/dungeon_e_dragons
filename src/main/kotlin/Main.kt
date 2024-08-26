import habilidades.AtributosPersonagens
import raca.Raca

fun main(args: Array<String>) {
  val atributos =  AtributosPersonagens(8,8,8,8,8,8)
  val personagem = Personagem("Aragorn", Raca.HUMANO, atributos, DistribuicaoPontosCustom())
println(personagem)
}