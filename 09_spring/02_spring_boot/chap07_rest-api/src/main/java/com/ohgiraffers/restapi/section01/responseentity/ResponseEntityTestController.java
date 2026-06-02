package com.ohgiraffers.restapi.section01.responseentity;

import io.swagger.v3.oas.models.links.Link;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.*;

@RestController
@RequestMapping("/api/v1/response")
public class ResponseEntityTestController {

    private final List<UserDto> users;

    public ResponseEntityTestController() {
        users = new ArrayList<>();

        users.add(new UserDto(1, "user01", "pass01", "판다", new Date(), "active"));
        users.add(new UserDto(2, "user02", "pass02", "고릴라", new Date(), "active"));
        users.add(new UserDto(3, "user03", "pass03", "원숭이", new Date(), "inactive"));
    }

    @GetMapping("/users")
    public ResponseEntity<ResponseMessage> findUserByConditions(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String status
    ) {
        // 응답 header를 담는 객체
        HttpHeaders headers = new HttpHeaders();
        // Content-Type: application/json;charset=UTF-8
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        List<UserDto> foundUsers = users.stream()
                .filter(user -> {
                    if (status != null && !user.getStatus().equals(status)) {
                        return false;
                    }
                    if (name != null && !user.getName().contains(name)) {
                        return false;
                    }
                    return true;
                }).toList(); // 필터링된 결과를 새로운 List로 만든다

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("users", foundUsers);
        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공", response);

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    @GetMapping("/users/{userNo}")
    public ResponseEntity<ResponseMessage> findUserByNo(@PathVariable int userNo) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json", StandardCharsets.UTF_8));

        UserDto foundUser = users.stream()
                .filter(user -> user.getNo() == userNo)
                .findFirst()
                .get();

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("user", foundUser);

        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공", response);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(responseMessage);
    }

    @PostMapping("/users")
    // ResponseEntity<Void> : 응답 body가 없음 -> .build()로 응답 완성
    public ResponseEntity<Void> registerUser(@RequestBody UserDto newUser) {

        int lastUserNo = users.get(users.size() - 1).getNo();
        newUser.setNo(lastUserNo + 1);
        newUser.setEnrollDate(new Date());
        users.add(newUser);

        return ResponseEntity
            // HTTP 에서는 새 리소스를 만들었을 때 Location header로 그 리소스의 위치를 알려줄 수 있다.
            .created(URI.create("/api/v1/response/users/" + newUser.getNo()))
            .build();
    }

    @PutMapping("/users/{userNo}")
    public ResponseEntity<Void> modifyUser(@PathVariable int userNo,
                                           @RequestBody UserDto modifyInfo) {

        UserDto foundUser = users.stream()
                .filter(user -> user.getNo() == userNo)
                .findFirst()
                .get();

        foundUser.setId(modifyInfo.getId());
        foundUser.setPwd(modifyInfo.getPwd());
        foundUser.setName(modifyInfo.getName());

        return ResponseEntity
                .noContent()    // 204 No Content
                .build();
    }

    @DeleteMapping("/users/{userNo}")
    public ResponseEntity<Void> removeUser(@PathVariable int userNo) {

        UserDto foundUser = users.stream()
                .filter(user -> user.getNo() == userNo)
                .findFirst()
                .get();

        users.remove(foundUser);

        return ResponseEntity
                .noContent()
                .build();
    }
}
