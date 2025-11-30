fun maxTipsIn5Rides(tips: IntArray): Int {
    if (tips.size < 5) return 0

    // Считаем сумму первых 5 поездок
    var currentSum = tips.take(5).sum()
    var maxSum = currentSum

    // Скользящее окно: убираем левый элемент, добавляем новый справа
    for (i in 5 until tips.size) {
        currentSum += tips[i] - tips[i - 5]
        maxSum = maxOf(maxSum, currentSum)
    }

    return maxSum
}
fun main() {
   println(maxTipsIn5Rides(intArrayOf(100, 200, 50, 300, 150, 400))) // → 1100
    println(maxTipsIn5Rides(intArrayOf(10, 20))) // → 0
    println(maxTipsIn5Rides(intArrayOf(500, 500, 500, 500, 500))) // → 2500
}
