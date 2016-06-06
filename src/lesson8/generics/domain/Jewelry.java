package lesson8.generics.domain;


import lesson8.reflection.Service;

@Service(name = "Test")
public class Jewelry {
    private String article;
    private String name;
    private int price;
    private int count;

    public Jewelry() {
    }

    public Jewelry(String article, Integer count, String name, Integer price) {
        this.article = article;
        this.count = count;
        this.name = name;
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if(this.count <count){
             System.out.println("You have only " + this.count +". You can't sell it");
                return;
        }
        this.count = -count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

}
