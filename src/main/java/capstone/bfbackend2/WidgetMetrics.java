package capstone.bfbackend2;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "widget_metrics")
public class WidgetMetrics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long widgetMetrics_id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "usefulness_rating", precision = 5, scale = 1)
    private BigDecimal usefulnessRating;

    public WidgetMetrics(Long widgetMetrics_id, int quantity, BigDecimal usefulnessRating) {
        this.widgetMetrics_id = widgetMetrics_id;
        this.quantity = quantity;
        this.usefulnessRating = usefulnessRating;
    }

    public WidgetMetrics() {
        this.widgetMetrics_id = 0L;
        this.quantity = 0;
        this.usefulnessRating = BigDecimal.valueOf(0.0);
    }



    //Setters and Getters

    public Long getWidgetMetrics_id() {
        return widgetMetrics_id;
    }

    public void setWidgetMetrics_id(Long widgetMetrics_id) {
        this.widgetMetrics_id = widgetMetrics_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUsefulnessRating() {
        return usefulnessRating;
    }

    public void setUsefulnessRating(BigDecimal usefulnessRating) {
        this.usefulnessRating = usefulnessRating;
    }
}
