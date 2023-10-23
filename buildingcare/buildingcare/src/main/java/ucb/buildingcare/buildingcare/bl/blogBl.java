package ucb.buildingcare.buildingcare.bl;

import java.time.LocalDateTime;
import java.util.Date;
import java.sql.Time;


import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucb.buildingcare.buildingcare.dto.BuildingcareResponse;
import ucb.buildingcare.buildingcare.dto.PostRequest;
import ucb.buildingcare.buildingcare.dto.PostResponse;
import ucb.buildingcare.buildingcare.entity.Post;
import ucb.buildingcare.buildingcare.entity.User;
import ucb.buildingcare.buildingcare.repository.PostRepository;
import ucb.buildingcare.buildingcare.repository.UserRepository;
import ucb.buildingcare.buildingcare.repository.TypePostRepository;

@Service
public class blogBl {

    Logger LOGGER = LoggerFactory.getLogger(blogBl.class);
    
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TypePostRepository typePostRepository;

    public blogBl(PostRepository postRepository, UserRepository userRepository, TypePostRepository typePostRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.typePostRepository = typePostRepository;
    }

    public BuildingcareResponse ListAllPosts() {
        LOGGER.info("blogBl - ListAllPosts");
        List<Post> posts = postRepository.findAll();
        LOGGER.info("el tamano de posts List<Post> es: "+ posts.size());
        List<PostResponse> postResponses = new ArrayList<>();
        for (Post post : posts) {
            LOGGER.info("en el for de List<Post> posts: "+ post.toString());
            postResponses.add(new PostResponse(post));
        }
        LOGGER.info("retornando new BuildingcareResponse(postResponses): "+ new BuildingcareResponse(postResponses).toString());
        return new BuildingcareResponse(postResponses);
    }

    public PostResponse getPostById(Integer id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post != null) {
            return new PostResponse(post);
        } else {
            //TODO raise exception
            return null;
        }
    }

    

    public PostResponse createPost(PostRequest postRequest) {
        Post post = new Post();
        //insert with current date
        post.setDate(new Date());
        post.setHour(new Time(System.currentTimeMillis()));
        post.setTitle(postRequest.getTitle());
        post.setContent(postRequest.getContent());
        post.setState(postRequest.getState());
        post.setIdUser(userRepository.findById(postRequest.getIdUser()).orElse(null));
        post.setIdTypePost(typePostRepository.findById(postRequest.getIdTypePost()).orElse(null));

        //If post has a parent post
        // post.setIdPostRequest(postRepository.findById(postRequest.getIdPostRequest()).orElse(null));
        if(postRequest.getIdPostRequest() != null) {
            post.setIdPostRequest(postRepository.findById(postRequest.getIdPostRequest()).orElse(null));
        }

        
        LOGGER.info("blogBl - creating post: "+ post.toString());
        // Save the post object to the database
        postRepository.save(post);
        return new PostResponse(post);
    }

    public PostResponse deletePost(Integer id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post != null) {
            postRepository.delete(post);
            return new PostResponse(post);
        } else {
            //TODO raise exception
            return null;
        }
    }

    public PostResponse markPostAsDone(Integer id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post != null) {
            post.setState("Done");
            postRepository.save(post);
            return new PostResponse(post);
        } else {
            //TODO raise exception
            return null;
        }
    }
    
    public PostResponse markPostAsUrgent(Integer id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post != null) {
            post.setState("Urgent");
            postRepository.save(post);
            return new PostResponse(post);
        } else {
            //TODO raise exception
            return null;
        }
    }

    public PostResponse updatePost(Integer id, PostRequest postRequest) {
        Post post = postRepository.findById(id).orElse(null);
        if (post != null) {

            if (postRequest.getTitle() != null) post.setTitle(postRequest.getTitle());
            if (postRequest.getContent() != null) post.setContent(postRequest.getContent());
            if (postRequest.getState() != null) post.setState(postRequest.getState());
            if (postRequest.getIdUser() != null) post.setIdUser(userRepository.findById(postRequest.getIdUser()).orElse(null));
            if (postRequest.getIdTypePost() != null) post.setIdTypePost(typePostRepository.findById(postRequest.getIdTypePost()).orElse(null));
            
            postRepository.save(post);
            
            return new PostResponse(post);
        } else {
            //TODO raise exception
            return null;
        }
    }
    
}
