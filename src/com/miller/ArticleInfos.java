package com.miller;

public class ArticleInfos {
    private static int articleId;
    private String name;
    private int quantity;

    public ArticleInfos(String name,int quantity){
        articleId += 1;
        this.name = name;
        this.quantity = quantity;
    }

    public static int getArticleId() {
        return articleId;
    }

    public static void setArticleId(int articleId) {
        ArticleInfos.articleId = articleId;
    }

    public final String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public final int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
