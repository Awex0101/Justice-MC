package awex.heroes.client.render.hero;


import awex.heroes.common.hero.HeroRegistry;
import fiskfille.heroes.client.render.hero.HeroRenderer;
import fiskfille.heroes.client.render.hero.HeroRendererBase;
public class RendererManager {
    public RendererManager() {
    }

    public static void register() {
        HeroRenderer.register(HeroRegistry.HAL_JORDAN, new HeroRendererBase());
    }
}
