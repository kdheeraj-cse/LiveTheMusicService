package com.dheeraj.classes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Songs {
	private String songPath;
	private String artist;
	private String title;
	private String album;
	private String year;
	private Integer genre;
	private String track;
	private String genreDesciption;
	private Integer bitrate;
	private long lengthInSeconds;
	
	public Integer getBitrate() {
		return bitrate;
	}
	public void setBitrate(Integer bitrate) {
		this.bitrate = bitrate;
	}
	public long getLengthInSeconds() {
		return lengthInSeconds;
	}
	public void setLengthInSeconds(long lengthInSeconds) {
		this.lengthInSeconds = lengthInSeconds;
	}
	public String getSongPath() {
		return songPath;
	}
	public Integer getGenre() {
		return genre;
	}
	public void setGenre(int genre) {
		this.genre = genre;
	}
	public String getTrack() {
		return track;
	}
	public void setTrack(String track) {
		this.track = track;
	}
	public String getGenreDesciption() {
		return genreDesciption;
	}
	public void setGenreDesciption(String genreDesciption) {
		this.genreDesciption = genreDesciption;
	}
	public void setSongPath(String songName) {
		this.songPath = songName;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
}