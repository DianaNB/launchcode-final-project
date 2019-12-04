package com.launchcode.adrienne.FinalProjectTest.models.data;

import com.launchcode.adrienne.FinalProjectTest.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PostDao extends CrudRepository<Post, Integer> {
//    public Post findOne(int postId);
}
