package application;

import entities.*;

public class Main {
    public static void main(String[] args) {
        // Criar o Microblog
        Microblog microblog = new Microblog();

        // Criar Postagens
        Postagem post1 = new Postagem(1, "Primeira postagem no microblog!");
        Postagem post2 = new Postagem(2, "Aprendendo a criar classes em Java.");
        Postagem post3 = new Postagem(3, "Adicionando likes e removendo posts.");

        // Teste: Adicionar postagens
        microblog.postContent(post1);
        microblog.postContent(post2);
        microblog.postContent(post3);
        System.out.println("Postagens adicionadas:");
        System.out.println(microblog);

        // Teste: Buscar postagem por ID
        System.out.println("\nBuscando postagem com ID 2:");
        System.out.println(microblog.searchPostForId(2));

        // Teste: Curtir uma postagem
        System.out.println("\nCurtindo a postagem com ID 1 (3 likes):");
        microblog.likeForId(1);
        microblog.likeForId(1);
        microblog.likeForId(1);
        System.out.println(microblog.searchPostForId(1));

        // Teste: Encontrar a postagem mais curtida
        System.out.println("\nPostagem mais curtida:");
        System.out.println(microblog.getMostLiked());

        // Teste: Remover uma postagem
        System.out.println("\nRemovendo postagem com ID 2:");
        microblog.removePost(2);
        System.out.println(microblog);

        // Teste: Buscar postagens por ID (retornando uma lista)
        System.out.println("\nBuscando postagem como lista (ID 3):");
        System.out.println(microblog.getPosts(3));

        // Teste: Removendo likes de uma postagem
        System.out.println("\nRemovendo 2 likes da postagem com ID 1:");
        post1.removeLike();
        post1.removeLike();
        System.out.println(post1);

        // Teste: Visualizar todas as postagens no microblog
        System.out.println("\nEstado final do microblog:");
        System.out.println(microblog);
    }
}
