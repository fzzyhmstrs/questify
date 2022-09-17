package me.fzzyhmstrs.questify.arrow

import me.fzzyhmstrs.questify.util.Vertex

abstract class AbstractArrow(protected val parent: ArrowParent, xy: Vertex): ArrowParent {

    private val children: MutableList<AbstractArrow> = mutableListOf()
    private val xy: Vertex
    private val uv: Vertex by lazy { initUV() }

    init{
        this.xy = xy
    }

    fun arrowChildren(): List<AbstractArrow>{
        return children
    }

    fun addChild(child:AbstractArrow){
        children.add(child)
    }

    fun xyUvMap(): Map<Vertex,Vertex>{
        val map: MutableMap<Vertex,Vertex> = mutableMapOf()
        map[xy] = uv
        children.forEach {
            map[it.xy] = it.uv
        }
        return map
    }

    abstract fun possibleChildren(): List<AbstractArrow>

    abstract fun canStackWith(arrow: AbstractArrow): Boolean

    open fun xOffset(): Int{
        return -2
    }
    open fun yOffset(): Int{
        return -2
    }

    private fun initUV(): Vertex{
        return Vertex(initTexU(),initTextV())
    }

    abstract fun initTexU(): Int

    abstract fun initTextV(): Int

    protected enum class Type{
        RIGHT_VERTEX,
        LEFT_VERTEX,
        UP_VERTEX,
        DOWN_VERTEX,
        UP_LEFT_DIAGONAL,
        UP_RIGHT_DIAGONAL,
        DOWN_LEFT_DIAGONAL,
        DOWN_RIGHT_DIAGONAL
    }
}