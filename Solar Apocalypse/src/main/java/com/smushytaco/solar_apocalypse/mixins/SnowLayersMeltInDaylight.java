package com.smushytaco.solar_apocalypse.mixins;
import net.minecraft.block.BlockState;
import net.minecraft.block.SnowBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import java.util.Random;
@Mixin(SnowBlock.class)
public abstract class SnowLayersMeltInDaylight {
    @Inject(method = "randomTick", at = @At("HEAD"))
    private void hookRandomTick(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
        BlockPos blockPos = pos.offset(Direction.UP);
        double worldAge = world.getTimeOfDay() / 24000.0D;
        if (worldAge < 5.0D || world.isNight() || world.isRaining() || !world.isSkyVisible(blockPos)) return;
        world.removeBlock(pos, false);
    }
}