data class DriverApplication(
    val carNumber: String,
    val carBrand: String,
    val carYear: Int
)
fun isValidNumber(s: String): Boolean {
    if (s.length != 6) return false

    // Разрешённые буквы: кириллица + латинские аналоги (в нижнем регистре для простоты)
    val letters = "авекмнорстухabekmhopctyx" // ← все в lowercase!

    val n = s.lowercase()  // приводим весь номер к нижнему регистру

    return n[0] in letters &&
           n[1].isDigit() &&
           n[2].isDigit() &&
           n[3].isDigit() &&
           n[4] in letters &&
           n[5] in letters
}

fun processApplications(apps: Array<DriverApplication>): Int {
     val valid = apps.filter { app ->
        app.carYear >= 2000 && isValidNumber(app.carNumber)
    }

    // Группируем по марке и находим макс. количество
    return valid.groupBy { it.carBrand }
                .maxOfOrNull { it.value.size } ?: 0
}
fun main() {
    val apps = arrayOf(
        DriverApplication("а111аа", "Toyota", 2010),
        DriverApplication("a111aa", "Toyota", 2015),
        DriverApplication("X777XX", "Toyota", 2020),
        DriverApplication("b222bb", "Lada", 2005),
        DriverApplication("111aaa", "Lada", 2018), // не походит
        DriverApplication("д555ке", "Lada", 2022)  // ('д' нет в списке)
    )
    println(processApplications(apps)) // → 3
}