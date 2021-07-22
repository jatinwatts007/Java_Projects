import java.util.*;

public class Game {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		board b1 = new board (6);
		b1.snakes_on_the_board();
		b1.ladder_on_the_board();
		System.out.println("You are ready to go");
		int [] count = b1.getPlayer();
		Map<Integer,Integer> snakes = b1.getSnakes();
		Map<Integer,Integer> ladders = b1.getLadders();
		int i=0;
		while(true) {
			if(i==6) i=0;
			int dice = (int)(Math.random()* (6 - 1) + 1);
			System.out.println("Player "+(i+1)+" has rolled the dice : "+ dice);
			if(dice!=1 && count[i]==-1) {
				i++;
				continue;
			}
			else if(dice==1 && count[i]==-1) {
				if(ladders.containsKey(1)) {
					count[i] = ladders.get(1);
					if(count[i]==100) {
						won(i);
						break;
					}
				}
					count[i]=1;
					
					i++;
					continue;
				}
			else if(!ladders.containsKey(count[i]+dice) && !snakes.containsKey(count[i]+dice)) {
				if(count[i]+dice>100)
				{
					i++;
					continue;
				}
				count[i] = count[i]+dice;
				if(count[i]==100) {
					won(i);
					break;
				}
				i++;
				continue;
				
			}else if(ladders.containsKey(count[i]+dice)) {
				count[i] = ladders.get(count[i]+dice);
				if(count[i]==100) {
					won(i);
					break;
				}
				i++;
				continue;
				
			}else if (snakes.containsKey(count[i]+dice)) {
				count[i] = snakes.get(count[i]+dice);
				i++;
				continue;
			}
	}

}
	public static void won(int winner) {
		winner++;
		System.out.println("Player " + winner + " has won the game\nGame completed\nTHANK YOU");
	}
}
