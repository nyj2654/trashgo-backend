package com.trashgo.trashgo_backend.controller;

import com.trashgo.trashgo_backend.domain.model.Trash;
import com.trashgo.trashgo_backend.domain.model.User;
import com.trashgo.trashgo_backend.dto.UserResponse;
import com.trashgo.trashgo_backend.service.TrashService;
import com.trashgo.trashgo_backend.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/trash")
public class TrashController {
    private final TrashService trashService;

    public TrashController(TrashService trashService) {
        this.trashService = trashService;
    }

    @ApiOperation(value = "빈병 조회")
    @GetMapping("/{id}")
    public ResponseEntity<Trash> select(@PathVariable Long id){
        Trash trash = trashService.findById(id);
        return ResponseEntity.ok(trash);
    }

    @ApiOperation(value = "빈병 전체 조회")
    @GetMapping()
    public ResponseEntity<List<Trash>> selectAll(){
        List<Trash> list = trashService.findAll();
        return ResponseEntity.ok(list);
    }

    @ApiOperation(value = "빈병 수거 입력")
    @PostMapping()
    public ResponseEntity<Trash> save(@RequestBody Trash trash){
        Trash savedTrash = trashService.save(trash);
        return ResponseEntity.ok(trash);
    }
}
