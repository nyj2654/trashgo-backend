package com.trashgo.trashgo_backend.controller;

import com.trashgo.trashgo_backend.domain.model.User;
import com.trashgo.trashgo_backend.dto.LoginRequsest;
import com.trashgo.trashgo_backend.dto.UserResponse;
import com.trashgo.trashgo_backend.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @ApiOperation(value = "유저 조회")
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> select(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(user.of());
    }


    @ApiOperation(value = "유저 전체 조회")
    @GetMapping()
    public ResponseEntity<List<User>> selectAll() {
        List<User> list = userService.findAll();
        return ResponseEntity.ok(list);
    }


    // 3. 저장하는 메서드 만들기 , 리턴타입 ResponseEntity<User>
    @ApiOperation(value = "유저 저장")
    @PostMapping()
    public ResponseEntity<User> save(@RequestBody User user){
        User savedUser = userService.save(user);
        return ResponseEntity.ok(user);
    }

    @ApiOperation(value = "로그인")
    @PostMapping("login")
    public ResponseEntity<User> login(@RequestBody LoginRequsest loginRequsest) throws Exception {
        User user = userService.findByEmailAndPassword(loginRequsest.getEmail(), loginRequsest.getPassword());
        if (user == null) {
            throw new Exception();
        }
        return  ResponseEntity.ok(user);
    }



}
