package ved.boot.rest.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import ved.boot.rest.domain.Album;
import ved.boot.rest.domain.Artist;

/**
 * Hard coded simulation of a Service + Data Access Layer.
 */
@Service
public class MusicService {

	private Map<String, Album> albums;
	private Map<String, Artist> artists;

	/**
	 * Constructor populates the 'database' (i.e. Maps) of Artists and Albums.
	 */
	public MusicService() {

		albums = new HashMap<String, Album>();
		artists = new HashMap<String, Artist>();

		Artist artist1 = new Artist("Pop", "ABCPop");
		Artist artist2 = new Artist("Jazz", "ABCJazz");
		artists.put(artist1.getId(), artist1);
		artists.put(artist2.getId(), artist2);

		Album album1 = new Album("Pop-1", "Pop-1 & Pop-1", artist1, 2);
		Album album2 = new Album("Pop-2", "Pop-2 & Pop-2", artist1, 3);
		Album album3 = new Album("Pop-3", "Pop-3 & Pop-3", artist1, 0);
		Album album4 = new Album("Pop-4", "Pop-4 & Pop-4", artist2, 1);
		
		albums.put(album1.getId(), album1);
		albums.put(album2.getId(), album2);
		albums.put(album3.getId(), album3);
		albums.put(album4.getId(), album4);

	}

	public Collection<Album> getAllAlbums() {
		return albums.values();
	}

	public Album getAlbum(final String id) {
		return albums.get(id);
	}

	public Artist getArtist(final String id) {
		return artists.get(id);
	}
}