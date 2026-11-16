fun main() {
    val rockPlanets = arrayOf("Mercury", "Venus", "Earth", "Mars")
    val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")
    val solarSystem = rockPlanets + gasPlanets
    println(solarSystem.joinToString())

    val mutableSolarSystem = solarSystem.toMutableList()
    mutableSolarSystem.add("Pluto")
    mutableSolarSystem.remove("Pluto")
    println("Earth" in mutableSolarSystem)

    val uniquePlanets = mutableSolarSystem.toSet()
    println("Unique planets: ${uniquePlanets.size}")

    val moons = mutableMapOf("Jupiter" to 79, "Saturn" to 82, "Earth" to 1)
    moons["Jupiter"] = 80
    println("Earth has ${moons["Earth"]} moon")
    println("Tracked planets: ${moons.keys.sorted().joinToString()}")
}
