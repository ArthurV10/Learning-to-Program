package entities;

public class Postagem {
    private int id;
    private String textPost;
    private int qtdLikes;

    public Postagem(int id, String text){
        this.id = id;
        this.textPost = text;
        this.qtdLikes = 0;
    }

    public int getId(){
        return this.id;
    }

    public String getTextPost(){
        return this.textPost;
    }

    public int getQtdLikes(){
        return this.qtdLikes;
    }

    public void addLike(){
        this.qtdLikes++;
    }

    public void removeLike(){
        if (this.qtdLikes > 0){
            this.qtdLikes--;
        }
    }

    public String toString() {
        return "Postagem ID: " + this.id + ", Texto: " + this.textPost + ", Likes: " + this.qtdLikes;
    }
}

