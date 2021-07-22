import java.util.*;

public class board{
	private int size=100;
	private snake s;
	private ladder l;
	private players player;
	
	public board(int No_of_players) {
		player = new players(No_of_players);
		s = new snake();
		l = new ladder();
	}
	public void snakes_on_the_board() {
		Map<Integer,Integer> snakes = s.getSnakes();
		Scanner sc = new Scanner(System.in);
		System.out.println("You can enter maximum 10 snakes choose wisely");
		int i=0;
		while(i<10)
		{
			System.out.print("Enter 1 to place snake on the board\nEnter 0 to exit");
			int value = sc.nextInt();
			
			if(value==1) {
				System.out.println("Enter the starting position of snake between 1 to 100");
				int start=sc.nextInt();
				while(start>99 || start<=1 || snakes.containsKey(start)) {
				System.out.println("Wrong start value");
				start = sc.nextInt();
				}
				
				System.out.println("Enter the ending position of snake, greater than 0 and less then starting position");
				int end = sc.nextInt();
				while(end>=start || end < 1 || snakes.containsValue(end)) {
				System.out.println("wrong end value\nPlease enter again: ");
				end=sc.nextInt();
				}
				snakes.put(start, end);
			}
			else break;
			i++;
			
		}
	}
	
	public void ladder_on_the_board() {
		Map<Integer,Integer> snakes = s.getSnakes();
		Map<Integer,Integer> ladders = l.getLadders();
		Scanner sc = new Scanner(System.in);
		System.out.println("You can enter maximum 10 ladders choose wisely");
		int i=0;
		while(i<10)
		{
			System.out.print("Enter 1 to place ladder on the board/nEnter 0 to exit");
			int value = sc.nextInt();
			
			if(value==1) {
				System.out.println("Enter the starting position of ladder between 1 to 100");
				int start=sc.nextInt();
				while(start>99 || start<1 || ladders.containsKey(start) || snakes.containsKey(start) || snakes.containsValue(start)) {
				System.out.println("Wrong start value");
				start = sc.nextInt();
				}
				
				System.out.println("Enter the ending position of ladder, greater then starting position and less 100");
				int end = sc.nextInt();
				while(end<=start || end > 100 || ladders.containsValue(end) || snakes.containsKey(end) || snakes.containsValue(end)) {
				System.out.println("wrong end value\nPlease enter again: ");
				end=sc.nextInt();
				}
				ladders.put(start, end);
			}
			else break;
			i++;
			
		}
	}
	public int [] getPlayer() {
		return player.getPlayers();
	}
	
	public Map<Integer,Integer> getSnakes()
	{
		return s.getSnakes();
	}
	public Map<Integer,Integer> getLadders()
	{
		return l.getLadders();
	}
	
	
	

}
