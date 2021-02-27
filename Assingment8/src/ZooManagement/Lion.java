package ZooManagement;

/**
 * Class for creating and maintaining lion structure extends Mammle
 * @author krishna.meghwal_meta
 * @since 24-02-2021*/
public class Lion extends Mammle {
	public String getSound(){
		return "roar";
	}
	public Lion(String name,String type,int weight,int height) {
		super(name,type,weight,height);
	}

}
