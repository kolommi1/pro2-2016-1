package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import cz.uhk.fim.pro2.game.interfacer.WorldListener;

public class World {

	public static final int SPEED = 100;
	
	private static final int SPACE_BETWEEN_TUBES = 300;
	private static final int SPACE_BETWEEN_HEARTS = 450;
	
	//atributy
	private Bird bird;
	private WorldListener worldListener;
	private List<Tube> tubes;
	private List<Heart> hearts;
	private boolean generated = false;

	//konstruktor
	public World(Bird bird, WorldListener worldListener) {
		this.bird = bird;
		this.worldListener = worldListener;
		tubes = new ArrayList<>();
		hearts = new ArrayList<>();
	}
	
	public void update(float deltaTime){
		bird.update(deltaTime);
		if(generated){regenerate();}
	
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
				if(!tube.isCounted() && bird.getPositionX()>tube.getMaxX()){
					bird.addPoint();					
					tube.setCounted(true);					
				}
			}
		}	
	}
	
	//metody
	public void addHeart(Heart heart){
		hearts.add(heart);
	}
	
	public void addTube(Tube tube){
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
	
	public void generateRandom(){
		generated= true;
		for(int i = 0; i<3; i++){
			addTube(new Tube(SPACE_BETWEEN_TUBES + i * SPACE_BETWEEN_TUBES, Tube.getRandomHeight(), Color.green));
		}
		
		addHeart(new Heart(SPACE_BETWEEN_HEARTS, Heart.getRandomY()));
	}
	
	private void regenerate(){
		for(Tube tube : tubes){
			if(tube.getPositionX()<-100){
				tube.setPositionX(tube.getPositionX() + tubes.size()*SPACE_BETWEEN_TUBES);
				tube.setHeight(Tube.getRandomHeight());
				tube.setCounted(false);
			}
		}
		for(Heart heart : hearts){
			if(heart.getPositionX()<-100){
				heart.setPositionX(heart.getPositionX() + (hearts.size() + 1)*SPACE_BETWEEN_HEARTS);
				heart.setPositionY(Heart.getRandomY());
			}
		}
	}
}
