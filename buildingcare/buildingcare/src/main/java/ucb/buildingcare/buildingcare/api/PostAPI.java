package ucb.buildingcare.buildingcare.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ucb.buildingcare.buildingcare.bl.BlogBl;
import ucb.buildingcare.buildingcare.dto.BuildingcareResponse;
import ucb.buildingcare.buildingcare.dto.PostRequest;
import ucb.buildingcare.buildingcare.util.BuildingcareException;

@RestController
@RequestMapping(path = "/api/v1/blog")
public class PostAPI {
    //Esta API se encarga de la logica sobre el blog de publicaciones
    //Requiere de los servicios:
    //blogBl

    Logger LOGGER = LoggerFactory.getLogger(PostAPI.class);
    
    @Autowired
    private BlogBl blogService;

    public PostAPI(BlogBl blogService) {
        this.blogService = blogService;
    }

    @GetMapping(path = "/all")
    public BuildingcareResponse ListAllPosts() {
        LOGGER.info("ListAllPosts");
        BuildingcareResponse buildingcareResponse = blogService.ListAllPosts();
        buildingcareResponse.setResponseCode("POST-0000");
        LOGGER.info("{}", buildingcareResponse);
        return buildingcareResponse;
    }

    @GetMapping(path = "/{id}")
    public BuildingcareResponse getPostById(@PathVariable Integer id) {
        LOGGER.info("getPostById: id: {}", id);
        BuildingcareResponse buildingcareResponse = new BuildingcareResponse();
        try {
            buildingcareResponse.setData(blogService.getPostById(id));
            buildingcareResponse.setResponseCode("POST-0000");
        } catch (BuildingcareException e) {
            buildingcareResponse.setErrorMessage(e.getMessage());
            buildingcareResponse.setResponseCode("POST-6000");
        }
        LOGGER.info("{}", buildingcareResponse);
        return buildingcareResponse;
    }

    @GetMapping(path = "/urgent")
    public BuildingcareResponse getUrgentPosts() {
        LOGGER.info("getUrgentPosts");
        BuildingcareResponse buildingcareResponse = new BuildingcareResponse();
        try {
            buildingcareResponse.setData(blogService.getPostsByStatus("urgent"));
            buildingcareResponse.setResponseCode("POST-0000");
        } catch (BuildingcareException e) {
            buildingcareResponse.setErrorMessage(e.getMessage());
            buildingcareResponse.setResponseCode("POST-6000");
        }
        LOGGER.info("{}", buildingcareResponse);
        return buildingcareResponse;
    }

    @GetMapping(path = "/done")
    public BuildingcareResponse getDonePosts() {
        LOGGER.info("getDonePosts");
        BuildingcareResponse buildingcareResponse = new BuildingcareResponse();
        try {
            buildingcareResponse.setData(blogService.getPostsByStatus("done"));
            buildingcareResponse.setResponseCode("POST-0000");
        } catch (BuildingcareException e) {
            buildingcareResponse.setErrorMessage(e.getMessage());
            buildingcareResponse.setResponseCode("POST-6000");
        }
        LOGGER.info("{}", buildingcareResponse);
        return buildingcareResponse;
    }

    /* @GetMapping(path = "/{id}/children")
    public BuildingcareResponse getChildrenPosts(@PathVariable Integer id) {
        LOGGER.info("getChildrenPosts");
        BuildingcareResponse buildingcareResponse = new BuildingcareResponse();
        try {
            buildingcareResponse.setData(blogService.getChildrenPosts(id));
            buildingcareResponse.setResponseCode("POST-0000");
        } catch (BuildingcareException e) {
            buildingcareResponse.setErrorMessage(e.getMessage());
            buildingcareResponse.setResponseCode("POST-6000");
        }
        LOGGER.info("{}", buildingcareResponse);
        return buildingcareResponse;
    } */

    @PostMapping()
    public BuildingcareResponse createPost(@RequestBody PostRequest postRequest, @RequestHeader Integer token) {
        LOGGER.info("Entrando a crear post");
        BuildingcareResponse buildingcareResponse = new BuildingcareResponse();
        buildingcareResponse.setData(blogService.createPost(postRequest, token));
        buildingcareResponse.setResponseCode("POST-0001");
        return buildingcareResponse;
    }

    @DeleteMapping(path = "/{id}")
    public BuildingcareResponse deletePost(@PathVariable Integer id) {
        LOGGER.info("Deleting post with id: {}", id);
        BuildingcareResponse buildingcareResponse = new BuildingcareResponse();
        try {
            buildingcareResponse.setData(blogService.deletePost(id));
            buildingcareResponse.setResponseCode("POST-0003");
        } catch (BuildingcareException e) {
            buildingcareResponse.setErrorMessage(e.getMessage());
            buildingcareResponse.setResponseCode("POST-6003");
        }
        return buildingcareResponse;
    }

    @PutMapping(path = "/{id}/done")
    public BuildingcareResponse markPostAsDone(@PathVariable Integer id, @RequestHeader Integer token) {
        LOGGER.info("Marking post as done: {}", id);
        BuildingcareResponse buildingcareResponse = new BuildingcareResponse();
        try {
            buildingcareResponse.setData(blogService.markPostAsDone(id, token));
            buildingcareResponse.setResponseCode("POST-0002");
        } catch (BuildingcareException e) {
            buildingcareResponse.setErrorMessage(e.getMessage());
            buildingcareResponse.setResponseCode("POST-6002");
        }
        return buildingcareResponse;
    }

    @PutMapping(path = "/{id}/urgent")
    public BuildingcareResponse markPostAsUrgent(@PathVariable Integer id,@RequestHeader Integer token) {
        LOGGER.info("Marking post as urgent: {}", id);
        BuildingcareResponse buildingcareResponse = new BuildingcareResponse();
        try {
            buildingcareResponse.setData(blogService.markPostAsUrgent(id, token));
            buildingcareResponse.setResponseCode("POST-0002");
        } catch (BuildingcareException e) {
            buildingcareResponse.setErrorMessage(e.getMessage());
            buildingcareResponse.setResponseCode("POST-6002");
        }
        return buildingcareResponse;
    }

    @PutMapping(path = "/{id}")
    public BuildingcareResponse updatePost(@PathVariable Integer id, @RequestBody PostRequest postRequest, @RequestHeader Integer token) {
        LOGGER.info("Updating post with id: {}", id);
        BuildingcareResponse buildingcareResponse = new BuildingcareResponse();
        try {
        buildingcareResponse.setData(blogService.updatePost(id, postRequest, token));
            buildingcareResponse.setResponseCode("POST-0002");
        } catch (BuildingcareException e) {
            buildingcareResponse.setErrorMessage(e.getMessage());
            buildingcareResponse.setResponseCode("POST-6002");
        }
        
        return buildingcareResponse;
    }

}
