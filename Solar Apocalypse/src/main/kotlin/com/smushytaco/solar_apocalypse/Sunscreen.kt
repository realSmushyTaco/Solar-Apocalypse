package com.smushytaco.solar_apocalypse
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectType
object Sunscreen: StatusEffect(StatusEffectType.BENEFICIAL, 14981690) {
    override fun canApplyUpdateEffect(duration: Int, amplifier: Int) = true
}