package org.myungkeun.blog.service;

import org.myungkeun.blog.payload.PostDto;
import org.myungkeun.blog.payload.PostResponseDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    PostResponseDto getAllPosts();

    PostDto getPostById(String id);

    PostDto updatePostById(String id);

    void deletePostById(String id);
}
