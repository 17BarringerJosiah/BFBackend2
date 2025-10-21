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
    @JoinColumn(name = "color_id")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "metrics_id")
    private WidgetMetrics widgetMetrics;

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


    public WidgetVariant(Long id, Widget widget, Color color, WidgetMetrics widgetMetrics, String variantName, String imageUrl, int price, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.widget = widget;
        this.color = color;
        this.widgetMetrics = widgetMetrics;
        this.variantName = variantName;
        this.imageUrl = imageUrl;
        this.price = price;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public WidgetMetrics getWidgetMetrics() {
        return widgetMetrics;
    }

    public void setWidgetMetrics(WidgetMetrics widgetMetrics) {
        this.widgetMetrics = widgetMetrics;
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
