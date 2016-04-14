import java.util.*;

public class q5
{
    public enum Color {BLANK, RED, GREEN, BLUE, YELLOW}

    public static void main(String[] args)
    {
    }

    public static Result check(Color[] slots, Color[] guesses)
    {
	if (slots == null || guesses == null) return null;

	int hit = 0;
	int pseudoHit = 0;
	
	Color curr;
	Color guess;
	Map<Color, Boolean> pastSlot = new HashMap<>();
	Map<Color, Boolean> pastGuess = new HashMap<>();

	for (int i = 0; i < slots.size(); ++i)
	{
	    curr = slots[i];
	    guess = guesses[i];
	    if (curr == guess)
	    {
		hit++;
		continue;
	    }

	    if (pastSlot.hasKey(guess) && pastSlow.get(guess))
	    {
		pseudoHit++;
		pastSlow.put(guess, false);
	    }
	    else
	    {
		pastGuess.put(guess, true);
	    }

	    if (pastGuess.hasKey(curr) && pastGuess.get(curr))
	    {
		pseudoHit++;
		pastGuess.put(curr, false);
	    }
	    else
	    {
		pastSlot.put(curr, true);
	    }
	}

	return new Result(pseduoHit, hit);
    }
}

class Result
{
    int pseudoHit;
    int hit;

    public Result(int pseudoHit, int hit)
    {
	this.pseudoHit = pseudoHit;
	this.hit = hit;
    }
}
