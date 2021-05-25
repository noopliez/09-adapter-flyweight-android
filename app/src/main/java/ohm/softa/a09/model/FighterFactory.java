package ohm.softa.a09.model;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

import ohm.softa.a09.R;
import ohm.softa.a09.model.empire.TieBomber;
import ohm.softa.a09.model.empire.TieFighter;
import ohm.softa.a09.model.empire.TieInterceptor;
import ohm.softa.a09.model.rebellion.AWing;
import ohm.softa.a09.model.rebellion.XWing;
import ohm.softa.a09.model.rebellion.YWing;

/**
 * @author Peter Kurfer
 */

public class FighterFactory {

    private class FighterFlyweight {
        private final Drawable image;

        FighterFlyweight(int imageId) throws URISyntaxException, IOException {
            image = new BitmapDrawable(context.getResources(), BitmapFactory.decodeResource(context.getResources(), imageId));
        }
    }

    private final Random random;
    private final Context context;
    private final NameGenerator nameGenerator;

    private final Map<Integer, FighterFlyweight> flyweights = new HashMap<>();

    public FighterFactory(Context context) {
        this.context = context;
        nameGenerator = new NameGenerator(context);
        random = new Random();
    }

    public Fighter createFighter() throws IOException, URISyntaxException {
        switch (random.nextInt(6)) {
            case 0:
                return new AWing(nameGenerator.generateName(), loadImage(R.drawable.awing));
            case 1:
                return new XWing(nameGenerator.generateName(), loadImage(R.drawable.xwing));
            case 2:
                return new YWing(nameGenerator.generateName(), loadImage(R.drawable.ywing));
            case 3:
                return new TieBomber(nameGenerator.generateName(), loadImage(R.drawable.tiebomber));
            case 4:
                return new TieFighter(nameGenerator.generateName(), loadImage(R.drawable.tiefighter));
            default:
                return new TieInterceptor(nameGenerator.generateName(), loadImage(R.drawable.tieinterceptor));
        }
    }

    private Drawable loadImage(int imageId) throws IOException, URISyntaxException {
        if (flyweights.containsKey(imageId)) {
            return Objects.requireNonNull(flyweights.get(imageId)).image;
        }

        FighterFlyweight fw = new FighterFlyweight(imageId);
        flyweights.put(imageId, fw);

        return fw.image;
    }
}
