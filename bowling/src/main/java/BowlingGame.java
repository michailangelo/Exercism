class BowlingGame{

private int rolls[]=new int[22];
private int currentRoll=0;

	public void roll(int pins) {
		rolls[currentRoll++]=pins;
	}

	public int score() {
		if(currentRoll<6)
			throw new IllegalStateException("Score cannot be taken until the end of the game");
		for(int i=0;i<21;i++){
			if(rolls[i]<0)
				throw new IllegalStateException("Negative roll is invalid");
			if(rolls[i]>10)
				throw new IllegalStateException("Pin count exceeds pins on the lane");
		}
		int score =0;
		int frameIndex=0;
		for(int frame=0;frame<10;frame++){
			if(isStrike(frameIndex)){
				if(frame==9)
					if(currentRoll>18&&currentRoll<21)
						throw new IllegalStateException("Score cannot be taken until the end of the game");
					if(!isStrike(frameIndex+1)&&strikeBonus(frameIndex)>10)
						throw new IllegalStateException("Pin count exceeds pins on the lane");
					if(currentRoll==22)
						throw new IllegalStateException("Cannot roll after game is over");
						
			score+=10+ strikeBonus(frameIndex);
			frameIndex++;
			}
			else if(isSpare(frameIndex)){
				if(frame==9)
					if(currentRoll==20)
						throw new IllegalStateException("Score cannot be taken until the end of the game");
					if(currentRoll>21)
						throw new IllegalStateException("Cannot roll after game is over");
				score+=10+spareBonus(frameIndex);
				frameIndex+=2;
			}else{
				if(frame==9)
					if(currentRoll>20)
						throw new IllegalStateException("Cannot roll after game is over");	
				if(sumOfBallsInFrame(frameIndex)>10)
					throw new IllegalStateException("Pin count exceeds pins on the lane");
				score +=sumOfBallsInFrame(frameIndex);
				frameIndex+=2;
			}
		}
		return score;
	}

	private boolean isStrike(int frameIndex){
		return rolls[frameIndex]==10;	  
	}

	private int sumOfBallsInFrame(int frameIndex){
		return rolls[frameIndex] +rolls[frameIndex+1];

	}

	private int spareBonus(int frameIndex){
		return rolls[frameIndex+2];
	}

	private int strikeBonus(int frameIndex){
		return rolls[frameIndex+1] +rolls[frameIndex+2];
	}

	private boolean isSpare(int frameIndex){
		return rolls[frameIndex]+rolls[frameIndex+1]==10;
	}
}



