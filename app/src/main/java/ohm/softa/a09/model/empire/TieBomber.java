package ohm.softa.a09.model.empire;

import android.graphics.drawable.Drawable;

import ohm.softa.a09.model.Fighter;

/**
 * @author Peter Kurfer
 */

public class TieBomber extends Fighter {

    public TieBomber(String pilot, Drawable fighterImage) {
        super(pilot, fighterImage);
    }

    @Override
    public String getFighterType() {
        return "Tie bomber";
    }
}
