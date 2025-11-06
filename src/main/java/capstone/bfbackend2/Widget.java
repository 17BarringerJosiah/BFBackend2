package capstone.bfbackend2;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "widget")
public class Widget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "widget_name", nullable = false)
    private String widget_name;

    @Column(nullable = false, unique = true)
    private String slug;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String blurb;

    @Column(name = "image_url")
    private String image_url;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "metrics_id")
    private WidgetMetrics widgetMetrics;

    @ManyToOne
    @JoinColumn(name = "lifecycle_status_id")
    private LifecycleStatus lifecycleStatus;

    @JsonManagedReference
    @OneToMany(mappedBy = "widget", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<WidgetVariant> variants;


//Constructors
    public Widget(Long id, String widget_name, String slug, String blurb, String image_url, LocalDateTime createdAt, LocalDateTime updatedAt, int price, Color color, WidgetMetrics widgetMetrics, LifecycleStatus lifecycleStatus) {
        this.id = id;
        this.widget_name = widget_name;
        this.slug = slug;
        this.blurb = blurb;
        this.image_url = image_url;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.price = price;
        this.color = color;
        this.widgetMetrics = widgetMetrics;
        this.lifecycleStatus = lifecycleStatus;
    }

    public Widget() {

    }



    //Setters and Getters
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getWidget_name() {
        return widget_name;
    }

    public void setWidget_name(String widget_name) {
        this.widget_name = widget_name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<WidgetVariant> getVariants() {
        return variants;
    }

    public void setVariants(List<WidgetVariant> variants) {
        this.variants = variants;
    }

    public Color getColor() { return color; }
    public void setColor(Color color) { this.color = color; }

    public WidgetMetrics getWidgetMetrics() { return widgetMetrics; }
    public void setWidgetMetrics(WidgetMetrics widgetMetrics) { this.widgetMetrics = widgetMetrics; }

    public LifecycleStatus getLifecycleStatus() { return lifecycleStatus; }
    public void setLifecycleStatus(LifecycleStatus lifecycleStatus) { this.lifecycleStatus = lifecycleStatus; }

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
