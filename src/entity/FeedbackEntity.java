package entity;

public class FeedbackEntity {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FeedbackEntity(int id, String quality, String likeProduct, String money, String version) {
        this.id = id;
        this.quality = quality;
        this.likeProduct = likeProduct;
        this.money = money;
        this.version = version;
    }

    public FeedbackEntity() {
    }

    private int id;
    private String quality;
    private String likeProduct;
    private String money;
    private String version;

    public String getLikeProduct() {
        return likeProduct;
    }

    public void setLikeProduct(String likeProduct) {
        this.likeProduct = likeProduct;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }



    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }


}
