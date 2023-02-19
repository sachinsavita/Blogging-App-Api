package com.blogapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogapp.payloads.PostDto;
import com.blogapp.services.PostService;

import lombok.Delegate;

@RestController
@RequestMapping("/api")
public class PostController {
	
	@Autowired
	private PostService postService;
	

	@PostMapping("/user/{userId}/category/{categoryId}/post")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, 
			                                  @PathVariable Integer userId,
			                                  @PathVariable Integer categoryId)
	{
		PostDto createdPost = this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(createdPost, HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId)
	{
		List<PostDto> posts = this.postService.getPostByCategory(categoryId);
		
		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
	}
	
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId)
	{
		List<PostDto> posts = this.postService.getPostByUser(userId);
		
		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
	}
	
	@GetMapping("/post/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId)
	{
		PostDto post = this.postService.getPostById(postId);
		return new ResponseEntity<PostDto>(post, HttpStatus.OK);
	}
	
	@PutMapping("post/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId)
	{
		PostDto updatedPost = this.postService.updatePost(postDto, postId);
		
		return new ResponseEntity<PostDto>(updatedPost, HttpStatus.OK);
				
	}
	
	@GetMapping("/posts")
	public ResponseEntity<List<PostDto>> getAllPosts()
	{
		List<PostDto> posts = this.postService.getAllPost();
		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/post/{postId}")
	public ResponseEntity<PostDto> deletePost(@PathVariable Integer postId)
	{
		PostDto deletedPost = this.postService.deletePost(postId);
		return new ResponseEntity<PostDto>(deletedPost, HttpStatus.OK);
	}
}
