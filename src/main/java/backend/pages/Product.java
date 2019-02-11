package backend.pages;

public class Product {
    private String name;
    private String description;
    private String tag;
    private String model;
    private String price;
    private String outOfStock;
    private String weight;
    private String weightCategory;

    public Product(String name, String description, String tag, String model, String price, String outOfStock, String weight, String weightCategory) {
        this.name = name;
        this.description = description;
        this.tag = tag;
        this.model = model;
        this.price = price;
        this.outOfStock = outOfStock;
        this.weight = weight;
        this.weightCategory = weightCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOutOfStock() {
        return outOfStock;
    }

    public void setOutOfStock(String outOfStock) {
        this.outOfStock = outOfStock;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWeightCategory() {
        return weightCategory;
    }

    public void setWeightCategory(String weightCategory) {
        this.weightCategory = weightCategory;
    }
}
