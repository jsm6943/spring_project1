package com.sparta.homework01.service;

import com.sparta.homework01.domain.Blog;
import com.sparta.homework01.domain.BlogRepository;
import com.sparta.homework01.domain.BlogRequestDto;
import com.sparta.homework01.domain.BlogResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BlogService {
    private final BlogRepository blogRepository;

    @Transactional
    public Long update(Long id, BlogRequestDto requestDto) {
        Blog blog = (Blog)this.blogRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("아이디가 존재하지 않습니다.");
        });
        if (blog.getPw() != requestDto.getPw()) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        } else {
            blog.update(requestDto);
            return blog.getId();
        }
    }

    @Transactional
    public BlogResponseDto readB(Long id) {
        Blog detail = (Blog)this.blogRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("아이디가 존재하지 않습니다.");
        });
        return new BlogResponseDto(detail);
    }

    public BlogService(final BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }
}
