package com.sindercube.aileron.mixin;

import com.sindercube.aileron.registry.AileronAttributes;
import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CampfireBlock.class)
public class CampfireBlockMixin {

	@Inject(method = "onEntityCollision", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;damage(Lnet/minecraft/entity/damage/DamageSource;F)Z"), cancellable = true)
	private void protectUsingSmokestack(BlockState state, World world, BlockPos pos, Entity entity, CallbackInfo ci) {
		if (!(entity instanceof PlayerEntity player)) return;
		if (player.getCampfireDamageIFrames() > 0) return;
		if (!player.isSneaking()) return;
		if (player.getMaxSmokestacks() == 0) return;
		ci.cancel();
	}

}