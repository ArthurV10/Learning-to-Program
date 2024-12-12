package entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Microblog {
    private List<Postagem> posts;

    public Microblog() {
        this.posts = new ArrayList<Postagem>();
    }

    public void postContent(Postagem postagem) {
        posts.add(postagem);
    }

    public List<Postagem> getPosts(int id) {
        for (Postagem postagem : posts) {
            if (postagem.getId() == id) {
                return new ArrayList<>(Arrays.asList(postagem));
            }
        }
        return null;
    }


     public Postagem searchPostForId(int id) {
        for (Postagem post : posts) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
     }

    public void removePost(int id) {
        Postagem postToRemove = searchPostForId(id);
        if (postToRemove!= null) {
            posts.remove(postToRemove);
        }
    }

    public Postagem postMostLiked(){
        Postagem mostLiked = posts.get(0);
        for (Postagem post : posts) {
            if (post.getQtdLikes() > mostLiked.getQtdLikes()){
                mostLiked = post;
            }
        }
        return mostLiked;
    }

    public Postagem getMostLiked(){
        return postMostLiked();
    }

    public void likeForId(int id){
        Postagem postToLike = searchPostForId(id);
        postToLike.addLike();
    }

    public String toString(){
        String Text = "";
        for (Postagem post : posts){
            Text += "================================================================" + "\n" +  "Postagem:" + "\n" + "Id postagem: " + post.getId() + "\n" + 
            "Texto do Post: " + post.getTextPost() + "\n" + "Likes da Postagem: " + post.getQtdLikes() + "\n"
            + "================================================================" +"\n\n";
        }
        return Text;
    }
}
