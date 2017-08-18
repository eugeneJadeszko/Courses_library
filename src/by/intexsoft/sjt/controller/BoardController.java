package by.intexsoft.sjt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import by.intexsoft.sjt.entity.BoardEntity;
import by.intexsoft.sjt.service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;

	@RequestMapping("/add/{number}")
	public ResponseEntity<?> add(@PathVariable("number") int number) {
		BoardEntity board = new BoardEntity();
		board.number = number;
		return new ResponseEntity<BoardEntity>(boardService.save(board), HttpStatus.OK);
	}

	@RequestMapping("/all")
	public ResponseEntity<?> findAll() {
		List<BoardEntity> rezList = boardService.findAll();
		return new ResponseEntity<List<BoardEntity>>(rezList, HttpStatus.OK);
	}
}
