package pl.sel.selenium.model;


public class ProductDisplay {

    private String productTitle;
    private String regularPriceAmount;
    private String regularPriceColor;
    private String regularPriceFontStyle;
    private String campaignPriceAmount;
    private String campaignPriceColor;
    private String campaignPriceFontStyle;

    public ProductDisplay withTitle(String articleTitle) {
        this.productTitle = articleTitle;
        return this;
    }

    public ProductDisplay withRegularPriceAmount(String regularPriceAmount) {
        this.regularPriceAmount = regularPriceAmount;
        return this;
    }

    public ProductDisplay withRegularPriceColor(String regularPriceColor) {
        this.regularPriceColor = regularPriceColor;
        return this;
    }

    public ProductDisplay withRegularPriceFontStyle(String regularPriceFontStyle) {
        this.regularPriceFontStyle = regularPriceFontStyle;
        return this;
    }

    public ProductDisplay withCampaignPriceAmount(String campaignPriceAmount) {
        this.campaignPriceAmount = campaignPriceAmount;
        return this;
    }

    public ProductDisplay withCampaignPriceColor(String campaignPriceColor) {
        this.campaignPriceColor = campaignPriceColor;
        return this;
    }

    public ProductDisplay withCampaignPriceFontStyle(String campaignPriceFontStyle) {
        this.campaignPriceFontStyle = campaignPriceFontStyle;
        return this;
    }

    public String getProductTitle() { return productTitle; }

    public String getRegularPriceAmount() { return regularPriceAmount; }

    public String getRegularPriceColor() { return regularPriceColor; }

    public String getRegularPriceFontStyle() { return regularPriceFontStyle; }

    public String getCampaignPriceAmount() { return campaignPriceAmount; }

    public String getCampaignPriceColor() { return campaignPriceColor; }

    public String getCampaignPriceFontStyle() { return campaignPriceFontStyle; }

    @Override
    public String toString() {
        return "ProductDisplay{" +
                "productTitle='" + productTitle + '\'' +
                ", regularPriceAmount='" + regularPriceAmount + '\'' +
                ", regularPriceColor='" + regularPriceColor + '\'' +
                ", regularPriceFontStyle='" + regularPriceFontStyle + '\'' +
                ", campaignPriceAmount='" + campaignPriceAmount + '\'' +
                ", campaignPriceColor='" + campaignPriceColor + '\'' +
                ", campaignPriceFontStyle='" + campaignPriceFontStyle + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductDisplay that = (ProductDisplay) o;

        if (productTitle != null ? !productTitle.equals(that.productTitle) : that.productTitle != null) return false;
        if (regularPriceAmount != null ? !regularPriceAmount.equals(that.regularPriceAmount) : that.regularPriceAmount != null)
            return false;
        if (regularPriceColor != null ? !regularPriceColor.equals(that.regularPriceColor) : that.regularPriceColor != null)
            return false;
        if (regularPriceFontStyle != null ? !regularPriceFontStyle.equals(that.regularPriceFontStyle) : that.regularPriceFontStyle != null)
            return false;
        if (campaignPriceAmount != null ? !campaignPriceAmount.equals(that.campaignPriceAmount) : that.campaignPriceAmount != null)
            return false;
        if (campaignPriceColor != null ? !campaignPriceColor.equals(that.campaignPriceColor) : that.campaignPriceColor != null)
            return false;
        return campaignPriceFontStyle != null ? campaignPriceFontStyle.equals(that.campaignPriceFontStyle) : that.campaignPriceFontStyle == null;
    }

    @Override
    public int hashCode() {
        int result = productTitle != null ? productTitle.hashCode() : 0;
        result = 31 * result + (regularPriceAmount != null ? regularPriceAmount.hashCode() : 0);
        result = 31 * result + (regularPriceColor != null ? regularPriceColor.hashCode() : 0);
        result = 31 * result + (regularPriceFontStyle != null ? regularPriceFontStyle.hashCode() : 0);
        result = 31 * result + (campaignPriceAmount != null ? campaignPriceAmount.hashCode() : 0);
        result = 31 * result + (campaignPriceColor != null ? campaignPriceColor.hashCode() : 0);
        result = 31 * result + (campaignPriceFontStyle != null ? campaignPriceFontStyle.hashCode() : 0);
        return result;
    }
}
