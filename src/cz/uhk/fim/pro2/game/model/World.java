package cz.uhk.fim.pro2.game.model;

import java.util.ArrayList;
import java.util.List;

public class World {

	public static final int SPEED = 100;
	
	//atributy
	private Bird bird;
	private List<Tube> tubes;
	private List<Heart> hearts;

	//konstruktor
	public World(Bird bird) {
		this.bird = bird;
		tubes = new ArrayList<>();
		hearts = new ArrayList<>();
	}
	
	public void update(float deltaTime){
		bird.update(deltaTime);
	}
	
	//metody
	public void addHeart(Heart heart){
		hearts.add(heart);
	}
	
	public void addTubet(Tube tube){
		tubes.add(tube);
	}
	
	public Bird getBird() {
		return bird;
	}
	
	@Override
	public String toString(){
		return (bird.getName()+ " Bird na pozici "+ bird.getPositionX() 
				+ ", " + bird.getPositionY()+" Trubky: " + tubes.size() +
				", Hearts: " + hearts.size());	
	}

	public List<Heart> getHearts() {
		// TODO Auto-generated method stub
		return hearts;
	}

	public List<Tube> getTubes() {
		// TODO Auto-generated method stub
		return tubes;
	}
}
