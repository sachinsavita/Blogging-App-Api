package com.blogapp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapp.entity.Category;
import com.blogapp.entity.Post;
import com.blogapp.entity.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
	
	List<Post> findByUser(User user);
	
	List<Post> findByCategory(Category category);

}
