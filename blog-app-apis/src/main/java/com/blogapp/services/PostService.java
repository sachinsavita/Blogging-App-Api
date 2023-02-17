package com.blogapp.services;

import java.util.List;

import com.blogapp.payloads.PostDto;


public interface PostService {
	
	PostDto createPost(PostDto postDto, Integer userId,Integer categoryId);
	PostDto updatePost(PostDto post, Integer postId);
	PostDto getPostById(Integer postId);
	List<PostDto> getAllPost();
	void deletePost(Integer postId);
	
	List<PostDto> getPostByCategory(Integer categoryId);
	List<PostDto> getPostByUser(Integer userId);
	
	List<PostDto> searchPost(String keyword);
	
}
