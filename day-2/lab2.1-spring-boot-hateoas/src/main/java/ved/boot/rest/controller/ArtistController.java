package ved.boot.rest.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ved.boot.rest.domain.Artist;
import ved.boot.rest.service.MusicService;

/**
 * 
 * @author Ved Tripathi
 *
 */

// if below annotation is enabled , then will get - white label page
//@Controller

@RestController
public class ArtistController {
	
	@Autowired
	private MusicService musicService;

	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(path = "/artist/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Resource<Artist> getArtist(@PathVariable(value = "id") String id) {
		Artist a = musicService.getArtist(id);
		Resource<Artist> resource = new Resource<Artist>(a);
		resource.add(linkTo(methodOn(ArtistController.class).getArtist(id)).withSelfRel());
		return resource;
	}
}