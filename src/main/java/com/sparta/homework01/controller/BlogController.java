package com.sparta.homework01.controller;

import com.sparta.homework01.domain.Blog;
import com.sparta.homework01.domain.BlogRepository;
import com.sparta.homework01.domain.BlogRequestDto;
import com.sparta.homework01.domain.BlogResponseDto;
import com.sparta.homework01.service.BlogService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {
    private final BlogRepository blogRepository;
    private final BlogService blogService;

    @GetMapping({"/blogs"})
    public List<Blog> readBlogs() {
        return this.blogRepository.findAllByOrderByCreatedAtDesc();
    }

    @GetMapping({"/blogs/{id}"})
    public BlogResponseDto detailBlog(@PathVariable Long id) {
        return this.blogService.readB(id);
    }

    @PostMapping({"/blogs"})
    public Blog createBlog(@RequestBody BlogRequestDto requestDto) {
        Blog blog = new Blog(requestDto);
        return (Blog)this.blogRepository.save(blog);
    }

    @PatchMapping({"/blogs/{id}"})
    public Long updateBlog(@PathVariable Long id, @RequestBody BlogRequestDto requestDto) {
        this.blogService.update(id, requestDto);
        return id;
    }

    @DeleteMapping({"/blogs/{id}"})
    public Long deleteBlog(@PathVariable Long id, @RequestBody BlogRequestDto requestDto) {
        Blog blog = (Blog)this.blogRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("아이디가 존재하지 않습니다.");
        });
        if (blog.getPw() != requestDto.getPw()) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        } else {
            this.blogRepository.deleteById(id);
            return id;
        }
    }

    public BlogController(final BlogRepository blogRepository, final BlogService blogService) {
        this.blogRepository = blogRepository;
        this.blogService = blogService;
    }
}
