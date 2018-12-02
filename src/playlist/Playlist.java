/*
* Assignment	playlist
* Program		Playlist
* date			Oct 17, 2018
* Author		Jorge Jimenez
*/
package playlist;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Playlist
{
	private static SongEntry headNode = null;
	private static SongEntry currNode = null;
	private static SongEntry tailNode = null;
	private static int listSize = 0;
	
	public static void main(String[]args) throws IOException
	{
		System.setIn(new FileInputStream("playlistCase.txt"));
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter playlist's title:");
		System.out.println();
		
		String playlistTitle = scan.nextLine();
		
		printMenu(playlistTitle, scan);
	}
	public static void printMenu(String title, Scanner scan)
	{
		
		String input = "";
		while (true)
		{
			System.out.println(title + " PLAYLIST MENU");
			System.out.println("a - Add song");
			System.out.println("d - Remove song");
			System.out.println("c - Change position of song");
			System.out.println("s - Output songs by specific artist");
			System.out.println("t - Output total time of playlist (in seconds)");
			System.out.println("o - Output full playlist");
			System.out.println("q - Quit");	
			System.out.println();
			System.out.println("Choose an option:");
			
			input = scan.nextLine();
			switch (input)
			{
				case "a":
					addSong(scan);
					break;
				case "d":
					removeSong(scan);
					break;
				case "c":
					changePositionSong(scan);
					break;
				case "s":
					outputByArtist(scan);
					break;
				case "t":
					totalTime();
					break;
				case "o":
					outplayList(headNode, title);
					break;
				case "q":
					return;
			}
		}
	}

	private static void totalTime()
	{
		int seconds = 0;
		SongEntry current = headNode;
		while (current != null)
		{
			seconds += current.getSongLength();
			current = current.getNext();
		}
		System.out.printf("OUTPUT TOTAL TIME OF PLAYLIST (IN SECONDS)\n" + 
				"Total time: %d seconds\n\n", seconds);
	}
	private static void outputByArtist(Scanner scan)
	{
		System.out.println("OUTPUT SONGS BY SPECIFIC ARTIST");
		System.out.println("Enter artist's name:");
		String artist = scan.nextLine();
		
		int counter = 1;
		SongEntry current = headNode;
		while (current != null)
		{
			
			if (current.getArtistName().equals(artist))
			{
				System.out.println(counter + ".");
				current.printPlaylistSongs();
				System.out.println();
			}
			current = current.getNext();
			counter++;
		}
	}
	private static void changePositionSong(Scanner scan)
	{
		SongEntry songToMove;
		SongEntry tempNode;
		SongEntry newPos;
		
		
		System.out.println("CHANGE POSITION OF SONG");
		// get position of the song to move
		System.out.println("Enter song's current position:");
		int songIndex = scan.nextInt();
		
		// get the position to move the song
		songToMove = removeSong(songIndex);
		
		System.out.println("Enter new position for song:");
		int newIndex = scan.nextInt();
		scan.nextLine();
		
		//"Canned Heat" moved to position 2
		System.out.println("\"" + songToMove.getSongName() + 
					"\"" + " moved to position " + newIndex);
		System.out.println();
		
		if (newIndex <= 1)
		{
			songToMove.setNext(headNode);
			headNode = songToMove;
			return;
		}
		
		// TODO: add to tail if new index is > list size 
		intsertAt(newIndex, songToMove);
	}
	//returns the song at the specified index
	private static void intsertAt(int index, SongEntry song)
	{
		SongEntry current = headNode;
		
		if (index > listSize)
		{	
			current = tailNode;
			current.insertAfter(song);
			tailNode = song;
			return;
		}
		index -= 2;
		for (int i = 0; i < index; i++)
		{
			current = current.getNext();
		}
//		current.printPlaylistSongs();
		current.insertAfter(song);
	}
	// removes and returns a song at the index starting at 1
	// if index less then or equal to 2, returns headNode
	private static SongEntry removeSong(int index)
	{
		SongEntry song;
		if (index <= 2)
		{
			
			if (index == 1)
			{
				song = headNode;
				headNode = headNode.getNext();
				listSize--;
				return song;
			}
			
			song = headNode.getNext();
			headNode.setNext(headNode.getNext().getNext());
			listSize--;
			return song;
		}
		
		SongEntry current = headNode;
		index -= 2;
		for (int i = 0; i < index; i++)
			current = current.getNext();
		
		song = current.getNext();
		if (index + 2 == listSize)
		{
			current.setNext(null);
			listSize--;
			return song;
		}
			
		current.setNext(current.getNext().getNext());
		listSize--;
		return song;
	}
	
	private static void removeSong(Scanner scan)
	{

		System.out.println("REMOVE SONG");
		System.out.println("Enter song's unique ID:");
		
		String id = scan.nextLine();
		currNode = headNode;
		
		while(!currNode.getNext().getID().equals(id))
		{
			currNode = currNode.getNext();
		}
		String deletedSongName = currNode.getNext().getSongName();
		
		// currNode -> nodeWeWantToDelete -> nextNode
		currNode.setNext(currNode.getNext().getNext());
		
		System.out.println("\"" + deletedSongName + "\"" + " removed.");
		System.out.println();
		
		currNode = headNode;
		listSize--;
	}
	private static void outplayList(SongEntry headNode, String title)
	{
		System.out.println(title + " - OUTPUT FULL PLAYLIST");
		if (headNode == null)
		{
			System.out.println("Playlist is empty");
			System.out.println();
		}
		else
		{	
			SongEntry currNode = headNode;
			int counter = 0;
			while (currNode != null)
			{
				counter++;
				System.out.println(counter + ".");
				
				currNode.printPlaylistSongs();
				System.out.println();
				currNode = currNode.getNext();
			}
		}
	}
	
	private static void addSong(Scanner scan)
	{
		String id         = "";
		String songName   = "";
		String artistName = "";
		int songLength = 0;
		
		System.out.println("ADD SONG");
		System.out.println("Enter song's unique ID:");
		id 		   = scan.nextLine();
		System.out.println("Enter song's name:");
		songName   = scan.nextLine();
		System.out.println("Enter artist's name:");
		artistName = scan.nextLine();
		System.out.println("Enter song's length (in seconds):");
		songLength = scan.nextInt();
		System.out.println();
		
		scan.nextLine();
		
		if (headNode == null)
		{
			headNode = new SongEntry(id, songName, artistName, songLength);
			currNode = headNode;
			tailNode = headNode;
		}
		else
		{
			currNode.insertAfter(new SongEntry(id, songName, artistName, songLength));
			currNode = currNode.getNext();
			tailNode = currNode;
		}
		listSize++;
	}
	
}
