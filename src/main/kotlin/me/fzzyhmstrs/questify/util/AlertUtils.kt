package me.fzzyhmstrs.questify.util

import net.minecraft.client.gui.DrawableHelper
import net.minecraft.client.util.math.MatrixStack

object AlertUtils: DrawableHelper() {

    const val ALERT_W = 10
    const val ALERT_H = 12
    

    fun drawAlert(matrices: MatrixStack, alert: AbstractAlert, x: Int, y: Int, hovered: Boolean){
        val u = if (hovered) alert.hover else alert.u
        this.drawTexture(matrices,x,y,u,alert.v,ALERT_W,ALERT_H)
    }

    enum class IconAlert(override val u: Int, override val v: Int): AbstractAlert{
        GOLD_EXCLAIM(203,120),
        GREY_EXCLAIM(203,132),
        GOLD_CHECK(203,144),
        EMPTY(0,0);

        override val hover = u + 10
    }

    class NumAlert(num: Int): AbstractAlert{
        override val u = 203
        override val v = if (num < 1) 0 else if (num < 10) (12 * num - 12) else 108
        override val hover = u + 10
    }

    interface AbstractAlert{
        val u: Int
        val v: Int
        val hover: Int
    }

}
