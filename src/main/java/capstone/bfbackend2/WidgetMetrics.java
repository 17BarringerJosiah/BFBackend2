package capstone.bfbackend2;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "widget_metrics")
public class WidgetMetrics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long widgetMetrics_id;

    @Column(name = "total_quantity")
    private int totalQuantity;

    @Column(name = "usefulness_rating", precision = 5, scale = 1)
    private BigDecimal usefulnessRating;

    @OneToMany(mappedBy = "widgetMetrics")
    private List<WidgetVariant> variants;


    public WidgetMetrics(Long widgetMetrics_id, int totalQuantity, BigDecimal usefulnessRating) {
        this.widgetMetrics_id = widgetMetrics_id;
        this.totalQuantity = totalQuantity;
        this.usefulnessRating = usefulnessRating;
    }

    public WidgetMetrics() {
        this.widgetMetrics_id = 0L;
        this.totalQuantity = 0;
        this.usefulnessRating = BigDecimal.valueOf(0.0);
    }



    //Setters and Getters

    public Long getWidgetMetrics_id() {
        return widgetMetrics_id;
    }

    public void setWidgetMetrics_id(Long widgetMetrics_id) {
        this.widgetMetrics_id = widgetMetrics_id;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public BigDecimal getUsefulnessRating() {
        return usefulnessRating;
    }

    public void setUsefulnessRating(BigDecimal usefulnessRating) {
        this.usefulnessRating = usefulnessRating;
    }
}
