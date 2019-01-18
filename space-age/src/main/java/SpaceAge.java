
import java.text.DecimalFormat;

class SpaceAge {
	
	private long  seconds;

    SpaceAge(long seconds) {
        this.seconds = seconds;
    }

    double getSeconds() {
        return seconds;
    }

    double onEarth() {
		
		
		return seconds / (double)31557600;
        
    }

    double onMercury() {
		
        
		return seconds /(double)(0.2408467 *31557600);
    }

    double onVenus() {
        
		return seconds /(double)(0.61519726 *31557600);
    }

    double onMars() {
     
	   return seconds /(double)(1.8808158 *31557600);
    }

    double onJupiter() {
        
	   return seconds /(double)(11.862615 *31557600);
    }

    double onSaturn() {
       
	   return seconds /(double)(29.447498 *31557600);
    }

    double onUranus() {
        
	   return seconds /(double)(84.016846 *31557600);
    }

    double onNeptune() {
       
	   return seconds /(double)(164.79132 *31557600);
    }

}
