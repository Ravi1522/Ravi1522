package com.simple.package1;

import java.util.List;

public class TestRunner {

	public static void main(String[] args) {
		
		RecentPlayed recent= new RecentPlayed(5);
		recent.addSong("Song 1", "User 1");
		recent.addSong("Song 2", "User 3");
		recent.addSong("Song 3", "User 1");
		recent.addSong("Song 4", "User 2");
		recent.addSong("Song 5", "User 4");
		recent.addSong("Song 6", "User 1");
		recent.addSong("Song 7", "User 1");
		recent.addSong("Song 8", "User 1");
		recent.addSong("Song 9", "User 1");
		
		List songList= recent.getRecentlyPlayed("User 1");
		System.out.println(songList);
		System.out.println("Execution done");
		System.out.println("Next step Execution done");
		System.out.println("3rd step Execution done");
		
	}

}
