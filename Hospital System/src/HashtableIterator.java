
import java.util.Hashtable;

public class HashtableIterator{
	Hashtable items;//use hashtable structure
	int position = 0;
	
	//iterator
	public HashtableIterator(Hashtable items) {
		this.items = items;
	}
 
	//get the next
	public Object next() {
			Object object = items.get(position);
			position = position + 1;
			return object;
	}
	
	//check whether it is the next
	public boolean hasNext() {
		if (position >= items.size()) {
			return false;
		} else {
			return true;
		}
	}
}