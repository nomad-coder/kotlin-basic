package com.github.nomadcoder.kotlinbasic

/**
 * 이펙티브 자바에선 상속을 목적으로 만든 클래스가 아니라면 상속을 금지하도록 가이드하고 있다.
 * java 와 달리 Kotlin 의 class 는 기본적으로 final 이다.
 * 상속을 목적으로 했을 때에만 open 이라는 keyword 를 넣어 class, field 를 상속 가능하도록 열어둔다.
 */
open class Game {

	var starCount = 0

	open val label: String = "Unknown"

	fun vote(starCount : Int) {
		this.starCount += starCount
	}

	open fun isOnline() = false

}

class RolePlayingGame(override val label: String) : Game() {

	override fun isOnline() = true

}

class SimulationGame(override val label: String) : Game()

fun main() {

	val rpg = RolePlayingGame("엘든링")
	rpg.vote(10);
	println("${rpg.label} / ${rpg.starCount}")

	val simulationGame = SimulationGame("롤러코스터타이쿤")
	simulationGame.vote(5)
	println("${simulationGame.label} / ${simulationGame.starCount}")

}