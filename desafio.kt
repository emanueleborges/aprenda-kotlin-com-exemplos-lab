
enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

// Aluno
// Aluno Caracteristica
// Nome 
class Aluno(val nome: String)

// Conteudo Educacional 
// Conteudo Educacional Caracteristicas
// Nome
// Duração: por padrão 60 
data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

// Formação possui Conteudos Educacionais 
// Formação Caracteristicas
// Nome
// Nível
// ConteudosEducacionais 
data class Formacao(val nome: String, val nivel: Nivel, val conteudos: List<ConteudoEducacional>) {
    
    //Aluno 
    val inscritos = mutableListOf<Aluno>()

    //funcao matricular aluno
    fun matricular(aluno: Aluno) {
        inscritos.add(aluno)
    }
}

fun main() {

    // criar alunos
    val aluno1 = Aluno("João")
    val aluno2 = Aluno("Maria")

    // criar conteudos
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 90)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 120)
    
    //criar formação 
    val formacao = Formacao("Desenvolvimento em Kotlin", Nivel.INTERMEDIARIO, listOf(conteudo1, conteudo2))

    formacao.matricular(aluno1)
    formacao.matricular(aluno2)

    // listar dados 
    // Formacao
    // Niveis
    // Conteudos
    // Alunos 
    println("Formação: ${formacao.nome}")
    println("Nível: ${formacao.nivel}")
    println("Conteúdos:")
    for (conteudo in formacao.conteudos) {
        println("- ${conteudo.nome} (${conteudo.duracao} minutos)")
    }
    println("Inscritos:")
    for (inscrito in formacao.inscritos) {
        println("- ${inscrito.nome}")
    }
}