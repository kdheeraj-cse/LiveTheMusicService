package com.dheeraj.exceptions;

import java.io.FileNotFoundException;

public class AlbumNotFoundException extends FileNotFoundException{
	private static final long serialVersionUID = 1L;
		public AlbumNotFoundException(String excpetionMessage) {
			super(excpetionMessage);
		}
}
