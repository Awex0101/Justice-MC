package awex.heroes.client.gui;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fiskfille.core.helper.TextureHelper;
import fiskfille.heroes.helper.SHRenderHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import java.awt.*;

@SideOnly(Side.CLIENT)
public class GuiPowerHud extends Gui
{/**
    private Minecraft mc;
    private static final ResourceLocation hudTexture = new ResourceLocation("mchardcore", "textures/gui/hud.png");
    private static final ResourceLocation armourBarTexture = new ResourceLocation("mchardcore", "textures/gui/armour_bar.png");

    public GuiPowerHud(Minecraft mc)
    {
        super();
        this.mc = mc;
    }

    @SubscribeEvent
    public void onRenderHealthBar(RenderGameOverlayEvent event)
    {

        if(event.type.equals(RenderGameOverlayEvent.ElementType.EXPERIENCE) && event.isCancelable())
        {
            event.setCanceled(true);

            this.mc.getTextureManager().bindTexture(hudTexture);

            //GL11.glPushAttrib(GL11.GL_ENABLE_BIT);
            //GL11.glEnable(GL11.GL_ALPHA_TEST);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glDisable(GL11.GL_LIGHTING);

            this.drawTexturedModalRect(5, 5, 0, 0, 118, 38);

            EntityPlayer player = this.mc.thePlayer;

            ExtendedPlayerProperties properties = ExtendedPlayerProperties.fetchProperties(player);

            if(properties == null)
            {
                return;
            }

            int totalLevelXp = properties.calculateNewExpToLevel(properties.getLevel());
            int currentXp = properties.getCurrentXp();

            int xpRemaining = totalLevelXp-currentXp;

            //SET BAR WIDTHS
            float health = player.getHealth();
            float maxHealth = player.getMaxHealth();
            int stamina = player.getFoodStats().getFoodLevel();
            int armour = player.getTotalArmorValue();

            int hungerBarWidth = (int)(((float)stamina/20)*79);
            int armourBarWidth = (int)(((float)armour/20)*79);
            int healthBarWidth = (int)(((float)health/maxHealth)*79);
            int xpBarWidth = (int)(((float)currentXp/totalLevelXp)*79);

            //DRAW BARS
            //HEALTH
            this.drawTexturedModalRect(41, 13, 0, 52, healthBarWidth, 7);

            Entity mount = player.ridingEntity;

            //HUNGER
            if(mount == null)
            {
                this.drawTexturedModalRect(41, 21, 0, 45, hungerBarWidth, 7);
            }

            //EXP
            this.drawTexturedModalRect(41, 29, 0, 38, xpBarWidth, 7);

            //SET SCREEN POS FOR ARMOUR AND AIR
            int xPos = event.resolution.getScaledWidth() / 2 - 91;
            int yPos = event.resolution.getScaledHeight() - 40;

            //ARMOUR BAR
            if(armour > 0)
            {
                this.mc.getTextureManager().bindTexture(armourBarTexture);

                this.drawTexturedModalRect(xPos, yPos-10, 0, 0, 81, 9);
                this.drawTexturedModalRect(xPos+1, yPos-9, 0, 9, armourBarWidth, 7);
            }


            this.drawCenteredString(this.mc.fontRenderer, "\u00A7a"+properties.getLevel(), 23, 20, 0xffffffff);

        }
    }*/
}