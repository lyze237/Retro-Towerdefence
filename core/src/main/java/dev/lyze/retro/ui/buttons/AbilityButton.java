package dev.lyze.retro.ui.buttons;

import dev.lyze.retro.Stats;
import dev.lyze.retro.game.Game;

public class AbilityButton extends Button {
    private final int price;

    public AbilityButton(Game game, String up, String down) {
        super(game, up, down);

        this.price = Stats.ABILITY_PRICE;
    }

    @Override
    protected void setState(boolean state) {
        if (!state)
            return;

        if (game.getPlayer().subtractCoins(price)) {
            game.getAss().playRandomSound(game.getAss().getAbilityButtonSounds());
            game.getEnemy().getRoundUnits().forEach(u -> u.damage(1));
        }
    }
}
