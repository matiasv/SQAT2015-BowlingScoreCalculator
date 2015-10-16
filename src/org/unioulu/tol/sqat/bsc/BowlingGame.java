package org.unioulu.tol.sqat.bsc;

import java.util.ArrayList;
import java.util.List;


public class BowlingGame {
	//a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	
	public BowlingGame(){}
	
	public void addFrame(Frame frame){
		//to be implemented
		frames.add(frame);
	}
	
	public void setBonus(int firstThrow, int secondThrow) {
		//to be implemented
	}
	
	public int score(){
		int score = 0;
		
		for(int i = 0; i < frames.size(); i++) {
			score += calculateFrameScore(i);	
		}
		
		return score;
	}
	
	private int calculateFrameScore(int indx) {
		Frame currentFrame = frames.get(indx);
		
		int score = currentFrame.score();
		
		boolean isStrike = currentFrame.isStrike();
		boolean isSpare = currentFrame.isSpare();
		
		if(isStrike && indx < (frames.size()-1)) {
			score += calculateFrameScore(indx+1);
		} else if(isSpare && indx < frames.size()-1) {
			if(isFollowedBySpare(indx)) {
				Frame next = frames.get(indx+1);
				score += next.firstThrow() + next.secondThrow();
			}
			score += frames.get(indx+1).firstThrow();
		}
		
		return score;
	}
	
	private boolean isFollowedBySpare(int indx) {
		if(indx < 0 || indx >= (frames.size() -1)) {
			return false;
		}
		
		return frames.get(indx+1).isSpare();
	}
	
	public int scoreByIndex(int index) {
		if(index < 0 || index >= frames.size()) {
			return -1;
		}
		
		return calculateFrameScore(index);
	}
	
	
	public boolean isNextFrameBonus(){
		//to be implemented
		return false;
	}
}
