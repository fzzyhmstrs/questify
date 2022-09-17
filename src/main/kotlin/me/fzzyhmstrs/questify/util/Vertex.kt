package me.fzzyhmstrs.questify.util

data class Vertex(val x: Int, val y: Int) {
    fun plus(other: Vertex): Vertex{
        return copy(x = this.x+other.x,y = this.y+other.y)
    }
}