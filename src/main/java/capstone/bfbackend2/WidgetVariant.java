package capstone.bfbackend2;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "widget_variant")
public class WidgetVariant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Relationships

    @ManyToOne
    @JoinColumn(name = "widget_id", nullable = false)
    @JsonBackReference
    private Widget widget;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "color_id", nullable = false)
    private Color color;

    @Column(name = "variant_quantity")
    private int variantQuantity;


    @Column(name = "variant_name")
    private String variantName;

    @Column(name = "variant_image_url")
    private String imageUrl;

    @Column(nullable = false)
    private int price;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "widgetMetrics_id")
    private WidgetMetrics widgetMetrics;


    public WidgetVariant(Long id, Widget widget, Color color, String variantName, String imageUrl, int price, LocalDateTime createdAt, LocalDateTime updatedAt, WidgetMetrics widgetMetrics) {
        this.id = id;
        this.widget = widget;
        this.color = color;
        this.variantName = variantName;
        this.imageUrl = imageUrl;
        this.price = price;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.widgetMetrics = widgetMetrics;
    }


    public WidgetVariant() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Widget getWidget() {
        return widget;
    }

    public void setWidget(Widget widget) {
        this.widget = widget;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


    public String getVariantName() {
        return variantName;
    }

    public void setVariantName(String variantName) {
        this.variantName = variantName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getVariantQuantity() {
        return variantQuantity;
    }

    public void setVariantQuantity(int variantQuantity) {
        this.variantQuantity = variantQuantity;
    }

    public WidgetMetrics getWidgetMetrics() {
        return widgetMetrics;
    }

    public void setWidgetMetrics(WidgetMetrics widgetMetrics) {
        this.widgetMetrics = widgetMetrics;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
