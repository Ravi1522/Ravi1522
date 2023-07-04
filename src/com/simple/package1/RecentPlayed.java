package com.simple.package1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RecentPlayed {

	private int intialCapacity;
	Map<String, String> map = new HashMap<String, String>();

	public RecentPlayed(int intialCapacity) {
		this.intialCapacity = intialCapacity;
	}

	public void addSong(String song, String user) {
		
		List list2 = new ArrayList();
		map.put(song, user);
		Iterator<Map.Entry<String, String>> itr1 = map.entrySet().iterator();
		while (itr1.hasNext()) {
			Map.Entry<String, String> entry = itr1.next();
			String usr = entry.getValue();
			list2.add(usr);
		}		
		int repeatedCount = repeatedUser(list2);
		removeSong(repeatedCount);
		
	}
	public List getRecentlyPlayed(String user) {

		List list = new ArrayList();
		String song = null;
		String userName;
		Iterator<Map.Entry<String, String>> itr = map.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<String, String> entry = itr.next();
			song = entry.getKey();
			userName = entry.getValue();
			if (userName.equals(user)) {
				list.add(song);
			}
		}
		return list;
	}

	public void removeSong(int count) {

		if (count > intialCapacity) {
			Set set= map.keySet();
			Iterator itr = set.iterator();
			String key=(String)itr.next();
			map.remove(key);
		}
	}
	
	public int repeatedUser(List list) {
	
		int count=1;
		String arr[]= new String[list.size()];
		for (int k=0; k<list.size();k++) {
			arr[k]=(String) list.get(k);
		}
		for (int i=0;i<arr.length;i++) {
			for (int j=i+1;j<arr.length;j++) {
				if (arr[i]==arr[j]) {
					count++;
				}
			}
		}
		return count;
	}
}
