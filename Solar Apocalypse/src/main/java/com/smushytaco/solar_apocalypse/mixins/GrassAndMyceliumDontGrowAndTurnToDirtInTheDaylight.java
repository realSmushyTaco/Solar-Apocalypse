package com.smushytaco.solar_apocalypse.mixins;
import net.minecraft.block.BlockState;
import net.minecraft.block.SpreadableBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
@Mixin(SpreadableBlock.class)
public abstract class GrassAndMyceliumDontGrowAndTurnToDirtInTheDaylight {
    @Inject(method = "canSurvive", at = @At("RETURN"), cancellable = true)
    private static void hookCanSurvive(BlockState state, WorldView worldView, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        BlockPos blockPos = pos.offset(Direction.UP);
        World world = (World) worldView;
        double worldAge = world.getTimeOfDay() / 24000.0D;
        if (worldAge < 3.0D || world.isNight() || !world.isSkyVisible(blockPos)) return;
        cir.setReturnValue(false);
    }
}