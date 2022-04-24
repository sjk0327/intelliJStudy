package com.study.crystal.test.web;

import com.study.crystal.test.service.posts.PostsService;
import com.study.crystal.test.web.dto.PostSaveRequestDto;
import com.study.crystal.test.web.dto.PostsResponseDto;
import com.study.crystal.test.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id){
        return postsService.findById(id);
    }
}
