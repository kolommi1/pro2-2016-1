package cz.uhk.fim.pro2.game.model;

import java.util.ArrayList;
import java.util.List;

import cz.uhk.fim.pro2.game.interfacer.WorldListener;

public class World {

	public static final int SPEED = 100;
	
	//atributy
	private Bird bird;
	private WorldListener worldListener;
	private List<Tube> tubes;
	private List<Heart> hearts;

	//konstruktor
	public World(Bird bird, WorldListener worldListener) {
		this.bird = bird;
		this.worldListener = worldListener;
		tubes = new ArrayList<>();
		hearts = new ArrayList<>();
	}
	
	public void update(float deltaTime){
		bird.update(deltaTime);
	
		if(bird.isOutOf()){
			worldListener.outOf();
		}		
		
		for(Heart heart : hearts){
			heart.update(deltaTime);
			
			if(bird.collideWith(heart)){
				worldListener.catchHeart(heart);
			}
		}		
		
		for(Tube tube : tubes){
			tube.update(deltaTime);	
			
			if(bird.collideWith(tube)){
				tube.setCounted(true);
				worldListener.crashTube(tube);
			}
			else {
				if(bird.getPositionX()>tube.getMinX() && bird.getPositionX()<tube.getMaxX()){
					if(!tube.isCounted()){
						bird.addPoint();					
						tube.setCounted(true);
					}
				}
			}
		}	
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
		return hearts;
	}

	public List<Tube> getTubes() {		
		return tubes;
	}
}
