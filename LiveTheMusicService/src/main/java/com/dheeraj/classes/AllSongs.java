package com.dheeraj.classes;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class AllSongs {
	private List<String> allSongsList;
	public AllSongs() {
		allSongsList = new ArrayList<String>();
	}

	public List<String> getAllSongsList() {
	return allSongsList;
	}

	public void setAllSongsList(List<String> allSongsList) {
	this.allSongsList = allSongsList;
	}
	
	
}
