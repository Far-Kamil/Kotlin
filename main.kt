import kotlin.random.Random

fun bubbleSort(arr: IntArray) {
    val n = arr.size
    for (i in 0 until n - 1) {
        // Флаг для оптимизации: если за проход не было обменов — массив отсортирован
        var swapped = false
        for (j in 0 until n - i - 1) {
            if (arr[j] > arr[j + 1]) {
                // Обмен элементов
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
                swapped = true
            }
        }
        // Если не было обменов — выходим
        if (!swapped) break
    }
}
fun main() {
    val size = 10  // размер массива (можно изменить)
    val maxValue = 100  // максимальное значение элемента (включительно)
    val array = IntArray(size) { Random.nextInt(0, maxValue + 1) }
    println("Origin array: ${array.contentToString()}")

    bubbleSort(array)

    println("Sorted array: ${array.contentToString()}")
}