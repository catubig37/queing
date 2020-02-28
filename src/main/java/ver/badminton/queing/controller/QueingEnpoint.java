package ver.badminton.queing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ver.badminton.queing.helper.Util;
import ver.badminton.queing.model.Game;
import ver.badminton.queing.model.Match;
import ver.badminton.queing.model.Player;
import ver.badminton.queing.service.GameService;
import ver.badminton.queing.service.MatchService;
import ver.badminton.queing.service.PlayerService;

@RestController
public class QueingEnpoint {
	
	@Autowired
	GameService gameService;
	
	@Autowired
	PlayerService playerService;
	
	@Autowired
	MatchService matchService;
	
	@GetMapping("/")
	public String welcome(){
		return "Welcome to Ver Badminton Queing Application.";
	}
	
	@PutMapping("/createGame")
	public ResponseEntity<String> createGame(@RequestBody Game game){		
		return ResponseEntity.status(HttpStatus.CREATED)
		          .body(Util.objToJson(gameService.createGame(game)));
	}
	
	@PutMapping(value = "/addPlayers", consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> addPlayers(@RequestBody Player player) {
		
			String playerId = playerService.createPlayer(player);
	
		if(player.getPlayerId() != null) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Succesfully Added! Player ID: " + playerId);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("Got Error upon Adding Player!");
		}
	}
	
	@PutMapping(value = "/addPlayersInGame", consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> addPlayers(@RequestParam String gameId, @RequestBody Player player) {
		
		if(player.getPlayerId() != null && !"".equals(player.getPlayerId())) {
			gameService.addGamePlayer(gameId, player.getPlayerId());
		} else {
			String playerId = playerService.createPlayer(player);
			gameService.addGamePlayer(gameId, playerId);
			
		}
	
		if(player.getPlayerId() != null) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(gameId+ Util.objToJson(player));
		}else {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("Got Error upon Adding Player in Game!");
		}
	}
	
	@GetMapping("/getMatch")
	public @ResponseBody ResponseEntity<String>  getMatch(@RequestParam String gameID){
		Match match = matchService.getMatch(gameID);
		return ResponseEntity.status(HttpStatus.CREATED)
		          .body(Util.objToJson(match));
	}
	
	@PutMapping("/queMatch")
	public @ResponseBody ResponseEntity<String>  queMatch(@RequestParam String gameID, @RequestBody Match match){
		String matchId = matchService.queMatch(gameID, match);
		if(matchId != null) {
		return ResponseEntity.status(HttpStatus.CREATED)
		          .body("Successfully Added Match: " + matchId);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("Got Error upon Adding a Match!");
		}
	}
	
	@GetMapping(value = "/getPlayers", consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> getPlayers(@RequestParam int gameId) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("");
	}
	
	
	@GetMapping("/getGame")
	public String getGame(@RequestParam String gameID){
		return "Welcome to Ver Badminton Queing Application";
	}
}
