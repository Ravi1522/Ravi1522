package com.simple.package1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;

public class RecentPlayed {

	private int intialCapacity;
	boolean limitFlag = false;
	Map<String, String> map = new HashMap<String, String>();

	public RecentPlayed(int intialCapacity) {
		this.intialCapacity = intialCapacity;
	}

	public void addSong(String song, String user) {

		List list2 = new ArrayList();
		map.put(song, user);
		if (!map.isEmpty()) {
			Iterator<Map.Entry<String, String>> itr1 = map.entrySet().iterator();
			while (itr1.hasNext()) {
				Map.Entry<String, String> entry = itr1.next();
				String usr = entry.getValue();
				list2.add(usr);
			}
		} else {
			Assert.fail();
		}
		String userName = checkRepeatedUser(list2);
		if (limitFlag)
			removeSong(userName);
	}

	public List getRecentlyPlayed(String user) {

		List list = new ArrayList();
		String song = null;
		String userName;
		try {
			Iterator<Map.Entry<String, String>> itr = map.entrySet().iterator();
			while (itr.hasNext()) {
				Map.Entry<String, String> entry = itr.next();
				song = entry.getKey();
				userName = entry.getValue();
				if (userName.equals(user)) {
					list.add(song);
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}
		return list;
	}

	public void removeSong(String user) {

		try {
			Iterator<Map.Entry<String, String>> itr = map.entrySet().iterator();
			while (itr.hasNext()) {
				Map.Entry<String, String> entry = itr.next();
				String key = entry.getKey();
				String value = entry.getValue();
				if (value.equals(user)) {
					map.remove(key);
					break;
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}
	}

	public String checkRepeatedUser(List list) {

		int count = 1;
		String user = null;
		int i, j;
		String arr[] = new String[list.size()];
		for (int k = 0; k < list.size(); k++) {
			arr[k] = (String) list.get(k);
		}
		for (i = 0; i < arr.length; i++) {
			for (j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			}
			if (count > intialCapacity) {
				user = arr[i];
				limitFlag = true;
				break;
			}
			count = 1;
		}
		return user;
	}
}
