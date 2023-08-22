package io.github.lieonlion.mcv.client;

import io.github.lieonlion.mcv.MoreChestVariants;
import io.github.lieonlion.mcv.block.MoreChestBlock;
import io.github.lieonlion.mcv.block.MoreChestBlockEntity;
import io.github.lieonlion.mcv.block.MoreChestEnum;
import it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.*;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.entity.LidOpenable;
import net.minecraft.block.enums.ChestType;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;
import net.minecraft.client.render.block.entity.LightmapCoordinatesRetriever;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.World;

import java.util.Locale;


@Environment(EnvType.CLIENT)
public class MoreChestRenderer extends ChestBlockEntityRenderer<MoreChestBlockEntity> {
    public static SpriteIdentifier[] single = new SpriteIdentifier[MoreChestEnum.VALUES.length];
    public static SpriteIdentifier[] left = new SpriteIdentifier[MoreChestEnum.VALUES.length];
    public static SpriteIdentifier[] right = new SpriteIdentifier[MoreChestEnum.VALUES.length];
    private final ModelPart singleChestLid;
    private final ModelPart singleChestBase;
    private final ModelPart singleChestLatch;
    private final ModelPart doubleChestLeftLid;
    private final ModelPart doubleChestLeftBase;
    private final ModelPart doubleChestLeftLatch;
    private final ModelPart doubleChestRightLid;
    private final ModelPart doubleChestRightBase;
    private final ModelPart doubleChestRightLatch;

    static {
        for (MoreChestEnum type : MoreChestEnum.VALUES) {
            single[type.ordinal()] = getChestMaterial(type.name().toLowerCase(Locale.ENGLISH));
            left[type.ordinal()] = getChestMaterial(type.name().toLowerCase(Locale.ENGLISH) + "_left");
            right[type.ordinal()] = getChestMaterial(type.name().toLowerCase(Locale.ENGLISH) + "_right");
        }
    }

    public MoreChestRenderer(BlockEntityRendererFactory.Context context) {
        super(context);
        ModelPart modelPart = context.getLayerModelPart(EntityModelLayers.CHEST);
        this.singleChestBase = modelPart.getChild("bottom");
        this.singleChestLid = modelPart.getChild("lid");
        this.singleChestLatch = modelPart.getChild("lock");
        ModelPart modelPart2 = context.getLayerModelPart(EntityModelLayers.DOUBLE_CHEST_LEFT);
        this.doubleChestLeftBase = modelPart2.getChild("bottom");
        this.doubleChestLeftLid = modelPart2.getChild("lid");
        this.doubleChestLeftLatch = modelPart2.getChild("lock");
        ModelPart modelPart3 = context.getLayerModelPart(EntityModelLayers.DOUBLE_CHEST_RIGHT);
        this.doubleChestRightBase = modelPart3.getChild("bottom");
        this.doubleChestRightLid = modelPart3.getChild("lid");
        this.doubleChestRightLatch = modelPart3.getChild("lock");
    }

    private static SpriteIdentifier getChestMaterial(String path) {
        return new SpriteIdentifier(TexturedRenderLayers.CHEST_ATLAS_TEXTURE, new Identifier(MoreChestVariants.MODID, "entity/chest/" + path)) {
        };
    }

    private static SpriteIdentifier getChestMaterial(MoreChestBlockEntity tile, ChestType type) {
        switch(type) {
            case LEFT:
                return left[tile.getChestType().ordinal()];
            case RIGHT:
                return right[tile.getChestType().ordinal()];
            case SINGLE:
            default:
                return single[tile.getChestType().ordinal()];
        }
    }

    public void render(MoreChestBlockEntity blockEntity, float f, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, int j) {
        World world = blockEntity.getWorld();
        boolean bl = world != null;
        BlockState blockState = bl ? blockEntity.getCachedState() : (BlockState)Blocks.CHEST.getDefaultState().with(ChestBlock.FACING, Direction.SOUTH);
        ChestType chestType = blockState.contains(ChestBlock.CHEST_TYPE) ? (ChestType)blockState.get(ChestBlock.CHEST_TYPE) : ChestType.SINGLE;
        Block block = blockState.getBlock();
        if (block instanceof MoreChestBlock abstractChestBlock) {
            boolean bl2 = chestType != ChestType.SINGLE;
            matrixStack.push();
            float g = ((Direction)blockState.get(ChestBlock.FACING)).asRotation();
            matrixStack.translate(0.5F, 0.5F, 0.5F);
            matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-g));
            matrixStack.translate(-0.5F, -0.5F, -0.5F);
            DoubleBlockProperties.PropertySource<? extends ChestBlockEntity> propertySource;
            if (bl) {
                propertySource = abstractChestBlock.getBlockEntitySource(blockState, world, blockEntity.getPos(), true);
            } else {
                propertySource = DoubleBlockProperties.PropertyRetriever::getFallback;
            }

            float h = ((Float2FloatFunction)propertySource.apply(ChestBlock.getAnimationProgressRetriever((LidOpenable)blockEntity))).get(f);
            h = 1.0F - h;
            h = 1.0F - h * h * h;
            int k = ((Int2IntFunction)propertySource.apply(new LightmapCoordinatesRetriever())).applyAsInt(i);
            SpriteIdentifier spriteIdentifier = getChestMaterial(blockEntity, chestType);
            VertexConsumer vertexConsumer = spriteIdentifier.getVertexConsumer(vertexConsumerProvider, RenderLayer::getEntityCutout);
            if (bl2) {
                if (chestType == ChestType.LEFT) {
                    this.render(matrixStack, vertexConsumer, this.doubleChestLeftLid, this.doubleChestLeftLatch, this.doubleChestLeftBase, h, k, j);
                } else {
                    this.render(matrixStack, vertexConsumer, this.doubleChestRightLid, this.doubleChestRightLatch, this.doubleChestRightBase, h, k, j);
                }
            } else {
                this.render(matrixStack, vertexConsumer, this.singleChestLid, this.singleChestLatch, this.singleChestBase, h, k, j);
            }

            matrixStack.pop();
        }
    }

    private void render(MatrixStack matrixStack, VertexConsumer vertexConsumer, ModelPart modelPart, ModelPart modelPart2, ModelPart modelPart3, float f, int i, int j) {
        modelPart.pitch = -(f * 1.5707964F);
        modelPart2.pitch = modelPart.pitch;
        modelPart.render(matrixStack, vertexConsumer, i, j);
        modelPart2.render(matrixStack, vertexConsumer, i, j);
        modelPart3.render(matrixStack, vertexConsumer, i, j);
    }
}