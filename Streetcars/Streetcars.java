/**
 * @(#)Streetcars.java
 *
 * Streetcars application
 *
 * @author 
 * @version 1.00 2015/12/16
 */
 import java.io.*;
 import java.util.*;
public class Streetcars {
    public class SC
    {
    	private int passengers=0,capacity=0;
    	public SC(boolean New)
    	{
    		if(New)capacity=251;
    		else capacity=132;
    	}
    	int capacity()
    	{
    		return capacity;
    	}
    	int passengers()
    	{
    		return passengers;
    	}
    	void leave(int percentage)
    	{
    		passengers-=(int)(Math.floor(((double)passengers/100.0)*(double)percentage));
    	}
    	int enter(int people)
    	{
    		if(people>capacity-passengers)
    		{
    			int temp=people-(capacity-passengers);
    			passengers=capacity;
    			return temp;
    		}
    		else
    		{
    			passengers+=people;
    			return 0;
    		}
    	}
    }
    public static void main(String[] args)throws Exception {
    	new Streetcars();
    }
    Streetcars()throws Exception
    {
    	main();
    }
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    int[][]stop;
    void main()throws Exception
    {
    	int stops=Integer.parseInt(br.readLine());
    	stop=new int[2][stops];
    	for(int c=0;c<stops;c++)
    	{
    		//System.out.println("");
    		String temp=br.readLine();
    		//System.out.println("Temp: "+temp);
    		StringTokenizer st=new StringTokenizer(temp);
    		stop[0][c]=Integer.parseInt(st.nextToken());
    		stop[1][c]=Integer.parseInt(st.nextToken());
    	}
    	ArrayList<SC>nCars=new ArrayList<SC>();
    	ArrayList<SC>oCars=new ArrayList<SC>();
    	nCars.add(new SC(true));
    	oCars.add(new SC(false));
    	System.out.println(""+(calc(oCars,0,false)-calc(nCars,0,true)));
    }
    int calc(ArrayList<SC>cars,int pos,boolean New)throws Exception
    {
    	//System.out.println(""+New+" "+pos);
    	if(pos>=stop[0].length)return cars.size();
    	int taken=stop[0][pos];
    	//System.out.println("Taken: "+taken);
    	//System.out.println("Size: "+cars.size());
    	for(int c=0;c<cars.size()&&taken>=0;c++)
    	{
    		//System.out.println("C: "+c+" "+cars.size()+" "+(c<cars.size()));
    		//System.out.println("Pos: "+pos+" "+cars.get(c).passengers());
    		cars.get(c).leave(stop[1][pos]);
    		//System.out.println("Passengers: "+cars.get(c).passengers());
    		taken=cars.get(c).enter(taken);
    		//System.out.println("Taken: "+taken+" "+cars.get(c).passengers());
    	}
    	//System.out.println("Taken: "+taken);
    	while(taken>0)
		{
			cars.add(new SC(New));
    		taken=cars.get(cars.size()-1).enter(taken);
    		//System.out.println("Size: "+cars.size());
		}
    	return calc(cars,pos+1,New);
    }
}