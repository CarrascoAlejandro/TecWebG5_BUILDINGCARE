package ucb.buildingcare.buildingcare.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.sql.Time;

@Entity
@Table(name = "Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "hour", nullable = false)
    private Time hour;

    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @Column(name = "content", length = 250, nullable = false)
    private String content;

    @Column(name = "state", length = 50, nullable = false)
    private String state;

    @Column(name = "idUser", nullable = false)
    private int idUser;

    @Column(name = "idTypePost", nullable = false)
    private int idTypePost;

    @Column(name = "idPostRequest")
    private Integer idPostRequest; // Puede ser nulo, por lo que usamos Integer en lugar de int

    // Constructor por defecto
    public Post() {
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getHour() {
        return hour;
    }

    public void setHour(Time hour) {
        this.hour = hour;
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

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdTypePost() {
        return idTypePost;
    }

    public void setIdTypePost(int idTypePost) {
        this.idTypePost = idTypePost;
    }

    public Integer getIdPostRequest() {
        return idPostRequest;
    }

    public void setIdPostRequest(Integer idPostRequest) {
        this.idPostRequest = idPostRequest;
    }

    @Override
    public String toString() {
        return "Post [id=" + id + ", date=" + date + ", hour=" + hour + ", title=" + title + ", content=" + content + ", state=" + state + ", idUser=" + idUser + ", idTypePost=" + idTypePost + ", idPostRequest=" + idPostRequest + "]";
    }
}
