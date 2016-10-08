package com.dheeraj.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dheeraj.exceptions.AlbumNotFoundException;
import com.dheeraj.logic.SongsService;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;

@Path("/service")
public class RestService {

	@GET
	@Path("/allSongs")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
		public Response getAllSongs(@Context HttpServletRequest req, @Context HttpServletResponse res) {
		SongsService songService = new SongsService();
		return Response.status(Response.Status.OK).entity(songService.getAllSongs(req, res)).build();
	}
	@GET
	@Path("/getAlbumDetails/{albumName}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getAlbumDetails(@PathParam("albumName") String albumName) throws UnsupportedTagException, InvalidDataException, IOException, AlbumNotFoundException{
		SongsService songService = new SongsService();
		return Response.status(Response.Status.OK).entity(songService.getAlbumSongs(albumName)).build();
	}
	@GET
	@Path("/getSongDetails/{albumName}/{songName}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getSongDetails(@PathParam("albumName") String albumName,  @PathParam("songName") String songName) throws UnsupportedTagException, InvalidDataException, IOException, AlbumNotFoundException{
		System.out.println(songName);
		SongsService songService = new SongsService();
		return Response.status(Response.Status.OK).entity(songService.getSongAlbumContent(songName,albumName)).build();
	}
	
}
