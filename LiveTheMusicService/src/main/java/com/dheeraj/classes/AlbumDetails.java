package com.dheeraj.classes;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class AlbumDetails {
	private String albumArtPath;
	private List<Songs> albumSongList;
	
	public String getAlbumArtPath() {
		return albumArtPath;
	}

	public void setAlbumArtPath(String albumArtPath) {
		this.albumArtPath = albumArtPath;
	}

	public List<Songs> getAlbumSongList() {
		return albumSongList;
	}

	public void setAlbumSongList(List<Songs> albumSongList) {
		this.albumSongList = albumSongList;
	}

	public AlbumDetails() {
		albumSongList = new ArrayList<>();
	}

}
