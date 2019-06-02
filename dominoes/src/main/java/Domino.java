import java.util.Objects;

class Domino {
    private int left;
    private int right;
    Domino(int left, int right) {
        this.left = left;
        this.right = right;
    }
    
    int getLeft() {
    	return this.left;
    }
    
    int getRight() {
    	return this.right;
    }
	
	Domino flipped(){
		return new Domino(right,left);
	}
    
    @Override
    public boolean equals(Object o) {
    	Domino otherDomino = (Domino) o;
    	return (this.getLeft() == otherDomino.getLeft() && this.getRight() == otherDomino.getRight()) ||
    			(this.getLeft() == otherDomino.getRight() && this.getRight() == otherDomino.getLeft());
    }
    
    @Override
    public int hashCode() {
    	return Objects.hash(left, right);
    }
    
    @Override
    public String toString() {
        return "[" + left + "/" + right + "]";
    }
}
