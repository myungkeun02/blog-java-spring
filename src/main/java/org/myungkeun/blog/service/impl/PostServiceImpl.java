package org.myungkeun.blog.service.impl;

import com.springboot.blog.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.myungkeun.blog.entity.Post;
import org.myungkeun.blog.payload.PostDto;
import org.myungkeun.blog.payload.PostResponseDto;
import org.myungkeun.blog.repository.PostRepository;
import org.myungkeun.blog.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
    private ModelMapper modelMapper;
    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.postRepository = postRepository;
    }
    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = mapToEntity(postDto);
        Post newPost = postRepository.save(post);
        PostDto postResponse = mapToDto(newPost);
        return postResponse;
//        Post newPost = new Post();
//        newPost.setTitle(postDto.getTitle());
//        newPost.setDescription(postDto.getDescription());
//        newPost.setContent(postDto.getContent());
//        postRepository.save(newPost);
//        return postDto;
    }

    @Override
    public PostResponseDto getAllPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostDto> contents = posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
        PostResponseDto postResponseDto = new PostResponseDto();
        postResponseDto.setContent(contents);
        return postResponseDto;
    }

    @Override
    public PostDto getPostById(String id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return mapToDto(post);
    }

    @Override
    public PostDto updatePostById(String id) {
        return null;
    }

    @Override
    public void deletePostById(String id) {

    }

    private PostDto mapToDto(Post post) {
        PostDto postDto = modelMapper.map(post, PostDto.class);
        return postDto;
    }

    private Post mapToEntity(PostDto postDto) {
        Post post = modelMapper.map(postDto, Post.class);
        return post;
    }
}
