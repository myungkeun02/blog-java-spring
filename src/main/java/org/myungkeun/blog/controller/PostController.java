package org.myungkeun.blog.controller;


import org.myungkeun.blog.payload.PostDto;
import org.myungkeun.blog.payload.PostResponseDto;
import org.myungkeun.blog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    @PostMapping("/create")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<PostResponseDto> getAllPosts() {
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable String id) {
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
//        return new ResponseEntity.ok(postService.getPostById(id));
    }

}
