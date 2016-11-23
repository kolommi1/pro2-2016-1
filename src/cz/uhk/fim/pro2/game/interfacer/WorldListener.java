package cz.uhk.fim.pro2.game.interfacer;

import cz.uhk.fim.pro2.game.model.Heart;
import cz.uhk.fim.pro2.game.model.Tube;

public interface WorldListener {
	void crashTube(Tube tube);

	void outOf();

	void catchHeart(Heart heart);
}
