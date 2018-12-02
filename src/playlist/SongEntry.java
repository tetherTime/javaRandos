/*
* Assignment	playlist
* Program		SongEntry
* date			Oct 17, 2018
* Author		Jorge Jimenez
*/
package playlist;

public class SongEntry
{
	private String uniqueID;
	private String songName;
	private String artistName;
	private int	   songLength;
	
	private SongEntry nextNode;
	
	public SongEntry()
	{
		this.uniqueID = "none";
		this.songName = "none";
		this.artistName = "none";
		this.songLength = 0;
		this.nextNode = null;
	}

	public SongEntry(String uniqueID, String songName, String artistName, int songLength)
	{		
		this.uniqueID = uniqueID;
		this.songName = songName;
		this.artistName = artistName;
		this.songLength = songLength;
	}


	public void insertAfter(SongEntry currNode)
	{
		SongEntry tempNext;
		
		tempNext = this.getNext(); 
		this.setNext(currNode);
		currNode.setNext(tempNext);
	}
	
	public void setNext(SongEntry nextNode)
	{
		this.nextNode = nextNode;
	}

	/**
	 * Field getter
	 * 
	 * @return the uniqueID
	 */
	public String getID()
	{
		return uniqueID;
	}

	/**
	 * Field getter
	 * 
	 * @return the songName
	 */
	public String getSongName()
	{
		return songName;
	}

	/**
	 * Field getter
	 * 
	 * @return the artistName
	 */
	public String getArtistName()
	{
		return artistName;
	}

	/**
	 * Field getter
	 * 
	 * @return the songLength
	 */
	public int getSongLength()
	{
		return songLength;
	}

	/**
	 * Field getter
	 * 
	 * @return the nextNode
	 */
	public SongEntry getNext()
	{
		return this.nextNode;
	}
	/*
		Unique ID: S123
		Song Name: Peg
		Artist Name: Steely Dan
		Song Length (in seconds): 237
	 */
	public void printPlaylistSongs()
	{
		System.out.println("Unique ID: " + this.getID());
		System.out.println("Song Name: " + this.getSongName());
		System.out.println("Artist Name: " + this.getArtistName());
		System.out.println("Song Length (in seconds): " + this.getSongLength());
	}
	
}
