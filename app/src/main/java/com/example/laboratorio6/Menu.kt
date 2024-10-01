package com.example.laboratorio6

sealed class Menu(val screen: String) {
    data object P1: Menu("P1")
    data object P3: Menu("P3")
    data object P4: Menu("P4")
}