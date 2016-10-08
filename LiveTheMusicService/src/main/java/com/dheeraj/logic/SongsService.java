package com.dheeraj.logic;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dheeraj.classes.AllSongs;
import com.dheeraj.classes.Songs;
import com.dheeraj.exceptions.AlbumNotFoundException;
import com.mpatric.mp3agic.ID3v1Tag;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import com.dheeraj.classes.AlbumDetails;

public class SongsService {
	static final Properties properties = new Properties();
	static final String MP3EXTENSION = "mp3";
	
	static {
		try{
			properties.load(SongsService.class.getResourceAsStream("/config.properties"));
		} catch (Exception e) {
		}
	}

	public AllSongs getAllSongs(HttpServletRequest req, HttpServletResponse res){
		String songsPoolPath = properties.getProperty("Location_SongRepo");
		AllSongs allSongs = new AllSongs();
		allSongs.setAllSongsList(Arrays.asList(new File(songsPoolPath).list()));
		return allSongs;
	}

	public AlbumDetails getAlbumSongs(String albumName) throws UnsupportedTagException, InvalidDataException, IOException {
		AlbumDetails albumdetails = new AlbumDetails();
		String absoluteAlbumPath = properties.getProperty("Location_SongRepo")+"/"+albumName;
		String [] albumFolderContent = new File(absoluteAlbumPath).list();
		List<Songs> albumSongList = new ArrayList<>();
		for (String string : albumFolderContent) {
			if(string.endsWith(SongsService.MP3EXTENSION)){
				albumSongList.add(getSongAlbumContent(string, albumName));
			}else{
				albumdetails.setAlbumArtPath(string);
			}
		}
		albumdetails.setAlbumSongList(albumSongList);
		return albumdetails;
	}
	
	public Songs getSongAlbumContent(String songName,String albumName) throws UnsupportedTagException, InvalidDataException, IOException, AlbumNotFoundException {
		String songAbsolutePath = properties.getProperty("Location_SongRepo")+"/"+albumName+"/"+songName;
		return getSongsTagDetails(songAbsolutePath);
	}
	
	private Songs getSongsTagDetails(String songAbsolutePath) throws UnsupportedTagException, InvalidDataException, IOException{
		Songs song = new Songs();
		
		File songFile = new File(songAbsolutePath);
		if(!songFile.exists()){
			throw new AlbumNotFoundException(properties.getProperty("Album_not_found_exception_message")+"at path "+songFile.getAbsolutePath());
		}
		Mp3File file = new Mp3File(songAbsolutePath);
		song.setBitrate(file.getBitrate());
		song.setLengthInSeconds(file.getLengthInSeconds());
		ID3v1Tag iD3v1Tag = (ID3v1Tag) file.getId3v1Tag();
		song.setTitle(iD3v1Tag.getTitle());
		song.setArtist(iD3v1Tag.getArtist());
		song.setYear(iD3v1Tag.getYear());
		song.setAlbum(iD3v1Tag.getAlbum());
		song.setGenre(iD3v1Tag.getGenre());
		song.setTrack(iD3v1Tag.getTrack());
		song.setGenreDesciption(iD3v1Tag.getGenreDescription());
		song.setSongPath(songAbsolutePath);
		return song;
	}
}
 