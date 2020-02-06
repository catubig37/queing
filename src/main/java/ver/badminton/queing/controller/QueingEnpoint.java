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
import ver.badminton.queing.service.PlayerService;

@RestController
public class QueingEnpoint {
	
	@Autowired
	GameService gameService;
	
	@Autowired
	PlayerService pService;
	
	@GetMapping("/")
	public String welcome(){
		return "Welcome to Ver Badminton Queing Application";
	}
	
	@PutMapping("/createGame")
	public ResponseEntity<String> createGame(@RequestBody Game game){		
		return ResponseEntity.status(HttpStatus.CREATED)
		          .body(Util.objToJson(gameService.createGame(game)));
	}
	
	@PutMapping(value = "/addPlayers", consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> addPlayers(@RequestParam String gameId, @RequestBody Player player) {
		
		if(player.getPlayerId() != null && !"".equals(player.getPlayerId())) {
			gameService.addGamePlayer(gameId, player.getPlayerId());
		} else {
			String playerId = pService.createPlayer(player);
			gameService.addGamePlayer(gameId, playerId);
			
		}
	
		if(player.getPlayerId() != null) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(gameId+ Util.objToJson(player));
		}else {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("");
		}
	}
	
	@GetMapping("/getMatch")
	public @ResponseBody ResponseEntity<String>  getMatch(@RequestParam String gameID){
		Match match = gameService.getMatch(gameID);
		return ResponseEntity.status(HttpStatus.CREATED)
		          .body(Util.objToJson(match));
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
