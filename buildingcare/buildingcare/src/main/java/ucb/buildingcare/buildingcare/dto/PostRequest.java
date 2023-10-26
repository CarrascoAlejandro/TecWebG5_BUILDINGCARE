package ucb.buildingcare.buildingcare.dto;

public class PostRequest {
    //Esta clase es la que se encarga de recibir una peticion de Post del front end

    private String title;
    private String content;
    private String state;
    private Integer idUser;
    private Integer idTypePost;
    private Integer idPostRequest;

    public PostRequest() {
    }

    public PostRequest(String title, String content, String state, Integer idUser, Integer idTypePost, Integer idPostRequest) {
        this.title = title;
        this.content = content;
        this.state = state;
        this.idUser = idUser;
        this.idTypePost = idTypePost;
        this.idPostRequest = idPostRequest;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdTypePost() {
        return idTypePost;
    }

    public void setIdTypePost(Integer idTypePost) {
        this.idTypePost = idTypePost;
    }

    public Integer getIdPostRequest() {
        return idPostRequest;
    }

    public void setIdPostRequest(Integer idPostRequest) {
        this.idPostRequest = idPostRequest;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "PostRequest{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", state='" + state + '\'' +
                ", idUser=" + idUser +
                ", idTypePost=" + idTypePost +
                ", idPostRequest=" + idPostRequest +
                '}';
    }
}
