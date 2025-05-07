package com.s2310036.testmod.worldgen.biome;

import com.s2310036.testmod.block.TestBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class TestSurfaceRuleData {
    private static final SurfaceRules.RuleSource PRISMARINE = makeStateRule(Blocks.PRISMARINE);
    private static final SurfaceRules.RuleSource GUARDIAN =
            makeStateRule(TestBlocks.GUARDMARINE.get());

    public static SurfaceRules.RuleSource makeRules() {
        return SurfaceRules.sequence(
                // ガーディアンの森バイオームの地面をプリズマリンブロックにする
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(TestBiomes.GUARDIAN_FOREST),
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, PRISMARINE)),
                // ガーディアンの森バイオームの天井をガードマリンにする
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(TestBiomes.GUARDIAN_FOREST),
                        SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, GUARDIAN))
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
