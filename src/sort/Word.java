package sort;

public class Word implements Comparable<Word>{

// Declare variable	
	private String word;
	private int score;
	
//Constructor for Word class
	public Word(String w, int s)
	{
		this.word = w;
		this.score = s;
	}
	
//getter for score
	public int getScore()
	{
		return score;
	}
	
//setter for score
	public void setScore(int s)
	{
		this.score = s;
	}
	
//getter for the string
	public String getWord()
	{
		return word;
	}
	
//setter for the string
	public void setWord(String w)
	{
		this.word = w;
	}
	
//implementation of the compareTo method, which compares scores to sort 
	@Override
	public int compareTo(Word w)
	{
		if (this.score > w.score) return +1;
		if (this.score < w.score) return -1;
		return 0;
	}
	
//String representation of the word object
	public String toString()
	{
		return word + "," + score;
	}

}
